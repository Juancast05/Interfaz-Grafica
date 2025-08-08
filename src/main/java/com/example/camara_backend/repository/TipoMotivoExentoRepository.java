package com.example.camara_backend.repository;

import com.example.camara_backend.models.TipoMotivoExento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoMotivoExentoRepository extends JpaRepository<TipoMotivoExento, Long> {
}