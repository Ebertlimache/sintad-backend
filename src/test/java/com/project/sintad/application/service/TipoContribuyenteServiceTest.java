package com.project.sintad.application.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.project.sintad.infrastructure.exception.ResourceNotFoundException;
import com.project.sintad.domain.model.TipoContribuyente;
import com.project.sintad.domain.repository.TipoContribuyenteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class TipoContribuyenteServiceTest {

    @Mock
    private TipoContribuyenteRepository tipoContribuyenteRepository;

    @InjectMocks
    private TipoContribuyenteService tipoContribuyenteService;

    public TipoContribuyenteServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        List<TipoContribuyente> tiposContribuyente = new ArrayList<>();
        when(tipoContribuyenteRepository.findAll()).thenReturn(tiposContribuyente);

        List<TipoContribuyente> result = tipoContribuyenteService.findAll();

        assertEquals(tiposContribuyente, result);
        verify(tipoContribuyenteRepository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        int tipoContribuyenteId = 1;
        TipoContribuyente tipoContribuyente = new TipoContribuyente();
        when(tipoContribuyenteRepository.findById(tipoContribuyenteId)).thenReturn(Optional.of(tipoContribuyente));

        TipoContribuyente result = tipoContribuyenteService.findById(tipoContribuyenteId).orElse(null);

        assertEquals(tipoContribuyente, result);
        verify(tipoContribuyenteRepository, times(1)).findById(tipoContribuyenteId);
    }

    @Test
    public void testFindById_EntityNotFound() {
        int tipoContribuyenteId = 1;
        when(tipoContribuyenteRepository.findById(tipoContribuyenteId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> tipoContribuyenteService.findById(tipoContribuyenteId));
        verify(tipoContribuyenteRepository, times(1)).findById(tipoContribuyenteId);
    }

    @Test
    public void testCreateNewTipoContribuyente() {
        TipoContribuyente tipoContribuyente = new TipoContribuyente();
        when(tipoContribuyenteRepository.save(tipoContribuyente)).thenReturn(tipoContribuyente);

        TipoContribuyente result = tipoContribuyenteService.createNewTipoContribuyente(tipoContribuyente);

        assertEquals(tipoContribuyente, result);
        verify(tipoContribuyenteRepository, times(1)).save(tipoContribuyente);
    }

    @Test
    public void testUpdateTipoContribuyente() {
        int tipoContribuyenteId = 1;
        TipoContribuyente tipoContribuyente = new TipoContribuyente();
        when(tipoContribuyenteRepository.findById(tipoContribuyenteId)).thenReturn(Optional.of(tipoContribuyente));
        when(tipoContribuyenteRepository.saveAndFlush(tipoContribuyente)).thenReturn(tipoContribuyente);

        TipoContribuyente result = tipoContribuyenteService.updateTipoContribuyente(tipoContribuyenteId, tipoContribuyente);

        assertEquals(tipoContribuyente, result);
        verify(tipoContribuyenteRepository, times(1)).findById(tipoContribuyenteId);
        verify(tipoContribuyenteRepository, times(1)).saveAndFlush(tipoContribuyente);
    }

    @Test
    public void testDeleteById_EntityNotFound() {
        int tipoContribuyenteId = 1;
        when(tipoContribuyenteRepository.findById(tipoContribuyenteId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> tipoContribuyenteService.deleteById(tipoContribuyenteId));
        verify(tipoContribuyenteRepository, times(1)).findById(tipoContribuyenteId);
        verify(tipoContribuyenteRepository, never()).deleteById(tipoContribuyenteId);
    }
}
