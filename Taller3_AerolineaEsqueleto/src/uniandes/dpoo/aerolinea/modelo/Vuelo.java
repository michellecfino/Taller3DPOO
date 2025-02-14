package uniandes.dpoo.aerolinea.modelo;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.ArrayList;

import uniandes.dpoo.aerolinea.tiquetes.Tiquete;
import uniandes.dpoo.aerolinea.tiquetes.GeneradorTiquetes;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
import cliente.Cliente;

import java.util.Collection;
import java.util.HashMap;

public class Vuelo {

	private String fecha;
	private Ruta ruta;
	private Avion avion;
	private Map<String, Tiquete> tiquetes;	
	
	
	
	public Vuelo(Ruta ruta,String fecha, Avion avion) {

		this.fecha = fecha;
		this.ruta = ruta;
		this.avion = avion;
		this.tiquetes= new HashMap<String,Tiquete>();
	
	}

	
	public String getFecha() {
		 return this.fecha;
		 
		 
	}
	public Ruta getRuta() {
		
		return this.ruta;
		
	}
	public Avion getAvion() {
		return this.avion;
	}
	
    public Collection<Tiquete> getTiquetes()
    {
        
        return tiquetes.values();
    }
    
    public int venderTiquetes(Cliente cliente, CalculadoraTarifas calculadora, int cantidad) {
        int totalVendido = 0;
        for (int i = 0; i < cantidad; i++) {
            Tiquete tiquete = GeneradorTiquetes.generarTiquete(this, cliente, calculadora.calcularTarifa(this, cliente));
            tiquetes.put(tiquete.getCodigo(), tiquete);
            cliente.agregarTiquete(tiquete);
            totalVendido++;
        }
        return totalVendido;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Vuelo)) return false;
        Vuelo vuelo = (Vuelo) obj;
        return fecha.equals(vuelo.fecha) && ruta.equals(vuelo.ruta) && avion.equals(vuelo.avion);
    }
}