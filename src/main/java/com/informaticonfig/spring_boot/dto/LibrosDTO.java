package com.informaticonfig.spring_boot.dto;

import com.informaticonfig.spring_boot.models.Libros;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibrosDTO {

    private Integer id;
    private String titulo;
    private String editorial;
    private String genero;
    private Double precio;
    private LocalDate fechaEdicion;

    private AutorSimpleDTO autorSimpleDTO;

    public LibrosDTO(Libros libros) {
        this.id = libros.getId();
        this.titulo = libros.getTitulo();
        this.editorial = libros.getEditorial();
        this.genero = libros.getGenero();
        this.precio = libros.getPrecio();
        this.fechaEdicion = libros.getFechaEdicion();
        this.autorSimpleDTO = new AutorSimpleDTO(libros.getAutor());
    }
}
