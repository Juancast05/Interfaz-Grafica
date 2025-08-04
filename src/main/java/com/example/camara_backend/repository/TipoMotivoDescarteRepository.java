package com.example.camara_backend.repository;

import com.example.camara_backend.models.TipoMotivoDescarte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoMotivoDescarteRepository extends JpaRepository<TipoMotivoDescarte, Long> {
}