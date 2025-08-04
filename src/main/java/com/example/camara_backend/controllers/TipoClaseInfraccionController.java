package com.example.camara_backend.controllers;

import com.example.camara_backend.models.TipoClaseInfraccion;
import com.example.camara_backend.repository.TipoClaseInfraccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos-clase-infraccion") // Define la ruta base para este controlador
public class TipoClaseInfraccionController {

    private final TipoClaseInfraccionRepository tipoClaseInfraccionRepository;

    @Autowired
    public TipoClaseInfraccionController(TipoClaseInfraccionRepository tipoClaseInfraccionRepository) {
        this.tipoClaseInfraccionRepository = tipoClaseInfraccionRepository;
    }

    // GET /api/tipos-clase-infraccion
    @GetMapping
    public ResponseEntity<List<TipoClaseInfraccion>> getAllTiposClaseInfraccion() {
        List<TipoClaseInfraccion> tiposClaseInfraccion = tipoClaseInfraccionRepository.findAll();
        return new ResponseEntity<>(tiposClaseInfraccion, HttpStatus.OK);
    }

    // GET /api/tipos-clase-infraccion/{id}
    @GetMapping("/{id}")
    public ResponseEntity<TipoClaseInfraccion> getTipoClaseInfraccionById(@PathVariable Long id) {
        return tipoClaseInfraccionRepository.findById(id)
                .map(tipoClaseInfraccion -> new ResponseEntity<>(tipoClaseInfraccion, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // POST /api/tipos-clase-infraccion
    @PostMapping
    public ResponseEntity<TipoClaseInfraccion> createTipoClaseInfraccion(@RequestBody TipoClaseInfraccion tipoClaseInfraccion) {
        // No hay campos de fecha/hora para auto-generar en esta tabla
        TipoClaseInfraccion createdTipoClaseInfraccion = tipoClaseInfraccionRepository.save(tipoClaseInfraccion);
        return new ResponseEntity<>(createdTipoClaseInfraccion, HttpStatus.CREATED);
    }

    // PUT /api/tipos-clase-infraccion/{id}
    @PutMapping("/{id}")
    public ResponseEntity<TipoClaseInfraccion> updateTipoClaseInfraccion(@PathVariable Long id, @RequestBody TipoClaseInfraccion tipoClaseInfraccionDetails) {
        return tipoClaseInfraccionRepository.findById(id)
                .map(existingTipoClaseInfraccion -> {
                    existingTipoClaseInfraccion.setNombreClaseInfraccion(tipoClaseInfraccionDetails.getNombreClaseInfraccion());
                    existingTipoClaseInfraccion.setActivo(tipoClaseInfraccionDetails.getActivo());
                    return new ResponseEntity<>(tipoClaseInfraccionRepository.save(existingTipoClaseInfraccion), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // DELETE /api/tipos-clase-infraccion/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTipoClaseInfraccion(@PathVariable Long id) {
        if (tipoClaseInfraccionRepository.existsById(id)) {
            tipoClaseInfraccionRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}