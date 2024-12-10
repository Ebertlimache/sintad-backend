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

import com.project.sintad.domain.model.TipoContribuyente;
import com.project.sintad.application.service.TipoContribuyenteService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/tipo-contribuyente/")
public class TipoContribuyenteController {

    @Autowired
    private TipoContribuyenteService tipoContribuyenteService;

    @GetMapping
    public ResponseEntity<List<TipoContribuyente>> getAllTipoContribuyente() {
        List<TipoContribuyente> contribuyentes = tipoContribuyenteService.findAll();
        return ResponseEntity.ok(contribuyentes);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getTipoContribuyente(@PathVariable("id") int tipoContribuyenteId) {
        Optional<TipoContribuyente> contribuyente = tipoContribuyenteService.findById(tipoContribuyenteId);
        if (contribuyente.isPresent()) {
            return ResponseEntity.ok(contribuyente.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("TipoContribuyente not found");
        }
    }

    @PostMapping
    public ResponseEntity<?> createTipoContribuyente(@Valid @RequestBody TipoContribuyente nuevoTipoContribuyente, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errors);
        }
        TipoContribuyente createdContribuyente = tipoContribuyenteService.createNewTipoContribuyente(nuevoTipoContribuyente);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdContribuyente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody TipoContribuyente entidad) {
        try {
            TipoContribuyente updatedContribuyente = tipoContribuyenteService.updateTipoContribuyente(id, entidad);
            return ResponseEntity.ok(updatedContribuyente);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating TipoContribuyente");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        try {
            tipoContribuyenteService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting TipoContribuyente");
        }
    }
}
