package com.gourmet.modelo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pregunta")
public class Pregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPregunta")
    private Integer idPregunta;
    @Column(name = "enunciado")
    private String enunciado;
    @ManyToMany(mappedBy = "preguntaList")
    private List<Encuesta> encuestaList;
    @ManyToMany(mappedBy = "preguntaList")
    private List<Opcion> opcionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPregunta")
    private List<Respuesta> respuestaList;
    @JoinColumn(name = "idTipoPregunta", referencedColumnName = "idTipoPregunta", nullable = false)
    @ManyToOne
    private TipoPregunta idTipoPregunta;

    public Pregunta() {
    }

    public Pregunta(Integer idPregunta) {
        this.idPregunta = idPregunta;
    }

    public Integer getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(Integer idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public List<Encuesta> getEncuestaList() {
        return encuestaList;
    }

    public void setEncuestaList(List<Encuesta> encuestaList) {
        this.encuestaList = encuestaList;
    }

    public List<Opcion> getOpcionList() {
        return opcionList;
    }

    public void setOpcionList(List<Opcion> opcionList) {
        this.opcionList = opcionList;
    }

    public List<Respuesta> getRespuestaList() {
        return respuestaList;
    }

    public void setRespuestaList(List<Respuesta> respuestaList) {
        this.respuestaList = respuestaList;
    }

    public TipoPregunta getIdTipoPregunta() {
        return idTipoPregunta;
    }

    public void setIdTipoPregunta(TipoPregunta idTipoPregunta) {
        this.idTipoPregunta = idTipoPregunta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPregunta != null ? idPregunta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pregunta)) {
            return false;
        }
        Pregunta other = (Pregunta) object;
        if ((this.idPregunta == null && other.idPregunta != null) || (this.idPregunta != null && !this.idPregunta.equals(other.idPregunta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gourmet.model.Pregunta[ idPregunta=" + idPregunta + " ]";
    }

}

