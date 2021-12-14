package com.gourmet.repositorio;

import com.gourmet.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {

    Cliente findByCorreoElectronico(String correoElectronico);

    @Modifying
    @Query(value = "INSERT INTO clienteencuesta VALUES(:idCliente, :idEncuesta)", nativeQuery = true)
    @Transactional
    void guardarClientePorEncuesta(@Param("idCliente") Integer idCliente, @Param("idEncuesta") Integer idEncuesta);
}
