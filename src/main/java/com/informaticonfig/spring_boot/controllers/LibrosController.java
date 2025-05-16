package com.informaticonfig.spring_boot.controllers;

import com.informaticonfig.spring_boot.dto.LibrosDTO;
import com.informaticonfig.spring_boot.models.Libros;
import com.informaticonfig.spring_boot.services.LibrosService;
import jakarta.persistence.EntityNotFoundException;
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

    @PutMapping("/update/{id}")
    public ResponseEntity<LibrosDTO> actualizar(@PathVariable Integer id, @RequestBody Libros libros) {
        libros.setId(id);
        LibrosDTO libroActualizado = librosService.actualizar(libros);
        return new ResponseEntity<>(libroActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        try {
            librosService.eliminar(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
