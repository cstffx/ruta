package com.comtel.ruta;

/**
 * @author user
 */
public class Ruta {

    public static void main(String[] args) throws Exception {
        Juego juego = new Juego();

        Jugador j = new Jugador(0);
        juego.getPartida().agregarJugador(j);

        juego.nuevaPartida();

        ConfiguracionJugada config = new ConfiguracionJugada();
        config.indiceCarta = 0;
        juego.jugada(config);
    }
}
