package com.comtel.ruta;

import java.util.LinkedList;

/**
 *
 * @author user
 */
public final class Juego {

    private final LinkedList<Carta> mazo;
    
    public Juego() {
        this.mazo = this.crearMazo();
    }
    
    public LinkedList<Carta> crearMazo() {
        
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
        
        vi.push(new CartaTupla(CartaTipo.DistanciaKilometrica, CartaSubtipo.Distancia4200Km, 4));
        vi.push(new CartaTupla(CartaTipo.DistanciaKilometrica, CartaSubtipo.Distancia12100Km, 12));
        vi.push(new CartaTupla(CartaTipo.DistanciaKilometrica, CartaSubtipo.Distancia1075Km, 10));
        vi.push(new CartaTupla(CartaTipo.DistanciaKilometrica, CartaSubtipo.Distancia1050Km, 10));
        vi.push(new CartaTupla(CartaTipo.DistanciaKilometrica, CartaSubtipo.Distancia1025Km, 10));
        
        LinkedList<Carta> result = new LinkedList<>();
        for( CartaTupla tupla: vi ){
            for(int i = 0; i < tupla.cantidad; i++){
                result.add(new Carta(tupla.tipo, tupla.subtipo));
            }
        }
        
        return result;
    }
}
