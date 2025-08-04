package com.example.camara_backend.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tipo_caracter_puntaje") // Nombre de la tabla en la BD
public class TipoCaracterPuntaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_caracter_puntaje")
    private Long idTipoCaracterPuntaje; // CamelCase

    @Column(name = "id_tipo_sistema")
    private Long idTipoSistema;

    @Column(name = "id_cliente_sistema")
    private Long idClienteSistema;

    @Column(name = "caracter", nullable = false)
    private String caracter;

    @Column(name = "coeficiente_dispositivo")
    private Double coeficienteDispositivo; // Asumiendo Double

    @Column(name = "eficiencia_dispositivo")
    private Double eficienciaDispositivo; // Asumiendo Double

    @Column(name = "coeficiente_sistema")
    private Double coeficienteSistema; // Asumiendo Double

    @Column(name = "eficiencia_sistema")
    private Double eficienciaSistema; // Asumiendo Double

    @Column(name = "coeficiente_qalpr")
    private Double coeficienteQalpr; // Asumiendo Double

    @Column(name = "eficiencia_qalpr")
    private Double eficienciaQalpr; // Asumiendo Double

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro; // Tipo de dato para fecha_registro

    @Column(name = "activo", length = 1, nullable = false)
    private String activo; // 'S' o 'N'

    @Column(name = "id_tipo_vehiculo")
    private Long idTipoVehiculo;

    @Column(name = "version_score")
    private String versionScore; // Asumiendo String, puedes cambiar a Double si es numérico

    // Constructor vacío (necesario para JPA)
    public TipoCaracterPuntaje() {}

    // Constructor con todos los campos (opcional, útil para pruebas)
    public TipoCaracterPuntaje(Long idTipoSistema, Long idClienteSistema, String caracter, Double coeficienteDispositivo,
                               Double eficienciaDispositivo, Double coeficienteSistema, Double eficienciaSistema,
                               Double coeficienteQalpr, Double eficienciaQalpr, LocalDateTime fechaRegistro,
                               String activo, Long idTipoVehiculo, String versionScore) {
        this.idTipoSistema = idTipoSistema;
        this.idClienteSistema = idClienteSistema;
        this.caracter = caracter;
        this.coeficienteDispositivo = coeficienteDispositivo;
        this.eficienciaDispositivo = eficienciaDispositivo;
        this.coeficienteSistema = coeficienteSistema;
        this.eficienciaSistema = eficienciaSistema;
        this.coeficienteQalpr = coeficienteQalpr;
        this.eficienciaQalpr = eficienciaQalpr;
        this.fechaRegistro = fechaRegistro;
        this.activo = activo;
        this.idTipoVehiculo = idTipoVehiculo;
        this.versionScore = versionScore;
    }

    // --- Getters y Setters ---
    // (Puedes generarlos con tu IDE o usar Lombok)

    public Long getIdTipoCaracterPuntaje() { return idTipoCaracterPuntaje; }
    public void setIdTipoCaracterPuntaje(Long idTipoCaracterPuntaje) { this.idTipoCaracterPuntaje = idTipoCaracterPuntaje; }
    public Long getIdTipoSistema() { return idTipoSistema; }
    public void setIdTipoSistema(Long idTipoSistema) { this.idTipoSistema = idTipoSistema; }
    public Long getIdClienteSistema() { return idClienteSistema; }
    public void setIdClienteSistema(Long idClienteSistema) { this.idClienteSistema = idClienteSistema; }
    public String getCaracter() { return caracter; }
    public void setCaracter(String caracter) { this.caracter = caracter; }
    public Double getCoeficienteDispositivo() { return coeficienteDispositivo; }
    public void setCoeficienteDispositivo(Double coeficienteDispositivo) { this.coeficienteDispositivo = coeficienteDispositivo; }
    public Double getEficienciaDispositivo() { return eficienciaDispositivo; }
    public void setEficienciaDispositivo(Double eficienciaDispositivo) { this.eficienciaDispositivo = eficienciaDispositivo; }
    public Double getCoeficienteSistema() { return coeficienteSistema; }
    public void setCoeficienteSistema(Double coeficienteSistema) { this.coeficienteSistema = coeficienteSistema; }
    public Double getEficienciaSistema() { return eficienciaSistema; }
    public void setEficienciaSistema(Double eficienciaSistema) { this.eficienciaSistema = eficienciaSistema; }
    public Double getCoeficienteQalpr() { return coeficienteQalpr; }
    public void setCoeficienteQalpr(Double coeficienteQalpr) { this.coeficienteQalpr = coeficienteQalpr; }
    public Double getEficienciaQalpr() { return eficienciaQalpr; }
    public void setEficienciaQalpr(Double eficienciaQalpr) { this.eficienciaQalpr = eficienciaQalpr; }
    public LocalDateTime getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDateTime fechaRegistro) { this.fechaRegistro = fechaRegistro; }
    public String getActivo() { return activo; }
    public void setActivo(String activo) { this.activo = activo; }
    public Long getIdTipoVehiculo() { return idTipoVehiculo; }
    public void setIdTipoVehiculo(Long idTipoVehiculo) { this.idTipoVehiculo = idTipoVehiculo; }
    public String getVersionScore() { return versionScore; }
    public void setVersionScore(String versionScore) { this.versionScore = versionScore; }

    @Override
    public String toString() {
        return "TipoCaracterPuntaje{" +
                "idTipoCaracterPuntaje=" + idTipoCaracterPuntaje +
                ", idTipoSistema=" + idTipoSistema +
                ", idClienteSistema=" + idClienteSistema +
                ", caracter='" + caracter + '\'' +
                ", coeficienteDispositivo=" + coeficienteDispositivo +
                ", eficienciaDispositivo=" + eficienciaDispositivo +
                ", coeficienteSistema=" + coeficienteSistema +
                ", eficienciaSistema=" + eficienciaSistema +
                ", coeficienteQalpr=" + coeficienteQalpr +
                ", eficienciaQalpr=" + eficienciaQalpr +
                ", fechaRegistro=" + fechaRegistro +
                ", activo='" + activo + '\'' +
                ", idTipoVehiculo=" + idTipoVehiculo +
                ", versionScore='" + versionScore + '\'' +
                '}';
    }
}