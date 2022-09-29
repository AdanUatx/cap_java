package com.curso.cap.modulos.empleado.controlador;

import com.curso.cap.modelos.Empleado;
import com.curso.cap.modulos.empleado.dto.EmpleadoDTO;
import com.curso.cap.modulos.empleado.servicio.EmpleadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("empleado")
public class EmpleadoControlador {
    @Autowired
    private EmpleadoServicio empleadoServicio;


    @GetMapping("obtener")
    public ResponseEntity<List<EmpleadoDTO>> obtenerEmpleado(){
        List<EmpleadoDTO> lista = empleadoServicio.obtenerEmpleado();
        return new ResponseEntity<>( lista, HttpStatus.OK);
    }

    @GetMapping("obtener/")
    public ResponseEntity<EmpleadoDTO> obtenerEmpleadoById(@RequestParam Long idEmpleado){
        EmpleadoDTO respuesta = empleadoServicio.obtenerEmpleadoById(idEmpleado);
        return new ResponseEntity<>( respuesta, HttpStatus.OK);
    }

    @PostMapping("guardar")
    public ResponseEntity<Boolean> guardarEmpleado(@RequestBody EmpleadoDTO paramentros){
        boolean respuesta = empleadoServicio.guardarEmpleado(paramentros);
        return new ResponseEntity<>( respuesta, HttpStatus.OK);
    }

    @PutMapping ("update")
    public ResponseEntity<Boolean> updateEmpleado(@RequestBody EmpleadoDTO parametros){
        boolean respuesta = empleadoServicio.updateEmpleado(parametros);
        return new ResponseEntity<>( respuesta, HttpStatus.OK);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Boolean> deleteEmpleado(@RequestParam Long idEmpleado){
        boolean respuesta = empleadoServicio.deleteEmpleado(idEmpleado);
        return new ResponseEntity<>( respuesta, HttpStatus.OK);
    }

    @PutMapping ("eliminar")
    public ResponseEntity<String> eliminarEmpleado(@RequestBody EmpleadoDTO status){
        String respuesta = empleadoServicio.eliminarEmpleado(status);
        return new ResponseEntity<>( respuesta, HttpStatus.OK);
    }

    @PutMapping ("reincorporar")
    public ResponseEntity<String> reincorporarEmpleado(@RequestBody EmpleadoDTO status){
        String respuesta = empleadoServicio.reincorporarEmpleado(status);
        return new ResponseEntity<>( respuesta, HttpStatus.OK);
    }
}
//localhost:9000/empleado/obtener/