package com.example.camara_backend.repository;

import com.example.camara_backend.models.TipoGrupoParametros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoGrupoParametrosRepository extends JpaRepository<TipoGrupoParametros, Long> {
}