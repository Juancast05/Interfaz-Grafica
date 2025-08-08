package com.example.camara_backend.controllers;

import com.example.camara_backend.models.TipoEstadoSolicitud;
import com.example.camara_backend.repository.TipoEstadoSolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos-estado-solicitud")
public class TipoEstadoSolicitudController {

    private final TipoEstadoSolicitudRepository tipoEstadoSolicitudRepository;

    @Autowired
    public TipoEstadoSolicitudController(TipoEstadoSolicitudRepository tipoEstadoSolicitudRepository) {
        this.tipoEstadoSolicitudRepository = tipoEstadoSolicitudRepository;
    }

    // GET /api/tipos-estado-solicitud
    @GetMapping
    public ResponseEntity<List<TipoEstadoSolicitud>> getAllTiposEstadoSolicitud() {
        List<TipoEstadoSolicitud> tipos = tipoEstadoSolicitudRepository.findAll();
        return new ResponseEntity<>(tipos, HttpStatus.OK);
    }

    // GET /api/tipos-estado-solicitud/{id}
    @GetMapping("/{id}")
    public ResponseEntity<TipoEstadoSolicitud> getTipoEstadoSolicitudById(@PathVariable Long id) {
        return tipoEstadoSolicitudRepository.findById(id)
                .map(tipo -> new ResponseEntity<>(tipo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // POST /api/tipos-estado-solicitud
    @PostMapping
    public ResponseEntity<TipoEstadoSolicitud> createTipoEstadoSolicitud(@RequestBody TipoEstadoSolicitud tipoEstadoSolicitud) {
        TipoEstadoSolicitud createdTipo = tipoEstadoSolicitudRepository.save(tipoEstadoSolicitud);
        return new ResponseEntity<>(createdTipo, HttpStatus.CREATED);
    }

    // PUT /api/tipos-estado-solicitud/{id}
    @PutMapping("/{id}")
    public ResponseEntity<TipoEstadoSolicitud> updateTipoEstadoSolicitud(@PathVariable Long id, @RequestBody TipoEstadoSolicitud tipoDetails) {
        return tipoEstadoSolicitudRepository.findById(id)
                .map(existingTipo -> {
                    existingTipo.setNombre(tipoDetails.getNombre());
                    existingTipo.setActivo(tipoDetails.getActivo());
                    return new ResponseEntity<>(tipoEstadoSolicitudRepository.save(existingTipo), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // DELETE /api/tipos-estado-solicitud/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTipoEstadoSolicitud(@PathVariable Long id) {
        if (tipoEstadoSolicitudRepository.existsById(id)) {
            tipoEstadoSolicitudRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}