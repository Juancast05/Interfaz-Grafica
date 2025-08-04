package com.example.camara_backend.repository;

import com.example.camara_backend.models.TipoCarril;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCarrilRepository extends JpaRepository<TipoCarril, Long> {
    // JpaRepository<[Clase de la Entidad], [Tipo de la Clave Primaria]>
}