package com.example.camara_backend.controllers;

import com.example.camara_backend.models.TipoEstadoReenvio;
import com.example.camara_backend.repository.TipoEstadoReenvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/tipos-estado-reenvio")
public class TipoEstadoReenvioController {

    private final TipoEstadoReenvioRepository tipoEstadoReenvioRepository;

    @Autowired
    public TipoEstadoReenvioController(TipoEstadoReenvioRepository tipoEstadoReenvioRepository) {
        this.tipoEstadoReenvioRepository = tipoEstadoReenvioRepository;
    }

    // GET /api/tipos-estado-reenvio
    @GetMapping
    public ResponseEntity<List<TipoEstadoReenvio>> getAllTiposEstadoReenvio() {
        List<TipoEstadoReenvio> tipos = tipoEstadoReenvioRepository.findAll();
        return new ResponseEntity<>(tipos, HttpStatus.OK);
    }

    // GET /api/tipos-estado-reenvio/{id}
    @GetMapping("/{id}")
    public ResponseEntity<TipoEstadoReenvio> getTipoEstadoReenvioById(@PathVariable Long id) {
        return tipoEstadoReenvioRepository.findById(id)
                .map(tipo -> new ResponseEntity<>(tipo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // POST /api/tipos-estado-reenvio
    @PostMapping
    public ResponseEntity<TipoEstadoReenvio> createTipoEstadoReenvio(@RequestBody TipoEstadoReenvio tipoEstadoReenvio) {
        if (tipoEstadoReenvio.getFechaRegistra() == null) {
            tipoEstadoReenvio.setFechaRegistra(LocalDateTime.now());
        }
        TipoEstadoReenvio createdTipo = tipoEstadoReenvioRepository.save(tipoEstadoReenvio);
        return new ResponseEntity<>(createdTipo, HttpStatus.CREATED);
    }

    // PUT /api/tipos-estado-reenvio/{id}
    @PutMapping("/{id}")
    public ResponseEntity<TipoEstadoReenvio> updateTipoEstadoReenvio(@PathVariable Long id, @RequestBody TipoEstadoReenvio tipoDetails) {
        return tipoEstadoReenvioRepository.findById(id)
                .map(existingTipo -> {
                    existingTipo.setNombre(tipoDetails.getNombre());
                    existingTipo.setFechaRegistra(tipoDetails.getFechaRegistra());
                    existingTipo.setFechaInactiva(tipoDetails.getFechaInactiva());
                    existingTipo.setActivo(tipoDetails.getActivo());
                    return new ResponseEntity<>(tipoEstadoReenvioRepository.save(existingTipo), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // DELETE /api/tipos-estado-reenvio/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTipoEstadoReenvio(@PathVariable Long id) {
        if (tipoEstadoReenvioRepository.existsById(id)) {
            tipoEstadoReenvioRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}