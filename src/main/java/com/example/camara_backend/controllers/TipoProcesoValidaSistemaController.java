package com.example.camara_backend.controllers;

import com.example.camara_backend.models.TipoProcesoValidaSistema;
import com.example.camara_backend.repository.TipoProcesoValidaSistemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos-proceso-valida-sistema")
public class TipoProcesoValidaSistemaController {

    private final TipoProcesoValidaSistemaRepository tipoProcesoValidaSistemaRepository;

    @Autowired
    public TipoProcesoValidaSistemaController(TipoProcesoValidaSistemaRepository tipoProcesoValidaSistemaRepository) {
        this.tipoProcesoValidaSistemaRepository = tipoProcesoValidaSistemaRepository;
    }

    // GET /api/tipos-proceso-valida-sistema
    @GetMapping
    public ResponseEntity<List<TipoProcesoValidaSistema>> getAllTiposProcesoValidaSistema() {
        List<TipoProcesoValidaSistema> tipos = tipoProcesoValidaSistemaRepository.findAll();
        return new ResponseEntity<>(tipos, HttpStatus.OK);
    }

    // GET /api/tipos-proceso-valida-sistema/{id}
    @GetMapping("/{id}")
    public ResponseEntity<TipoProcesoValidaSistema> getTipoProcesoValidaSistemaById(@PathVariable Long id) {
        return tipoProcesoValidaSistemaRepository.findById(id)
                .map(tipo -> new ResponseEntity<>(tipo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // POST /api/tipos-proceso-valida-sistema
    @PostMapping
    public ResponseEntity<TipoProcesoValidaSistema> createTipoProcesoValidaSistema(@RequestBody TipoProcesoValidaSistema tipoProcesoValidaSistema) {
        TipoProcesoValidaSistema createdTipo = tipoProcesoValidaSistemaRepository.save(tipoProcesoValidaSistema);
        return new ResponseEntity<>(createdTipo, HttpStatus.CREATED);
    }

    // PUT /api/tipos-proceso-valida-sistema/{id}
    @PutMapping("/{id}")
    public ResponseEntity<TipoProcesoValidaSistema> updateTipoProcesoValidaSistema(@PathVariable Long id, @RequestBody TipoProcesoValidaSistema tipoDetails) {
        return tipoProcesoValidaSistemaRepository.findById(id)
                .map(existingTipo -> {
                    existingTipo.setIdTipoCodigoInfraccion(tipoDetails.getIdTipoCodigoInfraccion());
                    existingTipo.setIdTipoSistemaAplica(tipoDetails.getIdTipoSistemaAplica());
                    existingTipo.setIdTipoSistemaConsumo(tipoDetails.getIdTipoSistemaConsumo());
                    existingTipo.setValido(tipoDetails.getValido());
                    return new ResponseEntity<>(tipoProcesoValidaSistemaRepository.save(existingTipo), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // DELETE /api/tipos-proceso-valida-sistema/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTipoProcesoValidaSistema(@PathVariable Long id) {
        if (tipoProcesoValidaSistemaRepository.existsById(id)) {
            tipoProcesoValidaSistemaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}