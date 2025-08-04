package com.example.camara_backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_proceso_valida_sistema")
public class TipoProcesoValidaSistema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_proceso_valida_sistema")
    private Long idTipoProcesoValidaSistema;

    @Column(name = "id_tipo_codigo_infraccion")
    private Long idTipoCodigoInfraccion;

    @Column(name = "id_tipo_sistema_aplica")
    private Long idTipoSistemaAplica;

    @Column(name = "id_tipo_sistema_consumo")
    private Long idTipoSistemaConsumo;

    @Column(name = "valido")
    private String valido;

    // Constructor vacío (necesario para JPA)
    public TipoProcesoValidaSistema() {
    }

    // Constructor con campos (opcional)
    public TipoProcesoValidaSistema(Long idTipoCodigoInfraccion, Long idTipoSistemaAplica, Long idTipoSistemaConsumo, String valido) {
        this.idTipoCodigoInfraccion = idTipoCodigoInfraccion;
        this.idTipoSistemaAplica = idTipoSistemaAplica;
        this.idTipoSistemaConsumo = idTipoSistemaConsumo;
        this.valido = valido;
    }

    // --- Getters y Setters ---
    public Long getIdTipoProcesoValidaSistema() { return idTipoProcesoValidaSistema; }
    public void setIdTipoProcesoValidaSistema(Long idTipoProcesoValidaSistema) { this.idTipoProcesoValidaSistema = idTipoProcesoValidaSistema; }
    public Long getIdTipoCodigoInfraccion() { return idTipoCodigoInfraccion; }
    public void setIdTipoCodigoInfraccion(Long idTipoCodigoInfraccion) { this.idTipoCodigoInfraccion = idTipoCodigoInfraccion; }
    public Long getIdTipoSistemaAplica() { return idTipoSistemaAplica; }
    public void setIdTipoSistemaAplica(Long idTipoSistemaAplica) { this.idTipoSistemaAplica = idTipoSistemaAplica; }
    public Long getIdTipoSistemaConsumo() { return idTipoSistemaConsumo; }
    public void setIdTipoSistemaConsumo(Long idTipoSistemaConsumo) { this.idTipoSistemaConsumo = idTipoSistemaConsumo; }
    public String getValido() { return valido; }
    public void setValido(String valido) { this.valido = valido; }
}