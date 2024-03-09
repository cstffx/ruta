package com.comtel.ruta;

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
            jugador.tomarMano(mazo);
        }
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
