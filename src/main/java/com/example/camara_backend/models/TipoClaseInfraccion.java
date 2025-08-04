package com.example.camara_backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_clase_infraccion") // Nombre de la tabla en la BD
public class TipoClaseInfraccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_clase_infraccion") // Mapea el campo al nombre de la columna en la BD
    private Long idTipoClaseInfraccion; // Usamos camelCase en Java

    @Column(name = "nombre_clase_infraccion", nullable = false) // 'nullable = false' si es un campo requerido
    private String nombreClaseInfraccion;

    @Column(name = "activo", length = 1, nullable = false) // 'S' o 'N', longitud 1
    private String activo;

    // Constructor vacío (necesario para JPA)
    public TipoClaseInfraccion() {
    }

    // Constructor con campos (opcional, útil para pruebas)
    public TipoClaseInfraccion(String nombreClaseInfraccion, String activo) {
        this.nombreClaseInfraccion = nombreClaseInfraccion;
        this.activo = activo;
    }

    // --- Getters y Setters ---
    // (Puedes generarlos automáticamente en tu IDE o usando Lombok)

    public Long getIdTipoClaseInfraccion() {
        return idTipoClaseInfraccion;
    }

    public void setIdTipoClaseInfraccion(Long idTipoClaseInfraccion) {
        this.idTipoClaseInfraccion = idTipoClaseInfraccion;
    }

    public String getNombreClaseInfraccion() {
        return nombreClaseInfraccion;
    }

    public void setNombreClaseInfraccion(String nombreClaseInfraccion) {
        this.nombreClaseInfraccion = nombreClaseInfraccion;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "TipoClaseInfraccion{" +
                "idTipoClaseInfraccion=" + idTipoClaseInfraccion +
                ", nombreClaseInfraccion='" + nombreClaseInfraccion + '\'' +
                ", activo='" + activo + '\'' +
                '}';
    }
}