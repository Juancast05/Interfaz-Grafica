package com.example.camara_backend.repository;

import com.example.camara_backend.models.TipoTecnologia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoTecnologiaRepository extends JpaRepository<TipoTecnologia, Long> {
}