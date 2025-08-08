package com.example.camara_backend.controllers;

import com.example.camara_backend.models.TipoEvidenciaInfraccion;
import com.example.camara_backend.repository.TipoEvidenciaInfraccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos-evidencia-infraccion")
public class TipoEvidenciaInfraccionController {

    private final TipoEvidenciaInfraccionRepository tipoEvidenciaInfraccionRepository;

    @Autowired
    public TipoEvidenciaInfraccionController(TipoEvidenciaInfraccionRepository tipoEvidenciaInfraccionRepository) {
        this.tipoEvidenciaInfraccionRepository = tipoEvidenciaInfraccionRepository;
    }

    // GET /api/tipos-evidencia-infraccion
    @GetMapping
    public ResponseEntity<List<TipoEvidenciaInfraccion>> getAllTiposEvidenciaInfraccion() {
        List<TipoEvidenciaInfraccion> tipos = tipoEvidenciaInfraccionRepository.findAll();
        return new ResponseEntity<>(tipos, HttpStatus.OK);
    }

    // GET /api/tipos-evidencia-infraccion/{id}
    @GetMapping("/{id}")
    public ResponseEntity<TipoEvidenciaInfraccion> getTipoEvidenciaInfraccionById(@PathVariable Long id) {
        return tipoEvidenciaInfraccionRepository.findById(id)
                .map(tipo -> new ResponseEntity<>(tipo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // POST /api/tipos-evidencia-infraccion
    @PostMapping
    public ResponseEntity<TipoEvidenciaInfraccion> createTipoEvidenciaInfraccion(@RequestBody TipoEvidenciaInfraccion tipoEvidenciaInfraccion) {
        TipoEvidenciaInfraccion createdTipo = tipoEvidenciaInfraccionRepository.save(tipoEvidenciaInfraccion);
        return new ResponseEntity<>(createdTipo, HttpStatus.CREATED);
    }

    // PUT /api/tipos-evidencia-infraccion/{id}
    @PutMapping("/{id}")
    public ResponseEntity<TipoEvidenciaInfraccion> updateTipoEvidenciaInfraccion(@PathVariable Long id, @RequestBody TipoEvidenciaInfraccion tipoDetails) {
        return tipoEvidenciaInfraccionRepository.findById(id)
                .map(existingTipo -> {
                    existingTipo.setIdTipoCodigoInfraccion(tipoDetails.getIdTipoCodigoInfraccion());
                    existingTipo.setIdTipoEvidencia(tipoDetails.getIdTipoEvidencia());
                    existingTipo.setFechaInicio(tipoDetails.getFechaInicio());
                    existingTipo.setFechaFin(tipoDetails.getFechaFin());
                    existingTipo.setActivo(tipoDetails.getActivo());
                    return new ResponseEntity<>(tipoEvidenciaInfraccionRepository.save(existingTipo), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // DELETE /api/tipos-evidencia-infraccion/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTipoEvidenciaInfraccion(@PathVariable Long id) {
        if (tipoEvidenciaInfraccionRepository.existsById(id)) {
            tipoEvidenciaInfraccionRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}