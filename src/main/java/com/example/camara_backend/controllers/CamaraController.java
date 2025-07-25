package com.example.camara_backend.controllers;

import com.example.camara_backend.models.Camara;
import com.example.camara_backend.repository.CamaraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/api/camaras")
    public class CamaraController {

        @Autowired
        private CamaraRepository cameraRepository;

        // Obtener todas las cámaras
        @GetMapping
        public List<Camara> getAllCameras() {
            return cameraRepository.findAll();
        }

        // Registrar una nueva cámara
        @PostMapping
        public Camara createCamera(@RequestBody Camara camera) {
            return cameraRepository.save(camera);
        }

        // Obtener una cámara por ID
        @GetMapping("/{id}")
        public Camara getCameraById(@PathVariable Long id) {
            return cameraRepository.findById(id).orElse(null);
        }

        // Eliminar una cámara por ID
        @DeleteMapping("/{id}")
        public void deleteCamera(@PathVariable Long id) {
            cameraRepository.deleteById(id);
        }

    }
