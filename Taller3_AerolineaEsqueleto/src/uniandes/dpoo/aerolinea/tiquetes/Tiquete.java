package uniandes.dpoo.aerolinea.tiquetes;
import java.util.List;

import cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.Vuelo;

public class Tiquete {
	
	private String codigo;
	private int tarifa;
	private boolean usado;

	private Vuelo vuelo;
	private Cliente clienteComprador;
	
	public Tiquete(String codigo, Vuelo vuelo, Cliente cliente, int tarifa) {
		
		this.codigo = codigo;
		this.vuelo = vuelo;
		this.clienteComprador = cliente;
		this.tarifa = tarifa;
		this.usado = false;
	}
	
	public Cliente getClienteComprador() {
		return clienteComprador;
	}
	

	public Vuelo getVuelo() {
		return vuelo;
	}

	public String getCodigo() {
		return codigo;
	}
	
	public int getTarifa() {
		return tarifa;
	}
	
	public void marcarComoUsado() {
		this.usado=true;
	}
	public boolean esUsado() {
		return usado;
	}

	
	
	
	
	
	
}