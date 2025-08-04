package com.example.camara_backend.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tipo_fuente_evidencia")
public class TipoFuenteEvidencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_fuente_evidencia")
    private Long idTipoFuenteEvidencia;

    @Column(name = "nombre_fuente_evidencia", nullable = false)
    private String nombreFuenteEvidencia;

    @Column(name = "fecha_registra")
    private LocalDateTime fechaRegistra;

    @Column(name = "fecha_modifica_bd")
    private LocalDateTime fechaModificaBd;

    @Column(name = "activo", length = 1, nullable = false)
    private String activo;

    // Constructor vacío (necesario para JPA)
    public TipoFuenteEvidencia() {
    }

    // Constructor con campos (opcional)
    public TipoFuenteEvidencia(String nombreFuenteEvidencia, LocalDateTime fechaRegistra, LocalDateTime fechaModificaBd, String activo) {
        this.nombreFuenteEvidencia = nombreFuenteEvidencia;
        this.fechaRegistra = fechaRegistra;
        this.fechaModificaBd = fechaModificaBd;
        this.activo = activo;
    }

    // --- Getters y Setters ---
    public Long getIdTipoFuenteEvidencia() { return idTipoFuenteEvidencia; }
    public void setIdTipoFuenteEvidencia(Long idTipoFuenteEvidencia) { this.idTipoFuenteEvidencia = idTipoFuenteEvidencia; }
    public String getNombreFuenteEvidencia() { return nombreFuenteEvidencia; }
    public void setNombreFuenteEvidencia(String nombreFuenteEvidencia) { this.nombreFuenteEvidencia = nombreFuenteEvidencia; }
    public LocalDateTime getFechaRegistra() { return fechaRegistra; }
    public void setFechaRegistra(LocalDateTime fechaRegistra) { this.fechaRegistra = fechaRegistra; }
    public LocalDateTime getFechaModificaBd() { return fechaModificaBd; }
    public void setFechaModificaBd(LocalDateTime fechaModificaBd) { this.fechaModificaBd = fechaModificaBd; }
    public String getActivo() { return activo; }
    public void setActivo(String activo) { this.activo = activo; }
}