package com.comtel.ruta;

enum TipoPila {
    
}

/**
 *
 * @author user
 */
public final class Juego {

    public static int CARTAS_TOTALES = 108;
    public static int CARTAS_EN_MANO = 6;
    public static int CARTAS_AL_ROBAR = 7;

    private Mazo mazo;
    private Turno turno;
    private final int size;

    public Juego(int size) {
        this.size = size;
        this.turno = new Turno(size);

        this.nuevoJuego();
    }

    public void nuevoJuego() {
        this.mazo = new Mazo();
        // Repartir cartas.
        var jugadores = this.turno.getJugadores();
        for (Jugador jugador : jugadores) {
            jugador.tomar(mazo, 6);
        }
    }
    
    public Carta robarCarta(){
        var jugador = this.turno.getJugadorActual();
        var cartas = jugador.tomar(mazo, 1);
        if(cartas.isEmpty()){
            return null;
        }
        return cartas.get(0);
    }
    
    public void jugarCarta(int index, TipoPila pila){ 
        
    }

    public boolean esFinal() {
        // TODO: Utilizar eventos
        if (this.mazo.vacio()) {
            return true;
        }
        return false;
    }

    public Mazo getMazo() {
        return this.mazo;
    }

    public Turno getTurno() {
        return this.turno;
    }
}
