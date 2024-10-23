package com.Josehp.servicios;

import com.Josehp.modelos.Cancion;
import com.Josehp.repositorios.RepositorioCanciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServicioCanciones {
    @Autowired
    private RepositorioCanciones repositorio;

    public List<Cancion> obtenerTodasLasCanciones() {
        return repositorio.findAll();
    }

    public Cancion obtenerCancionPorId(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    // Método para agregar una nueva canción
    public Cancion agregarCancion(Cancion cancion) {
        // Puedes realizar más validaciones aquí si es necesario
        return repositorio.save(cancion);
    }
    public Cancion actualizaCancion(Cancion cancion) {
        return repositorio.save(cancion);
    }
    public void eliminaCancion(Long id) {
        repositorio.deleteById(id);
    }

}
