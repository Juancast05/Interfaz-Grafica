package com.example.camara_backend.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tipo_evidencia_infraccion")
public class TipoEvidenciaInfraccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_evidencia_infraccion")
    private Long idTipoEvidenciaInfraccion;

    @Column(name = "id_tipo_codigo_infraccion", nullable = false)
    private Long idTipoCodigoInfraccion;

    @Column(name = "id_tipo_evidencia", nullable = false)
    private Long idTipoEvidencia;

    @Column(name = "fecha_inicio")
    private LocalDateTime fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDateTime fechaFin;

    @Column(name = "activo", nullable = false)
    private String activo;

    // Constructor vacío (necesario para JPA)
    public TipoEvidenciaInfraccion() {
    }

    // Getters y Setters
    public Long getIdTipoEvidenciaInfraccion() {
        return idTipoEvidenciaInfraccion;
    }

    public void setIdTipoEvidenciaInfraccion(Long idTipoEvidenciaInfraccion) {
        this.idTipoEvidenciaInfraccion = idTipoEvidenciaInfraccion;
    }

    public Long getIdTipoCodigoInfraccion() {
        return idTipoCodigoInfraccion;
    }

    public void setIdTipoCodigoInfraccion(Long idTipoCodigoInfraccion) {
        this.idTipoCodigoInfraccion = idTipoCodigoInfraccion;
    }

    public Long getIdTipoEvidencia() {
        return idTipoEvidencia;
    }

    public void setIdTipoEvidencia(Long idTipoEvidencia) {
        this.idTipoEvidencia = idTipoEvidencia;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }
}