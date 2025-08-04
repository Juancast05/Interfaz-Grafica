package com.example.camara_backend.controllers;

import com.example.camara_backend.models.TipoCarril;
import com.example.camara_backend.repository.TipoCarrilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos-carril") // Define la ruta base para este controlador
public class TipoCarrilController {

    private final TipoCarrilRepository tipoCarrilRepository;

    @Autowired
    public TipoCarrilController(TipoCarrilRepository tipoCarrilRepository) {
        this.tipoCarrilRepository = tipoCarrilRepository;
    }

    // GET /api/tipos-carril
    @GetMapping
    public ResponseEntity<List<TipoCarril>> getAllTiposCarril() {
        List<TipoCarril> tiposCarril = tipoCarrilRepository.findAll();
        return new ResponseEntity<>(tiposCarril, HttpStatus.OK);
    }

    // GET /api/tipos-carril/{id}
    @GetMapping("/{id}")
    public ResponseEntity<TipoCarril> getTipoCarrilById(@PathVariable Long id) {
        return tipoCarrilRepository.findById(id)
                .map(tipoCarril -> new ResponseEntity<>(tipoCarril, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // POST /api/tipos-carril
    @PostMapping
    public ResponseEntity<TipoCarril> createTipoCarril(@RequestBody TipoCarril tipoCarril) {
        // No hay campos de fecha/hora para auto-generar en esta tabla
        TipoCarril createdTipoCarril = tipoCarrilRepository.save(tipoCarril);
        return new ResponseEntity<>(createdTipoCarril, HttpStatus.CREATED);
    }

    // PUT /api/tipos-carril/{id}
    @PutMapping("/{id}")
    public ResponseEntity<TipoCarril> updateTipoCarril(@PathVariable Long id, @RequestBody TipoCarril tipoCarrilDetails) {
        return tipoCarrilRepository.findById(id)
                .map(existingTipoCarril -> {
                    existingTipoCarril.setNombreCarril(tipoCarrilDetails.getNombreCarril());
                    existingTipoCarril.setActivo(tipoCarrilDetails.getActivo());
                    return new ResponseEntity<>(tipoCarrilRepository.save(existingTipoCarril), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // DELETE /api/tipos-carril/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTipoCarril(@PathVariable Long id) {
        if (tipoCarrilRepository.existsById(id)) {
            tipoCarrilRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}