package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.*;
import uniandes.dpoo.aerolinea.modelo.Ruta;

public abstract class CalculadoraTarifas {
    public static final double IMPUESTO = 0.28;
    
    public CalculadoraTarifas() {
    	
    }

    public abstract int calcularTarifa(Vuelo vuelo, Cliente cliente);
    
    protected abstract int calcularCostoBase(Vuelo vuelo, Cliente cliente);
    
    protected abstract double calcularPorcentajeDescuento(Cliente cliente);
    
    protected int calcularDistanciaVuelo(Ruta ruta) {
        
        return ruta.getDuracion(); 
    }
    
    public int calcularValorImpuestos(int costoBase) {
        return (int) (costoBase * IMPUESTO);
    }
    


	

}