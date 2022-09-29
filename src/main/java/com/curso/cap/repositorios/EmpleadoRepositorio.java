package com.curso.cap.repositorios;

import com.curso.cap.modelos.Empleado;
import com.curso.cap.modulos.empleado.dto.EmpleadoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepositorio extends JpaRepository<Empleado, Long> {
    @Query("select e from Empleado e")
    List<Empleado> findAll();

}
