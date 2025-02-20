package uniandes.dpoo.aerolinea.persistencia;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;
import org.json.JSONArray;
import org.json.JSONObject;

import uniandes.dpoo.aerolinea.modelo.Aerolinea;
import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.Avion;

public class PersistenciaAerolineaJson implements IPersistenciaAerolinea {

    

    @Override
    public void cargarAerolinea(String archivo, Aerolinea aerolinea) throws IOException {

    }

    @Override
    public void salvarAerolinea(String archivo, Aerolinea aerolinea) throws IOException {

    }

}
