package com.example.camara_backend.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tipo_tecnologia")
public class TipoTecnologia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TIPO_TECNOLOGIA")
    private Long idTipoTecnologia;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "FECHA_REGISTRA")
    private LocalDateTime fechaRegistra;

    @Column(name = "FECHA_INACTIVA")
    private LocalDateTime fechaInactiva;

    @Column(name = "ACTIVO", length = 1, nullable = false)
    private String activo;

    // Constructor vacío
    public TipoTecnologia() {
    }

    // Getters y Setters
    public Long getIdTipoTecnologia() { return idTipoTecnologia; }
    public void setIdTipoTecnologia(Long idTipoTecnologia) { this.idTipoTecnologia = idTipoTecnologia; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public LocalDateTime getFechaRegistra() { return fechaRegistra; }
    public void setFechaRegistra(LocalDateTime fechaRegistra) { this.fechaRegistra = fechaRegistra; }
    public LocalDateTime getFechaInactiva() { return fechaInactiva; }
    public void setFechaInactiva(LocalDateTime fechaInactiva) { this.fechaInactiva = fechaInactiva; }
    public String getActivo() { return activo; }
    public void setActivo(String activo) { this.activo = activo; }
}