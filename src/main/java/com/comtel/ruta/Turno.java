package com.comtel.ruta;

import java.util.LinkedList;

/**
 *
 * @author user
 */
public class Turno {
    
    private int actual = 0; 
    private final LinkedList<Jugador> jugadores;
    
    public Turno(int size){
        this.jugadores = new LinkedList<>();
        for(int i = 0; i < size; i++){
            this.jugadores.push(new Jugador());
        }
    }
    
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
}
