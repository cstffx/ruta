package com.comtel.ruta;

enum CartaTipo {
    PeligroAtaque,
    SolucionesDefensa,
    SeguridadEscudo,
    DistanciaKilometrica
}

enum CartaSubtipo {
    SinGasolina,
    Pinchazo,
    Accidente,
    LimiteVelocidad,
    Pare,
    Gasolina,
    LlantaRepuesto,
    Reparacion,
    FinLimiteVelocidad,
    Siga,
    Sistema,
    LlantaIrrompible,
    ViaLibre,
    AzAlVolante,
    Distancia4200Km,
    Distancia12100Km,
    Distancia1075Km,
    Distancia1050Km,
    Distancia1025Km,
}

/**
 *
 * @author user
 */
public class Carta {
    
    private CartaSubtipo subtipo;
    private CartaTipo tipo;
    
    Carta(CartaTipo tipo, CartaSubtipo subtipo){
        this.tipo = tipo;
        this.subtipo = subtipo;
    }

    public CartaSubtipo getSubtipo() {
        return subtipo;
    }

    public void setSubtipo(CartaSubtipo subtipo) {
        this.subtipo = subtipo;
    }

    public CartaTipo getTipo() {
        return tipo;
    }

    public void setTipo(CartaTipo tipo) {
        this.tipo = tipo;
    }
}
