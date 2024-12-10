package com.project.sintad.controller;

import org.springframework.web.bind.annotation.RestController;

import com.project.sintad.domain.model.Entidad;
import com.project.sintad.application.service.EntidadService;

import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/entidad/")
public class EntidadController {

    @Autowired
    private EntidadService entidadService;

    @GetMapping
    public ResponseEntity<List<Entidad>> getAllEntidad() {
        List<Entidad> entidades = entidadService.findAll();
        return ResponseEntity.ok(entidades);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getEntidad(@PathVariable("id") int entidadId) {
        Optional<Entidad> entidad = entidadService.findById(entidadId);
        if (entidad.isPresent()) {
            return ResponseEntity.ok(entidad.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entidad not found");
        }
    }

    @PostMapping
    public ResponseEntity<?> createEntidad(@Valid @RequestBody Entidad nuevaEntidad, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return handleValidationErrors(bindingResult);
        }
        Entidad createdEntidad = entidadService.createNewEntidad(nuevaEntidad);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEntidad);
    }

    private ResponseEntity<Map<String, String>> handleValidationErrors(BindingResult bindingResult) {
        Map<String, String> errors = new HashMap<>();
        bindingResult.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Entidad entidad) {
        try {
            Entidad updatedEntidad = entidadService.updateEntidad(id, entidad);
            return ResponseEntity.ok(updatedEntidad);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating Entidad");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        try {
            entidadService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting Entidad");
        }
    }
}
