package com.informaticonfig.spring_boot.services;

import com.informaticonfig.spring_boot.dto.LibrosDTO;
import com.informaticonfig.spring_boot.models.Libros;

import java.util.List;
import java.util.Optional;

public interface LibrosService {
    List<LibrosDTO> listarLibros();
    Optional<LibrosDTO> buscarPorId(Integer id);
    LibrosDTO guardar(Libros libro);
    LibrosDTO actualizar(Libros libro);
    void eliminar(Integer id);
}
