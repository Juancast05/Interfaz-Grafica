package com.example.camara_backend.controllers;

import com.example.camara_backend.models.TipoCamara;
import com.example.camara_backend.repository.TipoCamaraRepository; // Inyectamos el repositorio directamente
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime; // Necesario para LocalDateTime.now()
import java.util.List;

@RestController
@RequestMapping("/api/tipos-camara")
public class TipoCamaraController {

    private final TipoCamaraRepository tipoCamaraRepository; // Inyectamos el repositorio

    @Autowired
    public TipoCamaraController(TipoCamaraRepository tipoCamaraRepository) {
        this.tipoCamaraRepository = tipoCamaraRepository;
    }

    @GetMapping
    public ResponseEntity<List<TipoCamara>> getAllTiposCamara() {
        List<TipoCamara> tiposCamara = tipoCamaraRepository.findAll();
        return new ResponseEntity<>(tiposCamara, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoCamara> getTipoCamaraById(@PathVariable Long id) {
        return tipoCamaraRepository.findById(id)
                .map(tipoCamara -> new ResponseEntity<>(tipoCamara, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping
    public ResponseEntity<TipoCamara> createTipoCamara(@RequestBody TipoCamara tipoCamara) {
        if (tipoCamara.getFechaRegistra() == null) {
            tipoCamara.setFechaRegistra(LocalDateTime.now());
        }
        TipoCamara createdTipoCamara = tipoCamaraRepository.save(tipoCamara);
        return new ResponseEntity<>(createdTipoCamara, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoCamara> updateTipoCamara(@PathVariable Long id, @RequestBody TipoCamara tipoCamaraDetails) {
        return tipoCamaraRepository.findById(id)
                .map(existingTipoCamara -> {
                    existingTipoCamara.setNombre(tipoCamaraDetails.getNombre());
                    if (tipoCamaraDetails.getFechaRegistra() != null) {
                        existingTipoCamara.setFechaRegistra(tipoCamaraDetails.getFechaRegistra());
                    }
                    existingTipoCamara.setFechaInactiva(tipoCamaraDetails.getFechaInactiva());
                    existingTipoCamara.setActivo(tipoCamaraDetails.getActivo());
                    return new ResponseEntity<>(tipoCamaraRepository.save(existingTipoCamara), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTipoCamara(@PathVariable Long id) {
        if (tipoCamaraRepository.existsById(id)) {
            tipoCamaraRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}