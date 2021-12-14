package com.gourmet.servicio;

import com.google.common.base.Preconditions;
import com.gourmet.dto.EncuestaDTO;
import com.gourmet.dto.RespuestaDTO;
import com.gourmet.exception.BadRequestException;
import com.gourmet.exception.ModelNotFoundException;
import com.gourmet.modelo.Cliente;
import com.gourmet.modelo.Encuesta;
import com.gourmet.modelo.Respuesta;
import com.gourmet.repositorio.ClienteRepositorio;
import com.gourmet.repositorio.EncuestaRepositorio;
import com.gourmet.repositorio.RespuestaRepositorio;
import com.gourmet.util.EncuestaMapper;
import com.gourmet.util.RespuestaMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EncuestaServicio {

    @Autowired
    private EncuestaRepositorio encuestaRepositorio;

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Autowired
    private RespuestaRepositorio respuestaRepositorio;

    private static final String NULL_CORREO_ELECTRONICO = "Se debe enviar un correo electronico";
    private static final String NULL_ID_ENCUESTA = "Se debe enviar el id encuesta";
    private static final String NULL_PREGUNTA = "Se debe enviar las respuestas de las preguntas";

    public EncuestaDTO listarEncuestaPorId(Integer id) {
        Optional<Encuesta> optionalEncuesta = getEncuestaById(id);
        Encuesta encuesta = optionalEncuesta.get();
        return EncuestaMapper.crearDTO(encuesta);
    }

    public RespuestaDTO guardarRespuesta(RespuestaDTO respuestaDTO) {
        revisarArgumentosDTO(respuestaDTO);
        Cliente cliente = getClienteByCorreoElectronico(respuestaDTO.getCorreoElectronico());
        respuestaDTO.setIdCliente(cliente.getIdCliente());
        List<Respuesta> respuestas = RespuestaMapper.crearRespuesta(respuestaDTO);
        respuestas.stream().forEach(respuesta ->
                guardarRespuesta(respuesta));
        guardarClientePorEncuesta(respuestaDTO.getIdCliente(), respuestaDTO.getIdEncuesta());
        return respuestaDTO;
    }

    private Optional<Encuesta> getEncuestaById(Integer encuestaId) {
        Optional<Encuesta> encuesta = encuestaRepositorio.findById(encuestaId);
        if (!encuesta.isPresent()) {
            throw new ModelNotFoundException(String.format("No se encontro la encuesta con el id: %s", encuestaId));
        }
        return encuesta;
    }

    private Cliente getClienteByCorreoElectronico(String correoElectronico) {
        Cliente cliente = clienteRepositorio.findByCorreoElectronico(correoElectronico);
        if (Objects.isNull(cliente)) {
            throw new ModelNotFoundException(String.format("No se encontro al cliente con el correo electrónico : %s", correoElectronico));
        }
        return cliente;
    }

    private void revisarArgumentosDTO(RespuestaDTO respuestaDTO) {
        try {
            Preconditions.checkArgument(StringUtils.isNotBlank(respuestaDTO.getCorreoElectronico()), NULL_CORREO_ELECTRONICO);
            Preconditions.checkArgument(Objects.nonNull(respuestaDTO.getIdEncuesta()), NULL_ID_ENCUESTA);
            Preconditions.checkArgument(Objects.nonNull(respuestaDTO.getPreguntas()), NULL_PREGUNTA);
        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        }
        Preconditions.checkArgument(getEncuestaById(respuestaDTO.getIdEncuesta()).isPresent());
    }

    private void guardarClientePorEncuesta(Integer idCliente, Integer idEncuesta) {
        clienteRepositorio.guardarClientePorEncuesta(idCliente, idEncuesta);
    }

    private void guardarRespuesta(Respuesta respuesta) {
        respuestaRepositorio.save(respuesta);
        if (Objects.nonNull(respuesta.getOpcionList())) {
            respuesta.getOpcionList().stream().forEach(
                    opcion ->
                            respuestaRepositorio.guardarOpcionesPorRespuesta(
                                    respuesta.getIdRespuesta(), opcion.getIdOpcion()));
        }
    }
}
