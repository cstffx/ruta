package com.comtel;

import com.comtel.ruta.Juego;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.comtel.ruta.Jugador;
import com.comtel.ruta.Mazo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author user
 */
public class JugadorTest {
    
    @Test
    @DisplayName("Inicializar jugador")
    public void testIniciarMano() {
        var mazo = new Mazo();
        var cantidadCartas = 6;
        var cantidadJugadores = 6;
        var cartasTotales = Juego.CARTAS_TOTALES;
        
        for(int i = 0; i < cantidadJugadores; i++){
            var jugador = new Jugador();
            jugador.tomar(mazo);
        }
        
        var obtenido = mazo.size();
        var esperado = cartasTotales - (cantidadJugadores*cantidadCartas);
        
        // cartas_totales - 6 jugadors * 6 cartas por jugador
        assertEquals(obtenido, esperado);
    }
}
