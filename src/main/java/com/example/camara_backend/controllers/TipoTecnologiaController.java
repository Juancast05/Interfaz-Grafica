package com.example.camara_backend.controllers;

import com.example.camara_backend.models.TipoTecnologia;
import com.example.camara_backend.repository.TipoTecnologiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/tipos-tecnologia")
public class TipoTecnologiaController {

    private final TipoTecnologiaRepository tipoTecnologiaRepository;

    @Autowired
    public TipoTecnologiaController(TipoTecnologiaRepository tipoTecnologiaRepository) {
        this.tipoTecnologiaRepository = tipoTecnologiaRepository;
    }

    // GET /api/tipos-tecnologia
    @GetMapping
    public ResponseEntity<List<TipoTecnologia>> getAllTiposTecnologia() {
        List<TipoTecnologia> tipos = tipoTecnologiaRepository.findAll();
        return new ResponseEntity<>(tipos, HttpStatus.OK);
    }

    // GET /api/tipos-tecnologia/{id}
    @GetMapping("/{id}")
    public ResponseEntity<TipoTecnologia> getTipoTecnologiaById(@PathVariable Long id) {
        return tipoTecnologiaRepository.findById(id)
                .map(tipo -> new ResponseEntity<>(tipo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // POST /api/tipos-tecnologia
    @PostMapping
    public ResponseEntity<TipoTecnologia> createTipoTecnologia(@RequestBody TipoTecnologia tipoTecnologia) {
        if (tipoTecnologia.getFechaRegistra() == null) {
            tipoTecnologia.setFechaRegistra(LocalDateTime.now());
        }
        TipoTecnologia createdTipo = tipoTecnologiaRepository.save(tipoTecnologia);
        return new ResponseEntity<>(createdTipo, HttpStatus.CREATED);
    }

    // PUT /api/tipos-tecnologia/{id}
    @PutMapping("/{id}")
    public ResponseEntity<TipoTecnologia> updateTipoTecnologia(@PathVariable Long id, @RequestBody TipoTecnologia tipoDetails) {
        return tipoTecnologiaRepository.findById(id)
                .map(existingTipo -> {
                    existingTipo.setNombre(tipoDetails.getNombre());
                    existingTipo.setFechaRegistra(tipoDetails.getFechaRegistra());
                    existingTipo.setFechaInactiva(tipoDetails.getFechaInactiva());
                    existingTipo.setActivo(tipoDetails.getActivo());
                    return new ResponseEntity<>(tipoTecnologiaRepository.save(existingTipo), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // DELETE /api/tipos-tecnologia/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTipoTecnologia(@PathVariable Long id) {
        if (tipoTecnologiaRepository.existsById(id)) {
            tipoTecnologiaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}