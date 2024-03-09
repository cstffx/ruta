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
        return this.cartas.size();
    }

    public boolean vacio() {
        return this.cartas.isEmpty();
    }

    public Carta sacar(int index) {
        if (index == Pila.ULTIMA_CARTA) {
            return this.cartas.pollLast();
        }
        return this.cartas.remove(index);
    }

    public void meter(Carta carta) {
        this.cartas.push(carta);
    }

    public void vaciar() {
        this.cartas.clear();
    }

    public void mezclar() {
        Collections.shuffle(this.cartas);
    }

    public LinkedList<Carta> getAll() {
        return this.cartas;
    }
}
