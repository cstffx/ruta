package com.comtel.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.comtel.ruta.Carta;
import com.comtel.ruta.CartaSubtipo;
import com.comtel.ruta.Tipo;
import com.comtel.ruta.Pila;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author user
 */
public class PilaTest {

    @Test
    @DisplayName("Transferir")
    public void testTransferir() throws Exception {
        var a = new Pila();
        var b = new Pila();

        var carta1 = new Carta(Tipo.DistanciaKilometrica, CartaSubtipo.Distancia25Km);
        var carta2 = new Carta(Tipo.DistanciaKilometrica, CartaSubtipo.Distancia25Km);
        var carta3 = new Carta(Tipo.DistanciaKilometrica, CartaSubtipo.Distancia25Km);

        a.add(carta1);
        a.add(carta2);
        a.add(carta3);

        assertEquals(3, a.size());
        assertEquals(carta1, a.get(0));
        assertEquals(carta2, a.get(1));
        assertEquals(carta3, a.get(2));

        // Debe transferir desde el final al comienzo
        Pila.transfer(a, b);
        assertEquals(b.get(0), carta3);
        Pila.transfer(a, b);
        assertEquals(b.get(1), carta2);
        Pila.transfer(a, b);
        assertEquals(b.get(2), carta1);

        assertEquals(true, a.isEmpty());
        assertEquals(3, b.size());
    }

    @Test
    @DisplayName("Transferir por indice")
    public void testTransferirPorIndice() throws Exception {
        var a = new Pila();
        var b = new Pila();

        var carta1 = new Carta(Tipo.DistanciaKilometrica, CartaSubtipo.Distancia25Km);
        var carta2 = new Carta(Tipo.DistanciaKilometrica, CartaSubtipo.Distancia25Km);
        var carta3 = new Carta(Tipo.DistanciaKilometrica, CartaSubtipo.Distancia25Km);

        a.add(carta1);
        a.add(carta2);
        a.add(carta3);

        Pila.transfer(a, b, 1);
        assertEquals(b.get(0), carta2);

        Pila.transfer(a, b, 1);
        assertEquals(b.get(1), carta3);

        Pila.transfer(a, b, 0);
        assertEquals(b.get(2), carta1);
        
        assertEquals(true, a.isEmpty());
        assertEquals(3, b.size());
    }

    @Test
    @DisplayName("Agregar y transferir muchos")
    public void testTransferirMuchos() throws Exception {
        var count = 6;
        var a = new Pila();
        var b = new Pila();
        
        var carta = new Carta(Tipo.DistanciaKilometrica, CartaSubtipo.Distancia25Km);
        a.addMany(carta, count);

        Pila.transferMany(a, b, count);

        assertEquals(0, a.size());
        assertEquals(count, b.size());
    }
}
