package com.project.sintad.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_tipo_contribuyente")
public class TipoContribuyente {
    
    public TipoContribuyente() { }

    public TipoContribuyente(String nombre, Boolean estado) {
        this.nombre = nombre;
        this.estado = estado;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_contribuyente")
    private Integer idTipoContribuyente;
    
    @NotBlank(message = "El nombre del Tipo Contribuyente no puede estar vacío")
    @Size(max = 50, message = "El nombre del Tipo Contribuyente no puede tener más de 50 caracteres")
    private String nombre;

    @NotNull(message = "El estado no puede ser nulo")
    private Boolean estado;

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getIdTipoContribuyente() {
        return idTipoContribuyente;
    }
    public void setIdTipoContribuyente(Integer idTipoContribuyente) {
        this.idTipoContribuyente = idTipoContribuyente;
    }
    public Boolean getEstado() {
        return estado;
    }
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    
}
