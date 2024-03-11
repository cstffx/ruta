package com.comtel.ruta;

/**
 *
 * @author user
 */
public class Pila {

    public final Cartas ataqueDefensa = new Cartas();
    public final Cartas velocidad = new Cartas();
    public final PilaKilometros kilometrica = new PilaKilometros();
    public final Cartas contrataque = new Cartas();
    public final Cartas seguridadEscudo = new Cartas();

    void vaciar() {
        ataqueDefensa.clear();
        velocidad.clear();
        kilometrica.clear();
        contrataque.clear();
        seguridadEscudo.clear();
    }
}
