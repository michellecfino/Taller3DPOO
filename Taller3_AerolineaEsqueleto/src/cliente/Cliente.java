package cliente;

import uniandes.dpoo.aerolinea.tiquetes.Tiquete;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
	
	
    private String identificador;
    private List<Tiquete> tiquetesSinUsar;
    private List<Tiquete> tiquetesUsados;
    private static int identificador1=0;

    public Cliente() {
        
        this.tiquetesSinUsar = new ArrayList<>();
        this.tiquetesUsados = new ArrayList<>();
        //Variable para crear el identificador a partir de su creación :p
        Cliente.identificador1++;
        this.identificador = Integer.toString(identificador1);
    }

    public String getIdentificador() {
        return identificador;
    }

    public abstract String getTipoCliente();

    public void agregarTiquete(Tiquete tiquete) {
        tiquetesSinUsar.add(tiquete);
    }

    public int calcularValorTotalTiquetes() {
        int total = 0;
        for (Tiquete tiquete : tiquetesSinUsar) {
            total += tiquete.getTarifa();
        }
        return total;
    }

    public void usarTiquetes(Vuelo vuelo) {

    	for (Tiquete tiquete : tiquetesSinUsar) {
            if (tiquete.getVuelo().equals(vuelo) && !tiquete.esUsado()) {
                tiquete.marcarComoUsado();
                tiquetesUsados.add(tiquete);
                tiquetesSinUsar.remove(tiquete);
            }
        }
    }


}