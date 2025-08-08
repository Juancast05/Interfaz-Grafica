package com.example.camara_backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_servicio_plataforma")
public class TipoServicioPlataforma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio_plataforma")
    private Long idServicioPlataforma;

    @Column(name = "nombre_servicio_plataforma", nullable = false)
    private String nombreServicioPlataforma;

    @Column(name = "id_tipo_sistema", nullable = false)
    private Long idTipoSistema;

    @Column(name = "externo", nullable = false)
    private String externo;

    // Constructor vacío (necesario para JPA)
    public TipoServicioPlataforma() {
    }

    // Getters y Setters
    public Long getIdServicioPlataforma() {
        return idServicioPlataforma;
    }

    public void setIdServicioPlataforma(Long idServicioPlataforma) {
        this.idServicioPlataforma = idServicioPlataforma;
    }

    public String getNombreServicioPlataforma() {
        return nombreServicioPlataforma;
    }

    public void setNombreServicioPlataforma(String nombreServicioPlataforma) {
        this.nombreServicioPlataforma = nombreServicioPlataforma;
    }

    public Long getIdTipoSistema() {
        return idTipoSistema;
    }

    public void setIdTipoSistema(Long idTipoSistema) {
        this.idTipoSistema = idTipoSistema;
    }

    public String getExterno() {
        return externo;
    }

    public void setExterno(String externo) {
        this.externo = externo;
    }
}