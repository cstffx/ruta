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
    public static int PUNTOS_POR_ELIMINACION = 500;
    public static int PUNTOS_MIN_PARA_GANAR = 5000;
    
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

    public void jugada(ConfiguracionJugada jugada) throws Exception {
        partida.jugada(jugada);
    }
        
    public boolean esFinal() {
        var jugadores = partida.getJugadores();
        for(Jugador j: jugadores){
            if(j.ganaPartida()){
                
            }
        }
        return false;
    }
  
    // TODO: Utilizar eventos
    public boolean esFinalParcial() {
        return partida.esFinal();
    }

    public Partida getPartida() {
        return partida;
    }
}
