package com.comtel.ruta;

import static com.comtel.ruta.CartaSubtipo.Distancia100Km;
import static com.comtel.ruta.CartaSubtipo.Distancia200Km;
import static com.comtel.ruta.CartaSubtipo.Distancia25Km;
import static com.comtel.ruta.CartaSubtipo.Distancia50Km;
import static com.comtel.ruta.CartaSubtipo.Distancia75Km;

enum CartaTipo {
    PeligroAtaque,
    SolucionesDefensa,
    SeguridadEscudo,
    DistanciaKilometrica,
    SemaforoVerde,
    SemaforoRojo
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
    Distancia200Km,
    Distancia100Km,
    Distancia75Km,
    Distancia50Km,
    Distancia25Km,
    Ninguno,
}

/**
 *
 * @author user
 */
public class Carta {

    private CartaSubtipo subtipo;
    private CartaTipo tipo;

    Carta(CartaTipo tipo, CartaSubtipo subtipo) {
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

    public boolean isKilometrica() {
        return this.tipo == CartaTipo.DistanciaKilometrica;
    }

    public boolean isSeguridad() {
        return this.tipo == CartaTipo.SeguridadEscudo;
    }

    public int getKilometros() {
        return switch (this.getSubtipo()) {
            case Distancia25Km -> 25;
            case Distancia50Km -> 50;
            case Distancia75Km -> 75;
            case Distancia100Km -> 100;
            case Distancia200Km -> 200;
            default -> 0;
        };
    }

    public int getPuntuacionPorKilometros() {
        var kilometros = this.getKilometros();
        return Juego.PUNTOS_POR_KM * kilometros;
    }
}
