package com.example.camara_backend.repository;

import com.example.camara_backend.models.TipoProcesoValidaSistema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoProcesoValidaSistemaRepository extends JpaRepository<TipoProcesoValidaSistema, Long> {
}