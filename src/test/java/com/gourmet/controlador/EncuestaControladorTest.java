package com.gourmet.controlador;

import com.gourmet.dto.EncuestaDTO;
import com.gourmet.dto.RespuestaDTO;
import com.gourmet.servicio.EncuestaServicio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EncuestaControladorTest {

    @InjectMocks
    private EncuestaControlador encuestaControlador;
    @Mock
    private EncuestaServicio encuestaServicio;
    private static final Integer ID_ENCUESTA = 1;

    @Test
    void listarEncuestaPorId() {
        EncuestaDTO encuestaDTO = new EncuestaDTO();
        encuestaDTO.setId(ID_ENCUESTA);

        when(encuestaServicio.listarEncuestaPorId(ID_ENCUESTA)).thenReturn(encuestaDTO);

        ResponseEntity<EncuestaDTO> result = encuestaControlador.listarEncuestaPorId(ID_ENCUESTA);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result.getBody());
        assertEquals(ID_ENCUESTA, result.getBody().getId());
    }

    @Test
    void registrarEncuesta() {
        RespuestaDTO respuestaDTO = new RespuestaDTO();
        respuestaDTO.setIdEncuesta(1);

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        when(encuestaServicio.guardarRespuesta(respuestaDTO)).thenReturn(respuestaDTO);

        ResponseEntity<Object> result = encuestaControlador.registrarEncuesta(respuestaDTO);
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertNotNull(result.getHeaders().get("Location"));
        assertEquals("http://localhost/1", result.getHeaders().get("Location").get(0));
    }
}
