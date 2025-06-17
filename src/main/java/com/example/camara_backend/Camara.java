package com.example.camara_backend;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

import javax.print.DocFlavor;
import java.time.LocalDate;

@Entity
@Table(name = "info_camara")
public class Camara {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_info_camara;

    private Integer id_cliente_sistema;
    private Integer id_tipo_proveedor_camara;
    private Integer id_tipo_camara;
    private Integer id_tipo_tecnologia;

    private String index_code_proveedor;
    private String codigo_camara;
    private String codigo_equipo;
    private String direccion;
    private Integer maximocarril;

    private LocalDate fecha_calibracion;
    private String serial_camara;
    private String alias_camara;

    private LocalDate fecha_registra;
    private LocalDate fecha_modifica;
    private Integer id_usuario_registra;
    private Integer id_usuario_modifica;
    private Integer id_tipo_fuente_evidencia;
    private String latitud;
    private String longitud;
    private String activo;
    private String punto_Referencia_inicial;
    private String Punto_Referencia_final;
    private Integer metros_referencia;
    private Integer velocidad_maxima_camara;
    private Integer tolerancia_permitida;
    private String resolucion_camara;




    // Getters y Setters
    public Integer getId_info_camara() {
        return id_info_camara;
    }
    public void setId_info_camara(int id_info_camara) {
        this.id_info_camara = id_info_camara;

    }

    public Integer getId_cliente_sistema() {

        return id_cliente_sistema;
    }
    public void setId_cliente_sistema(int id_cliente_sistema) {

        this.id_cliente_sistema = id_cliente_sistema;
    }

    public Integer getId_tipo_proveedor_camara() {

        return id_tipo_proveedor_camara;
    }
    public void setId_tipo_proveedor_camara(int id_tipo_proveedor_camara) {
        this.id_tipo_proveedor_camara = id_tipo_proveedor_camara;
    }

    public Integer getId_tipo_camara() {
        return id_tipo_camara;
    }
    public void setId_tipo_camara(int id_tipo_camara) {
        this.id_tipo_camara = id_tipo_camara;
    }

    public Integer getId_tipo_tecnologia() {
        return id_tipo_tecnologia;
    }
    public void setId_tipo_tecnologia(int id_tipo_tecnologia) {
        this.id_tipo_tecnologia = id_tipo_tecnologia;
    }

    public String getIndex_code_proveedor() {
        return index_code_proveedor;
    }
    public void setIndex_code_proveedor(String index_code_proveedor) {
        this.index_code_proveedor = index_code_proveedor;
    }

    public String getCodigo_camara() {
        return codigo_camara;
    }

    public void setCodigo_camara(String codigo_camara) {
        this.codigo_camara = codigo_camara;
    }

    public String getCodigo_equipo() {
        return codigo_equipo;
    }
    public void setCodigo_equipo(String codigo_equipo) {
        this.codigo_equipo = codigo_equipo;
    }

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getMaximocarril() {
        return maximocarril;
    }
    public void setMaximocarril(Integer maximocarril) {
        this.maximocarril = maximocarril;
    }

    public LocalDate getFecha_calibracion() {
        return fecha_calibracion;
    }
    public void setFecha_calibracion(LocalDate fecha_calibracion) {
        this.fecha_calibracion = fecha_calibracion;
    }

    public String getSerial_camara() {
        return serial_camara;
    }
    public void setSerial_camara(String serial_camara) {
        this.serial_camara = serial_camara;
    }

    public String getAlias_camara() {
        return alias_camara;
    }
    public void setAlias_camara(String alias_camara) {
        this.alias_camara = alias_camara;
    }

    public LocalDate getFecha_registra() {
        return fecha_registra;
    }
    public void setFecha_registra(LocalDate fecha_registra) {
        this.fecha_registra = fecha_registra;
    }

    public LocalDate getFecha_modifica() {
        return fecha_modifica;
    }
    public void setFecha_modifica(LocalDate fecha_modifica) {
        this.fecha_modifica = fecha_modifica;
    }
    public Integer getId_usuario_registra(){
        return id_usuario_registra;
    }
    public void setId_usuario_registra(int id_usuario_registra) {
        this.id_usuario_registra = id_usuario_registra;
    }
    public Integer getId_usuario_modifica() {
        return id_usuario_modifica;
    }
    public void setId_usuario_modifica(int id_usuario_modifica) {
        this.id_usuario_modifica = id_usuario_modifica;
    }
    public Integer getId_tipo_fuente_evidencia() {
        return id_tipo_fuente_evidencia;
    }
    public void setId_tipo_fuente_evidencia(int id_tipo_fuente_evidencia) {
        this.id_tipo_fuente_evidencia = id_tipo_fuente_evidencia;
    }
    public String getLatitud() {
        return latitud;
    }
    public void setLatitudt(String latitud) {
        this.latitud = latitud;
    }
    public String getLongitud() {
        return longitud;
    }
    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
    public String getActivo() {
        return activo;
    }
    public void setActivo(String activo) {
        this.activo = activo;
    }
    public String getPunto_Referencia_inicial() {
        return punto_Referencia_inicial;
    }
    public void setPunto_Referencia_inicial(String punto_Referencia_inicial) {
        this.punto_Referencia_inicial = punto_Referencia_inicial;
    }
    public String getPunto_Referencia_final() {
        return Punto_Referencia_final;
    }
    public void setPunto_Referencia_final(String punto_Referencia_final) {
        this.Punto_Referencia_final = punto_Referencia_final;
    }
    public Integer getMetros_referencia() {
        return metros_referencia;
    }
    public void setMetros_referencia(int metrosReferencia) {
        this.metros_referencia = metrosReferencia;
    }
    public Integer getVelocidad_maxima_camara() {
        return velocidad_maxima_camara;
    }
    public void setVelocidad_maxima_camara(int velocidadMaximaCamara) {
        this.velocidad_maxima_camara = velocidadMaximaCamara;
    }
    public Integer getTolerancia_permitida () {
        return tolerancia_permitida;
    }
    public void setTolerancia_permitida (int toleranciaPermitida) {
        this.tolerancia_permitida = toleranciaPermitida;
    }
    public String getResolucion_camara() {
        return resolucion_camara;
    }
    public void setResolucion_camara(String resolucionCamara) {
        this.resolucion_camara = resolucionCamara;
    }

    @ManyToOne
    @JoinColumn(name = "id_cliente_sistema", insertable = false, updatable = false)
    private ClienteSistema clienteSistema;

}
