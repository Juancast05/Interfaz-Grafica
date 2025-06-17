package com.example.camara_backend;
import jakarta.persistence.*;

@Entity
@Table(name = "cliente_sistema")
public class ClienteSistema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cliente_sistema;

    private String nombre;
    private String ruta_base;
    private String ruta_destino;
    private String url_registro_detenccion;
    private Integer nodos;
    private String aplica_sabado;
    private String codigo_externo;
    private String activo;

    public ClienteSistema() {
    }
    public Integer getId_cliente_sistema() {
        return id_cliente_sistema;
    }
    public void setId_cliente_sistema(Integer id_cliente_sistema) {
        this.id_cliente_sistema = id_cliente_sistema;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getRuta_base() {
        return ruta_base;
    }
    public void setRuta_base(String ruta_base) {
        this.ruta_base = ruta_base;
    }
    public String getRuta_destino() {
        return ruta_destino;
    }
    public void setRuta_destino(String ruta_destino) {
        this.ruta_destino = ruta_destino;
    }
    public String getUrl_registro_detenccion() {
        return url_registro_detenccion;
    }
    public void setUrl_registro_detenccion(String url_registro_detenccion) {
        this.url_registro_detenccion = url_registro_detenccion;
    }
    public Integer getNodos() {
        return nodos;
    }
    public void setNodos(Integer nodos) {
        this.nodos = nodos;
    }
    public String getAplica_sabado() {
        return aplica_sabado;
    }
    public void setAplica_sabado(String aplica_sabado) {
        this.aplica_sabado = aplica_sabado;
    }
    public String getCodigo_externo() {
        return codigo_externo;
    }
    public void setCodigo_externo(String codigo_externo) {
        this.codigo_externo = codigo_externo;
    }
    public String getActivo() {
        return activo;
    }
    public void setActivo(String activo) {
        this.activo = activo;
    }

}
