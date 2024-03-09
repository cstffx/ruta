package com.comtel.ruta;

import java.util.LinkedList;

/**
 *
 * @author user
 */
public class Jugador {
    
    private int juegosGanados = 0;
    private final Pila ataque = new Pila(); 
    private final Pila Defensa = new Pila();
    private final Mano mano;
    
    public Jugador(Mazo mazo) {
        this.mano = new Mano(mazo);
    }
    
    public Mano getMano() {
        return this.mano;
    }
    
    public void anotarVictoria() {
        ++this.juegosGanados;
    }
    
    public void jugarCarta(int index) throws Exception{
        var carta = this.mano.sacar(index);
        var tipo = carta.getTipo();
        var subtipo = carta.getSubtipo(); 
        // TODO Jugar carta
    }
}
