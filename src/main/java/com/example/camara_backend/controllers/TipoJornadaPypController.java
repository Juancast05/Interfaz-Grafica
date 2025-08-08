package com.example.camara_backend.controllers;

import com.example.camara_backend.models.TipoJornadaPyp;
import com.example.camara_backend.repository.TipoJornadaPypRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/tipos-jornada-pyp")
public class TipoJornadaPypController {

    private final TipoJornadaPypRepository tipoJornadaPypRepository;

    @Autowired
    public TipoJornadaPypController(TipoJornadaPypRepository tipoJornadaPypRepository) {
        this.tipoJornadaPypRepository = tipoJornadaPypRepository;
    }

    // GET /api/tipos-jornada-pyp
    @GetMapping
    public ResponseEntity<List<TipoJornadaPyp>> getAllTiposJornadaPyp() {
        List<TipoJornadaPyp> tipos = tipoJornadaPypRepository.findAll();
        return new ResponseEntity<>(tipos, HttpStatus.OK);
    }

    // GET /api/tipos-jornada-pyp/{id}
    @GetMapping("/{id}")
    public ResponseEntity<TipoJornadaPyp> getTipoJornadaPypById(@PathVariable Long id) {
        return tipoJornadaPypRepository.findById(id)
                .map(tipo -> new ResponseEntity<>(tipo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // POST /api/tipos-jornada-pyp
    @PostMapping
    public ResponseEntity<TipoJornadaPyp> createTipoJornadaPyp(@RequestBody TipoJornadaPyp tipoJornadaPyp) {
        if (tipoJornadaPyp.getFechaRegistra() == null) {
            tipoJornadaPyp.setFechaRegistra(LocalDateTime.now());
        }
        TipoJornadaPyp createdTipo = tipoJornadaPypRepository.save(tipoJornadaPyp);
        return new ResponseEntity<>(createdTipo, HttpStatus.CREATED);
    }

    // PUT /api/tipos-jornada-pyp/{id}
    @PutMapping("/{id}")
    public ResponseEntity<TipoJornadaPyp> updateTipoJornadaPyp(@PathVariable Long id, @RequestBody TipoJornadaPyp tipoDetails) {
        return tipoJornadaPypRepository.findById(id)
                .map(existingTipo -> {
                    existingTipo.setNombre(tipoDetails.getNombre());
                    existingTipo.setFechaRegistra(tipoDetails.getFechaRegistra());
                    existingTipo.setFechaInactiva(tipoDetails.getFechaInactiva());
                    existingTipo.setActivo(tipoDetails.getActivo());
                    return new ResponseEntity<>(tipoJornadaPypRepository.save(existingTipo), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // DELETE /api/tipos-jornada-pyp/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTipoJornadaPyp(@PathVariable Long id) {
        if (tipoJornadaPypRepository.existsById(id)) {
            tipoJornadaPypRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}