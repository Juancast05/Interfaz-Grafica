package com.example.camara_backend.repository;

import com.example.camara_backend.models.TipoClasificacionEvidencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoClasificacionEvidenciaRepository extends JpaRepository<TipoClasificacionEvidencia, Long> {
}