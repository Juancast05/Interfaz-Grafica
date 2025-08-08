package com.example.camara_backend.controllers;

import com.example.camara_backend.models.TipoMotivoExento;
import com.example.camara_backend.repository.TipoMotivoExentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/tipos-motivo-exento")
public class TipoMotivoExentoController {

    private final TipoMotivoExentoRepository tipoMotivoExentoRepository;

    @Autowired
    public TipoMotivoExentoController(TipoMotivoExentoRepository tipoMotivoExentoRepository) {
        this.tipoMotivoExentoRepository = tipoMotivoExentoRepository;
    }

    // GET /api/tipos-motivo-exento
    @GetMapping
    public ResponseEntity<List<TipoMotivoExento>> getAllTiposMotivoExento() {
        List<TipoMotivoExento> tipos = tipoMotivoExentoRepository.findAll();
        return new ResponseEntity<>(tipos, HttpStatus.OK);
    }

    // GET /api/tipos-motivo-exento/{id}
    @GetMapping("/{id}")
    public ResponseEntity<TipoMotivoExento> getTipoMotivoExentoById(@PathVariable Long id) {
        return tipoMotivoExentoRepository.findById(id)
                .map(tipo -> new ResponseEntity<>(tipo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // POST /api/tipos-motivo-exento
    @PostMapping
    public ResponseEntity<TipoMotivoExento> createTipoMotivoExento(@RequestBody TipoMotivoExento tipoMotivoExento) {
        if (tipoMotivoExento.getFechaRegistra() == null) {
            tipoMotivoExento.setFechaRegistra(LocalDateTime.now());
        }
        TipoMotivoExento createdTipo = tipoMotivoExentoRepository.save(tipoMotivoExento);
        return new ResponseEntity<>(createdTipo, HttpStatus.CREATED);
    }

    // PUT /api/tipos-motivo-exento/{id}
    @PutMapping("/{id}")
    public ResponseEntity<TipoMotivoExento> updateTipoMotivoExento(@PathVariable Long id, @RequestBody TipoMotivoExento tipoDetails) {
        return tipoMotivoExentoRepository.findById(id)
                .map(existingTipo -> {
                    existingTipo.setIdClienteSistema(tipoDetails.getIdClienteSistema());
                    existingTipo.setCodigoMotivo(tipoDetails.getCodigoMotivo());
                    existingTipo.setNombreMotivo(tipoDetails.getNombreMotivo());
                    existingTipo.setFechaRegistra(tipoDetails.getFechaRegistra());
                    existingTipo.setFechaInactiva(tipoDetails.getFechaInactiva());
                    existingTipo.setActivo(tipoDetails.getActivo());
                    return new ResponseEntity<>(tipoMotivoExentoRepository.save(existingTipo), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // DELETE /api/tipos-motivo-exento/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTipoMotivoExento(@PathVariable Long id) {
        if (tipoMotivoExentoRepository.existsById(id)) {
            tipoMotivoExentoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}