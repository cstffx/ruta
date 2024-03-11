package com.comtel.test;

import com.comtel.ruta.Carta;
import com.comtel.ruta.CartaSubtipo;
import com.comtel.ruta.Juego;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.comtel.ruta.Jugador;
import com.comtel.ruta.Mazo;
import com.comtel.ruta.Tipo;
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

        for (int i = 0; i < cantidadJugadores; i++) {
            var jugador = new Jugador(1);
            jugador.tomarDelMazo(mazo, Juego.CARTAS_EN_MANO);
        }

        var obtenido = mazo.size();
        var esperado = cartasTotales - (cantidadJugadores * cantidadCartas);

        // cartas_totales - 6 jugadors * 6 cartas por jugador
        assertEquals(obtenido, esperado);
    }

    @Test
    @DisplayName("Puntos de velocidad")
    public void testPuntosVelocidad() {
        var jugador = new Jugador(1);
        var subtipos = new CartaSubtipo[]{
            CartaSubtipo.Sistema,
            CartaSubtipo.LlantaIrrompible,
            CartaSubtipo.ViaLibre,
            CartaSubtipo.AzAlVolante,};

        var pila = jugador.getPilaSeguridadEscudo();
        for (CartaSubtipo subtipo : subtipos) {
            pila.add(new Carta(Tipo.SeguridadEscudo, subtipo));
        }

        var extraida = pila.extract(0);

        var esperado = 3 * Juego.PUNTOS_POR_UNA_SEGURIDAD;
        var obtenido = jugador.getPuntosSeguridad();
        assertEquals(esperado, obtenido);

        // Ahora deben contar los puntos por tener todas
        // las cartas de seguridad.
        pila.add(extraida);
        
        esperado = 4 * Juego.PUNTOS_POR_UNA_SEGURIDAD + Juego.PUNTOS_POR_TODAS_SEGURIDAD;
        obtenido = jugador.getPuntosSeguridad();
        assertEquals(esperado, obtenido);
    }
}
