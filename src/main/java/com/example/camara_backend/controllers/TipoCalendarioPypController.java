package com.example.camara_backend.controllers;

import com.example.camara_backend.models.TipoCalendarioPyp;
import com.example.camara_backend.repository.TipoCalendarioPypRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/tipos-calendario-pyp")
public class TipoCalendarioPypController {

    private final TipoCalendarioPypRepository tipoCalendarioPypRepository;

    @Autowired
    public TipoCalendarioPypController(TipoCalendarioPypRepository tipoCalendarioPypRepository) {
        this.tipoCalendarioPypRepository = tipoCalendarioPypRepository;
    }

    // GET /api/tipos-calendario-pyp
    @GetMapping
    public ResponseEntity<List<TipoCalendarioPyp>> getAllTiposCalendarioPyp() {
        List<TipoCalendarioPyp> tipos = tipoCalendarioPypRepository.findAll();
        return new ResponseEntity<>(tipos, HttpStatus.OK);
    }

    // GET /api/tipos-calendario-pyp/{id}
    @GetMapping("/{id}")
    public ResponseEntity<TipoCalendarioPyp> getTipoCalendarioPypById(@PathVariable Long id) {
        return tipoCalendarioPypRepository.findById(id)
                .map(tipo -> new ResponseEntity<>(tipo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // POST /api/tipos-calendario-pyp
    @PostMapping
    public ResponseEntity<TipoCalendarioPyp> createTipoCalendarioPyp(@RequestBody TipoCalendarioPyp tipoCalendarioPyp) {
        if (tipoCalendarioPyp.getFechaRegistra() == null) {
            tipoCalendarioPyp.setFechaRegistra(LocalDateTime.now());
        }
        TipoCalendarioPyp createdTipo = tipoCalendarioPypRepository.save(tipoCalendarioPyp);
        return new ResponseEntity<>(createdTipo, HttpStatus.CREATED);
    }

    // PUT /api/tipos-calendario-pyp/{id}
    @PutMapping("/{id}")
    public ResponseEntity<TipoCalendarioPyp> updateTipoCalendarioPyp(@PathVariable Long id, @RequestBody TipoCalendarioPyp tipoDetails) {
        return tipoCalendarioPypRepository.findById(id)
                .map(existingTipo -> {
                    existingTipo.setNombre(tipoDetails.getNombre());
                    existingTipo.setFechaRegistra(tipoDetails.getFechaRegistra());
                    existingTipo.setFechaInactiva(tipoDetails.getFechaInactiva());
                    existingTipo.setActivo(tipoDetails.getActivo());
                    return new ResponseEntity<>(tipoCalendarioPypRepository.save(existingTipo), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // DELETE /api/tipos-calendario-pyp/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTipoCalendarioPyp(@PathVariable Long id) {
        if (tipoCalendarioPypRepository.existsById(id)) {
            tipoCalendarioPypRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}