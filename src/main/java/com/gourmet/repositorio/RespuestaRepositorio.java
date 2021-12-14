package com.gourmet.repositorio;

import com.gourmet.modelo.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface RespuestaRepositorio extends JpaRepository<Respuesta, Integer> {

    @Modifying
    @Query(value = "INSERT INTO respuestaopcion VALUES(:idRespuesta, :idOpcion)", nativeQuery = true)
    @Transactional
    void guardarOpcionesPorRespuesta(@Param("idRespuesta") Integer idRespuesta, @Param("idOpcion") Integer idOpcion);
}
