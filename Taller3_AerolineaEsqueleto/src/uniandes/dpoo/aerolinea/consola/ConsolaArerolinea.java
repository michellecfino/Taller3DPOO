package uniandes.dpoo.aerolinea.consola;

import java.io.IOException;

import uniandes.dpoo.aerolinea.exceptions.InformacionInconsistenteException;
import uniandes.dpoo.aerolinea.modelo.Aerolinea;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;
import uniandes.dpoo.aerolinea.modelo.Avion;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.persistencia.CentralPersistencia;
import uniandes.dpoo.aerolinea.persistencia.TipoInvalidoException;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;
import uniandes.dpoo.aerolinea.consola.ConsolaBasica;

public class ConsolaArerolinea extends ConsolaBasica
{
    private Aerolinea unaAerolinea;

    /**
     * Método que corre la aplicación y carga los datos iniciales.
     */
    public void correrAplicacion()
    {
        try
        {
            unaAerolinea = new Aerolinea();
            String archivo = "tiquetes.json"; 
            unaAerolinea.cargarTiquetes("./datos/" + archivo, CentralPersistencia.JSON);
        }
        catch (TipoInvalidoException | IOException | InformacionInconsistenteException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Método para probar ClienteCorporativo con la nueva estructura de Vuelo.
     */
    public void probarClienteCorporativo()
    {
        // Crear un cliente corporativo
        ClienteCorporativo cliente = new ClienteCorporativo("TechCorp", ClienteCorporativo.GRANDE);
        System.out.println("Cliente creado: " + cliente.getNombreEmpresa());



 

        // Mostrar información del cliente y sus tiquetes
        System.out.println("Tipo de Cliente: " + cliente.getTipoCliente());
        System.out.println("Tamaño de empresa: " + cliente.getTamanoEmpresa());
        System.out.println("Total a pagar por tiquetes: $" + cliente.calcularValorTotalTiquetes());

    }

    public static void main(String[] args)
    {
        ConsolaArerolinea ca = new ConsolaArerolinea();
        ca.correrAplicacion(); // Cargar datos
        ca.probarClienteCorporativo(); // Ejecutar prueba de ClienteCorporativo
    }
}
