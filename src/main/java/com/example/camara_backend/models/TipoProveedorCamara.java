package com.example.camara_backend.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tipo_proveedor_camara")
public class TipoProveedorCamara {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_proveedor_camara")
    private Long idTipoProveedorCamara;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "fecha_registra")
    private LocalDateTime fechaRegistra;

    @Column(name = "fecha_inactiva")
    private LocalDateTime fechaInactiva;

    @Column(name = "activo", length = 1, nullable = false)
    private String activo;

    // Constructor vacío (necesario para JPA)
    public TipoProveedorCamara() {
    }

    // Constructor con campos
    public TipoProveedorCamara(String nombre, LocalDateTime fechaRegistra, LocalDateTime fechaInactiva, String activo) {
        this.nombre = nombre;
        this.fechaRegistra = fechaRegistra;
        this.fechaInactiva = fechaInactiva;
        this.activo = activo;
    }

    // --- Getters y Setters ---
    public Long getIdTipoProveedorCamara() { return idTipoProveedorCamara; }
    public void setIdTipoProveedorCamara(Long idTipoProveedorCamara) {
        this.idTipoProveedorCamara = idTipoProveedorCamara;
    }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public LocalDateTime getFechaRegistra() { return fechaRegistra; }
    public void setFechaRegistra(LocalDateTime fechaRegistra) { this.fechaRegistra = fechaRegistra; }
    public LocalDateTime getFechaInactiva() { return fechaInactiva; }
    public void setFechaInactiva(LocalDateTime fechaInactiva) { this.fechaInactiva = fechaInactiva; }
    public String getActivo() { return activo; }
    public void setActivo(String activo) { this.activo = activo; }
}