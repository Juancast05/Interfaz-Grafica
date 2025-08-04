package com.example.camara_backend.controllers;

import com.example.camara_backend.models.TipoCodigoInfraccion;
import com.example.camara_backend.repository.TipoCodigoInfraccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/tipos-codigo-infraccion")
public class TipoCodigoInfraccionController {

    private final TipoCodigoInfraccionRepository tipoCodigoInfraccionRepository;

    @Autowired
    public TipoCodigoInfraccionController(TipoCodigoInfraccionRepository tipoCodigoInfraccionRepository) {
        this.tipoCodigoInfraccionRepository = tipoCodigoInfraccionRepository;
    }

    // GET /api/tipos-codigo-infraccion
    @GetMapping
    public ResponseEntity<List<TipoCodigoInfraccion>> getAllTiposCodigoInfraccion() {
        List<TipoCodigoInfraccion> tipos = tipoCodigoInfraccionRepository.findAll();
        return new ResponseEntity<>(tipos, HttpStatus.OK);
    }

    // GET /api/tipos-codigo-infraccion/{id}
    @GetMapping("/{id}")
    public ResponseEntity<TipoCodigoInfraccion> getTipoCodigoInfraccionById(@PathVariable Long id) {
        return tipoCodigoInfraccionRepository.findById(id)
                .map(tipo -> new ResponseEntity<>(tipo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // POST /api/tipos-codigo-infraccion
    @PostMapping
    public ResponseEntity<TipoCodigoInfraccion> createTipoCodigoInfraccion(@RequestBody TipoCodigoInfraccion tipoCodigoInfraccion) {
        if (tipoCodigoInfraccion.getFechaRegistra() == null) {
            tipoCodigoInfraccion.setFechaRegistra(LocalDateTime.now());
        }
        TipoCodigoInfraccion createdTipo = tipoCodigoInfraccionRepository.save(tipoCodigoInfraccion);
        return new ResponseEntity<>(createdTipo, HttpStatus.CREATED);
    }

    // PUT /api/tipos-codigo-infraccion/{id}
    @PutMapping("/{id}")
    public ResponseEntity<TipoCodigoInfraccion> updateTipoCodigoInfraccion(@PathVariable Long id, @RequestBody TipoCodigoInfraccion tipoDetails) {
        return tipoCodigoInfraccionRepository.findById(id)
                .map(existingTipo -> {
                    existingTipo.setIdClienteSistema(tipoDetails.getIdClienteSistema());
                    existingTipo.setCodigoInfraccion(tipoDetails.getCodigoInfraccion());
                    existingTipo.setDescripcion(tipoDetails.getDescripcion());
                    existingTipo.setFechaRegistra(tipoDetails.getFechaRegistra());
                    existingTipo.setFechaInactiva(tipoDetails.getFechaInactiva());
                    existingTipo.setActivo(tipoDetails.getActivo());
                    existingTipo.setIdTipoClaseInfraccion(tipoDetails.getIdTipoClaseInfraccion());
                    return new ResponseEntity<>(tipoCodigoInfraccionRepository.save(existingTipo), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // DELETE /api/tipos-codigo-infraccion/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTipoCodigoInfraccion(@PathVariable Long id) {
        if (tipoCodigoInfraccionRepository.existsById(id)) {
            tipoCodigoInfraccionRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}