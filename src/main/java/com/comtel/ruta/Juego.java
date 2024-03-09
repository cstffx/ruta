package com.comtel.ruta;

import java.util.LinkedList;

/**
 *
 * @author user
 */
public final class Juego {

    public static int CARTAS_TOTALES = 108; 
    
    private final Mazo mazo = new Mazo();
    private final LinkedList<Jugador> jugadores;
    private final int jugadorActual = 0;
    
    public Juego(int jugadores) { 
        this.jugadores = new LinkedList<>();   
        for(int i = 0; i < jugadores; i++){
            this.jugadores.push(new Jugador(this.mazo));
        }
    }
    
    public boolean esFinal() {
        // TODO: Utilizar eventos
        if(this.mazo.vacio()){
            return true;
        }
        return false;
    }
}
