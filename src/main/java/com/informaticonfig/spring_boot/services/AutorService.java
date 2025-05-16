package com.informaticonfig.spring_boot.services;

import com.informaticonfig.spring_boot.dto.AutorDTO;
import com.informaticonfig.spring_boot.models.Autor;

import java.util.List;
import java.util.Optional;

public interface AutorService {
    List<AutorDTO> listarAutores();
    Optional<AutorDTO> buscarPorId(Integer id);
    AutorDTO guardar(Autor autor);
    AutorDTO actualizar(Autor autor);
    void eliminar(Integer id);
}
