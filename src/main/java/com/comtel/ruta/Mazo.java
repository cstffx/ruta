package com.comtel.ruta;

import java.util.LinkedList;

/**
 *
 * @author user
 */
public final class Mazo extends Pila {
    
    public Mazo() {
        this.crearMazo();
    }
    
    private LinkedList<Carta> crearMazo() {
        LinkedList<CartaTupla> vi = new LinkedList<>();
        
        vi.push(new CartaTupla(CartaTipo.PeligroAtaque, CartaSubtipo.Siga, 3));
        vi.push(new CartaTupla(CartaTipo.PeligroAtaque, CartaSubtipo.Pinchazo, 3));
        vi.push(new CartaTupla(CartaTipo.PeligroAtaque, CartaSubtipo.Accidente, 3));
        vi.push(new CartaTupla(CartaTipo.PeligroAtaque, CartaSubtipo.LimiteVelocidad, 4));
        vi.push(new CartaTupla(CartaTipo.PeligroAtaque, CartaSubtipo.Pare, 5));

        vi.push(new CartaTupla(CartaTipo.SolucionesDefensa, CartaSubtipo.Gasolina, 6));
        vi.push(new CartaTupla(CartaTipo.SolucionesDefensa, CartaSubtipo.LlantaRepuesto, 6));
        vi.push(new CartaTupla(CartaTipo.SolucionesDefensa, CartaSubtipo.Reparacion, 6));
        vi.push(new CartaTupla(CartaTipo.SolucionesDefensa, CartaSubtipo.FinLimiteVelocidad, 6));
        vi.push(new CartaTupla(CartaTipo.SolucionesDefensa, CartaSubtipo.Siga, 14));
        
        vi.push(new CartaTupla(CartaTipo.SeguridadEscudo, CartaSubtipo.Sistema, 1));
        vi.push(new CartaTupla(CartaTipo.SeguridadEscudo, CartaSubtipo.LlantaIrrompible, 1));
        vi.push(new CartaTupla(CartaTipo.SeguridadEscudo, CartaSubtipo.ViaLibre, 1));
        vi.push(new CartaTupla(CartaTipo.SeguridadEscudo, CartaSubtipo.AzAlVolante, 1));
        
        vi.push(new CartaTupla(CartaTipo.DistanciaKilometrica, CartaSubtipo.Distancia200Km, 4));
        vi.push(new CartaTupla(CartaTipo.DistanciaKilometrica, CartaSubtipo.Distancia100Km, 12));
        vi.push(new CartaTupla(CartaTipo.DistanciaKilometrica, CartaSubtipo.Distancia75Km, 10));
        vi.push(new CartaTupla(CartaTipo.DistanciaKilometrica, CartaSubtipo.Distancia50Km, 10));
        vi.push(new CartaTupla(CartaTipo.DistanciaKilometrica, CartaSubtipo.Distancia25Km, 10));
        
        vi.push(new CartaTupla(CartaTipo.SemaforoVerde, CartaSubtipo.Ninguno, 1));
        vi.push(new CartaTupla(CartaTipo.SemaforoRojo, CartaSubtipo.Ninguno, 1));
        
        LinkedList<Carta> result = new LinkedList<>();
        for( CartaTupla tupla: vi ){
            for(int i = 0; i < tupla.cantidad; i++){
                this.meter(new Carta(tupla.tipo, tupla.subtipo));
            }
        }
        
        this.mezclar();
                
        return this.getAll();
    }
}
