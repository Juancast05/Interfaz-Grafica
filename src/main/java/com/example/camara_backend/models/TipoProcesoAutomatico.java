package com.example.camara_backend.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tipo_proceso_automatico")
public class TipoProcesoAutomatico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_proceso_automatico")
    private Long idTipoProcesoAutomatico;

    @Column(name = "nombre_proceso_automatico", nullable = false)
    private String nombreProcesoAutomatico;

    @Column(name = "fecha_registra")
    private LocalDateTime fechaRegistra;

    @Column(name = "activo", length = 1, nullable = false)
    private String activo;

    @Column(name = "id_tipo_sistema")
    private Long idTipoSistema;

    // Constructor vacío (necesario para JPA)
    public TipoProcesoAutomatico() {
    }

    // Constructor con campos (opcional)
    public TipoProcesoAutomatico(String nombreProcesoAutomatico, LocalDateTime fechaRegistra, String activo, Long idTipoSistema) {
        this.nombreProcesoAutomatico = nombreProcesoAutomatico;
        this.fechaRegistra = fechaRegistra;
        this.activo = activo;
        this.idTipoSistema = idTipoSistema;
    }

    // --- Getters y Setters ---
    public Long getIdTipoProcesoAutomatico() { return idTipoProcesoAutomatico; }
    public void setIdTipoProcesoAutomatico(Long idTipoProcesoAutomatico) { this.idTipoProcesoAutomatico = idTipoProcesoAutomatico; }
    public String getNombreProcesoAutomatico() { return nombreProcesoAutomatico; }
    public void setNombreProcesoAutomatico(String nombreProcesoAutomatico) { this.nombreProcesoAutomatico = nombreProcesoAutomatico; }
    public LocalDateTime getFechaRegistra() { return fechaRegistra; }
    public void setFechaRegistra(LocalDateTime fechaRegistra) { this.fechaRegistra = fechaRegistra; }
    public String getActivo() { return activo; }
    public void setActivo(String activo) { this.activo = activo; }
    public Long getIdTipoSistema() { return idTipoSistema; }
    public void setIdTipoSistema(Long idTipoSistema) { this.idTipoSistema = idTipoSistema; }
}