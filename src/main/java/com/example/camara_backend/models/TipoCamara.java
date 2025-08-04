package com.example.camara_backend.models;

import jakarta.persistence.*; // Usamos jakarta.persistence para Spring Boot 3+
import java.time.LocalDateTime;

@Entity // Marca esta clase como una entidad JPA
@Table(name = "tipo_camara") // Especifica el nombre de la tabla en la base de datos
public class TipoCamara {

    @Id // Marca el campo como clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que el ID es auto-generado por la base de datos
    @Column(name = "id_tipo_camara") // Mapea el campo al nombre de la columna en la BD
    private Long idTipoCamara; // Usamos camelCase en Java

    @Column(name = "nombre", nullable = false) // 'nullable = false' si es un campo requerido
    private String nombre;

    @Column(name = "fecha_registra") // Puede ser nulo, si no se especifica 'nullable = false'
    private LocalDateTime fechaRegistra;

    @Column(name = "fecha_inactiva") // Puede ser nulo
    private LocalDateTime fechaInactiva;

    @Column(name = "activo", length = 1, nullable = false) // 'S' o 'N', longitud 1
    private String activo; // Usamos String 'S'/'N' según tu ejemplo

    public TipoCamara() {
    }

    public TipoCamara(String nombre, LocalDateTime fechaRegistra, LocalDateTime fechaInactiva, String activo) {
        this.nombre = nombre;
        this.fechaRegistra = fechaRegistra;
        this.fechaInactiva = fechaInactiva;
        this.activo = activo;
    }

    // --- Getters y Setters ---

    public Long getIdTipoCamara() {
        return idTipoCamara;
    }

    public void setIdTipoCamara(Long idTipoCamara) {
        this.idTipoCamara = idTipoCamara;
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

    @Override
    public String toString() {
        return "TipoCamara{" +
                "idTipoCamara=" + idTipoCamara +
                ", nombre='" + nombre + '\'' +
                ", fechaRegistra=" + fechaRegistra +
                ", fechaInactiva=" + fechaInactiva +
                ", activo='" + activo + '\'' +
                '}';
    }
}