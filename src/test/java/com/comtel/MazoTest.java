package com.comtel;

import com.comtel.ruta.Juego;
import com.comtel.ruta.Mazo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author user
 */
public class MazoTest {
    
    @Test
    @DisplayName("El mazo debe contener 106 cartas")
    public void crearMazoTest() {
        Mazo mazo = new Mazo();
        mazo.reiniciar();
        assertEquals(Juego.CARTAS_TOTALES, mazo.size());
    }
}
