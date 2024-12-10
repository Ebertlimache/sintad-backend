package com.project.sintad.application.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import com.project.sintad.domain.model.TipoContribuyente;
import com.project.sintad.domain.model.TipoDocumento;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.sintad.infrastructure.exception.ResourceNotFoundException;
import com.project.sintad.domain.model.Entidad;
import com.project.sintad.domain.repository.EntidadRepository;

@Service
public class EntidadService implements EntidadRepository{

    private static final Logger logger = LoggerFactory.getLogger(EntidadService.class);

    @Autowired
    private EntidadRepository entidadRepository;

    @Override
    public List<Entidad> findAll() {
        return entidadRepository.findAll();
    }

    @Override
    public Optional<Entidad> findById(Integer id) {
        Optional<Entidad> entidad = entidadRepository.findById(id);
        if(entidad.isEmpty()){ 
            throw new ResourceNotFoundException("No se ha encontrado el recurso con el ID: " + id );
        }
        return entidad;
    }

    @Transactional
    public Entidad createNewEntidad(Entidad entidad){
        return entidadRepository.save(entidad);
    }

    @Transactional
    public Entidad updateEntidad(int id, Entidad entidad){
        findById(id);
        entidad.setIdEntidad(id);
        return entidadRepository.saveAndFlush(entidad);
    }

    @Transactional
    public void deleteByTipoContribuyente(TipoContribuyente tipoContribuyente) {
        logger.info("Attempting to delete entities with TipoContribuyente: {}", tipoContribuyente);
        try {
            entidadRepository.deleteByTipoContribuyente(tipoContribuyente);
            logger.info("Successfully deleted entities with TipoContribuyente: {}", tipoContribuyente);
        } catch (Exception e) {
            logger.error("Error occurred while deleting entities with TipoContribuyente: {}", tipoContribuyente, e);
            throw e; // Re-throw the exception after logging
        }
    }

    @Transactional
    public void deleteByTipoDocumento(TipoDocumento tipoDocumento){
        logger.info("Attempting to delete entities with TipoDocumento: {}", tipoDocumento);
        try {
            entidadRepository.deleteByTipoDocumento(tipoDocumento);
            logger.info("Successfully deleted entities with TipoDocumento: {}", tipoDocumento);
        } catch (Exception e) {
            logger.error("Error occurred while deleting entities with TipoDocumento: {}", tipoDocumento, e);
            throw e; // Re-throw the exception after logging
        }
    }

    @Override
    public void deleteById(Integer id) {
        findById(id);
        entidadRepository.deleteById(id);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> ids) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAllByIdInBatch'");
    }

    @Override
    public void deleteAllInBatch() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAllInBatch'");
    }

    @Override
    public void deleteAllInBatch(Iterable<Entidad> entities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAllInBatch'");
    }

    @Override
    public <S extends Entidad> List<S> findAll(Example<S> example) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public <S extends Entidad> List<S> findAll(Example<S> example, Sort sort) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public void flush() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'flush'");
    }

    @Override
    public Entidad getById(Integer arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public Entidad getOne(Integer arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOne'");
    }

    @Override
    public Entidad getReferenceById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getReferenceById'");
    }

    @Override
    public <S extends Entidad> List<S> saveAllAndFlush(Iterable<S> entities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveAllAndFlush'");
    }

    @Override
    public <S extends Entidad> S saveAndFlush(S entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveAndFlush'");
    }

    @Override
    public List<Entidad> findAllById(Iterable<Integer> ids) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllById'");
    }

    @Override
    public <S extends Entidad> List<S> saveAll(Iterable<S> entities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveAll'");
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    @Override
    public void delete(Entidad entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
    }

    @Override
    public void deleteAll(Iterable<? extends Entidad> entities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> ids) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAllById'");
    }

    @Override
    public boolean existsById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsById'");
    }

    @Override
    public <S extends Entidad> S save(S entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public List<Entidad> findAll(Sort sort) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Page<Entidad> findAll(Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public <S extends Entidad> long count(Example<S> example) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    @Override
    public <S extends Entidad> boolean exists(Example<S> example) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exists'");
    }

    @Override
    public <S extends Entidad> Page<S> findAll(Example<S> example, Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public <S extends Entidad, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findBy'");
    }

    @Override
    public <S extends Entidad> Optional<S> findOne(Example<S> example) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findOne'");
    }
}