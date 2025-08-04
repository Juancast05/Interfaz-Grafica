package com.example.camara_backend.controllers;

import com.example.camara_backend.models.TipoMotivoDescarte;
import com.example.camara_backend.repository.TipoMotivoDescarteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/tipos-motivo-descarte")
public class TipoMotivoDescarteController {

    private final TipoMotivoDescarteRepository tipoMotivoDescarteRepository;

    @Autowired
    public TipoMotivoDescarteController(TipoMotivoDescarteRepository tipoMotivoDescarteRepository) {
        this.tipoMotivoDescarteRepository = tipoMotivoDescarteRepository;
    }

    // GET /api/tipos-motivo-descarte
    @GetMapping
    public ResponseEntity<List<TipoMotivoDescarte>> getAllTiposMotivoDescarte() {
        List<TipoMotivoDescarte> tipos = tipoMotivoDescarteRepository.findAll();
        return new ResponseEntity<>(tipos, HttpStatus.OK);
    }

    // GET /api/tipos-motivo-descarte/{id}
    @GetMapping("/{id}")
    public ResponseEntity<TipoMotivoDescarte> getTipoMotivoDescarteById(@PathVariable Long id) {
        return tipoMotivoDescarteRepository.findById(id)
                .map(tipo -> new ResponseEntity<>(tipo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // POST /api/tipos-motivo-descarte
    @PostMapping
    public ResponseEntity<TipoMotivoDescarte> createTipoMotivoDescarte(@RequestBody TipoMotivoDescarte tipoMotivoDescarte) {
        if (tipoMotivoDescarte.getFechaRegistra() == null) {
            tipoMotivoDescarte.setFechaRegistra(LocalDateTime.now());
        }
        TipoMotivoDescarte createdTipo = tipoMotivoDescarteRepository.save(tipoMotivoDescarte);
        return new ResponseEntity<>(createdTipo, HttpStatus.CREATED);
    }

    // PUT /api/tipos-motivo-descarte/{id}
    @PutMapping("/{id}")
    public ResponseEntity<TipoMotivoDescarte> updateTipoMotivoDescarte(@PathVariable Long id, @RequestBody TipoMotivoDescarte tipoDetails) {
        return tipoMotivoDescarteRepository.findById(id)
                .map(existingTipo -> {
                    existingTipo.setDescripcionMotivo(tipoDetails.getDescripcionMotivo());
                    existingTipo.setFechaRegistra(tipoDetails.getFechaRegistra());
                    existingTipo.setActivo(tipoDetails.getActivo());
                    return new ResponseEntity<>(tipoMotivoDescarteRepository.save(existingTipo), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // DELETE /api/tipos-motivo-descarte/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTipoMotivoDescarte(@PathVariable Long id) {
        if (tipoMotivoDescarteRepository.existsById(id)) {
            tipoMotivoDescarteRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}