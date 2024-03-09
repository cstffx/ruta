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
            // TODO: Puntos condiciones adicionales.
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
            Pila.transferir(mazo, mano, 6);            
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
}
