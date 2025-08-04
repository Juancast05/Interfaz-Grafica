package com.example.camara_backend.controllers;

import com.example.camara_backend.models.TipoFormatoPlaca;
import com.example.camara_backend.repository.TipoFormatoPlacaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/tipos-formato-placa")
public class TipoFormatoPlacaController {

    private final TipoFormatoPlacaRepository tipoFormatoPlacaRepository;

    @Autowired
    public TipoFormatoPlacaController(TipoFormatoPlacaRepository tipoFormatoPlacaRepository) {
        this.tipoFormatoPlacaRepository = tipoFormatoPlacaRepository;
    }

    // GET /api/tipos-formato-placa
    @GetMapping
    public ResponseEntity<List<TipoFormatoPlaca>> getAllTiposFormatoPlaca() {
        List<TipoFormatoPlaca> tipos = tipoFormatoPlacaRepository.findAll();
        return new ResponseEntity<>(tipos, HttpStatus.OK);
    }

    // GET /api/tipos-formato-placa/{id}
    @GetMapping("/{id}")
    public ResponseEntity<TipoFormatoPlaca> getTipoFormatoPlacaById(@PathVariable Long id) {
        return tipoFormatoPlacaRepository.findById(id)
                .map(tipo -> new ResponseEntity<>(tipo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // POST /api/tipos-formato-placa
    @PostMapping
    public ResponseEntity<TipoFormatoPlaca> createTipoFormatoPlaca(@RequestBody TipoFormatoPlaca tipoFormatoPlaca) {
        if (tipoFormatoPlaca.getFechaRegistra() == null) {
            tipoFormatoPlaca.setFechaRegistra(LocalDateTime.now());
        }
        TipoFormatoPlaca createdTipo = tipoFormatoPlacaRepository.save(tipoFormatoPlaca);
        return new ResponseEntity<>(createdTipo, HttpStatus.CREATED);
    }

    // PUT /api/tipos-formato-placa/{id}
    @PutMapping("/{id}")
    public ResponseEntity<TipoFormatoPlaca> updateTipoFormatoPlaca(@PathVariable Long id, @RequestBody TipoFormatoPlaca tipoDetails) {
        return tipoFormatoPlacaRepository.findById(id)
                .map(existingTipo -> {
                    existingTipo.setFormato(tipoDetails.getFormato());
                    existingTipo.setDescripcionFormato(tipoDetails.getDescripcionFormato());
                    existingTipo.setFechaRegistra(tipoDetails.getFechaRegistra());
                    existingTipo.setFechaInactiva(tipoDetails.getFechaInactiva());
                    existingTipo.setActivo(tipoDetails.getActivo());
                    return new ResponseEntity<>(tipoFormatoPlacaRepository.save(existingTipo), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // DELETE /api/tipos-formato-placa/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTipoFormatoPlaca(@PathVariable Long id) {
        if (tipoFormatoPlacaRepository.existsById(id)) {
            tipoFormatoPlacaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}