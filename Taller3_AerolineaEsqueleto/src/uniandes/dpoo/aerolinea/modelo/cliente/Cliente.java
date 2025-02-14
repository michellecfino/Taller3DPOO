package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.ArrayList;
import java.util.Collection;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public abstract class Cliente {
    
    protected Collection<Tiquete> tiquetes;

    public Cliente() {
        this.tiquetes = new ArrayList<>();
    }

    public abstract String getTipoCliente();
    
    public abstract String getIdentificador();

    public void agregarTiquete(Tiquete tiquete) {
        tiquetes.add(tiquete);
    }

    public int calcularValorTotalTiquetes() {
        int total = 0;
        for (Tiquete t : tiquetes) {
            total += t.getTarifa();
        }
        return total;
    }

    public void usarTiquetes(Vuelo vuelo) {
        for (Tiquete tiquete : tiquetes) {
            if (tiquete.getVuelo().equals(vuelo) && !tiquete.esUsado()) {
                tiquete.marcarComoUsado();
            }
        }
    }

    public Collection<Tiquete> getTiquetes() {
        return tiquetes;
    }
}
