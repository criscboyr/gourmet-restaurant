package com.gourmet.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.List;

public class PreguntaDTO {

    private Integer id;
    private String enunciado;
    private TipoPreguntaDTO tipoPregunta;
    @JsonInclude(Include.NON_EMPTY)
    private List<OpcionDTO> opciones;
    @JsonInclude(Include.NON_NULL)
    private String comentarios;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public TipoPreguntaDTO getTipoPregunta() {
        return tipoPregunta;
    }

    public void setTipoPregunta(TipoPreguntaDTO tipoPregunta) {
        this.tipoPregunta = tipoPregunta;
    }

    public List<OpcionDTO> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<OpcionDTO> opciones) {
        this.opciones = opciones;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
}
