package com.example.camara_backend.controllers;

import com.example.camara_backend.models.TipoPosicionPyp;
import com.example.camara_backend.repository.TipoPosicionPypRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/tipos-posicion-pyp")
public class TipoPosicionPypController {

    private final TipoPosicionPypRepository tipoPosicionPypRepository;

    @Autowired
    public TipoPosicionPypController(TipoPosicionPypRepository tipoPosicionPypRepository) {
        this.tipoPosicionPypRepository = tipoPosicionPypRepository;
    }

    // GET /api/tipos-posicion-pyp
    @GetMapping
    public ResponseEntity<List<TipoPosicionPyp>> getAllTiposPosicionPyp() {
        List<TipoPosicionPyp> tipos = tipoPosicionPypRepository.findAll();
        return new ResponseEntity<>(tipos, HttpStatus.OK);
    }

    // GET /api/tipos-posicion-pyp/{id}
    @GetMapping("/{id}")
    public ResponseEntity<TipoPosicionPyp> getTipoPosicionPypById(@PathVariable Long id) {
        return tipoPosicionPypRepository.findById(id)
                .map(tipo -> new ResponseEntity<>(tipo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // POST /api/tipos-posicion-pyp
    @PostMapping
    public ResponseEntity<TipoPosicionPyp> createTipoPosicionPyp(@RequestBody TipoPosicionPyp tipoPosicionPyp) {
        if (tipoPosicionPyp.getFechaRegistra() == null) {
            tipoPosicionPyp.setFechaRegistra(LocalDateTime.now());
        }
        TipoPosicionPyp createdTipo = tipoPosicionPypRepository.save(tipoPosicionPyp);
        return new ResponseEntity<>(createdTipo, HttpStatus.CREATED);
    }

    // PUT /api/tipos-posicion-pyp/{id}
    @PutMapping("/{id}")
    public ResponseEntity<TipoPosicionPyp> updateTipoPosicionPyp(@PathVariable Long id, @RequestBody TipoPosicionPyp tipoDetails) {
        return tipoPosicionPypRepository.findById(id)
                .map(existingTipo -> {
                    existingTipo.setIdClienteSistema(tipoDetails.getIdClienteSistema());
                    existingTipo.setIdTipoFormatoPlaca(tipoDetails.getIdTipoFormatoPlaca());
                    existingTipo.setPosicionPyp(tipoDetails.getPosicionPyp());
                    existingTipo.setFechaRegistra(tipoDetails.getFechaRegistra());
                    existingTipo.setFechaInactiva(tipoDetails.getFechaInactiva());
                    existingTipo.setActivo(tipoDetails.getActivo());
                    return new ResponseEntity<>(tipoPosicionPypRepository.save(existingTipo), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // DELETE /api/tipos-posicion-pyp/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTipoPosicionPyp(@PathVariable Long id) {
        if (tipoPosicionPypRepository.existsById(id)) {
            tipoPosicionPypRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}