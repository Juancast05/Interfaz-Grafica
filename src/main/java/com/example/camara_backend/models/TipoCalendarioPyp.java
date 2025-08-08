package com.example.camara_backend.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tipo_calendario_pyp")
public class TipoCalendarioPyp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_calendario_pyp")
    private Long idTipoCalendarioPyp;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "fecha_registra")
    private LocalDateTime fechaRegistra;

    @Column(name = "fecha_inactiva")
    private LocalDateTime fechaInactiva;

    @Column(name = "activo", nullable = false)
    private String activo;

    // Constructor vacío (necesario para JPA)
    public TipoCalendarioPyp() {
    }

    // Getters y Setters
    public Long getIdTipoCalendarioPyp() {
        return idTipoCalendarioPyp;
    }

    public void setIdTipoCalendarioPyp(Long idTipoCalendarioPyp) {
        this.idTipoCalendarioPyp = idTipoCalendarioPyp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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