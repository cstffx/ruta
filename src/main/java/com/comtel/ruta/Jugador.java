package com.comtel.ruta;

/**
 *
 * @author user
 */
public class Jugador {
    
    private int juegosGanados = 0;
    private final Pila ataque = new Pila(); 
    private final Pila defensa = new Pila();
    private final Mano mano = new Mano();
    
    public void tomarMano(Mazo mazo){
        this.mano.vaciar();
        for(int i = 0; i < 6; i++){
            this.robarCarta(mazo);
        }
    }
    
    public void robarCarta(Mazo mazo){
        this.mano.meter(mazo.sacar());
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
