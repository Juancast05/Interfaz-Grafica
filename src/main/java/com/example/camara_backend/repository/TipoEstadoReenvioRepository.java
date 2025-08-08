package com.example.camara_backend.repository;

import com.example.camara_backend.models.TipoEstadoReenvio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoEstadoReenvioRepository extends JpaRepository<TipoEstadoReenvio, Long> {
}