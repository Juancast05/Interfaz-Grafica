package com.example.camara_backend.controllers;

import com.example.camara_backend.models.TipoClaseVehiculo;
import com.example.camara_backend.repository.TipoClaseVehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/tipos-clase-vehiculo")
public class TipoClaseVehiculoController {

    private final TipoClaseVehiculoRepository tipoClaseVehiculoRepository;

    @Autowired
    public TipoClaseVehiculoController(TipoClaseVehiculoRepository tipoClaseVehiculoRepository) {
        this.tipoClaseVehiculoRepository = tipoClaseVehiculoRepository;
    }

    // GET /api/tipos-clase-vehiculo
    @GetMapping
    public ResponseEntity<List<TipoClaseVehiculo>> getAllTiposClaseVehiculo() {
        List<TipoClaseVehiculo> tipos = tipoClaseVehiculoRepository.findAll();
        return new ResponseEntity<>(tipos, HttpStatus.OK);
    }

    // GET /api/tipos-clase-vehiculo/{id}
    @GetMapping("/{id}")
    public ResponseEntity<TipoClaseVehiculo> getTipoClaseVehiculoById(@PathVariable Long id) {
        return tipoClaseVehiculoRepository.findById(id)
                .map(tipo -> new ResponseEntity<>(tipo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // POST /api/tipos-clase-vehiculo
    @PostMapping
    public ResponseEntity<TipoClaseVehiculo> createTipoClaseVehiculo(@RequestBody TipoClaseVehiculo tipoClaseVehiculo) {
        if (tipoClaseVehiculo.getFechaRegistra() == null) {
            tipoClaseVehiculo.setFechaRegistra(LocalDateTime.now());
        }
        TipoClaseVehiculo createdTipo = tipoClaseVehiculoRepository.save(tipoClaseVehiculo);
        return new ResponseEntity<>(createdTipo, HttpStatus.CREATED);
    }

    // PUT /api/tipos-clase-vehiculo/{id}
    @PutMapping("/{id}")
    public ResponseEntity<TipoClaseVehiculo> updateTipoClaseVehiculo(@PathVariable Long id, @RequestBody TipoClaseVehiculo tipoDetails) {
        return tipoClaseVehiculoRepository.findById(id)
                .map(existingTipo -> {
                    existingTipo.setIdClienteSistema(tipoDetails.getIdClienteSistema());
                    existingTipo.setCodigoClasificacion(tipoDetails.getCodigoClasificacion());
                    existingTipo.setNombre(tipoDetails.getNombre());
                    existingTipo.setValorHomologado(tipoDetails.getValorHomologado());
                    existingTipo.setFechaRegistra(tipoDetails.getFechaRegistra());
                    existingTipo.setFechaInactiva(tipoDetails.getFechaInactiva());
                    existingTipo.setActivo(tipoDetails.getActivo());
                    return new ResponseEntity<>(tipoClaseVehiculoRepository.save(existingTipo), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // DELETE /api/tipos-clase-vehiculo/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTipoClaseVehiculo(@PathVariable Long id) {
        if (tipoClaseVehiculoRepository.existsById(id)) {
            tipoClaseVehiculoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}