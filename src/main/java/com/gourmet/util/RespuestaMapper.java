package com.gourmet.util;

import com.gourmet.dto.OpcionDTO;
import com.gourmet.dto.RespuestaDTO;
import com.gourmet.modelo.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RespuestaMapper {

    public static List<Respuesta> crearRespuesta(RespuestaDTO respuestaDTO) {
        List<Respuesta> respuestas = new ArrayList<>();
        respuestaDTO.getPreguntas().stream().forEach(pregunta ->
                respuestas.add(getRespuesta(pregunta.getId(), pregunta.getOpciones(), pregunta.getComentarios(), respuestaDTO.getIdCliente(), respuestaDTO.getIdEncuesta()))
        );

        return respuestas;
    }

    private static Respuesta getRespuesta(Integer idPregunta, List<OpcionDTO> opcionesDTO, String comentarios, Integer idCliente, Integer idEncuesta) {
        Respuesta respuesta = new Respuesta();
        respuesta.setIdPregunta(new Pregunta(idPregunta));
        if (Objects.nonNull(opcionesDTO)) {
            List<Opcion> opciones = new ArrayList<>();
            opcionesDTO.stream().forEach(opcion ->
                    opciones.add(new Opcion(opcion.getId()))
            );
            respuesta.setOpcionList(opciones);
        } else {
            respuesta.setComentarios(comentarios);
        }
        respuesta.setIdCliente(new Cliente(idCliente));
        respuesta.setIdEncuesta(new Encuesta(idEncuesta));
        return respuesta;
    }
}
