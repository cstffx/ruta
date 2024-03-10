package com.comtel.ruta;

import java.util.LinkedList;

/**
 *
 * @author user
 */
public class Jugador {

    private int juegosGanados = 0;
    private int equipo = 0;
    private int puntuacion = 0;

    private final Pila ataqueDefensa = new Pila();
    private final Pila velocidad = new Pila();
    private final PilaKilometros kilometrica = new PilaKilometros();
    private final Pila contrataque = new Pila();
    private final Pila seguridadEscudo = new Pila();

    private final Mano mano = new Mano();

    public Jugador(int equipo) {
        this.equipo = equipo;
    }
    
    public boolean mismoEquipo(Jugador jugador){
        return equipo == jugador.getEquipo();
    }
    
    public int getEquipo(){
        return equipo;
    }
    
    public boolean tieneCartaDistancia() {
        return kilometrica.size() > 0;
    }
    
    public boolean esViajeSeguro() {
        return kilometrica.esViajeSeguro();
    }
    
    public boolean esViajeCompleto() {
        return kilometrica.esViajeCompleto();
    }

    public LinkedList<Carta> tomarDePila(Mazo mazo, int cantidad) {
        LinkedList<Carta> cartasTomadas = new LinkedList<>();
        for (int i = 0; i < cantidad; i++) {
            // Pasamos la ultima carta del mazo a la mano
            var carta = Pila.transfer(mazo, this.mano);
            if (carta != null) {
                cartasTomadas.push(carta);
            }
        }
        return cartasTomadas;
    }

    public Mano getMano() {
        return this.mano;
    }

    public PilaKilometros getPilaKilometrica() {
        return this.kilometrica;
    }

    public void anotarVictoria() {
        ++this.juegosGanados;
    }

    public void anotarPuntos(int puntos) {
        this.puntuacion += puntos;
    }

    public Pila getPilaSeguridadEscudo() {
        return this.seguridadEscudo;
    }

    public int getPuntos() {
        var puntos = 0;

        // Puntos por km. 
        puntos += this.getPuntosPorKm();
        puntos += this.getPuntosSeguridad();

        // TODO: golpes de seguridad/contrataque.
        puntos += this.getPuntosViajeCompleto();
        
        return puntos;
    }

    public void vaciarMano() {
        this.mano.clear();
    }

    public void vaciarPilas() {
        ataqueDefensa.clear();
        velocidad.clear();
        kilometrica.clear();
        contrataque.clear();
        seguridadEscudo.clear();
    }
    
    public boolean ganaPartida() {
        return puntuacion >= Juego.PUNTOS_MIN_PARA_GANAR;
    }

    private int getPuntosPorKm() {
        return this.kilometrica.getPuntosTotales();
    }

    private int getPuntosViajeCompleto() {
        var completo = this.kilometrica.esViajeCompleto();
        return completo ? Juego.PUNTOS_POR_VIAJE_COMPLETO : 0;
    }

    private int getPuntosSeguridad() {
        int cantidad = this.seguridadEscudo.size();
        int puntos = cantidad * Juego.PUNTOS_POR_UNA_SEGURIDAD;

        if (cantidad == Juego.CANTIDAD_SEGURIDAD_ESCUDO) {
            puntos += Juego.PUNTOS_POR_TODAS_SEGURIDAD;
        }

        return puntos;
    }
}
