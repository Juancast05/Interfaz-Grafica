package com.example.camara_backend.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tipo_vehiculo")
public class TipoVehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_vehiculo")
    private Long idTipoVehiculo;

    @Column(name = "nombre_vehiculo", nullable = false)
    private String nombreVehiculo;

    @Column(name = "fecha_registra")
    private LocalDateTime fechaRegistra;

    @Column(name = "activo", nullable = false)
    private String activo;

    // Constructor vacío (necesario para JPA)
    public TipoVehiculo() {
    }

    // Getters y Setters
    public Long getIdTipoVehiculo() {
        return idTipoVehiculo;
    }

    public void setIdTipoVehiculo(Long idTipoVehiculo) {
        this.idTipoVehiculo = idTipoVehiculo;
    }

    public String getNombreVehiculo() {
        return nombreVehiculo;
    }

    public void setNombreVehiculo(String nombreVehiculo) {
        this.nombreVehiculo = nombreVehiculo;
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