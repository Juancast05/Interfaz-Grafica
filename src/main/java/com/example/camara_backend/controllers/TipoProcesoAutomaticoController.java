package com.example.camara_backend.controllers;

import com.example.camara_backend.models.TipoProcesoAutomatico;
import com.example.camara_backend.repository.TipoProcesoAutomaticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/tipos-proceso-automatico")
public class TipoProcesoAutomaticoController {

    private final TipoProcesoAutomaticoRepository tipoProcesoAutomaticoRepository;

    @Autowired
    public TipoProcesoAutomaticoController(TipoProcesoAutomaticoRepository tipoProcesoAutomaticoRepository) {
        this.tipoProcesoAutomaticoRepository = tipoProcesoAutomaticoRepository;
    }

    // GET /api/tipos-proceso-automatico
    @GetMapping
    public ResponseEntity<List<TipoProcesoAutomatico>> getAllTiposProcesoAutomatico() {
        List<TipoProcesoAutomatico> tipos = tipoProcesoAutomaticoRepository.findAll();
        return new ResponseEntity<>(tipos, HttpStatus.OK);
    }

    // GET /api/tipos-proceso-automatico/{id}
    @GetMapping("/{id}")
    public ResponseEntity<TipoProcesoAutomatico> getTipoProcesoAutomaticoById(@PathVariable Long id) {
        return tipoProcesoAutomaticoRepository.findById(id)
                .map(tipo -> new ResponseEntity<>(tipo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // POST /api/tipos-proceso-automatico
    @PostMapping
    public ResponseEntity<TipoProcesoAutomatico> createTipoProcesoAutomatico(@RequestBody TipoProcesoAutomatico tipoProcesoAutomatico) {
        if (tipoProcesoAutomatico.getFechaRegistra() == null) {
            tipoProcesoAutomatico.setFechaRegistra(LocalDateTime.now());
        }
        TipoProcesoAutomatico createdTipo = tipoProcesoAutomaticoRepository.save(tipoProcesoAutomatico);
        return new ResponseEntity<>(createdTipo, HttpStatus.CREATED);
    }

    // PUT /api/tipos-proceso-automatico/{id}
    @PutMapping("/{id}")
    public ResponseEntity<TipoProcesoAutomatico> updateTipoProcesoAutomatico(@PathVariable Long id, @RequestBody TipoProcesoAutomatico tipoDetails) {
        return tipoProcesoAutomaticoRepository.findById(id)
                .map(existingTipo -> {
                    existingTipo.setNombreProcesoAutomatico(tipoDetails.getNombreProcesoAutomatico());
                    existingTipo.setFechaRegistra(tipoDetails.getFechaRegistra());
                    existingTipo.setActivo(tipoDetails.getActivo());
                    existingTipo.setIdTipoSistema(tipoDetails.getIdTipoSistema());
                    return new ResponseEntity<>(tipoProcesoAutomaticoRepository.save(existingTipo), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // DELETE /api/tipos-proceso-automatico/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTipoProcesoAutomatico(@PathVariable Long id) {
        if (tipoProcesoAutomaticoRepository.existsById(id)) {
            tipoProcesoAutomaticoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}