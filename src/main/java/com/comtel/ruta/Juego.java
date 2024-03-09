package com.comtel.ruta;

/**
 *
 * @author user
 */
public final class Juego {

    public static int CARTAS_TOTALES = 108; 
    
    private final Mazo mazo = new Mazo();
    private final Turno turno;
    
    public Juego(int jugadores) {
        this.turno = new Turno(jugadores, mazo);
    }
    
    public boolean esFinal() {
        // TODO: Utilizar eventos
        if(this.mazo.vacio()){
            return true;
        }
        return false;
    }
}
