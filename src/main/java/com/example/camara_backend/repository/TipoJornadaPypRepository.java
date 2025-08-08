package com.example.camara_backend.repository;

import com.example.camara_backend.models.TipoJornadaPyp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoJornadaPypRepository extends JpaRepository<TipoJornadaPyp, Long> {
}