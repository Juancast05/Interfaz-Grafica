package com.example.camara_backend.repository;

import com.example.camara_backend.models.TipoCaracterPuntaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCaracterPuntajeRepository extends JpaRepository<TipoCaracterPuntaje, Long> {
}