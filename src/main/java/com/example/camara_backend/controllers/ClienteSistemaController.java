package com.example.camara_backend.controllers;

import com.example.camara_backend.models.ClienteSistema;
import com.example.camara_backend.repository.ClienteSistemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteSistemaController {

    @Autowired
    private ClienteSistemaRepository clienteSistemaRepository;

    // Obtener todos los clientes
    @GetMapping
    public List<ClienteSistema> listarClientes() {
        return clienteSistemaRepository.findAll();
    }

    // Crear nuevo cliente
    @PostMapping
    public ResponseEntity<ClienteSistema> crearCliente(@RequestBody ClienteSistema cliente) {
        ClienteSistema guardado = clienteSistemaRepository.save(cliente);
        return new ResponseEntity<>(guardado, HttpStatus.CREATED);
    }
}
