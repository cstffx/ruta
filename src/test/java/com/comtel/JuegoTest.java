package com.comtel;

import com.comtel.ruta.Juego;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author user
 */
public class JuegoTest {
    
    @Test
    @DisplayName("El mazo debe contener 106 cartas")
    public void crearMazoTest() {
        Juego juego = new Juego();
        assertEquals(106, juego.crearMazo().size());
    }
}
