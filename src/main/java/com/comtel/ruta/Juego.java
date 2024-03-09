package com.comtel.ruta;

import java.util.LinkedList;

/**
 *
 * @author user
 */
public final class Juego {

    private Mazo mazo = new Mazo();
    private final LinkedList<Jugador> jugadores;
    private int jugadorActual;
    
    public Juego() { 
        this.jugadores = new LinkedList<>();
    }
    
    public boolean esFinal() {
        // TODO: Utilizar eventos
        if(this.mazo.vacio()){
            return true;
        }
        return false;
    }
}
