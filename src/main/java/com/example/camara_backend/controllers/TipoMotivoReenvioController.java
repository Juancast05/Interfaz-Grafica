package com.example.camara_backend.controllers;

import com.example.camara_backend.models.TipoMotivoReenvio;
import com.example.camara_backend.repository.TipoMotivoReenvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/tipos-motivo-reenvio")
public class TipoMotivoReenvioController {

    private final TipoMotivoReenvioRepository tipoMotivoReenvioRepository;

    @Autowired
    public TipoMotivoReenvioController(TipoMotivoReenvioRepository tipoMotivoReenvioRepository) {
        this.tipoMotivoReenvioRepository = tipoMotivoReenvioRepository;
    }

    // GET /api/tipos-motivo-reenvio
    @GetMapping
    public ResponseEntity<List<TipoMotivoReenvio>> getAllTiposMotivoReenvio() {
        List<TipoMotivoReenvio> tipos = tipoMotivoReenvioRepository.findAll();
        return new ResponseEntity<>(tipos, HttpStatus.OK);
    }

    // GET /api/tipos-motivo-reenvio/{id}
    @GetMapping("/{id}")
    public ResponseEntity<TipoMotivoReenvio> getTipoMotivoReenvioById(@PathVariable Long id) {
        return tipoMotivoReenvioRepository.findById(id)
                .map(tipo -> new ResponseEntity<>(tipo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // POST /api/tipos-motivo-reenvio
    @PostMapping
    public ResponseEntity<TipoMotivoReenvio> createTipoMotivoReenvio(@RequestBody TipoMotivoReenvio tipoMotivoReenvio) {
        if (tipoMotivoReenvio.getFechaRegistro() == null) {
            tipoMotivoReenvio.setFechaRegistro(LocalDateTime.now());
        }
        TipoMotivoReenvio createdTipo = tipoMotivoReenvioRepository.save(tipoMotivoReenvio);
        return new ResponseEntity<>(createdTipo, HttpStatus.CREATED);
    }

    // PUT /api/tipos-motivo-reenvio/{id}
    @PutMapping("/{id}")
    public ResponseEntity<TipoMotivoReenvio> updateTipoMotivoReenvio(@PathVariable Long id, @RequestBody TipoMotivoReenvio tipoDetails) {
        return tipoMotivoReenvioRepository.findById(id)
                .map(existingTipo -> {
                    existingTipo.setNombreMotivo(tipoDetails.getNombreMotivo());
                    existingTipo.setFechaRegistro(tipoDetails.getFechaRegistro());
                    existingTipo.setFechaInactiva(tipoDetails.getFechaInactiva());
                    existingTipo.setActivo(tipoDetails.getActivo());
                    return new ResponseEntity<>(tipoMotivoReenvioRepository.save(existingTipo), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // DELETE /api/tipos-motivo-reenvio/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTipoMotivoReenvio(@PathVariable Long id) {
        if (tipoMotivoReenvioRepository.existsById(id)) {
            tipoMotivoReenvioRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}