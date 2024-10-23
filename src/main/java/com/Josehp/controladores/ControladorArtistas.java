package com.Josehp.controladores;

import com.Josehp.modelos.Artista;
import com.Josehp.servicios.ServicioArtistas;
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
public class ControladorArtistas {
    @Autowired
    private ServicioArtistas servicio;

    @GetMapping("/artistas")
    public String desplegarArtistas(Model model) {
        List<Artista> artistas = servicio.obtenerTodosLosArtistas();
        model.addAttribute("artistas", artistas);
        return "artistas"; // nombre del JSP
    }

    @GetMapping("/artistas/detalle/{idArtista}")
    public String desplegarDetalleArtista(@PathVariable Long idArtista, Model model) {
        Artista artista = servicio.obtenerArtistaPorId(idArtista);
        model.addAttribute("artista", artista);
        return "detalleArtista"; // nombre del JSP
    }

    @GetMapping("/artistas/formulario/agregar")
    public String formularioAgregarArtista(Model model) {
        model.addAttribute("artista", new Artista());
        return "agregarArtista"; // nombre del JSP
    }

    @PostMapping("/artistas/procesa/agregar")
    public String procesarAgregarArtista(@Validated @ModelAttribute Artista artista, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "agregarArtista"; // volver al formulario si hay errores
        }
        servicio.agregarArtista(artista);
        return "redirect:/artistas"; // redirigir a la lista de artistas
    }
    
}
