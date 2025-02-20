	package uniandes.dpoo.aerolinea.modelo.tarifas;
	
	import uniandes.dpoo.aerolinea.modelo.Vuelo;
	import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
	import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;
	
	public abstract class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas{
		
		protected static final int COSTO_POR_KM_NATURAL = 600;
		protected static final int COSTO_POR_KM_CORPORATIVO =900;
		protected static final double DESCUENTO_PEQ=0.02;
		protected static final double DESCUENTO_MEDIANAS = 0.1;
		protected static final double DESCUENTO_GRANDES = 0.2;
		
		
		protected  int calcularTarifa() {
			
			
			
			return 0;
		}
		
		
	    protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
	        int distancia = calcularDistanciaVuelo(vuelo.getRuta());
	        int costoBase = 0;
	        if(cliente.getTipoCliente().equals("Natural")) {
	        	costoBase=distancia*COSTO_POR_KM_NATURAL;
	        }
	        else {
	        	costoBase = distancia*COSTO_POR_KM_CORPORATIVO;
	        }
	        return costoBase;
	    }
	   protected double calcularPorcentajeDescuento(Cliente cliente) {
		   double porcentaje = 0.0;
		   
		    
		    if (cliente.getTipoCliente().equals("Corporativo")) {
		        ClienteCorporativo clienteCorp = (ClienteCorporativo) cliente;

		        if (clienteCorp.getTamanoEmpresa() == ClienteCorporativo.GRANDE) {
		            porcentaje = DESCUENTO_GRANDES;
		        } else if (clienteCorp.getTamanoEmpresa() == ClienteCorporativo.MEDIANA) {
		            porcentaje = DESCUENTO_MEDIANAS;
		        } else if (clienteCorp.getTamanoEmpresa() == ClienteCorporativo.PEQUENA) {
		            porcentaje = DESCUENTO_PEQ;
		        }
		    }

		    return porcentaje;
	   }

	
}