package com.example.camara_backend.repository;

import com.example.camara_backend.models.TipoMotivoPyp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoMotivoPypRepository extends JpaRepository<TipoMotivoPyp, Long> {
}