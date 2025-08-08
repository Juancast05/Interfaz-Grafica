package com.example.camara_backend.repository;

import com.example.camara_backend.models.TipoEvidenciaInfraccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoEvidenciaInfraccionRepository extends JpaRepository<TipoEvidenciaInfraccion, Long> {
}