package com.comtel.ruta;

import java.util.LinkedList;

/**
 *
 * @author user
 */
public class Jugador {
    private final LinkedList<Carta> pilaAtaque = new LinkedList(); 
    private final LinkedList<Carta> pilaDefensa = new LinkedList();
    private final Mano mano;
    
    public Jugador(Mazo mazo) {
        this.mano = new Mano(mazo);
    }
    
    public Mano getMano() {
        return this.mano;
    }
}
