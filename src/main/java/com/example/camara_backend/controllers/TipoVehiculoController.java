package com.example.camara_backend.controllers;

import com.example.camara_backend.models.TipoVehiculo;
import com.example.camara_backend.repository.TipoVehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/tipos-vehiculo")
public class TipoVehiculoController {

    private final TipoVehiculoRepository tipoVehiculoRepository;

    @Autowired
    public TipoVehiculoController(TipoVehiculoRepository tipoVehiculoRepository) {
        this.tipoVehiculoRepository = tipoVehiculoRepository;
    }

    // GET /api/tipos-vehiculo
    @GetMapping
    public ResponseEntity<List<TipoVehiculo>> getAllTiposVehiculo() {
        List<TipoVehiculo> tipos = tipoVehiculoRepository.findAll();
        return new ResponseEntity<>(tipos, HttpStatus.OK);
    }

    // GET /api/tipos-vehiculo/{id}
    @GetMapping("/{id}")
    public ResponseEntity<TipoVehiculo> getTipoVehiculoById(@PathVariable Long id) {
        return tipoVehiculoRepository.findById(id)
                .map(tipo -> new ResponseEntity<>(tipo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // POST /api/tipos-vehiculo
    @PostMapping
    public ResponseEntity<TipoVehiculo> createTipoVehiculo(@RequestBody TipoVehiculo tipoVehiculo) {
        if (tipoVehiculo.getFechaRegistra() == null) {
            tipoVehiculo.setFechaRegistra(LocalDateTime.now());
        }
        TipoVehiculo createdTipo = tipoVehiculoRepository.save(tipoVehiculo);
        return new ResponseEntity<>(createdTipo, HttpStatus.CREATED);
    }

    // PUT /api/tipos-vehiculo/{id}
    @PutMapping("/{id}")
    public ResponseEntity<TipoVehiculo> updateTipoVehiculo(@PathVariable Long id, @RequestBody TipoVehiculo tipoDetails) {
        return tipoVehiculoRepository.findById(id)
                .map(existingTipo -> {
                    existingTipo.setNombreVehiculo(tipoDetails.getNombreVehiculo());
                    existingTipo.setFechaRegistra(tipoDetails.getFechaRegistra());
                    existingTipo.setActivo(tipoDetails.getActivo());
                    return new ResponseEntity<>(tipoVehiculoRepository.save(existingTipo), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // DELETE /api/tipos-vehiculo/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTipoVehiculo(@PathVariable Long id) {
        if (tipoVehiculoRepository.existsById(id)) {
            tipoVehiculoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}