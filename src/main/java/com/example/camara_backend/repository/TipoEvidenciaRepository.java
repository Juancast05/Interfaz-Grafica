package com.example.camara_backend.repository;

import com.example.camara_backend.models.TipoEvidencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoEvidenciaRepository extends JpaRepository<TipoEvidencia, Long> {
}