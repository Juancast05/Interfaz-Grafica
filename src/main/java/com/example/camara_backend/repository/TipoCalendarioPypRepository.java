package com.example.camara_backend.repository;

import com.example.camara_backend.models.TipoCalendarioPyp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCalendarioPypRepository extends JpaRepository<TipoCalendarioPyp, Long> {
}