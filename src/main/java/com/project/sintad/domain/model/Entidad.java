package com.project.sintad.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_entidad")
public class Entidad {

    public Entidad(){ }

    public Entidad(TipoDocumento tipoDocumento, TipoContribuyente tipoContribuyente, String nroDocumento,
            String razonSocial, String nombreComercial, String direccion, String telefono, Boolean estado) {

        this.tipoDocumento = tipoDocumento;
        this.tipoContribuyente = tipoContribuyente;
        this.direccion = direccion;
        this.nroDocumento = nroDocumento;
        this.nombreComercial = nombreComercial;
        this.telefono = telefono;
        this.estado = estado;
        this.razonSocial = razonSocial;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entidad")
    private Integer idEntidad;

    @ManyToOne
    @JoinColumn(name = "id_tipo_documento", referencedColumnName = "id_tipo_documento")
    @NotNull(message = "El tipo de documento no puede ser nulo")
    private TipoDocumento tipoDocumento;

    @ManyToOne
    @JoinColumn(name = "id_tipo_contribuyente", referencedColumnName = "id_tipo_contribuyente")
    @NotNull(message = "El tipo de contribuyente no puede ser nulo")
    private TipoContribuyente tipoContribuyente;

    @Column(name = "nro_documento", nullable = false)
    @NotBlank(message = "El número de documento no puede estar vacío")
    @Size(max = 20, message = "El número de documento no puede tener más de 20 caracteres")
    private String nroDocumento;

    @Column(name = "razon_social", nullable = false)
    @NotBlank(message = "La razón social no puede estar vacía")
    private String razonSocial;

    @Column(name = "nombre_comercial")
    private String nombreComercial;
    private String direccion;
    
    @Size(max = 50, message = "El teléfono no puede tener más de 50 caracteres")
    private String telefono;
    
    @NotNull(message = "El estado no puede ser nulo")
    private Boolean estado;

    public Integer getIdEntidad() {
        return idEntidad;
    }
    public void setIdEntidad(Integer idEntidad) {
        this.idEntidad = idEntidad;
    }
    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }
    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
    public TipoContribuyente getTipoContribuyente() {
        return tipoContribuyente;
    }
    public void setTipoContribuyente(TipoContribuyente tipoContribuyente) {
        this.tipoContribuyente = tipoContribuyente;
    }
    public String getNroDocumento() {
        return nroDocumento;
    }
    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }
    public String getRazonSocial() {
        return razonSocial;
    }
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
    public String getNombreComercial() {
        return nombreComercial;
    }
    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public Boolean getEstado() {
        return estado;
    }
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
