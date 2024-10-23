package com.Josehp.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "canciones")
public class Cancion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El título es obligatorio")
    @Size(min = 5, message = "El título debe tener al menos 5 caracteres")
    private String titulo;

    @ManyToOne // Añadir esta anotación para la relación
    @JoinColumn(name = "artista_id") // Cambia esto si es necesario
    private Artista artista; // Cambiado de String a Artista

    @NotBlank(message = "El álbum es obligatorio")
    @Size(min = 3, message = "El álbum debe tener al menos 3 caracteres")
    private String album;

    @NotBlank(message = "El género es obligatorio")
    @Size(min = 3, message = "El género debe tener al menos 3 caracteres")
    private String genero;

    @NotBlank(message = "El idioma es obligatorio")
    @Size(min = 3, message = "El idioma debe tener al menos 3 caracteres")
    private String idioma;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date fechaCreacion;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    
    public Cancion() {}

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Artista getArtista() {
        return artista; // Cambiado de String a Artista
    }

    public void setArtista(Artista artista) {
        this.artista = artista; // Cambiado de String a Artista
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}
