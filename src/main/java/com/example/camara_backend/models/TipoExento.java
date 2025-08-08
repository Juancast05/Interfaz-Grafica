package com.example.camara_backend.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tipo_exento")
public class TipoExento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_exento")
    private Long idTipoExento;

    @Column(name = "id_cliente_sistema")
    private Long idClienteSistema;

    @Column(name = "codigo_exento", nullable = false)
    private Long codigoExento;

    @Column(name = "descripcion_exento", nullable = false)
    private String descripcionExento;

    @Column(name = "fecha_registra")
    private LocalDateTime fechaRegistra;

    @Column(name = "fecha_inactiva")
    private LocalDateTime fechaInactiva;

    @Column(name = "activo", nullable = false)
    private String activo;

    // Constructor vacío (necesario para JPA)
    public TipoExento() {
    }

    // Getters y Setters
    public Long getIdTipoExento() {
        return idTipoExento;
    }

    public void setIdTipoExento(Long idTipoExento) {
        this.idTipoExento = idTipoExento;
    }

    public Long getIdClienteSistema() {
        return idClienteSistema;
    }

    public void setIdClienteSistema(Long idClienteSistema) {
        this.idClienteSistema = idClienteSistema;
    }

    public Long getCodigoExento() {
        return codigoExento;
    }

    public void setCodigoExento(Long codigoExento) {
        this.codigoExento = codigoExento;
    }

    public String getDescripcionExento() {
        return descripcionExento;
    }

    public void setDescripcionExento(String descripcionExento) {
        this.descripcionExento = descripcionExento;
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