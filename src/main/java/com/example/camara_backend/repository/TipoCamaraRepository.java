package com.example.camara_backend.repository;

import com.example.camara_backend.models.TipoCamara;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCamaraRepository extends JpaRepository<TipoCamara, Long> {

}