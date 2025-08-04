package com.example.camara_backend.controllers;

import com.example.camara_backend.models.TipoClasificacionEvidencia;
import com.example.camara_backend.repository.TipoClasificacionEvidenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/tipos-clasificacion-evidencia")
public class TipoClasificacionEvidenciaController {

    private final TipoClasificacionEvidenciaRepository tipoClasificacionEvidenciaRepository;

    @Autowired
    public TipoClasificacionEvidenciaController(TipoClasificacionEvidenciaRepository tipoClasificacionEvidenciaRepository) {
        this.tipoClasificacionEvidenciaRepository = tipoClasificacionEvidenciaRepository;
    }

    // GET /api/tipos-clasificacion-evidencia
    @GetMapping
    public ResponseEntity<List<TipoClasificacionEvidencia>> getAllTiposClasificacionEvidencia() {
        List<TipoClasificacionEvidencia> tipos = tipoClasificacionEvidenciaRepository.findAll();
        return new ResponseEntity<>(tipos, HttpStatus.OK);
    }

    // GET /api/tipos-clasificacion-evidencia/{id}
    @GetMapping("/{id}")
    public ResponseEntity<TipoClasificacionEvidencia> getTipoClasificacionEvidenciaById(@PathVariable Long id) {
        return tipoClasificacionEvidenciaRepository.findById(id)
                .map(tipo -> new ResponseEntity<>(tipo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // POST /api/tipos-clasificacion-evidencia
    @PostMapping
    public ResponseEntity<TipoClasificacionEvidencia> createTipoClasificacionEvidencia(@RequestBody TipoClasificacionEvidencia tipoClasificacionEvidencia) {
        if (tipoClasificacionEvidencia.getFechaRegistra() == null) {
            tipoClasificacionEvidencia.setFechaRegistra(LocalDateTime.now());
        }
        TipoClasificacionEvidencia createdTipo = tipoClasificacionEvidenciaRepository.save(tipoClasificacionEvidencia);
        return new ResponseEntity<>(createdTipo, HttpStatus.CREATED);
    }

    // PUT /api/tipos-clasificacion-evidencia/{id}
    @PutMapping("/{id}")
    public ResponseEntity<TipoClasificacionEvidencia> updateTipoClasificacionEvidencia(@PathVariable Long id, @RequestBody TipoClasificacionEvidencia tipoDetails) {
        return tipoClasificacionEvidenciaRepository.findById(id)
                .map(existingTipo -> {
                    // Actualiza los campos que se envían
                    existingTipo.setIdTipoSistema(tipoDetails.getIdTipoSistema());
                    existingTipo.setIdClienteSistema(tipoDetails.getIdClienteSistema());
                    existingTipo.setUmbral1(tipoDetails.getUmbral1());
                    existingTipo.setUmbral2(tipoDetails.getUmbral2());
                    existingTipo.setUmbral3(tipoDetails.getUmbral3());
                    existingTipo.setUmbral4(tipoDetails.getUmbral4());
                    existingTipo.setConstanteDispositivo(tipoDetails.getConstanteDispositivo());
                    existingTipo.setConstanteSistema(tipoDetails.getConstanteSistema());
                    existingTipo.setConstanteQalpr(tipoDetails.getConstanteQalpr());
                    existingTipo.setPlateScore(tipoDetails.getPlateScore());
                    existingTipo.setOcrScore(tipoDetails.getOcrScore());
                    existingTipo.setFechaRegistra(tipoDetails.getFechaRegistra()); // Se puede actualizar o mantener
                    existingTipo.setActivo(tipoDetails.getActivo());
                    existingTipo.setIdTipoVehiculo(tipoDetails.getIdTipoVehiculo());

                    return new ResponseEntity<>(tipoClasificacionEvidenciaRepository.save(existingTipo), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // DELETE /api/tipos-clasificacion-evidencia/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTipoClasificacionEvidencia(@PathVariable Long id) {
        if (tipoClasificacionEvidenciaRepository.existsById(id)) {
            tipoClasificacionEvidenciaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}