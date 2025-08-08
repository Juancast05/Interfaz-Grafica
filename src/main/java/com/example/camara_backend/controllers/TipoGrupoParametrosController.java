package com.example.camara_backend.controllers;

import com.example.camara_backend.models.TipoGrupoParametros;
import com.example.camara_backend.repository.TipoGrupoParametrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/tipos-grupo-parametros")
public class TipoGrupoParametrosController {

    private final TipoGrupoParametrosRepository tipoGrupoParametrosRepository;

    @Autowired
    public TipoGrupoParametrosController(TipoGrupoParametrosRepository tipoGrupoParametrosRepository) {
        this.tipoGrupoParametrosRepository = tipoGrupoParametrosRepository;
    }

    // GET /api/tipos-grupo-parametros
    @GetMapping
    public ResponseEntity<List<TipoGrupoParametros>> getAllTiposGrupoParametros() {
        List<TipoGrupoParametros> tipos = tipoGrupoParametrosRepository.findAll();
        return new ResponseEntity<>(tipos, HttpStatus.OK);
    }

    // GET /api/tipos-grupo-parametros/{id}
    @GetMapping("/{id}")
    public ResponseEntity<TipoGrupoParametros> getTipoGrupoParametrosById(@PathVariable Long id) {
        return tipoGrupoParametrosRepository.findById(id)
                .map(tipo -> new ResponseEntity<>(tipo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // POST /api/tipos-grupo-parametros
    @PostMapping
    public ResponseEntity<TipoGrupoParametros> createTipoGrupoParametros(@RequestBody TipoGrupoParametros tipoGrupoParametros) {
        if (tipoGrupoParametros.getFechaRegistra() == null) {
            tipoGrupoParametros.setFechaRegistra(LocalDateTime.now());
        }
        TipoGrupoParametros createdTipo = tipoGrupoParametrosRepository.save(tipoGrupoParametros);
        return new ResponseEntity<>(createdTipo, HttpStatus.CREATED);
    }

    // PUT /api/tipos-grupo-parametros/{id}
    @PutMapping("/{id}")
    public ResponseEntity<TipoGrupoParametros> updateTipoGrupoParametros(@PathVariable Long id, @RequestBody TipoGrupoParametros tipoDetails) {
        return tipoGrupoParametrosRepository.findById(id)
                .map(existingTipo -> {
                    existingTipo.setNombre(tipoDetails.getNombre());
                    existingTipo.setFechaRegistra(tipoDetails.getFechaRegistra());
                    existingTipo.setFechaInactiva(tipoDetails.getFechaInactiva());
                    existingTipo.setActivo(tipoDetails.getActivo());
                    return new ResponseEntity<>(tipoGrupoParametrosRepository.save(existingTipo), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // DELETE /api/tipos-grupo-parametros/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTipoGrupoParametros(@PathVariable Long id) {
        if (tipoGrupoParametrosRepository.existsById(id)) {
            tipoGrupoParametrosRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}