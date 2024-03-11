package com.comtel.ruta;

import java.util.ArrayList;
import java.util.Collections;
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

    public void agregarJugador(Jugador j) {
        jugadores.add(j);
    }

    public void contabilizarPuntos() {
        for (Jugador jugador : jugadores) {
            var puntos = 0;
            // Puntos del jugador. 
            puntos += jugador.getPuntuacionPartida();

            var seguro = jugador.esViajeSeguro();
            var completo = jugador.esViajeCompleto();
            var mazoVacio = mazo.isEmpty();

            if (completo && mazoVacio) {
                puntos += Juego.PUNTOS_POR_ACCION_RETARDADA;
            }

            if (seguro) {
                puntos += Juego.PUNTOS_POR_VIAJE_SEGURO;
            }

            if (completo) {
                // Advertencia!!
                // Los puntos por viaje completo 
                // son contados por el jugador en getPuntos(). 

                // Verificar eliminacion de oponentes.             
                var eliminacion = true;
                for (Jugador otroJugador : jugadores) {
                    if (otroJugador == jugador || otroJugador.mismoEquipo(jugador)) {
                        continue;
                    }
                    if (jugador.tieneCartaDistancia()) {
                        eliminacion = false;
                        break;
                    }
                }
                if (eliminacion) {
                    puntos += Juego.PUNTOS_POR_ELIMINACION;
                }
            }

            jugador.anotarPuntos(puntos);
        }
    }

    public Jugador getJugadorActual() {
        return jugadores.get(actual);
    }

    public Jugador avanzarJugador() {
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
            if (false == jugador.getMano().isEmpty()) {
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

        var mazoVacio = mazo.isEmpty();
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
            mano.clear();

            Pila.transferMany(mazo, mano, Juego.CARTAS_EN_MANO);
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

        var carta = mano.get(index);

        Pila pila = null;

        switch (carta.getTipo()) {
            case DistanciaKilometrica:
                pila = jugador.getPilaKilometrica();
                break;
            case PeligroAtaque:
                jugador = jugada.jugadorDestino;
                pila = jugador.getPilaAtaqueDefensa();
                // Limite de velocidad se juega sobre pila kilometrica.
                if (CartaSubtipo.LimiteVelocidad == carta.getSubtipo()) {
                    pila = jugador.getPilaVelocidad();
                }
                break;
            case SolucionesDefensa:
                pila = jugador.getPilaAtaqueDefensa();
                // Fin de limite de velocidad se juega sobre pila kilometrica.
                if (CartaSubtipo.FinLimiteVelocidad == carta.getSubtipo()) {
                    pila = jugador.getPilaVelocidad();
                }
                break;
            case SeguridadEscudo:
                pila = jugador.getPilaEscudo();
                carta.setDireccion(jugada.direccion);
                break;
            case SemaforoVerde:
                pila = jugador.getPilaAtaqueDefensa();
                break;
            case SemaforoRojo:
                jugador = jugada.jugadorDestino;
                pila = jugador.getPilaAtaqueDefensa();
                break;
            default:
        }

        if (pila != null) {
            // Mover una carta especifica de la mano a una pila.
            Pila.transfer(mano, pila, index);
        }
    }
    
    public int getCantidadEquipos() {
        int max = 0;
        for(Jugador jugador: jugadores){
            var equipo = jugador.getEquipo();
            if(equipo > max){
                max = equipo;
            }
        }
        return max;
    }
    
    public ArrayList<Integer> getPuntosPorEquipo() {
        var cantidadEquipos = getCantidadEquipos();
        ArrayList<Integer> puntuaciones = new ArrayList<>(cantidadEquipos);
        Collections.fill(puntuaciones, 0);
        for(Jugador j: jugadores){
            var equipo = j.getEquipo();
            var acumulada = j.getPuntuacionAcumulada(); 
            var puntuacionEquipo = puntuaciones.get(equipo);
            puntuaciones.set(equipo - 1, acumulada + puntuacionEquipo);
        }
        return puntuaciones;
    } 
    
    public int getEquipoGanador() {
        var equipoGanador = -1;
        var puntosPorEquipo = getPuntosPorEquipo();
        for(int i = 0; i < puntosPorEquipo.size(); i++){
           if(puntosPorEquipo.get(i) >= Juego.PUNTOS_MIN_PARA_GANAR){
               equipoGanador = i + 1;
               break;
           }   
        }
        return equipoGanador;
    }
}
