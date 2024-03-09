package com.comtel;

import com.comtel.ruta.Juego;
import com.comtel.ruta.Jugador;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author user
 */
public class JuegoTest {

    @Test
    @DisplayName("Inicializar juego")
    public void testNuevoJuego() {
        var cantJugadores = 6;
        var juego = new Juego(cantJugadores);
        var jugadores = juego.getTurno().getJugadores();

        {
            var obtenido = jugadores.size();
            var esperado = cantJugadores;
            assertEquals(obtenido, esperado);
        }
        
        {
            for(Jugador jugador: jugadores){
                var mano = jugador.getMano();
                var obtenido = mano.size();
                var esperado = Juego.CARTAS_EN_MANO;
                assertEquals(obtenido, esperado);
            }
        }
        
        var mazo = juego.getMazo();
        var obtenido = mazo.size();
        var esperado = Juego.CARTAS_TOTALES - (cantJugadores * Juego.CARTAS_EN_MANO);
        assertEquals(obtenido, esperado);
    }
}
