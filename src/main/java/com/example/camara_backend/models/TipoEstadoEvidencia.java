package com.example.camara_backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_estado_evidencia")
public class TipoEstadoEvidencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_estado_evidencia")
    private Long idTipoEstadoEvidencia;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "activo", nullable = false)
    private String activo;

    // Constructor vacío (necesario para JPA)
    public TipoEstadoEvidencia() {
    }

    // Getters y Setters
    public Long getIdTipoEstadoEvidencia() {
        return idTipoEstadoEvidencia;
    }

    public void setIdTipoEstadoEvidencia(Long idTipoEstadoEvidencia) {
        this.idTipoEstadoEvidencia = idTipoEstadoEvidencia;
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