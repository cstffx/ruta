package com.comtel.ruta;

import java.util.LinkedList;

/**
 *
 * @author user
 */
public final class Mazo extends Pila {
    
    public Mazo() {
        this.reiniciar();
    }
    
    public LinkedList<Carta> reiniciar() {
        
        // Quitamos todas las cartas que puedan quedar.
        vaciar();
        
        this.meter(new Carta(CartaTipo.PeligroAtaque, CartaSubtipo.Siga), 3);
        this.meter(new Carta(CartaTipo.PeligroAtaque, CartaSubtipo.Pinchazo), 3);
        this.meter(new Carta(CartaTipo.PeligroAtaque, CartaSubtipo.Accidente), 3);
        this.meter(new Carta(CartaTipo.PeligroAtaque, CartaSubtipo.LimiteVelocidad), 3);
        this.meter(new Carta(CartaTipo.PeligroAtaque, CartaSubtipo.Pare), 3);
        
        this.meter(new Carta(CartaTipo.SolucionesDefensa, CartaSubtipo.Gasolina), 6);
        this.meter(new Carta(CartaTipo.SolucionesDefensa, CartaSubtipo.LlantaRepuesto), 6);
        this.meter(new Carta(CartaTipo.SolucionesDefensa, CartaSubtipo.Reparacion), 6);
        this.meter(new Carta(CartaTipo.SolucionesDefensa, CartaSubtipo.FinLimiteVelocidad), 6);
        this.meter(new Carta(CartaTipo.SolucionesDefensa, CartaSubtipo.Siga), 14);
        
             
        this.meter(new Carta(CartaTipo.SeguridadEscudo, CartaSubtipo.Sistema), 1);
        this.meter(new Carta(CartaTipo.SeguridadEscudo, CartaSubtipo.LlantaIrrompible), 1);
        this.meter(new Carta(CartaTipo.SeguridadEscudo, CartaSubtipo.ViaLibre), 1);
        this.meter(new Carta(CartaTipo.SeguridadEscudo, CartaSubtipo.AzAlVolante), 1);
        
        this.meter(new Carta(CartaTipo.DistanciaKilometrica, CartaSubtipo.Distancia200Km), 4);
        this.meter(new Carta(CartaTipo.DistanciaKilometrica, CartaSubtipo.Distancia100Km),12);
        this.meter(new Carta(CartaTipo.DistanciaKilometrica, CartaSubtipo.Distancia75Km),10);
        this.meter(new Carta(CartaTipo.DistanciaKilometrica, CartaSubtipo.Distancia50Km),10);
        this.meter(new Carta(CartaTipo.DistanciaKilometrica, CartaSubtipo.Distancia25Km),10);
        
        this.meter(new Carta(CartaTipo.SemaforoVerde, CartaSubtipo.Ninguno), 1);
        this.meter(new Carta(CartaTipo.SemaforoRojo, CartaSubtipo.Ninguno), 1);
         
        this.mezclar();
                
        return this.getAll();
    }
}
