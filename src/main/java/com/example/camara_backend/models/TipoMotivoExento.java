package com.example.camara_backend.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tipo_motivo_exento")
public class TipoMotivoExento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_motivo_exento")
    private Long idTipoMotivoExento;

    @Column(name = "id_cliente_sistema", nullable = false)
    private Long idClienteSistema;

    @Column(name = "codigo_motivo", nullable = false)
    private Long codigoMotivo;

    @Column(name = "nombre_motivo", nullable = false)
    private String nombreMotivo;

    @Column(name = "fecha_registra")
    private LocalDateTime fechaRegistra;

    @Column(name = "fecha_inactiva")
    private LocalDateTime fechaInactiva;

    @Column(name = "activo", nullable = false)
    private String activo;

    // Constructor vacío (necesario para JPA)
    public TipoMotivoExento() {
    }

    // Getters y Setters
    public Long getIdTipoMotivoExento() {
        return idTipoMotivoExento;
    }

    public void setIdTipoMotivoExento(Long idTipoMotivoExento) {
        this.idTipoMotivoExento = idTipoMotivoExento;
    }

    public Long getIdClienteSistema() {
        return idClienteSistema;
    }

    public void setIdClienteSistema(Long idClienteSistema) {
        this.idClienteSistema = idClienteSistema;
    }

    public Long getCodigoMotivo() {
        return codigoMotivo;
    }

    public void setCodigoMotivo(Long codigoMotivo) {
        this.codigoMotivo = codigoMotivo;
    }

    public String getNombreMotivo() {
        return nombreMotivo;
    }

    public void setNombreMotivo(String nombreMotivo) {
        this.nombreMotivo = nombreMotivo;
    }

    public LocalDateTime getFechaRegistra() {
        return fechaRegistra;
    }

    public void setFechaRegistra(LocalDateTime fechaRegistra) {
        this.fechaRegistra = fechaRegistra;
    }

    public LocalDateTime getFechaInactiva() {
        return fechaInactiva;
    }

    public void setFechaInactiva(LocalDateTime fechaInactiva) {
        this.fechaInactiva = fechaInactiva;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }
}