package com.comtel.ruta;

/**
 *
 * @author user
 */
public class Mano extends Pila {
    
    @Override
    public Carta sacar(int i) {
        if(this.size() == 7){
            return super.sacar(i);            
        }
        return null;
    }
    
    /**
     * Envía una carta al pozo
     * @param index
     * @throws Exception 
     */
    void enviarAPozo(int index) throws Exception {
        this.sacar(index);
    }
}
