package com.example.camara_backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_carril") // Nombre de la tabla en la BD
public class TipoCarril {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_carril") // Mapea el campo al nombre de la columna en la BD
    private Long idTipoCarril; // Usamos camelCase en Java

    @Column(name = "nombre_carril", nullable = false) // 'nullable = false' si es un campo requerido
    private String nombreCarril;

    @Column(name = "activo", length = 1, nullable = false) // 'S' o 'N', longitud 1
    private String activo;

    // Constructor vacío (necesario para JPA)
    public TipoCarril() {
    }

    // Constructor con campos (opcional, útil para pruebas)
    public TipoCarril(String nombreCarril, String activo) {
        this.nombreCarril = nombreCarril;
        this.activo = activo;
    }

    // --- Getters y Setters ---
    // (Puedes generarlos automáticamente en tu IDE o usando Lombok)

    public Long getIdTipoCarril() {
        return idTipoCarril;
    }

    public void setIdTipoCarril(Long idTipoCarril) {
        this.idTipoCarril = idTipoCarril;
    }

    public String getNombreCarril() {
        return nombreCarril;
    }

    public void setNombreCarril(String nombreCarril) {
        this.nombreCarril = nombreCarril;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "TipoCarril{" +
                "idTipoCarril=" + idTipoCarril +
                ", nombreCarril='" + nombreCarril + '\'' +
                ", activo='" + activo + '\'' +
                '}';
    }
}