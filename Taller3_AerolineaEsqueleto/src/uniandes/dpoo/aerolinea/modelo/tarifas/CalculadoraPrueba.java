package uniandes.dpoo.aerolinea.modelo.tarifas;

import cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;

public class CalculadoraPrueba extends CalculadoraTarifas{
	
    protected static final int COSTO_POR_KM_NATURAL = 600;
    protected static final int COSTO_POR_KM_CORPORATIVO = 900;
    protected static final double DESCUENTO_PEQ = 0.02;
    protected static final double DESCUENTO_MEDIANAS = 0.1;
    protected static final double DESCUENTO_GRANDES = 0.2;

	@Override
	public int calcularTarifa(Vuelo vuelo, Cliente cliente) {
		// TODO Auto-generated method stub
		int costoBase = calcularCostoBase(vuelo, cliente);
	    double descuento = calcularPorcentajeDescuento(cliente);
	    int valorImpuestos = calcularValorImpuestos(costoBase);
	
	    return (int) (costoBase * (1 - descuento)) + valorImpuestos;
	}

	@Override
	protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		// TODO Auto-generated method stub
		int distancia = calcularDistanciaVuelo(vuelo.getRuta());
        int costoBase;
        
        if (cliente.getTipoCliente().equals("Natural")) {
            costoBase = distancia * COSTO_POR_KM_NATURAL;
        } else {
            costoBase = distancia * COSTO_POR_KM_CORPORATIVO;
        }
        
        return costoBase;
	}

	@Override
	protected double calcularPorcentajeDescuento(Cliente cliente) {
		// TODO Auto-generated method stub
		   double porcentaje = 0.0;
		   
		    
		   if (cliente instanceof ClienteCorporativo) {
		        ClienteCorporativo clienteCorp = (ClienteCorporativo) cliente;

		        if (clienteCorp.getTamanoEmpresa() == ClienteCorporativo.GRANDE) {
		            porcentaje = DESCUENTO_GRANDES;
		        } else if (clienteCorp.getTamanoEmpresa() == ClienteCorporativo.MEDIANA) {
		            porcentaje = DESCUENTO_MEDIANAS;
		        } else if (clienteCorp.getTamanoEmpresa() == ClienteCorporativo.PEQUENA) {
		            porcentaje = DESCUENTO_PEQ;
		        }
		    }

		    return porcentaje;}

}
