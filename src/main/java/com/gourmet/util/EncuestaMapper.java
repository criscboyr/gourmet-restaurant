package com.gourmet.util;

import com.gourmet.dto.EncuestaDTO;
import com.gourmet.dto.OpcionDTO;
import com.gourmet.dto.PreguntaDTO;
import com.gourmet.dto.TipoPreguntaDTO;
import com.gourmet.modelo.Encuesta;
import com.gourmet.modelo.Opcion;
import com.gourmet.modelo.Pregunta;

import java.util.ArrayList;
import java.util.List;

public class EncuestaMapper {

    public static EncuestaDTO crearDTO(Encuesta encuesta) {
        EncuestaDTO encuestaDTO = new EncuestaDTO();
        encuestaDTO.setId(encuesta.getIdEncuesta());
        encuestaDTO.setTitulo(encuesta.getTitulo());
        encuestaDTO.setPreguntas(getPreguntas(encuesta.getPreguntaList()));
        return encuestaDTO;
    }

    private static List<PreguntaDTO> getPreguntas(List<Pregunta> preguntaList) {
        List<PreguntaDTO> preguntas = new ArrayList<>();
        preguntaList.stream().forEach(pregunta -> {
            preguntas.add(getPregunta(pregunta));
        });
        return preguntas;
    }

    private static PreguntaDTO getPregunta(Pregunta pregunta) {
        PreguntaDTO preguntaDTO = new PreguntaDTO();
        preguntaDTO.setId(pregunta.getIdPregunta());
        preguntaDTO.setEnunciado(pregunta.getEnunciado());
        preguntaDTO.setTipoPregunta(new TipoPreguntaDTO(pregunta.getIdTipoPregunta().getIdTipoPregunta(), pregunta.getIdTipoPregunta().getDescripcion()));
        preguntaDTO.setOpciones(getOpciones(pregunta.getOpcionList()));
        return preguntaDTO;
    }

    private static List<OpcionDTO> getOpciones(List<Opcion> opcionList) {
        List<OpcionDTO> opciones = new ArrayList<>();
        opcionList.stream().forEach(opcion -> {
            opciones.add(getOpcion(opcion));
        });
        return opciones;
    }

    private static OpcionDTO getOpcion(Opcion opcion) {
        return new OpcionDTO(opcion.getIdOpcion(), opcion.getDescripcion());
    }

}
