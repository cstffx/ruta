package com.comtel.test;

import com.comtel.ruta.Carta;
import com.comtel.ruta.CartaSubtipo;
import com.comtel.ruta.Tipo;
import com.comtel.ruta.ConfiguracionJugada;
import com.comtel.ruta.Juego;
import com.comtel.ruta.Jugador;
import com.comtel.ruta.Partida;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author user
 */
public class PartidaTest {

    @Test
    @DisplayName("Agregar jugador")
    public void testPartida() {
        var esperado = 6;
        var partida = new Partida();
        for (int i = 0; i < esperado; i++) {
            partida.agregarJugador(new Jugador(i + 1));
        }

        var obtenido = partida.getJugadores().size();
        assertEquals(esperado, obtenido);
    }

    @Test
    @DisplayName("Iniciar partida")
    public void testIniciarPartida() {
        var cantidadJugadores = 6;
        var partida = new Partida();
        for (int i = 0; i < cantidadJugadores; i++) {
            partida.agregarJugador(new Jugador(i + 1));
        }

        partida.nuevaPartida();

        var jugadores = partida.getJugadores();
        for (Jugador jugador : jugadores) {
            var mano = jugador.getMano();
            assertEquals(Juego.CARTAS_EN_MANO, mano.size());
        }
    }

    @Test
    @DisplayName("Comprobar paso de jugador")
    public void testSiguienteJugador() {
        var partida = new Partida();
        for (int i = 0; i < 6; i++) {
            partida.agregarJugador(new Jugador(i + 1));
        }

        var esperado = partida.getJugadores().get(0);
        var obtenido = partida.getJugadorActual();
        assertEquals(esperado, obtenido);

        partida.avanzarJugador();

        esperado = partida.getJugadores().get(1);
        obtenido = partida.getJugadorActual();
        assertEquals(esperado, obtenido);

        for (int i = 0; i < 5; i++) {
            partida.avanzarJugador();
        }

        esperado = partida.getJugadores().get(0);
        obtenido = partida.getJugadorActual();
        assertEquals(esperado, obtenido);
    }

    @Test
    @DisplayName("Jugada kilometrica")
    public void testJugadaKilometrica() throws Exception {
        var partida = new Partida();
        partida.agregarJugador(new Jugador(0));
        partida.nuevaPartida();

        var jugador = partida.getJugadores().get(0);
        var mano = jugador.getMano();
        mano.clear();

        var cantidad = Juego.CARTAS_EN_MANO + 1;
        var tipo = Tipo.DistanciaKilometrica;
        var subtipo = CartaSubtipo.Distancia200Km;
        var carta = new Carta(tipo, subtipo);
        
        mano.addMany(carta, cantidad);
        
        assertEquals(cantidad, mano.size());
        assertEquals(jugador, partida.getJugadorActual());
        
        var jugada = new ConfiguracionJugada();
        jugada.indiceCarta = 0;
        
        for (int i = 0; i < cantidad + 1; i++) {
            assertEquals(true, carta.isKilometrica());
        }
        
        partida.jugada(jugada);
        assertEquals(cantidad - 1, mano.size());

        mano.addMany(carta, 1);
        partida.jugada(jugada);
        assertEquals(cantidad - 1, mano.size());
        
        assertEquals(400, jugador.getPuntuacionPartida());
                
        mano.addMany(carta, 1);
        partida.jugada(jugada);
        assertEquals(cantidad - 1, mano.size());
        assertEquals(600, jugador.getPuntuacionPartida());
        
        // 800
        mano.addMany(carta, 1);
        partida.jugada(jugada);
        assertEquals(cantidad - 1, mano.size());
        assertEquals(800, jugador.getPuntuacionPartida());
  
        // 1000
        mano.addMany(carta, 1);
        partida.jugada(jugada);
        assertEquals(cantidad - 1, mano.size());
        assertEquals(1400, jugador.getPuntuacionPartida());
        
        assertEquals(true, partida.esFinal());
    }
}