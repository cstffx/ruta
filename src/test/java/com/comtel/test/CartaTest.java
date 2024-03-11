package com.comtel.test;

import com.comtel.ruta.Carta;
import com.comtel.ruta.CartaSubtipo;
import com.comtel.ruta.Tipo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author user
 */
public class CartaTest {
    @Test
    @DisplayName("Inicializar jugador")
    public void testCarta() {        
        var carta = new Carta(Tipo.DistanciaKilometrica, CartaSubtipo.Distancia25Km);
        var esperado = 25;
        var obtenido = carta.getKilometros();
        assertEquals(esperado, obtenido);
    }
    
}
