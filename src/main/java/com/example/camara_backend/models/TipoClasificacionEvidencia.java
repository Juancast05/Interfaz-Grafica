package com.example.camara_backend.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tipo_clasificacion_evidencia")
public class TipoClasificacionEvidencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_clasificacion")
    private Long idClasificacion;

    @Column(name = "id_tipo_sistema")
    private Long idTipoSistema;

    @Column(name = "id_cliente_sistema")
    private Long idClienteSistema;

    @Column(name = "umbral_1")
    private Double umbral1;

    @Column(name = "umbral_2")
    private Double umbral2;

    @Column(name = "umbral_3")
    private Double umbral3;

    @Column(name = "umbral_4")
    private Double umbral4;

    @Column(name = "constante_dispositivo")
    private Double constanteDispositivo;

    @Column(name = "constante_sistema")
    private Double constanteSistema;

    @Column(name = "constante_qalpr")
    private Double constanteQalpr;

    @Column(name = "plate_score")
    private Double plateScore;

    @Column(name = "ocr_score")
    private Double ocrScore;

    @Column(name = "fecha_registra")
    private LocalDateTime fechaRegistra;

    @Column(name = "activo", length = 1, nullable = false)
    private String activo;

    @Column(name = "id_tipo_vehiculo")
    private Long idTipoVehiculo;

    // Constructor vacío (necesario para JPA)
    public TipoClasificacionEvidencia() {
    }

    // Constructor con campos (opcional)
    public TipoClasificacionEvidencia(Long idTipoSistema, Long idClienteSistema, Double umbral1, Double umbral2,
                                      Double umbral3, Double umbral4, Double constanteDispositivo, Double constanteSistema,
                                      Double constanteQalpr, Double plateScore, Double ocrScore,
                                      LocalDateTime fechaRegistra, String activo, Long idTipoVehiculo) {
        this.idTipoSistema = idTipoSistema;
        this.idClienteSistema = idClienteSistema;
        this.umbral1 = umbral1;
        this.umbral2 = umbral2;
        this.umbral3 = umbral3;
        this.umbral4 = umbral4;
        this.constanteDispositivo = constanteDispositivo;
        this.constanteSistema = constanteSistema;
        this.constanteQalpr = constanteQalpr;
        this.plateScore = plateScore;
        this.ocrScore = ocrScore;
        this.fechaRegistra = fechaRegistra;
        this.activo = activo;
        this.idTipoVehiculo = idTipoVehiculo;
    }

    // --- Getters y Setters ---
    public Long getIdClasificacion() { return idClasificacion; }
    public void setIdClasificacion(Long idClasificacion) { this.idClasificacion = idClasificacion; }
    public Long getIdTipoSistema() { return idTipoSistema; }
    public void setIdTipoSistema(Long idTipoSistema) { this.idTipoSistema = idTipoSistema; }
    public Long getIdClienteSistema() { return idClienteSistema; }
    public void setIdClienteSistema(Long idClienteSistema) { this.idClienteSistema = idClienteSistema; }
    public Double getUmbral1() { return umbral1; }
    public void setUmbral1(Double umbral1) { this.umbral1 = umbral1; }
    public Double getUmbral2() { return umbral2; }
    public void setUmbral2(Double umbral2) { this.umbral2 = umbral2; }
    public Double getUmbral3() { return umbral3; }
    public void setUmbral3(Double umbral3) { this.umbral3 = umbral3; }
    public Double getUmbral4() { return umbral4; }
    public void setUmbral4(Double umbral4) { this.umbral4 = umbral4; }
    public Double getConstanteDispositivo() { return constanteDispositivo; }
    public void setConstanteDispositivo(Double constanteDispositivo) { this.constanteDispositivo = constanteDispositivo; }
    public Double getConstanteSistema() { return constanteSistema; }
    public void setConstanteSistema(Double constanteSistema) { this.constanteSistema = constanteSistema; }
    public Double getConstanteQalpr() { return constanteQalpr; }
    public void setConstanteQalpr(Double constanteQalpr) { this.constanteQalpr = constanteQalpr; }
    public Double getPlateScore() { return plateScore; }
    public void setPlateScore(Double plateScore) { this.plateScore = plateScore; }
    public Double getOcrScore() { return ocrScore; }
    public void setOcrScore(Double ocrScore) { this.ocrScore = ocrScore; }
    public LocalDateTime getFechaRegistra() { return fechaRegistra; }
    public void setFechaRegistra(LocalDateTime fechaRegistra) { this.fechaRegistra = fechaRegistra; }
    public String getActivo() { return activo; }
    public void setActivo(String activo) { this.activo = activo; }
    public Long getIdTipoVehiculo() { return idTipoVehiculo; }
    public void setIdTipoVehiculo(Long idTipoVehiculo) { this.idTipoVehiculo = idTipoVehiculo; }

    @Override
    public String toString() {
        return "TipoClasificacionEvidencia{" +
                "idClasificacion=" + idClasificacion +
                ", idTipoSistema=" + idTipoSistema +
                ", idClienteSistema=" + idClienteSistema +
                ", umbral1=" + umbral1 +
                ", umbral2=" + umbral2 +
                ", umbral3=" + umbral3 +
                ", umbral4=" + umbral4 +
                ", constanteDispositivo=" + constanteDispositivo +
                ", constanteSistema=" + constanteSistema +
                ", constanteQalpr=" + constanteQalpr +
                ", plateScore=" + plateScore +
                ", ocrScore=" + ocrScore +
                ", fechaRegistra=" + fechaRegistra +
                ", activo='" + activo + '\'' +
                ", idTipoVehiculo=" + idTipoVehiculo +
                '}';
    }
}