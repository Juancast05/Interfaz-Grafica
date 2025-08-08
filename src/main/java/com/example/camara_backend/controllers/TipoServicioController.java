package com.example.camara_backend.controllers;

import com.example.camara_backend.models.TipoServicio;
import com.example.camara_backend.repository.TipoServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/tipos-servicio")
public class TipoServicioController {

    private final TipoServicioRepository tipoServicioRepository;

    @Autowired
    public TipoServicioController(TipoServicioRepository tipoServicioRepository) {
        this.tipoServicioRepository = tipoServicioRepository;
    }

    // GET /api/tipos-servicio
    @GetMapping
    public ResponseEntity<List<TipoServicio>> getAllTiposServicio() {
        List<TipoServicio> tipos = tipoServicioRepository.findAll();
        return new ResponseEntity<>(tipos, HttpStatus.OK);
    }

    // GET /api/tipos-servicio/{id}
    @GetMapping("/{id}")
    public ResponseEntity<TipoServicio> getTipoServicioById(@PathVariable Long id) {
        return tipoServicioRepository.findById(id)
                .map(tipo -> new ResponseEntity<>(tipo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // POST /api/tipos-servicio
    @PostMapping
    public ResponseEntity<TipoServicio> createTipoServicio(@RequestBody TipoServicio tipoServicio) {
        if (tipoServicio.getFechaRegistra() == null) {
            tipoServicio.setFechaRegistra(LocalDateTime.now());
        }
        TipoServicio createdTipo = tipoServicioRepository.save(tipoServicio);
        return new ResponseEntity<>(createdTipo, HttpStatus.CREATED);
    }

    // PUT /api/tipos-servicio/{id}
    @PutMapping("/{id}")
    public ResponseEntity<TipoServicio> updateTipoServicio(@PathVariable Long id, @RequestBody TipoServicio tipoDetails) {
        return tipoServicioRepository.findById(id)
                .map(existingTipo -> {
                    existingTipo.setIdClienteSistema(tipoDetails.getIdClienteSistema());
                    existingTipo.setNombre(tipoDetails.getNombre());
                    existingTipo.setCodigoServicio(tipoDetails.getCodigoServicio());
                    existingTipo.setValorHomologado(tipoDetails.getValorHomologado());
                    existingTipo.setFechaRegistra(tipoDetails.getFechaRegistra());
                    existingTipo.setFechaInactiva(tipoDetails.getFechaInactiva());
                    existingTipo.setActivo(tipoDetails.getActivo());
                    return new ResponseEntity<>(tipoServicioRepository.save(existingTipo), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // DELETE /api/tipos-servicio/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTipoServicio(@PathVariable Long id) {
        if (tipoServicioRepository.existsById(id)) {
            tipoServicioRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}