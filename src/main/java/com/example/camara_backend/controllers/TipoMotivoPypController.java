package com.example.camara_backend.controllers;

import com.example.camara_backend.models.TipoMotivoPyp;
import com.example.camara_backend.repository.TipoMotivoPypRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/tipos-motivo-pyp")
public class TipoMotivoPypController {

    private final TipoMotivoPypRepository tipoMotivoPypRepository;

    @Autowired
    public TipoMotivoPypController(TipoMotivoPypRepository tipoMotivoPypRepository) {
        this.tipoMotivoPypRepository = tipoMotivoPypRepository;
    }

    // GET /api/tipos-motivo-pyp
    @GetMapping
    public ResponseEntity<List<TipoMotivoPyp>> getAllTiposMotivoPyp() {
        List<TipoMotivoPyp> tipos = tipoMotivoPypRepository.findAll();
        return new ResponseEntity<>(tipos, HttpStatus.OK);
    }

    // GET /api/tipos-motivo-pyp/{id}
    @GetMapping("/{id}")
    public ResponseEntity<TipoMotivoPyp> getTipoMotivoPypById(@PathVariable Long id) {
        return tipoMotivoPypRepository.findById(id)
                .map(tipo -> new ResponseEntity<>(tipo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // POST /api/tipos-motivo-pyp
    @PostMapping
    public ResponseEntity<TipoMotivoPyp> createTipoMotivoPyp(@RequestBody TipoMotivoPyp tipoMotivoPyp) {
        if (tipoMotivoPyp.getFechaRegistra() == null) {
            tipoMotivoPyp.setFechaRegistra(LocalDateTime.now());
        }
        TipoMotivoPyp createdTipo = tipoMotivoPypRepository.save(tipoMotivoPyp);
        return new ResponseEntity<>(createdTipo, HttpStatus.CREATED);
    }

    // PUT /api/tipos-motivo-pyp/{id}
    @PutMapping("/{id}")
    public ResponseEntity<TipoMotivoPyp> updateTipoMotivoPyp(@PathVariable Long id, @RequestBody TipoMotivoPyp tipoDetails) {
        return tipoMotivoPypRepository.findById(id)
                .map(existingTipo -> {
                    existingTipo.setNombre(tipoDetails.getNombre());
                    existingTipo.setDescripcion(tipoDetails.getDescripcion());
                    existingTipo.setPrioridad(tipoDetails.getPrioridad());
                    existingTipo.setFechaRegistra(tipoDetails.getFechaRegistra());
                    existingTipo.setFechaInactiva(tipoDetails.getFechaInactiva());
                    existingTipo.setActivo(tipoDetails.getActivo());
                    return new ResponseEntity<>(tipoMotivoPypRepository.save(existingTipo), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // DELETE /api/tipos-motivo-pyp/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTipoMotivoPyp(@PathVariable Long id) {
        if (tipoMotivoPypRepository.existsById(id)) {
            tipoMotivoPypRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}