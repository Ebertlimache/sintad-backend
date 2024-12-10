package com.project.sintad.application.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import com.project.sintad.domain.repository.EntidadRepository;
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
import com.project.sintad.domain.model.TipoContribuyente;
import com.project.sintad.domain.repository.TipoContribuyenteRepository;

@Service
public class TipoContribuyenteService implements TipoContribuyenteRepository{
    private static final Logger logger = LoggerFactory.getLogger(TipoContribuyenteService.class);

    @Autowired
    private EntidadRepository entidadRepository;

    @Autowired
    private TipoContribuyenteRepository tipoContribuyenteRepository;

    @Override
    public List<TipoContribuyente> findAll() {
        return tipoContribuyenteRepository.findAll();
    }

    @Override
    public Optional<TipoContribuyente> findById(Integer id) {
        Optional<TipoContribuyente> tipoContribuyente = tipoContribuyenteRepository.findById(id);
        if(tipoContribuyente.isEmpty()){ 
            throw new ResourceNotFoundException("No se ha encontrado el recurso con el ID: " + id );
        }
        return tipoContribuyente;
    }

    @Transactional
    public TipoContribuyente createNewTipoContribuyente(TipoContribuyente tipoContribuyente){
        return tipoContribuyenteRepository.save(tipoContribuyente);
    }

    @Transactional
    public TipoContribuyente updateTipoContribuyente(int id, TipoContribuyente tipoContribuyente){
        findById(id);
        tipoContribuyente.setIdTipoContribuyente(id);
        return tipoContribuyenteRepository.saveAndFlush(tipoContribuyente);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        Optional<TipoContribuyente> tipoContribuyenteOpt = findById(id);
        if (tipoContribuyenteOpt.isEmpty()) {
            logger.error("TipoContribuyente with ID: {} not found", id);
            throw new ResourceNotFoundException("No se ha encontrado el recurso con el ID: " + id);
        }
        
        TipoContribuyente tipoContribuyente = tipoContribuyenteOpt.get();
        entidadRepository.deleteByTipoContribuyente(tipoContribuyente);
        
        tipoContribuyenteRepository.deleteById(id);
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
    public void deleteAllInBatch(Iterable<TipoContribuyente> entities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAllInBatch'");
    }

    @Override
    public <S extends TipoContribuyente> List<S> findAll(Example<S> example) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public <S extends TipoContribuyente> List<S> findAll(Example<S> example, Sort sort) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public void flush() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'flush'");
    }

    @Override
    public TipoContribuyente getById(Integer arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public TipoContribuyente getOne(Integer arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOne'");
    }

    @Override
    public TipoContribuyente getReferenceById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getReferenceById'");
    }

    @Override
    public <S extends TipoContribuyente> List<S> saveAllAndFlush(Iterable<S> entities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveAllAndFlush'");
    }

    @Override
    public <S extends TipoContribuyente> S saveAndFlush(S entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveAndFlush'");
    }

    @Override
    public List<TipoContribuyente> findAllById(Iterable<Integer> ids) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllById'");
    }

    @Override
    public <S extends TipoContribuyente> List<S> saveAll(Iterable<S> entities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveAll'");
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    @Override
    public void delete(TipoContribuyente entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
    }

    @Override
    public void deleteAll(Iterable<? extends TipoContribuyente> entities) {
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
    public <S extends TipoContribuyente> S save(S entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public List<TipoContribuyente> findAll(Sort sort) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Page<TipoContribuyente> findAll(Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public <S extends TipoContribuyente> long count(Example<S> example) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    @Override
    public <S extends TipoContribuyente> boolean exists(Example<S> example) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exists'");
    }

    @Override
    public <S extends TipoContribuyente> Page<S> findAll(Example<S> example, Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public <S extends TipoContribuyente, R> R findBy(Example<S> example,
            Function<FetchableFluentQuery<S>, R> queryFunction) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findBy'");
    }

    @Override
    public <S extends TipoContribuyente> Optional<S> findOne(Example<S> example) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findOne'");
    }



}
