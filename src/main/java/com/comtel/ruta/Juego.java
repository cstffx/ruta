package com.comtel.ruta;

/**
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
    
    private final Partida partida;

    public Juego() {
        partida = new Partida();
    }

    public void nuevaPartida() {
        partida.nuevaPartida();
    }

    public Carta robarCarta() {
        return partida.robarCarta();
    }
    
    public void contabilizarPuntos() {
        partida.contabilizarPuntos();
    }

    public void jugarCarta(int index, ConfiguracionJugada jugada) throws Exception {
        var jugador = partida.getJugadorActual();
        var mano = jugador.getMano();

        if (jugada.enviarAPozo) {
            mano.enviarAPozo(index);
            return;
        }

        var carta = mano.getCarta(index);
        
        Pila pila = null;
        
        // TODO: Decidir a donde mover la carta.
        if (carta.isKilometrica()) {   
            pila = jugador.getPilaKilometrica();
        }
        
        // Mover una carta especifica de la mano a una pila.
        Pila.transferir(mano, pila, index);    
    }
    
    public boolean esFinal() {
        // TODO
        return false;
    }
  
    // TODO: Utilizar eventos
    public boolean esFinalParcial() {
        return partida.esFinal();
    }

    public Mazo getMazo() {
        return partida.getMazo();
    }

    public Partida getTurno() {
        return partida;
    }
}
