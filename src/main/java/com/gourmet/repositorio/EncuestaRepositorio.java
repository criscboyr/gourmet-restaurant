package com.gourmet.repositorio;

import com.gourmet.modelo.Encuesta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EncuestaRepositorio extends JpaRepository<Encuesta, Integer> {
}
