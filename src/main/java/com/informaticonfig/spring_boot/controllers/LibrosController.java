package com.informaticonfig.spring_boot.controllers;

import com.informaticonfig.spring_boot.dto.LibrosDTO;
import com.informaticonfig.spring_boot.models.Autor;
import com.informaticonfig.spring_boot.models.Libros;
import com.informaticonfig.spring_boot.services.LibrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/libros")
public class LibrosController {

    @Autowired
    private LibrosService librosService;

    @GetMapping("/list")
    public ResponseEntity<List<LibrosDTO>> listarLibros() {
        List<LibrosDTO> listaLibros = librosService.listarLibros();
        return new ResponseEntity<>(listaLibros,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibrosDTO> buscarLibro(@PathVariable Integer id) {
        Optional<LibrosDTO> libro = librosService.buscarPorId(id);
        return libro.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Libros> save(@RequestBody Libros libros) {
        librosService.guardar(libros);
        return new ResponseEntity<>(libros, HttpStatus.CREATED);
    }
}
