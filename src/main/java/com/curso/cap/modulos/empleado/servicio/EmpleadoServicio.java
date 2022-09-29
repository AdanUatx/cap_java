package com.curso.cap.modulos.empleado.servicio;

import com.curso.cap.modelos.Empleado;
import com.curso.cap.modulos.empleado.dto.EmpleadoDTO;
import com.curso.cap.repositorios.EmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmpleadoServicio {

    @Autowired
    private EmpleadoRepositorio empleadoRepositorio;
    public List<EmpleadoDTO> obtenerEmpleado(){
        List<Empleado> lista = empleadoRepositorio.findAll();
        List<EmpleadoDTO> resultadoFinal = lista.stream().filter(e-> e.getRegistro_activo()==true).map(e -> {return new EmpleadoDTO(e.getId_empleado(), e.getNombre() , e.getApellido(), e.getFecha_nacimiento(), e.getRegistro_activo() );}).collect(Collectors.toList());
        return resultadoFinal;
    }

    public EmpleadoDTO obtenerEmpleadoById(Long idEmpleado){
        Optional<Empleado> empleado = empleadoRepositorio.findById(idEmpleado);
        if (empleado.isPresent()){
            return new EmpleadoDTO(empleado.get().getId_empleado(), empleado.get().getNombre(), empleado.get().getApellido(), empleado.get().getFecha_nacimiento(), empleado.get().getRegistro_activo());
        }
        return null;
    }

    public boolean guardarEmpleado(EmpleadoDTO parametros){
        Empleado empleado = new Empleado();

        empleado.setNombre(parametros.getEmpleado());
        empleado.setApellido(parametros.getApellido());
        empleado.setFecha_nacimiento(parametros.getFecha_nacimiento());

        empleadoRepositorio.save(empleado);
        return true;
    }

    public boolean updateEmpleado(EmpleadoDTO parametros){

        Empleado empleado = empleadoRepositorio.getOne(parametros.getEmpleadoID());
        empleado.setNombre(parametros.getEmpleado());
        empleado.setApellido(parametros.getApellido());
        empleado.setFecha_nacimiento(parametros.getFecha_nacimiento());

        empleadoRepositorio.save(empleado);
        return true;
    }

    public boolean deleteEmpleado(Long idEmpleado){
        Empleado empleado = empleadoRepositorio.getOne(idEmpleado);
        empleadoRepositorio.delete(empleado);
        return true;
    }

    public String eliminarEmpleado(EmpleadoDTO status) {
        Empleado empleado = empleadoRepositorio.getOne(status.getEmpleadoID());
        empleado.setRegistro_activo(status.getRegistro_activo());
        empleadoRepositorio.save(empleado);
        return "Eliminado con Exito";
    }

    public String reincorporarEmpleado(EmpleadoDTO status) {
        Empleado empleado = empleadoRepositorio.getOne(status.getEmpleadoID());
        empleado.setRegistro_activo(status.getRegistro_activo());
        empleadoRepositorio.save(empleado);
        return "Empleado reincorporado con Exito";
    }
}
