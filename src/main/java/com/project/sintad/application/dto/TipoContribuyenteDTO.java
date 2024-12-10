package com.project.sintad.application.dto;

public class TipoContribuyenteDTO {
    private Long idTipoContribuyente;
    private String nombre;
    private Boolean estado;
    
    public Long getIdTipoContribuyente() {
        return idTipoContribuyente;
    }
    public void setIdTipoContribuyente(Long idTipoContribuyente) {
        this.idTipoContribuyente = idTipoContribuyente;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Boolean getEstado() {
        return estado;
    }
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
