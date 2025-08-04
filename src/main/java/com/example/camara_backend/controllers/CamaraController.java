package com.example.camara_backend.controllers; // <<-- ¡ASEGÚRATE DE QUE ESTE PAQUETE SEA TU PAQUETE CORRECTO!

import com.example.camara_backend.models.Camara; // Importa tu modelo Camara
import com.example.camara_backend.repository.CamaraRepository; // Importa tu repositorio CamaraRepository
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus; // Importación necesaria para HttpStatus
import org.springframework.http.ResponseEntity; // Importación necesaria para ResponseEntity
import org.springframework.web.bind.annotation.*; // Importa todas las anotaciones de Spring Web

import java.time.LocalDate; // ¡Necesario para campos LocalDate!
import java.util.List;
import java.util.Optional; // Importación necesaria para Optional

@RestController
@RequestMapping("/api/camaras")
public class CamaraController {

    @Autowired
    private CamaraRepository cameraRepository;

    // Obtener todas las cámaras
    @GetMapping
    public ResponseEntity<List<Camara>> getAllCameras() {
        try {
            List<Camara> cameras = cameraRepository.findAll();
            return new ResponseEntity<>(cameras, HttpStatus.OK); // Retorna 200 OK con la lista
        } catch (Exception e) {
            e.printStackTrace(); // Imprime la traza de la pila para depuración en la consola del backend
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Retorna 500 si hay un error
        }
    }

    // Registrar una nueva cámara
    @PostMapping
    public ResponseEntity<Camara> createCamera(@RequestBody Camara camera) {
        try {
            Camara savedCamera = cameraRepository.save(camera);
            return new ResponseEntity<>(savedCamera, HttpStatus.CREATED); // Retorna 201 Created
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtener una cámara por ID
    @GetMapping("/{id}")
    public ResponseEntity<Camara> getCameraById(@PathVariable Long id) {
        try {
            Optional<Camara> camera = cameraRepository.findById(id);
            if (camera.isPresent()) {
                return new ResponseEntity<>(camera.get(), HttpStatus.OK); // Retorna 200 OK
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retorna 404 Not Found
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // ** MÉTODO PARA ACTUALIZAR UNA CÁMARA (PUT) - CON TUS CAMPOS ESPECÍFICOS **
    @PutMapping("/{id}") // Esta anotación mapea las solicitudes PUT a /api/camaras/{id}
    public ResponseEntity<Camara> updateCamera(@PathVariable Long id, @RequestBody Camara camaraDetails) {
        try {
            Optional<Camara> camaraOptional = cameraRepository.findById(id);
            if (camaraOptional.isPresent()) {
                Camara existingCamara = camaraOptional.get();

                if (camaraDetails.getId_cliente_sistema() != null) {
                    existingCamara.setId_cliente_sistema(camaraDetails.getId_cliente_sistema());
                }
                if (camaraDetails.getId_tipo_proveedor_camara() != null) {
                    existingCamara.setId_tipo_proveedor_camara(camaraDetails.getId_tipo_proveedor_camara());
                }
                if (camaraDetails.getId_tipo_camara() != null) {
                    existingCamara.setId_tipo_camara(camaraDetails.getId_tipo_camara());
                }
                if (camaraDetails.getId_tipo_tecnologia() != null) {
                    existingCamara.setId_tipo_tecnologia(camaraDetails.getId_tipo_tecnologia());
                }
                if (camaraDetails.getMaximocarril() != null) {
                    existingCamara.setMaximocarril(camaraDetails.getMaximocarril());
                }
                if (camaraDetails.getMetros_referencia() != null) {
                    existingCamara.setMetros_referencia(camaraDetails.getMetros_referencia());
                }
                if (camaraDetails.getVelocidad_maxima_camara() != null) {
                    existingCamara.setVelocidad_maxima_camara(camaraDetails.getVelocidad_maxima_camara());
                }
                if (camaraDetails.getTolerancia_permitida() != null) {
                    existingCamara.setTolerancia_permitida(camaraDetails.getTolerancia_permitida());
                }
                if (camaraDetails.getId_tipo_fuente_evidencia() != null) {
                    existingCamara.setId_tipo_fuente_evidencia(camaraDetails.getId_tipo_fuente_evidencia());
                }
                // id_usuario_modifica se actualiza si viene, o podrías establecerlo desde el contexto de seguridad si lo tienes.
                if (camaraDetails.getId_usuario_modifica() != null) {
                    existingCamara.setId_usuario_modifica(camaraDetails.getId_usuario_modifica());
                }
                // Fecha de modificación se actualiza automáticamente con la fecha actual del servidor
                existingCamara.setFecha_modifica(LocalDate.now());


                // Campos String (se actualizan directamente, incluso si son nulos si el frontend los envía así)
                existingCamara.setIndex_code_proveedor(camaraDetails.getIndex_code_proveedor());
                existingCamara.setCodigo_camara(camaraDetails.getCodigo_camara());
                existingCamara.setCodigo_equipo(camaraDetails.getCodigo_equipo());
                existingCamara.setDireccion(camaraDetails.getDireccion());
                existingCamara.setSerial_camara(camaraDetails.getSerial_camara());
                existingCamara.setAlias_camara(camaraDetails.getAlias_camara());
                existingCamara.setLatitud(camaraDetails.getLatitud());
                existingCamara.setLongitud(camaraDetails.getLongitud());
                existingCamara.setActivo(camaraDetails.getActivo());
                existingCamara.setPunto_Referencia_inicial(camaraDetails.getPunto_Referencia_inicial());
                existingCamara.setPunto_Referencia_final(camaraDetails.getPunto_Referencia_final());
                existingCamara.setResolucion_camara(camaraDetails.getResolucion_camara());

                // Campos LocalDate
                existingCamara.setFecha_calibracion(camaraDetails.getFecha_calibracion());
                // fecha_registra no se actualiza en un PUT


                // Guarda la cámara actualizada. save() de JpaRepository actualiza si el ID ya existe en la DB.
                Camara updatedCamara = cameraRepository.save(existingCamara);
                return new ResponseEntity<>(updatedCamara, HttpStatus.OK); // Retorna 200 OK con la cámara actualizada
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Si la cámara no existe, devuelve 404
            }
        } catch (Exception e) {
            e.printStackTrace(); // Imprime la traza de error en la consola de tu IDE (MUY IMPORTANTE para depurar 500)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Retorna 500 si hay un error en el servidor
        }
    }

    // Eliminar una cámara por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCamera(@PathVariable Long id) {
        try {
            cameraRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Retorna 204 No Content para éxito sin cuerpo
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}