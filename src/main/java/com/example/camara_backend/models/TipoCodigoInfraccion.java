package com.example.camara_backend.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tipo_codigo_infraccion")
public class TipoCodigoInfraccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_codigo_infraccion")
    private Long idTipoCodigoInfraccion;

    @Column(name = "id_cliente_sistema")
    private Long idClienteSistema;

    @Column(name = "codigo_infraccion", nullable = false)
    private String codigoInfraccion;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_registra")
    private LocalDateTime fechaRegistra;

    @Column(name = "fecha_inactiva")
    private LocalDateTime fechaInactiva;

    @Column(name = "activo", length = 1, nullable = false)
    private String activo;

    @Column(name = "id_tipo_clase_infraccion")
    private Long idTipoClaseInfraccion; // Representa la relación con tipo_clase_infraccion

    // Constructor vacío (necesario para JPA)
    public TipoCodigoInfraccion() {
    }

    // Constructor con campos (opcional)
    public TipoCodigoInfraccion(Long idClienteSistema, String codigoInfraccion, String descripcion,
                                LocalDateTime fechaRegistra, LocalDateTime fechaInactiva, String activo,
                                Long idTipoClaseInfraccion) {
        this.idClienteSistema = idClienteSistema;
        this.codigoInfraccion = codigoInfraccion;
        this.descripcion = descripcion;
        this.fechaRegistra = fechaRegistra;
        this.fechaInactiva = fechaInactiva;
        this.activo = activo;
        this.idTipoClaseInfraccion = idTipoClaseInfraccion;
    }

    // --- Getters y Setters ---
    public Long getIdTipoCodigoInfraccion() { return idTipoCodigoInfraccion; }
    public void setIdTipoCodigoInfraccion(Long idTipoCodigoInfraccion) { this.idTipoCodigoInfraccion = idTipoCodigoInfraccion; }
    public Long getIdClienteSistema() { return idClienteSistema; }
    public void setIdClienteSistema(Long idClienteSistema) { this.idClienteSistema = idClienteSistema; }
    public String getCodigoInfraccion() { return codigoInfraccion; }
    public void setCodigoInfraccion(String codigoInfraccion) { this.codigoInfraccion = codigoInfraccion; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public LocalDateTime getFechaRegistra() { return fechaRegistra; }
    public void setFechaRegistra(LocalDateTime fechaRegistra) { this.fechaRegistra = fechaRegistra; }
    public LocalDateTime getFechaInactiva() { return fechaInactiva; }
    public void setFechaInactiva(LocalDateTime fechaInactiva) { this.fechaInactiva = fechaInactiva; }
    public String getActivo() { return activo; }
    public void setActivo(String activo) { this.activo = activo; }
    public Long getIdTipoClaseInfraccion() { return idTipoClaseInfraccion; }
    public void setIdTipoClaseInfraccion(Long idTipoClaseInfraccion) { this.idTipoClaseInfraccion = idTipoClaseInfraccion; }

    @Override
    public String toString() {
        return "TipoCodigoInfraccion{" +
                "idTipoCodigoInfraccion=" + idTipoCodigoInfraccion +
                ", idClienteSistema=" + idClienteSistema +
                ", codigoInfraccion='" + codigoInfraccion + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaRegistra=" + fechaRegistra +
                ", fechaInactiva=" + fechaInactiva +
                ", activo='" + activo + '\'' +
                ", idTipoClaseInfraccion=" + idTipoClaseInfraccion +
                '}';
    }
}