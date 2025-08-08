package com.example.camara_backend.repository;

import com.example.camara_backend.models.TipoServicioPlataforma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoServicioPlataformaRepository extends JpaRepository<TipoServicioPlataforma, Long> {
}