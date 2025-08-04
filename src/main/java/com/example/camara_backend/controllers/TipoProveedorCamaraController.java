package com.example.camara_backend.controllers;

import com.example.camara_backend.models.TipoProveedorCamara;
import com.example.camara_backend.repository.TipoProveedorCamaraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/tipos-proveedor-camara")
public class TipoProveedorCamaraController {

    private final TipoProveedorCamaraRepository tipoProveedorCamaraRepository;

    @Autowired
    public TipoProveedorCamaraController(TipoProveedorCamaraRepository tipoProveedorCamaraRepository) {
        this.tipoProveedorCamaraRepository = tipoProveedorCamaraRepository;
    }

    // GET /api/tipos-proveedor-camara
    @GetMapping
    public ResponseEntity<List<TipoProveedorCamara>> getAllTiposProveedorCamara() {
        List<TipoProveedorCamara> tipos = tipoProveedorCamaraRepository.findAll();
        return new ResponseEntity<>(tipos, HttpStatus.OK);
    }

    // GET /api/tipos-proveedor-camara/{id}
    @GetMapping("/{id}")
    public ResponseEntity<TipoProveedorCamara> getTipoProveedorCamaraById(@PathVariable Long id) {
        return tipoProveedorCamaraRepository.findById(id)
                .map(tipo -> new ResponseEntity<>(tipo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // POST /api/tipos-proveedor-camara
    @PostMapping
    public ResponseEntity<TipoProveedorCamara> createTipoProveedorCamara(@RequestBody TipoProveedorCamara tipoProveedorCamara) {
        if (tipoProveedorCamara.getFechaRegistra() == null) {
            tipoProveedorCamara.setFechaRegistra(LocalDateTime.now());
        }
        TipoProveedorCamara createdTipo = tipoProveedorCamaraRepository.save(tipoProveedorCamara);
        return new ResponseEntity<>(createdTipo, HttpStatus.CREATED);
    }

    // PUT /api/tipos-proveedor-camara/{id}
    @PutMapping("/{id}")
    public ResponseEntity<TipoProveedorCamara> updateTipoProveedorCamara(@PathVariable Long id, @RequestBody TipoProveedorCamara tipoDetails) {
        return tipoProveedorCamaraRepository.findById(id)
                .map(existingTipo -> {
                    existingTipo.setNombre(tipoDetails.getNombre());
                    existingTipo.setFechaRegistra(tipoDetails.getFechaRegistra());
                    existingTipo.setFechaInactiva(tipoDetails.getFechaInactiva());
                    existingTipo.setActivo(tipoDetails.getActivo());
                    return new ResponseEntity<>(tipoProveedorCamaraRepository.save(existingTipo), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // DELETE /api/tipos-proveedor-camara/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTipoProveedorCamara(@PathVariable Long id) {
        if (tipoProveedorCamaraRepository.existsById(id)) {
            tipoProveedorCamaraRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}