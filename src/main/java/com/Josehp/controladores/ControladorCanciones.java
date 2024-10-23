package com.Josehp.controladores;

import com.Josehp.modelos.Cancion;
import com.Josehp.modelos.Artista; // Asegúrate de importar el modelo Artista
import com.Josehp.servicios.ServicioCanciones;
import com.Josehp.servicios.ServicioArtistas; // Asegúrate de importar el servicio de Artistas
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class ControladorCanciones {
    @Autowired
    private ServicioCanciones servicio;

    @Autowired
    private ServicioArtistas servicioArtistas; // Inyección del servicio de artistas

    @GetMapping("/canciones")
    public String desplegarCanciones(Model model) {
        List<Cancion> canciones = servicio.obtenerTodasLasCanciones();
        model.addAttribute("canciones", canciones);
        return "canciones"; // nombre del JSP
    }

    @GetMapping("/canciones/detalle/{idCancion}")
    public String desplegarDetalleCancion(@PathVariable Long idCancion, Model model) {
        Cancion cancion = servicio.obtenerCancionPorId(idCancion);
        model.addAttribute("cancion", cancion);
        return "detalleCancion"; // nombre del JSP
    }

    // Método para mostrar el formulario de agregar canción
    @GetMapping("/canciones/formulario/agregar")
    public String formularioAgregarCancion(Model model) {
        model.addAttribute("cancion", new Cancion());
        model.addAttribute("artistas", servicioArtistas.obtenerTodosLosArtistas()); // Lista de artistas
        return "agregarCancion"; // nombre del JSP
    }

    // Método para procesar el formulario de agregar canción
    @PostMapping("/canciones/procesa/agregar")
    public String procesarAgregarCancion(@Validated @ModelAttribute Cancion cancion, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "agregarCancion"; // volver al formulario si hay errores
        }
        // Asignar el artista a la canción utilizando el servicio de artistas
        Artista artista = servicioArtistas.obtenerArtistaPorId(cancion.getArtista().getId());
        cancion.setArtista(artista);
        servicio.agregarCancion(cancion);
        return "redirect:/canciones"; // redirigir a la lista de canciones
    }

    @GetMapping("/canciones/formulario/editar/{idCancion}")
    public String formularioEditarCancion(@PathVariable Long idCancion, Model model) {
        Cancion cancion = servicio.obtenerCancionPorId(idCancion);
        model.addAttribute("cancion", cancion);
        model.addAttribute("artistas", servicioArtistas.obtenerTodosLosArtistas()); // Lista de artistas
        return "editarCancion"; // nombre del JSP
    }

    @PostMapping("/canciones/procesa/editar/{idCancion}")
    public String procesarEditarCancion(@PathVariable Long idCancion, @Validated @ModelAttribute Cancion cancion, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editarCancion"; // volver al formulario si hay errores
        }
        cancion.setId(idCancion); // establecer el ID de la canción
        // Asignar el artista a la canción utilizando el servicio de artistas
        Artista artista = servicioArtistas.obtenerArtistaPorId(cancion.getArtista().getId());
        cancion.setArtista(artista);
        servicio.actualizaCancion(cancion);
        return "redirect:/canciones"; // redirigir a la lista de canciones
    }

    @PostMapping("/canciones/eliminar/{idCancion}")
    public String procesarEliminarCancion(@PathVariable Long idCancion) {
        servicio.eliminaCancion(idCancion);
        return "redirect:/canciones"; // redirigir a la lista de canciones
    }
}

