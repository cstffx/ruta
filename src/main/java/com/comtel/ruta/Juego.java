package com.comtel.ruta;

import java.util.LinkedList;

/**
 *
 * @author user
 */
public final class Juego {

    private Mazo mazo = new Mazo(); 
    private final LinkedList<Jugador> jugadores;
    
    public Juego() { 
        this.jugadores = new LinkedList<>();
    }
}
