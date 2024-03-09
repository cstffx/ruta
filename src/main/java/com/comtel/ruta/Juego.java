package com.comtel.ruta;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author user
 */
public class Juego {

    private LinkedList<Carta> mazo;
    
    public Juego() {
    }
    
    private void inicializarMazo() {
        this.mazo = new LinkedList<>();
        
        LinkedList<CartaTupla> vectorInicializacion = new LinkedList<>();
        vectorInicializacion.push(new CartaTupla(CartaTipo.PeligroAtaque, CartaSubtipo.Siga, 3));
        vectorInicializacion.push(new CartaTupla(CartaTipo.PeligroAtaque, CartaSubtipo.Pinchazo, 3));
        vectorInicializacion.push(new CartaTupla(CartaTipo.PeligroAtaque, CartaSubtipo.Accidente, 3));
        vectorInicializacion.push(new CartaTupla(CartaTipo.PeligroAtaque, CartaSubtipo.LimiteVelocidad, 4));
        vectorInicializacion.push(new CartaTupla(CartaTipo.PeligroAtaque, CartaSubtipo.Pare, 5));

        vectorInicializacion.push(new CartaTupla(CartaTipo.PeligroAtaque, CartaSubtipo.Gasolina, 6));
        vectorInicializacion.push(new CartaTupla(CartaTipo.PeligroAtaque, CartaSubtipo.LlantaRepuesto, 6));
        vectorInicializacion.push(new CartaTupla(CartaTipo.PeligroAtaque, CartaSubtipo.Reparacion, 6));
        vectorInicializacion.push(new CartaTupla(CartaTipo.PeligroAtaque, CartaSubtipo.FinLimiteVelocidad, 6));
        vectorInicializacion.push(new CartaTupla(CartaTipo.PeligroAtaque, CartaSubtipo.Siga, 14));
        
        vectorInicializacion.push(new CartaTupla(CartaTipo.PeligroAtaque, CartaSubtipo.Sistema, 1));
        vectorInicializacion.push(new CartaTupla(CartaTipo.PeligroAtaque, CartaSubtipo.LlantaIrrompible, 1));
        vectorInicializacion.push(new CartaTupla(CartaTipo.PeligroAtaque, CartaSubtipo.ViaLibre, 1));
        vectorInicializacion.push(new CartaTupla(CartaTipo.PeligroAtaque, CartaSubtipo.AzAlVolante, 1));
        
        vectorInicializacion.push(new CartaTupla(CartaTipo.PeligroAtaque, CartaSubtipo.Distancia4200Km, 9));
        vectorInicializacion.push(new CartaTupla(CartaTipo.PeligroAtaque, CartaSubtipo.Distancia12100Km, 9));
        vectorInicializacion.push(new CartaTupla(CartaTipo.PeligroAtaque, CartaSubtipo.Distancia1075Km, 9));
        vectorInicializacion.push(new CartaTupla(CartaTipo.PeligroAtaque, CartaSubtipo.Distancia1050Km, 9));
        vectorInicializacion.push(new CartaTupla(CartaTipo.PeligroAtaque, CartaSubtipo.Distancia1025Km, 10));
    }
}
