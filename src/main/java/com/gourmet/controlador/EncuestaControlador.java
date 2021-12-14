package com.gourmet.controlador;

import com.gourmet.dto.EncuestaDTO;
import com.gourmet.dto.RespuestaDTO;
import com.gourmet.servicio.EncuestaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/encuestas")
public class EncuestaControlador {

    @Autowired
    private EncuestaServicio encuestaServicio;

    @GetMapping("/{id}")
    public ResponseEntity<EncuestaDTO> listarEncuestaPorId(@PathVariable("id") Integer id) {
        EncuestaDTO encuesta = encuestaServicio.listarEncuestaPorId(id);
        return new ResponseEntity<EncuestaDTO>(encuesta, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrarEncuesta(@Valid @RequestBody RespuestaDTO respuestaDTO) {
        RespuestaDTO respuesta = encuestaServicio.guardarRespuesta(respuestaDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idEncuesta}").buildAndExpand(respuesta.getIdEncuesta()).toUri();
        return ResponseEntity.created(location).build();
    }
}
