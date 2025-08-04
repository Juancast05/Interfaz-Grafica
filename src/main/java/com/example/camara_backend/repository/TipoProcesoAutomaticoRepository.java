package com.example.camara_backend.repository;

import com.example.camara_backend.models.TipoProcesoAutomatico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoProcesoAutomaticoRepository extends JpaRepository<TipoProcesoAutomatico, Long> {
}