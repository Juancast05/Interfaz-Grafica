package com.example.camara_backend.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tipo_evidencia")
public class TipoEvidencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_evidencia")
    private Long idTipoEvidencia;

    @Column(name = "nombre_evidencia", nullable = false)
    private String nombreEvidencia;

    @Column(name = "tipo_evidencia", nullable = false)
    private String tipoEvidencia;

    @Column(name = "fecha_registra")
    private LocalDateTime fechaRegistra;

    @Column(name = "activo", nullable = false)
    private String activo;

    // Constructor vacío (necesario para JPA)
    public TipoEvidencia() {
    }

    // Getters y Setters
    public Long getIdTipoEvidencia() {
        return idTipoEvidencia;
    }

    public void setIdTipoEvidencia(Long idTipoEvidencia) {
        this.idTipoEvidencia = idTipoEvidencia;
    }

    public String getNombreEvidencia() {
        return nombreEvidencia;
    }

    public void setNombreEvidencia(String nombreEvidencia) {
        this.nombreEvidencia = nombreEvidencia;
    }

    public String getTipoEvidencia() {
        return tipoEvidencia;
    }

    public void setTipoEvidencia(String tipoEvidencia) {
        this.tipoEvidencia = tipoEvidencia;
    }

    public LocalDateTime getFechaRegistra() {
        return fechaRegistra;
    }

    public void setFechaRegistra(LocalDateTime fechaRegistra) {
        this.fechaRegistra = fechaRegistra;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }
}