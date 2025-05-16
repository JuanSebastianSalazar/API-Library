package com.informaticonfig.spring_boot.controllers;

import com.informaticonfig.spring_boot.dto.AutorDTO;
import com.informaticonfig.spring_boot.models.Autor;
import com.informaticonfig.spring_boot.services.AutorService;
import com.informaticonfig.spring_boot.services.AutorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping("/list")
    public ResponseEntity<List<AutorDTO>> listarAutores() {
        List<AutorDTO> listaAutores = autorService.listarAutores();
        return new ResponseEntity<>(listaAutores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorDTO> buscarAutor(@PathVariable Integer id) {
        Optional<AutorDTO> autor = autorService.buscarPorId(id);
        return autor.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Autor> save(@RequestBody Autor autor) {
        autorService.guardar(autor);
        return new ResponseEntity<>(autor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutorDTO> actualizar(@PathVariable Integer id, @RequestBody Autor autor) {
        autor.setId(id);
        AutorDTO autorActualizado = autorService.actualizar(autor);
        return new ResponseEntity<>(autorActualizado, HttpStatus.OK);
    }
}
