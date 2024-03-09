package com.comtel.ruta;

import java.util.LinkedList;

/**
 *
 * @author user
 */
public class Mano {
    
    private LinkedList<Carta> cartas;
    
    public Mano(Mazo mazo) {
        // Roba 6 cartas del mazo al crear la mano.
        this.cartas = new LinkedList<>();
        for(int i = 0; i < 6; i++){
            this.cartas.push(mazo.robar());
        }
    }
    
    void descartar(int index) throws Exception {
        if(this.cartas.size() != 7){
            throw new Exception("Cantidad de cartas insuficientes para descartar");
        }
        this.cartas.remove(index);
    }
}
