package com.example.camara_backend.repository;

import com.example.camara_backend.models.TipoCodigoInfraccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCodigoInfraccionRepository extends JpaRepository<TipoCodigoInfraccion, Long> {
}