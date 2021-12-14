package com.gourmet.modelo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "encuesta")
public class Encuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEncuesta")
    private Integer idEncuesta;
    @Column(name = "titulo")
    private String titulo;
    @JoinTable(name = "encuestapregunta", joinColumns = {
            @JoinColumn(name = "idEncuesta", referencedColumnName = "idEncuesta")}, inverseJoinColumns = {
            @JoinColumn(name = "idPregunta", referencedColumnName = "idPregunta")})
    @ManyToMany
    private List<Pregunta> preguntaList;
    @ManyToMany(mappedBy = "encuestaList")
    private List<Cliente> clienteList;

    public Encuesta() {
    }

    public Encuesta(Integer idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

    public Integer getIdEncuesta() {
        return idEncuesta;
    }

    public void setIdEncuesta(Integer idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Pregunta> getPreguntaList() {
        return preguntaList;
    }

    public void setPreguntaList(List<Pregunta> preguntaList) {
        this.preguntaList = preguntaList;
    }

    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEncuesta != null ? idEncuesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Encuesta)) {
            return false;
        }
        Encuesta other = (Encuesta) object;
        if ((this.idEncuesta == null && other.idEncuesta != null) || (this.idEncuesta != null && !this.idEncuesta.equals(other.idEncuesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gourmet.model.Encuesta[ idEncuesta=" + idEncuesta + " ]";
    }

}