package com.project.sintad.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.sintad.domain.model.TipoDocumento;
import com.project.sintad.application.service.TipoDocumentoService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/tipo-documento/")
public class TipoDocumentoController {

    @Autowired
    private TipoDocumentoService tipoDocumentoService;

    @GetMapping
    public ResponseEntity<List<TipoDocumento>> getAllTipoDocumento() {
        List<TipoDocumento> documentos = tipoDocumentoService.findAll();
        return ResponseEntity.ok(documentos);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<?> getTipoDocumento(@PathVariable("id") int tipoDocumentoId) {
        Optional<TipoDocumento> documento = tipoDocumentoService.findById(tipoDocumentoId);
        if (documento.isPresent()) {
            return ResponseEntity.ok(documento);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("TipoDocumento not found");
        }
    }

    @PostMapping
    public ResponseEntity<?> createTipoDocumento(@Valid @RequestBody TipoDocumento nuevoTipoDocumento, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errors);
        }
        TipoDocumento createdDocumento = tipoDocumentoService.createNewTipoDocumento(nuevoTipoDocumento);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDocumento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody TipoDocumento entidad) {
        try {
            TipoDocumento updatedDocumento = tipoDocumentoService.updateTipoDocumento(id, entidad);
            return ResponseEntity.ok(updatedDocumento);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating TipoDocumento");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        try {
            tipoDocumentoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting TipoDocumento");
        }
    }
}
