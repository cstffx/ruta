package com.comtel.ruta;

import java.util.LinkedList;

/**
 *
 * @author user
 */
public class Turno {
    
    private int actual = 0; 
    private LinkedList<Jugador> jugadores;
    
    public Turno(int size, Mazo mazo){
        this.jugadores = new LinkedList<>();   
        for(int i = 0; i < size; i++){
            this.jugadores.push(new Jugador(mazo));
        }
    }
    
    public void siguienteJugador() {
        this.actual = (this.actual + 1) % this.jugadores.size();
    }
}
