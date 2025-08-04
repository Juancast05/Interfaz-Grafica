package com.example.camara_backend.repository;

import com.example.camara_backend.models.TipoClaseInfraccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoClaseInfraccionRepository extends JpaRepository<TipoClaseInfraccion, Long> {
    // JpaRepository<[Clase de la Entidad], [Tipo de la Clave Primaria]>
}