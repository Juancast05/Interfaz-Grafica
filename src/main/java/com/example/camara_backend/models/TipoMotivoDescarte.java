package com.example.camara_backend.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tipo_motivo_descarte")
public class TipoMotivoDescarte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_motivo_descarte")
    private Long idMotivoDescarte;

    @Column(name = "descripcion_motivo", nullable = false)
    private String descripcionMotivo;

    @Column(name = "fecha_registra")
    private LocalDateTime fechaRegistra;

    @Column(name = "activo", length = 1, nullable = false)
    private String activo;

    // Constructor vacío (necesario para JPA)
    public TipoMotivoDescarte() {
    }

    // Constructor con campos (opcional)
    public TipoMotivoDescarte(String descripcionMotivo, LocalDateTime fechaRegistra, String activo) {
        this.descripcionMotivo = descripcionMotivo;
        this.fechaRegistra = fechaRegistra;
        this.activo = activo;
    }

    // --- Getters y Setters ---
    public Long getIdMotivoDescarte() { return idMotivoDescarte; }
    public void setIdMotivoDescarte(Long idMotivoDescarte) { this.idMotivoDescarte = idMotivoDescarte; }
    public String getDescripcionMotivo() { return descripcionMotivo; }
    public void setDescripcionMotivo(String descripcionMotivo) { this.descripcionMotivo = descripcionMotivo; }
    public LocalDateTime getFechaRegistra() { return fechaRegistra; }
    public void setFechaRegistra(LocalDateTime fechaRegistra) { this.fechaRegistra = fechaRegistra; }
    public String getActivo() { return activo; }
    public void setActivo(String activo) { this.activo = activo; }
}