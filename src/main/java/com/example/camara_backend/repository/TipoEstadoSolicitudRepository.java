package com.example.camara_backend.repository;

import com.example.camara_backend.models.TipoEstadoSolicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoEstadoSolicitudRepository extends JpaRepository<TipoEstadoSolicitud, Long> {
}