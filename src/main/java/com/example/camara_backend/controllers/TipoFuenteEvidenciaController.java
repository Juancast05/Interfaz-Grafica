package com.example.camara_backend.controllers;

import com.example.camara_backend.models.TipoFuenteEvidencia;
import com.example.camara_backend.repository.TipoFuenteEvidenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/tipos-fuente-evidencia")
// @CrossOrigin ya no es necesario aquí
public class TipoFuenteEvidenciaController {

    private final TipoFuenteEvidenciaRepository tipoFuenteEvidenciaRepository;

    @Autowired
    public TipoFuenteEvidenciaController(TipoFuenteEvidenciaRepository tipoFuenteEvidenciaRepository) {
        this.tipoFuenteEvidenciaRepository = tipoFuenteEvidenciaRepository;
    }

    // GET /api/tipos-fuente-evidencia
    @GetMapping
    public ResponseEntity<List<TipoFuenteEvidencia>> getAllTiposFuenteEvidencia() {
        List<TipoFuenteEvidencia> tipos = tipoFuenteEvidenciaRepository.findAll();
        return new ResponseEntity<>(tipos, HttpStatus.OK);
    }

    // GET /api/tipos-fuente-evidencia/{id}
    @GetMapping("/{id}")
    public ResponseEntity<TipoFuenteEvidencia> getTipoFuenteEvidenciaById(@PathVariable Long id) {
        return tipoFuenteEvidenciaRepository.findById(id)
                .map(tipo -> new ResponseEntity<>(tipo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // POST /api/tipos-fuente-evidencia
    @PostMapping
    public ResponseEntity<TipoFuenteEvidencia> createTipoFuenteEvidencia(@RequestBody TipoFuenteEvidencia tipoFuenteEvidencia) {
        if (tipoFuenteEvidencia.getFechaRegistra() == null) {
            tipoFuenteEvidencia.setFechaRegistra(LocalDateTime.now());
        }
        TipoFuenteEvidencia createdTipo = tipoFuenteEvidenciaRepository.save(tipoFuenteEvidencia);
        return new ResponseEntity<>(createdTipo, HttpStatus.CREATED);
    }

    // PUT /api/tipos-fuente-evidencia/{id}
    @PutMapping("/{id}")
    public ResponseEntity<TipoFuenteEvidencia> updateTipoFuenteEvidencia(@PathVariable Long id, @RequestBody TipoFuenteEvidencia tipoDetails) {
        return tipoFuenteEvidenciaRepository.findById(id)
                .map(existingTipo -> {
                    existingTipo.setNombreFuenteEvidencia(tipoDetails.getNombreFuenteEvidencia());
                    existingTipo.setFechaRegistra(tipoDetails.getFechaRegistra());
                    existingTipo.setFechaModificaBd(LocalDateTime.now()); // Opcional: Actualizar la fecha de modificación
                    existingTipo.setActivo(tipoDetails.getActivo());
                    return new ResponseEntity<>(tipoFuenteEvidenciaRepository.save(existingTipo), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // DELETE /api/tipos-fuente-evidencia/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTipoFuenteEvidencia(@PathVariable Long id) {
        if (tipoFuenteEvidenciaRepository.existsById(id)) {
            tipoFuenteEvidenciaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}