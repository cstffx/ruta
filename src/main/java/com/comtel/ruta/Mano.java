package com.comtel.ruta;

import java.util.LinkedList;

/**
 *
 * @author user
 */
public class Mano {
    
    private final LinkedList<Carta> cartas = new LinkedList<>();
    
    public void vaciar() {
        this.cartas.clear();
    }
    
    public void meter(Carta carta){
        this.cartas.push(carta);
    }
    
    public Carta sacar(int index) throws Exception {
         if(this.cartas.size() != 7){
            throw new Exception("Cantidad de cartas insuficientes para descartar.");
        }
        return this.cartas.remove(index);
    }
    
    public int size() {
        return this.cartas.size();
    }
    
    void descartar(int index) throws Exception {
        this.sacar(index);
    }
}
