package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import cliente.Cliente;

public class CalculadoraTarifasTemporadaAlta extends CalculadoraTarifas {

    protected static final int COSTO_POR_KM = 1000;

    @Override
    public int calcularTarifa(Vuelo vuelo, Cliente cliente) {
        int costoBase = calcularCostoBase(vuelo, cliente);
        double descuento = calcularPorcentajeDescuento(cliente);
        int valorImpuestos = calcularValorImpuestos(costoBase);

        int valorFinal = (int) (costoBase * (1 - descuento)) + valorImpuestos;

        return valorFinal;
    }

    @Override
    protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
        int distancia = calcularDistanciaVuelo(vuelo.getRuta());
        return distancia * COSTO_POR_KM;
    }

    @Override
    protected double calcularPorcentajeDescuento(Cliente cliente) {
        return 0.0; //porque no veo valores de descuento entonces no hay descuento :p
    }
}
