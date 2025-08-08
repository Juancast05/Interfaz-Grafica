package com.example.camara_backend.controllers;

import com.example.camara_backend.models.TipoEvidencia;
import com.example.camara_backend.repository.TipoEvidenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/tipos-evidencia")
public class TipoEvidenciaController {

    private final TipoEvidenciaRepository tipoEvidenciaRepository;

    @Autowired
    public TipoEvidenciaController(TipoEvidenciaRepository tipoEvidenciaRepository) {
        this.tipoEvidenciaRepository = tipoEvidenciaRepository;
    }

    // GET /api/tipos-evidencia
    @GetMapping
    public ResponseEntity<List<TipoEvidencia>> getAllTiposEvidencia() {
        List<TipoEvidencia> tipos = tipoEvidenciaRepository.findAll();
        return new ResponseEntity<>(tipos, HttpStatus.OK);
    }

    // GET /api/tipos-evidencia/{id}
    @GetMapping("/{id}")
    public ResponseEntity<TipoEvidencia> getTipoEvidenciaById(@PathVariable Long id) {
        return tipoEvidenciaRepository.findById(id)
                .map(tipo -> new ResponseEntity<>(tipo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // POST /api/tipos-evidencia
    @PostMapping
    public ResponseEntity<TipoEvidencia> createTipoEvidencia(@RequestBody TipoEvidencia tipoEvidencia) {
        if (tipoEvidencia.getFechaRegistra() == null) {
            tipoEvidencia.setFechaRegistra(LocalDateTime.now());
        }
        TipoEvidencia createdTipo = tipoEvidenciaRepository.save(tipoEvidencia);
        return new ResponseEntity<>(createdTipo, HttpStatus.CREATED);
    }

    // PUT /api/tipos-evidencia/{id}
    @PutMapping("/{id}")
    public ResponseEntity<TipoEvidencia> updateTipoEvidencia(@PathVariable Long id, @RequestBody TipoEvidencia tipoDetails) {
        return tipoEvidenciaRepository.findById(id)
                .map(existingTipo -> {
                    existingTipo.setNombreEvidencia(tipoDetails.getNombreEvidencia());
                    existingTipo.setTipoEvidencia(tipoDetails.getTipoEvidencia());
                    existingTipo.setFechaRegistra(tipoDetails.getFechaRegistra());
                    existingTipo.setActivo(tipoDetails.getActivo());
                    return new ResponseEntity<>(tipoEvidenciaRepository.save(existingTipo), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // DELETE /api/tipos-evidencia/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTipoEvidencia(@PathVariable Long id) {
        if (tipoEvidenciaRepository.existsById(id)) {
            tipoEvidenciaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}