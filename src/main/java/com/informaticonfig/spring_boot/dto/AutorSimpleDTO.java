package com.informaticonfig.spring_boot.dto;

import com.informaticonfig.spring_boot.models.Autor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutorSimpleDTO {
    private Integer id;
    private String nombre;
    private String apellido;
    private String telefono;

    public AutorSimpleDTO(Autor autor) {
        this.id = autor.getId();
        this.nombre = autor.getNombre();
        this.apellido = autor.getApellido();
        this.telefono = autor.getTelefono();
    }
}