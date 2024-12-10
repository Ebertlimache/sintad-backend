package com.project.sintad.domain.repository;

import com.project.sintad.domain.model.TipoContribuyente;
import com.project.sintad.domain.model.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.sintad.domain.model.Entidad;

@Repository
public interface EntidadRepository extends JpaRepository<Entidad, Integer>{
    void deleteByTipoContribuyente(TipoContribuyente tipoContribuyente);
    void deleteByTipoDocumento(TipoDocumento tipoDocumento);
}
