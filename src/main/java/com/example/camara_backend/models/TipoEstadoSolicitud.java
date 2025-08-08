package com.example.camara_backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_estado_solicitud")
public class TipoEstadoSolicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_estado_solicitud")
    private Long idTipoEstadoSolicitud;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "activo", nullable = false)
    private String activo;

    // Constructor vacío (necesario para JPA)
    public TipoEstadoSolicitud() {
    }

    // Getters y Setters
    public Long getIdTipoEstadoSolicitud() {
        return idTipoEstadoSolicitud;
    }

    public void setIdTipoEstadoSolicitud(Long idTipoEstadoSolicitud) {
        this.idTipoEstadoSolicitud = idTipoEstadoSolicitud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }
}