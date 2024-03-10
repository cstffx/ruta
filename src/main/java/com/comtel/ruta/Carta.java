package com.comtel.ruta;

/**
 *
 * @author user
 */
public class Carta {

    private CartaSubtipo subtipo;
    private Tipo tipo;

    public Carta(Tipo tipo, CartaSubtipo subtipo) {
        this.tipo = tipo;
        this.subtipo = subtipo;
    }

    public CartaSubtipo getSubtipo() {
        return subtipo;
    }

    public void setSubtipo(CartaSubtipo subtipo) {
        this.subtipo = subtipo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public boolean isKilometrica() {
        return this.tipo == Tipo.DistanciaKilometrica;
    }

    public boolean isSeguridad() {
        return this.tipo == Tipo.SeguridadEscudo;
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
