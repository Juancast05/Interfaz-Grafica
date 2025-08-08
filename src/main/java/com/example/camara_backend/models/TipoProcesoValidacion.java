package com.example.camara_backend.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tipo_proceso_validacion")
public class TipoProcesoValidacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_proceso_validacion")
    private Long idTipoProcesoValidacion;

    @Column(name = "id_cliente_sistema", nullable = false)
    private Long idClienteSistema;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "id_tipo_codigo_infraccion", nullable = false)
    private Long idTipoCodigoInfraccion;

    @Column(name = "maximo_reporte_detecciones")
    private Integer maximoReporteDetecciones;

    @Column(name = "dias_reporte_deteccion")
    private Integer diasReporteDeteccion;

    @Column(name = "dias_habiles_reporte_deteccion")
    private String diasHabilesReporteDeteccion;

    @Column(name = "dias_gestion_entrega")
    private Integer diasGestionEntrega;

    @Column(name = "dias_habiles_gestion_entrega")
    private String diasHabilesGestionEntrega;

    @Column(name = "minimo_imagenes_reporte")
    private Integer minimoImagenesReporte;

    @Column(name = "valida_exento")
    private Integer validaExento;

    @Column(name = "fecha_registra")
    private LocalDateTime fechaRegistra;

    @Column(name = "fecha_inactiva")
    private LocalDateTime fechaInactiva;

    @Column(name = "activo", nullable = false)
    private String activo;

    // Constructor vacío (necesario para JPA)
    public TipoProcesoValidacion() {
    }

    // Getters y Setters
    public Long getIdTipoProcesoValidacion() {
        return idTipoProcesoValidacion;
    }

    public void setIdTipoProcesoValidacion(Long idTipoProcesoValidacion) {
        this.idTipoProcesoValidacion = idTipoProcesoValidacion;
    }

    public Long getIdClienteSistema() {
        return idClienteSistema;
    }

    public void setIdClienteSistema(Long idClienteSistema) {
        this.idClienteSistema = idClienteSistema;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getIdTipoCodigoInfraccion() {
        return idTipoCodigoInfraccion;
    }

    public void setIdTipoCodigoInfraccion(Long idTipoCodigoInfraccion) {
        this.idTipoCodigoInfraccion = idTipoCodigoInfraccion;
    }

    public Integer getMaximoReporteDetecciones() {
        return maximoReporteDetecciones;
    }

    public void setMaximoReporteDetecciones(Integer maximoReporteDetecciones) {
        this.maximoReporteDetecciones = maximoReporteDetecciones;
    }

    public Integer getDiasReporteDeteccion() {
        return diasReporteDeteccion;
    }

    public void setDiasReporteDeteccion(Integer diasReporteDeteccion) {
        this.diasReporteDeteccion = diasReporteDeteccion;
    }

    public String getDiasHabilesReporteDeteccion() {
        return diasHabilesReporteDeteccion;
    }

    public void setDiasHabilesReporteDeteccion(String diasHabilesReporteDeteccion) {
        this.diasHabilesReporteDeteccion = diasHabilesReporteDeteccion;
    }

    public Integer getDiasGestionEntrega() {
        return diasGestionEntrega;
    }

    public void setDiasGestionEntrega(Integer diasGestionEntrega) {
        this.diasGestionEntrega = diasGestionEntrega;
    }

    public String getDiasHabilesGestionEntrega() {
        return diasHabilesGestionEntrega;
    }

    public void setDiasHabilesGestionEntrega(String diasHabilesGestionEntrega) {
        this.diasHabilesGestionEntrega = diasHabilesGestionEntrega;
    }

    public Integer getMinimoImagenesReporte() {
        return minimoImagenesReporte;
    }

    public void setMinimoImagenesReporte(Integer minimoImagenesReporte) {
        this.minimoImagenesReporte = minimoImagenesReporte;
    }

    public Integer getValidaExento() {
        return validaExento;
    }

    public void setValidaExento(Integer validaExento) {
        this.validaExento = validaExento;
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