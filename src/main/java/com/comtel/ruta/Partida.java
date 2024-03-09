package com.comtel.ruta;

import java.util.LinkedList;

/**
 * @author user
 */
public class Partida {

    private int actual = 0;
    private final Mazo mazo;
    private final LinkedList<Jugador> jugadores = new LinkedList();

    public Partida() {
        mazo = new Mazo();
    }

    public LinkedList<Jugador> getJugadores() {
        return jugadores;
    }

    public Mazo getMazo() {
        return mazo;
    }

    public void contabilizarPuntos() {
        for (Jugador jugador : jugadores) {
            var puntos = 0;
            // Puntos del jugador. 
            puntos += jugador.getPuntos();

            var seguro = jugador.esViajeSeguro();
            var completo = jugador.esViajeCompleto();
            var mazoVacio = mazo.vacio();

            if (completo && mazoVacio) {
                puntos += Juego.PUNTOS_POR_ACCION_RETARDADA;
            }

            if(seguro){
                puntos += Juego.PUNTOS_POR_VIAJE_SEGURO;                
            }

            // Verificar eliminacion de oponentes.             
            if(completo){
                var eliminacion = true;
                for(Jugador otroJugador: jugadores){
                    if(otroJugador == jugador || otroJugador.mismoEquipo(jugador)){
                        continue;
                    }
                    if(jugador.tieneCartaDistancia()){
                        eliminacion = false;
                        break;
                    }
                }  
                if(eliminacion){
                    puntos += Juego.PUNTOS_POR_ELIMINACION;
                }
            }
            
            jugador.anotarPuntos(puntos);
        }
    }

    public Jugador getJugadorActual() {
        return jugadores.get(actual);
    }

    public Jugador siguienteJugador() {
        actual = (actual + 1) % jugadores.size();
        return getJugadorActual();
    }

    public Jugador getJugadorGanadorParcial() {
        for (Jugador jugador : jugadores) {
            var pila = jugador.getPilaKilometrica();
            var km = pila.getKilometrosTotales();
            if (Juego.KILOMETROS_POR_VIAJE_COMPLETO == km) {
                return jugador;
            }
        }
        return null;
    }

    /**
     * Retorna true si todas las manos estan vacias.
     *
     * @return
     */
    public boolean getManosVacias() {
        for (Jugador jugador : jugadores) {
            if (false == jugador.getMano().vacio()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Retorna true si se alzanzó el final parcial.
     *
     * @return
     */
    public boolean esFinal() {
        // Un jugador alcanza exactamente 1000 KM. 
        var ganador = getJugadorGanadorParcial();
        if (null != ganador) {
            return true;
        }

        var mazoVacio = mazo.vacio();
        var manoVacia = getManosVacias();

        return mazoVacio && manoVacia;
    }

    public void nuevaPartida() {
        mazo.reiniciar();
        for (Jugador jugador : jugadores) {
            Mano mano = jugador.getMano();

            // Quitar cartas de las pilas.
            jugador.vaciarPilas();

            // Nueva mano
            mano.vaciar();
            for (int i = 0; i < Juego.CARTAS_EN_MANO; i++) {
                Pila.transferir(mazo, mano, 6);
            }
        }
    }

    public Carta robarCarta() {
        var jugador = getJugadorActual();
        var cartas = jugador.tomarDePila(mazo, 1);
        if (cartas.isEmpty()) {
            return null;
        }
        return cartas.get(0);
    }

    public void jugada(ConfiguracionJugada jugada) throws Exception {
        var index = jugada.indiceCarta;
        var jugador = getJugadorActual();
        var mano = jugador.getMano();

        if (jugada.enviarAPozo) {
            mano.enviarAPozo(index);
            return;
        }

        var carta = mano.getCarta(index);

        Pila pila = null;

        // TODO: Decidir a donde mover la carta.
        if (carta.isKilometrica()) {
            pila = jugador.getPilaKilometrica();
        }

        // Mover una carta especifica de la mano a una pila.
        Pila.transferir(mano, pila, index);
    }
}
