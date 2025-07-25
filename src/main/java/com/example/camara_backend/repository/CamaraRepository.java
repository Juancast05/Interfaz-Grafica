package com.example.camara_backend.repository;

import com.example.camara_backend.models.Camara;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CamaraRepository extends JpaRepository<Camara, Long> {
    // Aquí puedes agregar métodos personalizados si los necesitas más adelante
}
