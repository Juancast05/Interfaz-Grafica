package com.example.camara_backend.controllers;

import com.example.camara_backend.models.TipoEstadoEvidencia;
import com.example.camara_backend.repository.TipoEstadoEvidenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos-estado-evidencia")
public class TipoEstadoEvidenciaController {

    private final TipoEstadoEvidenciaRepository tipoEstadoEvidenciaRepository;

    @Autowired
    public TipoEstadoEvidenciaController(TipoEstadoEvidenciaRepository tipoEstadoEvidenciaRepository) {
        this.tipoEstadoEvidenciaRepository = tipoEstadoEvidenciaRepository;
    }

    // GET /api/tipos-estado-evidencia
    @GetMapping
    public ResponseEntity<List<TipoEstadoEvidencia>> getAllTiposEstadoEvidencia() {
        List<TipoEstadoEvidencia> tipos = tipoEstadoEvidenciaRepository.findAll();
        return new ResponseEntity<>(tipos, HttpStatus.OK);
    }

    // GET /api/tipos-estado-evidencia/{id}
    @GetMapping("/{id}")
    public ResponseEntity<TipoEstadoEvidencia> getTipoEstadoEvidenciaById(@PathVariable Long id) {
        return tipoEstadoEvidenciaRepository.findById(id)
                .map(tipo -> new ResponseEntity<>(tipo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // POST /api/tipos-estado-evidencia
    @PostMapping
    public ResponseEntity<TipoEstadoEvidencia> createTipoEstadoEvidencia(@RequestBody TipoEstadoEvidencia tipoEstadoEvidencia) {
        TipoEstadoEvidencia createdTipo = tipoEstadoEvidenciaRepository.save(tipoEstadoEvidencia);
        return new ResponseEntity<>(createdTipo, HttpStatus.CREATED);
    }

    // PUT /api/tipos-estado-evidencia/{id}
    @PutMapping("/{id}")
    public ResponseEntity<TipoEstadoEvidencia> updateTipoEstadoEvidencia(@PathVariable Long id, @RequestBody TipoEstadoEvidencia tipoDetails) {
        return tipoEstadoEvidenciaRepository.findById(id)
                .map(existingTipo -> {
                    existingTipo.setNombre(tipoDetails.getNombre());
                    existingTipo.setActivo(tipoDetails.getActivo());
                    return new ResponseEntity<>(tipoEstadoEvidenciaRepository.save(existingTipo), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // DELETE /api/tipos-estado-evidencia/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTipoEstadoEvidencia(@PathVariable Long id) {
        if (tipoEstadoEvidenciaRepository.existsById(id)) {
            tipoEstadoEvidenciaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}