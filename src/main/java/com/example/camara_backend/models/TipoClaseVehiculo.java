package com.example.camara_backend.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tipo_clase_vehiculo")
public class TipoClaseVehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_clase_vehiculo")
    private Long idTipoClaseVehiculo;

    @Column(name = "id_cliente_sistema")
    private Long idClienteSistema;

    @Column(name = "codigo_clasificacion", nullable = false)
    private String codigoClasificacion;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "valor_homologado")
    private String valorHomologado;

    @Column(name = "fecha_registra")
    private LocalDateTime fechaRegistra;

    @Column(name = "fecha_inactiva")
    private LocalDateTime fechaInactiva;

    @Column(name = "activo", nullable = false)
    private String activo;

    // Constructor vacío (necesario para JPA)
    public TipoClaseVehiculo() {
    }

    // Getters y Setters
    public Long getIdTipoClaseVehiculo() {
        return idTipoClaseVehiculo;
    }

    public void setIdTipoClaseVehiculo(Long idTipoClaseVehiculo) {
        this.idTipoClaseVehiculo = idTipoClaseVehiculo;
    }

    public Long getIdClienteSistema() {
        return idClienteSistema;
    }

    public void setIdClienteSistema(Long idClienteSistema) {
        this.idClienteSistema = idClienteSistema;
    }

    public String getCodigoClasificacion() {
        return codigoClasificacion;
    }

    public void setCodigoClasificacion(String codigoClasificacion) {
        this.codigoClasificacion = codigoClasificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getValorHomologado() {
        return valorHomologado;
    }

    public void setValorHomologado(String valorHomologado) {
        this.valorHomologado = valorHomologado;
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