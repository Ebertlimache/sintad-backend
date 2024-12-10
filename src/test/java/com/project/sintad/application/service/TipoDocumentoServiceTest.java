package com.project.sintad.application.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.project.sintad.infrastructure.exception.ResourceNotFoundException;
import com.project.sintad.domain.model.TipoDocumento;
import com.project.sintad.domain.repository.TipoDocumentoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class TipoDocumentoServiceTest {

    @Mock
    private TipoDocumentoRepository tipoDocumentoRepository;

    @InjectMocks
    private TipoDocumentoService tipoDocumentoService;

    public TipoDocumentoServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        List<TipoDocumento> tiposDocumento = new ArrayList<>();
        when(tipoDocumentoRepository.findAll()).thenReturn(tiposDocumento);

        List<TipoDocumento> result = tipoDocumentoService.findAll();

        assertEquals(tiposDocumento, result);
        verify(tipoDocumentoRepository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        int tipoDocumentoId = 1;
        TipoDocumento tipoDocumento = new TipoDocumento();
        when(tipoDocumentoRepository.findById(tipoDocumentoId)).thenReturn(Optional.of(tipoDocumento));

        TipoDocumento result = tipoDocumentoService.findById(tipoDocumentoId).orElse(null);

        assertEquals(tipoDocumento, result);
        verify(tipoDocumentoRepository, times(1)).findById(tipoDocumentoId);
    }

    @Test
    public void testFindById_EntityNotFound() {
        int tipoDocumentoId = 2;
        when(tipoDocumentoRepository.findById(tipoDocumentoId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> tipoDocumentoService.findById(tipoDocumentoId));
        verify(tipoDocumentoRepository, times(1)).findById(tipoDocumentoId);
    }

    @Test
    public void testCreateNewTipoDocumento() {
        TipoDocumento tipoDocumento = new TipoDocumento();
        when(tipoDocumentoRepository.save(tipoDocumento)).thenReturn(tipoDocumento);

        TipoDocumento result = tipoDocumentoService.createNewTipoDocumento(tipoDocumento);

        assertEquals(tipoDocumento, result);
        verify(tipoDocumentoRepository, times(1)).save(tipoDocumento);
    }

    @Test
    public void testUpdateTipoDocumento() {
        int tipoDocumentoId = 1;
        TipoDocumento tipoDocumento = new TipoDocumento();
        when(tipoDocumentoRepository.findById(tipoDocumentoId)).thenReturn(Optional.of(tipoDocumento));
        when(tipoDocumentoRepository.saveAndFlush(tipoDocumento)).thenReturn(tipoDocumento);

        TipoDocumento result = tipoDocumentoService.updateTipoDocumento(tipoDocumentoId, tipoDocumento);

        assertEquals(tipoDocumento, result);
        verify(tipoDocumentoRepository, times(1)).findById(tipoDocumentoId);
        verify(tipoDocumentoRepository, times(1)).saveAndFlush(tipoDocumento);
    }

    @Test
    public void testDeleteById_EntityNotFound() {
        int tipoDocumentoId = 9;
        when(tipoDocumentoRepository.findById(tipoDocumentoId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> tipoDocumentoService.deleteById(tipoDocumentoId));
        verify(tipoDocumentoRepository, times(1)).findById(tipoDocumentoId);
        verify(tipoDocumentoRepository, never()).deleteById(tipoDocumentoId);
    }
}
