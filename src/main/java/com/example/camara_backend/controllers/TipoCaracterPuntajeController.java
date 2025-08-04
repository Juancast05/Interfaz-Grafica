package com.example.camara_backend.controllers;

import com.example.camara_backend.models.TipoCaracterPuntaje;
import com.example.camara_backend.repository.TipoCaracterPuntajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/tipos-caracter-puntaje") // Ruta base para este controlador
public class TipoCaracterPuntajeController {

    private final TipoCaracterPuntajeRepository tipoCaracterPuntajeRepository;

    @Autowired
    public TipoCaracterPuntajeController(TipoCaracterPuntajeRepository tipoCaracterPuntajeRepository) {
        this.tipoCaracterPuntajeRepository = tipoCaracterPuntajeRepository;
    }

    // GET /api/tipos-caracter-puntaje
    @GetMapping
    public ResponseEntity<List<TipoCaracterPuntaje>> getAllTiposCaracterPuntaje() {
        List<TipoCaracterPuntaje> tipos = tipoCaracterPuntajeRepository.findAll();
        return new ResponseEntity<>(tipos, HttpStatus.OK);
    }

    // GET /api/tipos-caracter-puntaje/{id}
    @GetMapping("/{id}")
    public ResponseEntity<TipoCaracterPuntaje> getTipoCaracterPuntajeById(@PathVariable Long id) {
        return tipoCaracterPuntajeRepository.findById(id)
                .map(tipo -> new ResponseEntity<>(tipo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // POST /api/tipos-caracter-puntaje
    @PostMapping
    public ResponseEntity<TipoCaracterPuntaje> createTipoCaracterPuntaje(@RequestBody TipoCaracterPuntaje tipoCaracterPuntaje) {
        if (tipoCaracterPuntaje.getFechaRegistro() == null) {
            tipoCaracterPuntaje.setFechaRegistro(LocalDateTime.now());
        }
        TipoCaracterPuntaje createdTipo = tipoCaracterPuntajeRepository.save(tipoCaracterPuntaje);
        return new ResponseEntity<>(createdTipo, HttpStatus.CREATED);
    }

    // PUT /api/tipos-caracter-puntaje/{id}
    @PutMapping("/{id}")
    public ResponseEntity<TipoCaracterPuntaje> updateTipoCaracterPuntaje(@PathVariable Long id, @RequestBody TipoCaracterPuntaje tipoCaracterPuntajeDetails) {
        return tipoCaracterPuntajeRepository.findById(id)
                .map(existingTipo -> {
                    // Actualiza los campos que se envían en el 'details'
                    existingTipo.setIdTipoSistema(tipoCaracterPuntajeDetails.getIdTipoSistema());
                    existingTipo.setIdClienteSistema(tipoCaracterPuntajeDetails.getIdClienteSistema());
                    existingTipo.setCaracter(tipoCaracterPuntajeDetails.getCaracter());
                    existingTipo.setCoeficienteDispositivo(tipoCaracterPuntajeDetails.getCoeficienteDispositivo());
                    existingTipo.setEficienciaDispositivo(tipoCaracterPuntajeDetails.getEficienciaDispositivo());
                    existingTipo.setCoeficienteSistema(tipoCaracterPuntajeDetails.getCoeficienteSistema());
                    existingTipo.setEficienciaSistema(tipoCaracterPuntajeDetails.getEficienciaSistema());
                    existingTipo.setCoeficienteQalpr(tipoCaracterPuntajeDetails.getCoeficienteQalpr());
                    existingTipo.setEficienciaQalpr(tipoCaracterPuntajeDetails.getEficienciaQalpr());
                    existingTipo.setFechaRegistro(tipoCaracterPuntajeDetails.getFechaRegistro()); // Actualizar si se envía
                    existingTipo.setActivo(tipoCaracterPuntajeDetails.getActivo());
                    existingTipo.setIdTipoVehiculo(tipoCaracterPuntajeDetails.getIdTipoVehiculo());
                    existingTipo.setVersionScore(tipoCaracterPuntajeDetails.getVersionScore());

                    return new ResponseEntity<>(tipoCaracterPuntajeRepository.save(existingTipo), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // DELETE /api/tipos-caracter-puntaje/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTipoCaracterPuntaje(@PathVariable Long id) {
        if (tipoCaracterPuntajeRepository.existsById(id)) {
            tipoCaracterPuntajeRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}