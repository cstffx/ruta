package com.comtel;

import com.comtel.ruta.Carta;
import com.comtel.ruta.CartaSubtipo;
import com.comtel.ruta.Tipo;
import com.comtel.ruta.Mano;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author user
 */
public class ManoTest {

    @Test
    @DisplayName("Inicializar partida")
    public void testMeter() {
        var mano = new Mano();

        var carta = new Carta(Tipo.DistanciaKilometrica, CartaSubtipo.Distancia50Km); 
        
        mano.add(carta);

        var esperado = 1;
        var actual = mano.size();

        assertEquals(esperado, actual);
        
        mano.addMany(carta, 6);
        
        esperado = 7;
        actual = mano.size();
        assertEquals(esperado, actual);
    }
}
