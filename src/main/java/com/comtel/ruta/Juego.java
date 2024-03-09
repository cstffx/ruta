package com.comtel.ruta;

/**
 *
 * @author user
 */
public final class Juego {

    public static int CARTAS_TOTALES = 108;
    public static int CARTAS_EN_MANO = 6;
    public static int CARTAS_AL_ROBAR = 7;
    public static int CANTIDAD_SEGURIDAD_ESCUDO = 4;

    public static int PUNTOS_POR_UNA_SEGURIDAD = 100;
    public static int PUNTOS_POR_TODAS_SEGURIDAD = 300;

    public static int KM_INSEGUROS = 200;
    public static int PUNTOS_POR_KM = 1;
    public static int PUNTOS_POR_VIAJE_COMPLETO = 400;
    public static int KILOMETROS_POR_VIAJE_COMPLETO = 1000;
    public static int PUNTOS_POR_ACCION_RETARDADA = 300;
    public static int PUNTOS_POR_VIAJE_SEGURO = 300;
    
    private Mazo mazo;
    private Turno turno;

    public Juego() {
        this.turno = new Turno();
        this.nuevoJuego();
    }

    public void nuevoJuego() {
        this.mazo = new Mazo();
        // Repartir cartas.
        var jugadores = this.turno.getJugadores();
        for (Jugador jugador : jugadores) {
            jugador.tomar(mazo, 6);
        }
    }

    public Carta robarCarta() {
        var jugador = this.turno.getJugadorActual();
        var cartas = jugador.tomar(mazo, 1);
        if (cartas.isEmpty()) {
            return null;
        }
        return cartas.get(0);
    }

    public void jugarCarta(int index, ConfiguracionJugada jugada) throws Exception {
        var jugador = this.turno.getJugadorActual();

        if (jugada.enviarAPozo) {
            jugador.getMano().enviarAPozo(index);
            return;
        }

        var puntos = 0;
        var mano = jugador.getMano();
        var carta = mano.getAll().get(index);
        
        if (carta.isKilometrica()) {
            var pila = jugador.getPilaKilometrica();
            
            // Mover la carta a la pila kilometrica.
            Pila.transferir(mano, pila, index);
            
            // Contar puntos -> 
            // Puntos por kilometros.
            puntos += carta.getPuntuacionPorKilometros();
            
            // Puntos por viaje completo. 
            if(pila.completaViaje()){
                puntos += Juego.PUNTOS_POR_VIAJE_COMPLETO;
                // Puntos por accion retardada.
                if(mazo.vacio()){
                    puntos += Juego.PUNTOS_POR_ACCION_RETARDADA;
                }
            }
            
            // Puntos por viaje seguro
            if(pila.viajeSeguro()){
                puntos += Juego.PUNTOS_POR_VIAJE_SEGURO;
            }
            
        } else if (carta.isSeguridad()) {
            // Contar cantidad de cartas de seguridad. 
            var cantidad = jugador.getPilaSeguridadEscudo().size();
            if (cantidad == Juego.CANTIDAD_SEGURIDAD_ESCUDO) {
                puntos += Juego.PUNTOS_POR_TODAS_SEGURIDAD;
            } else {
                puntos += Juego.PUNTOS_POR_UNA_SEGURIDAD;
            }
        }
        
        /// TODO: Implementar continuacion/extension.
                
        jugador.anotarPuntos(puntos);
    }
    
    public boolean esFinal() {
        
    }

    public boolean esFinalParcial() {
        // Un jugador alcanza exactamente 1000 KM. 
        
        
        
        
        // TODO: Utilizar eventos
        if (this.mazo.vacio()) {
            return true;
        }
        return false;
    }

    public Mazo getMazo() {
        return this.mazo;
    }

    public Turno getTurno() {
        return this.turno;
    }
}
