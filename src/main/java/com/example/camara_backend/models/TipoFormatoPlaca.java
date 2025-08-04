package com.example.camara_backend.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tipo_formato_placa")
public class TipoFormatoPlaca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_formato_placa")
    private Long idTipoFormatoPlaca;

    @Column(name = "formato", nullable = false)
    private String formato;

    @Column(name = "descripcion_formato")
    private String descripcionFormato;

    @Column(name = "fecha_registra")
    private LocalDateTime fechaRegistra;

    @Column(name = "fecha_inactiva")
    private LocalDateTime fechaInactiva;

    @Column(name = "activo", length = 1, nullable = false)
    private String activo;

    // Constructor vacío (necesario para JPA)
    public TipoFormatoPlaca() {
    }

    // Constructor con campos (opcional)
    public TipoFormatoPlaca(String formato, String descripcionFormato,
                            LocalDateTime fechaRegistra, LocalDateTime fechaInactiva, String activo) {
        this.formato = formato;
        this.descripcionFormato = descripcionFormato;
        this.fechaRegistra = fechaRegistra;
        this.fechaInactiva = fechaInactiva;
        this.activo = activo;
    }

    // --- Getters y Setters ---
    public Long getIdTipoFormatoPlaca() { return idTipoFormatoPlaca; }
    public void setIdTipoFormatoPlaca(Long idTipoFormatoPlaca) { this.idTipoFormatoPlaca = idTipoFormatoPlaca; }
    public String getFormato() { return formato; }
    public void setFormato(String formato) { this.formato = formato; }
    public String getDescripcionFormato() { return descripcionFormato; }
    public void setDescripcionFormato(String descripcionFormato) { this.descripcionFormato = descripcionFormato; }
    public LocalDateTime getFechaRegistra() { return fechaRegistra; }
    public void setFechaRegistra(LocalDateTime fechaRegistra) { this.fechaRegistra = fechaRegistra; }
    public LocalDateTime getFechaInactiva() { return fechaInactiva; }
    public void setFechaInactiva(LocalDateTime fechaInactiva) { this.fechaInactiva = fechaInactiva; }
    public String getActivo() { return activo; }
    public void setActivo(String activo) { this.activo = activo; }
}