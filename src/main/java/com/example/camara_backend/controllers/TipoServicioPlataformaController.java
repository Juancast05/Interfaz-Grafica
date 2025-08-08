package com.example.camara_backend.controllers;

import com.example.camara_backend.models.TipoServicioPlataforma;
import com.example.camara_backend.repository.TipoServicioPlataformaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos-servicio-plataforma")
public class TipoServicioPlataformaController {

    private final TipoServicioPlataformaRepository tipoServicioPlataformaRepository;

    @Autowired
    public TipoServicioPlataformaController(TipoServicioPlataformaRepository tipoServicioPlataformaRepository) {
        this.tipoServicioPlataformaRepository = tipoServicioPlataformaRepository;
    }

    // GET /api/tipos-servicio-plataforma
    @GetMapping
    public ResponseEntity<List<TipoServicioPlataforma>> getAllTiposServicioPlataforma() {
        List<TipoServicioPlataforma> tipos = tipoServicioPlataformaRepository.findAll();
        return new ResponseEntity<>(tipos, HttpStatus.OK);
    }

    // GET /api/tipos-servicio-plataforma/{id}
    @GetMapping("/{id}")
    public ResponseEntity<TipoServicioPlataforma> getTipoServicioPlataformaById(@PathVariable Long id) {
        return tipoServicioPlataformaRepository.findById(id)
                .map(tipo -> new ResponseEntity<>(tipo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // POST /api/tipos-servicio-plataforma
    @PostMapping
    public ResponseEntity<TipoServicioPlataforma> createTipoServicioPlataforma(@RequestBody TipoServicioPlataforma tipoServicioPlataforma) {
        TipoServicioPlataforma createdTipo = tipoServicioPlataformaRepository.save(tipoServicioPlataforma);
        return new ResponseEntity<>(createdTipo, HttpStatus.CREATED);
    }

    // PUT /api/tipos-servicio-plataforma/{id}
    @PutMapping("/{id}")
    public ResponseEntity<TipoServicioPlataforma> updateTipoServicioPlataforma(@PathVariable Long id, @RequestBody TipoServicioPlataforma tipoDetails) {
        return tipoServicioPlataformaRepository.findById(id)
                .map(existingTipo -> {
                    existingTipo.setNombreServicioPlataforma(tipoDetails.getNombreServicioPlataforma());
                    existingTipo.setIdTipoSistema(tipoDetails.getIdTipoSistema());
                    existingTipo.setExterno(tipoDetails.getExterno());
                    return new ResponseEntity<>(tipoServicioPlataformaRepository.save(existingTipo), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // DELETE /api/tipos-servicio-plataforma/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTipoServicioPlataforma(@PathVariable Long id) {
        if (tipoServicioPlataformaRepository.existsById(id)) {
            tipoServicioPlataformaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}