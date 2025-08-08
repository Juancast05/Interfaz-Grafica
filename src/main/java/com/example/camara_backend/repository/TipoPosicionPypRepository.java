package com.example.camara_backend.repository;

import com.example.camara_backend.models.TipoPosicionPyp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPosicionPypRepository extends JpaRepository<TipoPosicionPyp, Long> {
}