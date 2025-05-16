package com.informaticonfig.spring_boot.services;

import com.informaticonfig.spring_boot.dto.AutorDTO;
import com.informaticonfig.spring_boot.dto.LibrosDTO;
import com.informaticonfig.spring_boot.models.Libros;
import com.informaticonfig.spring_boot.repository.LibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LibrosServiceImpl implements LibrosService {
    @Autowired
    private LibrosRepository librosRepository;

    @Override
    public List<LibrosDTO> listarLibros() {
        return librosRepository.findAll()
                .stream()
                .map(LibrosDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<LibrosDTO> buscarPorId(Integer id) {
        return librosRepository.findById(id)
                .map(LibrosDTO::new);
    }

    @Override
    public LibrosDTO guardar(Libros libro) {
        return new LibrosDTO(librosRepository.save(libro));
    }

    @Override
    public void eliminar(Integer id) {
        librosRepository.deleteById(id);
    }
}
