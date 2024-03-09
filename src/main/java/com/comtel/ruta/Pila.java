package com.comtel.ruta;

import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author user
 */
public class Pila {

    public final static int ULTIMA_CARTA = -1;
    private final LinkedList<Carta> cartas = new LinkedList();

    public static Carta transferir(Pila a, Pila b, int index) {
        var carta = a.sacar(index);
        if( carta != null){
            b.meter(carta);            
        }
        return carta;
    }

    public static Carta transferir(Pila a, Pila b) {
        return Pila.transferir(a, b, Pila.ULTIMA_CARTA);
    }

    public int size() {
        return cartas.size();
    }

    public boolean vacio() {
        return cartas.isEmpty();
    }

    public Carta sacar(int index) {
        if (index == Pila.ULTIMA_CARTA) {
            return cartas.pollLast();
        }
        return cartas.remove(index);
    }

    public void meter(Carta carta) {
        cartas.push(carta);
    }

    public void meter(Carta carta, int cantidad) {
        for(int i = 0; i < cantidad; i++){
            this.meter(carta);
        }
    }

    public void vaciar() {
        cartas.clear();
    }

    public void mezclar() {
        Collections.shuffle(cartas);
    }
    
        
    public Carta getCarta(int index){
        return cartas.get(index);
    } 

    
    public LinkedList<Carta> getAll() {
        return cartas;
    }
}
