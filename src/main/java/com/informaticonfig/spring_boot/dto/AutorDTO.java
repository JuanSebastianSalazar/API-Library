package com.informaticonfig.spring_boot.dto;

import com.informaticonfig.spring_boot.models.Autor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutorDTO {

    private Integer id;
    private String nombre;
    private String apellido;
    private String telefono;
    private List<LibrosDTO> libros;

    public AutorDTO(Autor autor) {
        this.id = autor.getId();
        this.nombre = autor.getNombre();
        this.apellido = autor.getApellido();
        this.telefono = autor.getTelefono();
        this.libros = autor.getLibros() != null
                ? autor.getLibros().stream().map(LibrosDTO::new).collect(Collectors.toList())
                : new ArrayList<>();
    }
}
