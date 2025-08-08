package com.example.camara_backend.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tipo_posicion_pyp")
public class TipoPosicionPyp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_posicion")
    private Long idTipoPosicion;

    @Column(name = "id_cliente_sistema", nullable = false)
    private Long idClienteSistema;

    @Column(name = "id_tipo_formato_placa", nullable = false)
    private Long idTipoFormatoPlaca;

    @Column(name = "posicion_pyp", nullable = false)
    private String posicionPyp;

    @Column(name = "fecha_registra")
    private LocalDateTime fechaRegistra;

    @Column(name = "fecha_inactiva")
    private LocalDateTime fechaInactiva;

    @Column(name = "activo", nullable = false)
    private String activo;

    // Constructor vacío (necesario para JPA)
    public TipoPosicionPyp() {
    }

    // Getters y Setters
    public Long getIdTipoPosicion() {
        return idTipoPosicion;
    }

    public void setIdTipoPosicion(Long idTipoPosicion) {
        this.idTipoPosicion = idTipoPosicion;
    }

    public Long getIdClienteSistema() {
        return idClienteSistema;
    }

    public void setIdClienteSistema(Long idClienteSistema) {
        this.idClienteSistema = idClienteSistema;
    }

    public Long getIdTipoFormatoPlaca() {
        return idTipoFormatoPlaca;
    }

    public void setIdTipoFormatoPlaca(Long idTipoFormatoPlaca) {
        this.idTipoFormatoPlaca = idTipoFormatoPlaca;
    }

    public String getPosicionPyp() {
        return posicionPyp;
    }

    public void setPosicionPyp(String posicionPyp) {
        this.posicionPyp = posicionPyp;
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