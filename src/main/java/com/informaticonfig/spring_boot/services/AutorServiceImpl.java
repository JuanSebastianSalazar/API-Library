package com.informaticonfig.spring_boot.services;

import com.informaticonfig.spring_boot.dto.AutorDTO;
import com.informaticonfig.spring_boot.models.Autor;
import com.informaticonfig.spring_boot.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AutorServiceImpl implements AutorService{

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public List<AutorDTO> listarAutores() {
        return autorRepository.findAll()
                .stream()
                .map(AutorDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AutorDTO> buscarPorId(Integer id) {
        return autorRepository.findById(id)
                .map(AutorDTO::new);
    }

    @Override
    @Transactional
    public AutorDTO guardar(Autor autor) {
        return new AutorDTO(autorRepository.save(autor));
    }

    @Override
    @Transactional
    public AutorDTO actualizar(Autor autor) {
        Optional<Autor> autorExiste = Optional.ofNullable(autorRepository.findById(autor.getId())
                .orElseThrow(() -> new RuntimeException("Autor no existe" + autor.getId())));
        if (autorExiste.isPresent()) {
            return new AutorDTO(autorRepository.save(autor));
        } else {
            return new AutorDTO();
        }
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        autorRepository.deleteById(id);
    }
}
