package com.example.camara_backend.controllers;

import com.example.camara_backend.models.ClienteSistema;
import com.example.camara_backend.repository.ClienteSistemaRepository; // Se inyecta el repositorio directamente
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")

public class ClienteSistemaController {

    @Autowired
    private ClienteSistemaRepository clienteSistemaRepository; // Inyección del repositorio directamente

    // Obtener todos los clientes
    @GetMapping
    public ResponseEntity<List<ClienteSistema>> listarClientes() {
        try {
            List<ClienteSistema> clientes = clienteSistemaRepository.findAll(); // Uso directo del repositorio
            return new ResponseEntity<>(clientes, HttpStatus.OK); // Retorna 200 OK
        } catch (Exception e) {
            e.printStackTrace(); // Imprime la traza de error en la consola del backend para depuración
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Retorna 500 si hay un error
        }
    }

    // Crear nuevo cliente
    @PostMapping
    public ResponseEntity<ClienteSistema> crearCliente(@RequestBody ClienteSistema cliente) {
        try {
            ClienteSistema guardado = clienteSistemaRepository.save(cliente); // Uso directo del repositorio
            return new ResponseEntity<>(guardado, HttpStatus.CREATED); // Retorna 201 Created
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtener un cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<ClienteSistema> obtenerClientePorId(@PathVariable Integer id) { // ID es Integer
        try {
            Optional<ClienteSistema> cliente = clienteSistemaRepository.findById(id); // Uso directo del repositorio
            if (cliente.isPresent()) {
                return new ResponseEntity<>(cliente.get(), HttpStatus.OK); // Retorna 200 OK
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retorna 404 Not Found
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Actualizar un cliente por ID
    @PutMapping("/{id}")
    public ResponseEntity<ClienteSistema> actualizarCliente(@PathVariable Integer id, @RequestBody ClienteSistema clienteDetails) { // ID es Integer
        try {
            Optional<ClienteSistema> clienteOptional = clienteSistemaRepository.findById(id); // Uso directo del repositorio
            if (clienteOptional.isPresent()) {
                ClienteSistema existingCliente = clienteOptional.get();

                // *** ACTUALIZAR CADA CAMPO CON LOS DATOS DE clienteDetails ***
                existingCliente.setNombre(clienteDetails.getNombre());
                existingCliente.setRuta_base(clienteDetails.getRuta_base());
                existingCliente.setRuta_destino(clienteDetails.getRuta_destino());
                existingCliente.setUrl_registro_detenccion(clienteDetails.getUrl_registro_detenccion());

                if (clienteDetails.getNodos() != null) {
                    existingCliente.setNodos(clienteDetails.getNodos());
                }

                existingCliente.setAplica_sabado(clienteDetails.getAplica_sabado());
                existingCliente.setCodigo_externo(clienteDetails.getCodigo_externo());
                existingCliente.setActivo(clienteDetails.getActivo());

                ClienteSistema updatedCliente = clienteSistemaRepository.save(existingCliente); // Uso directo del repositorio
                return new ResponseEntity<>(updatedCliente, HttpStatus.OK); // Retorna 200 OK con el cliente actualizado
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retorna 404 Not Found si el cliente no existe
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}