package com.example.camara_backend.repository;

import com.example.camara_backend.models.TipoProveedorCamara;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoProveedorCamaraRepository extends JpaRepository<TipoProveedorCamara, Long> {
}