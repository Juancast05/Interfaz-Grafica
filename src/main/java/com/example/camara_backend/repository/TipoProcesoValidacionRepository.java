package com.example.camara_backend.repository;

import com.example.camara_backend.models.TipoProcesoValidacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoProcesoValidacionRepository extends JpaRepository<TipoProcesoValidacion, Long> {
}