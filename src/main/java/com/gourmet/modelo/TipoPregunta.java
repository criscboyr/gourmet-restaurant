package com.gourmet.modelo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tipopregunta")
public class TipoPregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipoPregunta")
    private Integer idTipoPregunta;
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoPregunta")
    private List<Pregunta> preguntaList;

    public TipoPregunta() {
    }

    public TipoPregunta(Integer idTipoPregunta) {
        this.idTipoPregunta = idTipoPregunta;
    }

    public Integer getIdTipoPregunta() {
        return idTipoPregunta;
    }

    public void setIdTipoPregunta(Integer idTipoPregunta) {
        this.idTipoPregunta = idTipoPregunta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Pregunta> getPreguntaList() {
        return preguntaList;
    }

    public void setPreguntaList(List<Pregunta> preguntaList) {
        this.preguntaList = preguntaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoPregunta != null ? idTipoPregunta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPregunta)) {
            return false;
        }
        TipoPregunta other = (TipoPregunta) object;
        if ((this.idTipoPregunta == null && other.idTipoPregunta != null) || (this.idTipoPregunta != null && !this.idTipoPregunta.equals(other.idTipoPregunta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gourmet.model.Tipopregunta[ idTipoPregunta=" + idTipoPregunta + " ]";
    }

}