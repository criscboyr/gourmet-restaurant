package com.gourmet.servicio;

import com.gourmet.dto.EncuestaDTO;
import com.gourmet.dto.PreguntaDTO;
import com.gourmet.dto.RespuestaDTO;
import com.gourmet.exception.BadRequestException;
import com.gourmet.exception.ModelNotFoundException;
import com.gourmet.modelo.Cliente;
import com.gourmet.modelo.Encuesta;
import com.gourmet.repositorio.ClienteRepositorio;
import com.gourmet.repositorio.EncuestaRepositorio;
import com.gourmet.repositorio.RespuestaRepositorio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EncuestaServicioTest {

    @InjectMocks
    private EncuestaServicio encuestaServicio;
    @Mock
    private EncuestaRepositorio encuestaRepositorio;
    @Mock
    private ClienteRepositorio clienteRepositorio;
    @Mock
    private RespuestaRepositorio respuestaRepositorio;
    private static final Integer ID_ENCUESTA = 1;

    @Test
    void listarEncuestaPorId_successfully() {
        Encuesta encuesta = new Encuesta(ID_ENCUESTA);
        encuesta.setPreguntaList(new ArrayList<>());
        Optional<Encuesta> optionalEncuesta = Optional.of(encuesta);

        when(encuestaRepositorio.findById(ID_ENCUESTA)).thenReturn(optionalEncuesta);

        EncuestaDTO result = encuestaServicio.listarEncuestaPorId(ID_ENCUESTA);
        assertNotNull(result);
        assertEquals(ID_ENCUESTA, result.getId());
    }

    @Test
    void listarEncuestaPorId_whenEncuestaNotFound_ThenThrowsAnException() {
        ModelNotFoundException exception = assertThrows(ModelNotFoundException.class, () -> encuestaServicio.listarEncuestaPorId(ID_ENCUESTA));
        assertTrue(exception.getMessage().contains("No se encontro la encuesta"));
    }

    @Test
    void guardarRespuesta_successfully() {
        Encuesta encuesta = new Encuesta(ID_ENCUESTA);
        Optional<Encuesta> optionalEncuesta = Optional.of(encuesta);
        RespuestaDTO respuestaDTO = new RespuestaDTO();
        respuestaDTO.setCorreoElectronico("test@gmail.com");
        PreguntaDTO preguntaDTO = new PreguntaDTO();
        preguntaDTO.setId(1);
        preguntaDTO.setComentarios("Test");
        respuestaDTO.setPreguntas(Arrays.asList(preguntaDTO));
        respuestaDTO.setIdEncuesta(ID_ENCUESTA);

        when(encuestaRepositorio.findById(ID_ENCUESTA)).thenReturn(optionalEncuesta);
        when(clienteRepositorio.findByCorreoElectronico(respuestaDTO.getCorreoElectronico())).thenReturn(new Cliente());

        RespuestaDTO result = encuestaServicio.guardarRespuesta(respuestaDTO);
        assertNotNull(result);
        assertEquals(ID_ENCUESTA, result.getIdEncuesta());
    }

    @Test
    void guardarRespuesta_whenEncuestaNotSent_ThenThrowsAnException() {

        RespuestaDTO respuestaDTO = new RespuestaDTO();
        respuestaDTO.setCorreoElectronico("test@gmail.com");
        PreguntaDTO preguntaDTO = new PreguntaDTO();
        preguntaDTO.setId(1);
        preguntaDTO.setComentarios("Test");
        respuestaDTO.setPreguntas(Arrays.asList(preguntaDTO));

        BadRequestException exception = assertThrows(BadRequestException.class, () -> encuestaServicio.guardarRespuesta(respuestaDTO));
        assertTrue(exception.getMessage().contains("Se debe enviar el id encuesta"));
    }

}
