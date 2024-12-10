package com.project.sintad.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_tipo_documento")
public class TipoDocumento {
    
    public TipoDocumento() { }

    public TipoDocumento(String codigo, String nombre, String descripcion, Boolean estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_documento")
    private Integer idTipoDocumento;

    @NotBlank(message = "El código del Tipo Documento no puede estar vacío")
    @Size(max = 20, message = "El código del Tipo Documento no puede tener más de 20 caracteres")
    private String codigo;
    
    @NotBlank(message = "El nombre del Tipo Documento no puede estar vacío")
    @Size(max = 100, message = "El nombre del Tipo Documento no puede tener más de 100 caracteres")
    private String nombre;
    
    @Size(max = 200, message = "La descripción del Tipo Documento no puede tener más de 200 caracteres")
    private String descripcion;

    @NotNull(message = "El estado no puede ser nulo")
    private Boolean estado;

    public Boolean getEstado() {
        return estado;
    }
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    public Integer getIdTipoDocumento() {
        return idTipoDocumento;
    }
    public void setIdTipoDocumento(Integer idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
