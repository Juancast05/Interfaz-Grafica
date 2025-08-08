package com.example.camara_backend.repository;

import com.example.camara_backend.models.TipoEstadoEvidencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoEstadoEvidenciaRepository extends JpaRepository<TipoEstadoEvidencia, Long> {
}