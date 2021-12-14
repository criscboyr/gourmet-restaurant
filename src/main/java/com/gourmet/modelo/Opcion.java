package com.gourmet.modelo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "opcion")
public class Opcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idOpcion")
    private Integer idOpcion;
    @Column(name = "descripcion")
    private String descripcion;
    @JoinTable(name = "respuestaopcion", joinColumns = {
            @JoinColumn(name = "idOpcion", referencedColumnName = "idOpcion")}, inverseJoinColumns = {
            @JoinColumn(name = "idRespuesta", referencedColumnName = "idRespuesta")})
    @ManyToMany
    private List<Respuesta> respuestaList;
    @JoinTable(name = "preguntaopcion", joinColumns = {
            @JoinColumn(name = "idOpcion", referencedColumnName = "idOpcion")}, inverseJoinColumns = {
            @JoinColumn(name = "idPregunta", referencedColumnName = "idPregunta")})
    @ManyToMany
    private List<Pregunta> preguntaList;

    public Opcion() {
    }

    public Opcion(Integer idOpcion) {
        this.idOpcion = idOpcion;
    }

    public Integer getIdOpcion() {
        return idOpcion;
    }

    public void setIdOpcion(Integer idOpcion) {
        this.idOpcion = idOpcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Respuesta> getRespuestaList() {
        return respuestaList;
    }

    public void setRespuestaList(List<Respuesta> respuestaList) {
        this.respuestaList = respuestaList;
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
        hash += (idOpcion != null ? idOpcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Opcion)) {
            return false;
        }
        Opcion other = (Opcion) object;
        if ((this.idOpcion == null && other.idOpcion != null) || (this.idOpcion != null && !this.idOpcion.equals(other.idOpcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gourmet.model.Opcion[ idOpcion=" + idOpcion + " ]";
    }
}
