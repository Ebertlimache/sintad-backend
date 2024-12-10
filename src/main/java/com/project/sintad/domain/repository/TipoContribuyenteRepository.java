package com.project.sintad.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.sintad.domain.model.TipoContribuyente;

@Repository
public interface TipoContribuyenteRepository extends JpaRepository<TipoContribuyente, Integer>{
}
