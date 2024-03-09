package com.comtel.ruta;

import java.util.LinkedList;

/**
 *
 * @author user
 */
public class Jugador {
    
    private int juegosGanados = 0;
    private final Pila ataque = new Pila(); 
    private final Pila defensa = new Pila();
    private final Mano mano = new Mano();
    
    public LinkedList<Carta> tomar(Mazo mazo, int cantidad){
        LinkedList<Carta> cartasTomadas = new LinkedList<>();
        this.mano.vaciar();
        for(int i = 0; i < cantidad; i++){
            // Pasamos la ultima carta del mazo a la mano
            var carta = Pila.transferir(mazo, this.mano);
            cartasTomadas.push(carta);
        }
        return cartasTomadas;
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
