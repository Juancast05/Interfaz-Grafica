package com.example.camara_backend.controllers;

import com.example.camara_backend.models.TipoExento;
import com.example.camara_backend.repository.TipoExentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/tipos-exento")
public class TipoExentoController {

    private final TipoExentoRepository tipoExentoRepository;

    @Autowired
    public TipoExentoController(TipoExentoRepository tipoExentoRepository) {
        this.tipoExentoRepository = tipoExentoRepository;
    }

    // GET /api/tipos-exento
    @GetMapping
    public ResponseEntity<List<TipoExento>> getAllTiposExento() {
        List<TipoExento> tipos = tipoExentoRepository.findAll();
        return new ResponseEntity<>(tipos, HttpStatus.OK);
    }

    // GET /api/tipos-exento/{id}
    @GetMapping("/{id}")
    public ResponseEntity<TipoExento> getTipoExentoById(@PathVariable Long id) {
        return tipoExentoRepository.findById(id)
                .map(tipo -> new ResponseEntity<>(tipo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // POST /api/tipos-exento
    @PostMapping
    public ResponseEntity<TipoExento> createTipoExento(@RequestBody TipoExento tipoExento) {
        if (tipoExento.getFechaRegistra() == null) {
            tipoExento.setFechaRegistra(LocalDateTime.now());
        }
        TipoExento createdTipo = tipoExentoRepository.save(tipoExento);
        return new ResponseEntity<>(createdTipo, HttpStatus.CREATED);
    }

    // PUT /api/tipos-exento/{id}
    @PutMapping("/{id}")
    public ResponseEntity<TipoExento> updateTipoExento(@PathVariable Long id, @RequestBody TipoExento tipoDetails) {
        return tipoExentoRepository.findById(id)
                .map(existingTipo -> {
                    existingTipo.setIdClienteSistema(tipoDetails.getIdClienteSistema());
                    existingTipo.setCodigoExento(tipoDetails.getCodigoExento());
                    existingTipo.setDescripcionExento(tipoDetails.getDescripcionExento());
                    existingTipo.setFechaRegistra(tipoDetails.getFechaRegistra());
                    existingTipo.setFechaInactiva(tipoDetails.getFechaInactiva());
                    existingTipo.setActivo(tipoDetails.getActivo());
                    return new ResponseEntity<>(tipoExentoRepository.save(existingTipo), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // DELETE /api/tipos-exento/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTipoExento(@PathVariable Long id) {
        if (tipoExentoRepository.existsById(id)) {
            tipoExentoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}