package com.comtel.ruta;

import java.util.LinkedList;

/**
 *
 * @author user
 */
public class Pila {
    private final LinkedList<Carta> cartas = new LinkedList();
    
    public void depositar(Carta carta){
        this.cartas.push(carta);
    }
}
