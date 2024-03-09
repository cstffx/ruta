package com.comtel.ruta;

import java.util.LinkedList;

/**
 *
 * @author user
 */
public class Turno {
    
    private int actual = 0;
    private final LinkedList<Jugador> jugadores = new LinkedList();
    
    public LinkedList<Jugador> getJugadores() {
        return this.jugadores;
    }
    
    public Jugador getJugadorActual() {
        return this.jugadores.get(this.actual);
    }
    
    public Jugador siguienteJugador() {
        this.actual = (this.actual + 1) % this.jugadores.size();
        return this.getJugadorActual();
    }
    
    public Jugador getJugadorGanadorParcial() {
        for(Jugador jugador: this.jugadores){
            var pila = jugador.getPilaKilometrica();
            var km = pila.getKilometrosTotales();
            if( Juego.KILOMETROS_POR_VIAJE_COMPLETO == km){
                return jugador;
            }
        }
        return null;
    }
}
