package com.comtel.ruta;

/**
 *
 * @author user
 */
public class PilaKilometros extends Pila {
    
    public boolean viajeSeguro() {
        var cartas = this.getAll();
        for(Carta carta: cartas){
            if(Juego.KM_INSEGUROS == carta.getKilometros()){
                return false;
            }
        }
        return true;
    }
    
    public boolean completaViaje() {
        return this.getKilometrosTotales() == Juego.KILOMETROS_POR_VIAJE_COMPLETO;
    }
    
    public int getKilometrosTotales() {
        var total = 0;
        var cartas = this.getAll();
        for(Carta carta: cartas){
            total += carta.getKilometros();
        }
        return total;
    }
}
