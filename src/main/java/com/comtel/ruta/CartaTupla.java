package com.comtel.ruta;

/**
 *
 * @author user
 */
public class CartaTupla {
    public CartaTipo tipo;
    public CartaSubtipo subtipo;
    public int cantidad;

    public CartaTupla(CartaTipo tipo, CartaSubtipo subtipo, int cantidad) {
        this.tipo = tipo;
        this.subtipo = subtipo;
        this.cantidad = cantidad;
    }
}
