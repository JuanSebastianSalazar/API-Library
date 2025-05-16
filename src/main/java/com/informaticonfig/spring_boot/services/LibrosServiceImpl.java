package com.informaticonfig.spring_boot.services;

import com.informaticonfig.spring_boot.dto.LibrosDTO;
import com.informaticonfig.spring_boot.models.Libros;
import com.informaticonfig.spring_boot.repository.LibrosRepository;
import org.springframework.transaction.annotation.Transactional;
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
    @Transactional
    public LibrosDTO guardar(Libros libro) {
        return new LibrosDTO(librosRepository.save(libro));
    }

    @Override
    @Transactional
    public LibrosDTO actualizar(Libros libro) {
        Optional<Libros> libroExiste = Optional.ofNullable(librosRepository.findById(libro.getId())
                .orElseThrow(() -> new RuntimeException("El libro no existe" + libro.getId())));
        if (libroExiste.isPresent()) {
            return new LibrosDTO(librosRepository.save(libro));
        } else {
            return new LibrosDTO();
        }
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        librosRepository.deleteById(id);
    }
}
