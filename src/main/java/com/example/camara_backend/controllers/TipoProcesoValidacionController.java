package com.example.camara_backend.controllers;

import com.example.camara_backend.models.TipoProcesoValidacion;
import com.example.camara_backend.repository.TipoProcesoValidacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/tipos-proceso-validacion")
public class TipoProcesoValidacionController {

    private final TipoProcesoValidacionRepository tipoProcesoValidacionRepository;

    @Autowired
    public TipoProcesoValidacionController(TipoProcesoValidacionRepository tipoProcesoValidacionRepository) {
        this.tipoProcesoValidacionRepository = tipoProcesoValidacionRepository;
    }

    // GET /api/tipos-proceso-validacion
    @GetMapping
    public ResponseEntity<List<TipoProcesoValidacion>> getAllTiposProcesoValidacion() {
        List<TipoProcesoValidacion> tipos = tipoProcesoValidacionRepository.findAll();
        return new ResponseEntity<>(tipos, HttpStatus.OK);
    }

    // GET /api/tipos-proceso-validacion/{id}
    @GetMapping("/{id}")
    public ResponseEntity<TipoProcesoValidacion> getTipoProcesoValidacionById(@PathVariable Long id) {
        return tipoProcesoValidacionRepository.findById(id)
                .map(tipo -> new ResponseEntity<>(tipo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // POST /api/tipos-proceso-validacion
    @PostMapping
    public ResponseEntity<TipoProcesoValidacion> createTipoProcesoValidacion(@RequestBody TipoProcesoValidacion tipoProcesoValidacion) {
        if (tipoProcesoValidacion.getFechaRegistra() == null) {
            tipoProcesoValidacion.setFechaRegistra(LocalDateTime.now());
        }
        TipoProcesoValidacion createdTipo = tipoProcesoValidacionRepository.save(tipoProcesoValidacion);
        return new ResponseEntity<>(createdTipo, HttpStatus.CREATED);
    }

    // PUT /api/tipos-proceso-validacion/{id}
    @PutMapping("/{id}")
    public ResponseEntity<TipoProcesoValidacion> updateTipoProcesoValidacion(@PathVariable Long id, @RequestBody TipoProcesoValidacion tipoDetails) {
        return tipoProcesoValidacionRepository.findById(id)
                .map(existingTipo -> {
                    existingTipo.setIdClienteSistema(tipoDetails.getIdClienteSistema());
                    existingTipo.setNombre(tipoDetails.getNombre());
                    existingTipo.setIdTipoCodigoInfraccion(tipoDetails.getIdTipoCodigoInfraccion());
                    existingTipo.setMaximoReporteDetecciones(tipoDetails.getMaximoReporteDetecciones());
                    existingTipo.setDiasReporteDeteccion(tipoDetails.getDiasReporteDeteccion());
                    existingTipo.setDiasHabilesReporteDeteccion(tipoDetails.getDiasHabilesReporteDeteccion());
                    existingTipo.setDiasGestionEntrega(tipoDetails.getDiasGestionEntrega());
                    existingTipo.setDiasHabilesGestionEntrega(tipoDetails.getDiasHabilesGestionEntrega());
                    existingTipo.setMinimoImagenesReporte(tipoDetails.getMinimoImagenesReporte());
                    existingTipo.setValidaExento(tipoDetails.getValidaExento());
                    existingTipo.setFechaRegistra(tipoDetails.getFechaRegistra());
                    existingTipo.setFechaInactiva(tipoDetails.getFechaInactiva());
                    existingTipo.setActivo(tipoDetails.getActivo());
                    return new ResponseEntity<>(tipoProcesoValidacionRepository.save(existingTipo), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // DELETE /api/tipos-proceso-validacion/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTipoProcesoValidacion(@PathVariable Long id) {
        if (tipoProcesoValidacionRepository.existsById(id)) {
            tipoProcesoValidacionRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}