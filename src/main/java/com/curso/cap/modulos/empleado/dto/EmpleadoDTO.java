package com.curso.cap.modulos.empleado.dto;

import java.sql.Date;

public class EmpleadoDTO {
    private Long empleadoID;
    private String empleado;

    private String apellido;

    private Date fecha_nacimiento;

    private Boolean registro_activo;

    public EmpleadoDTO() {
        super();
    }

    public EmpleadoDTO(Long empleadoID, String empleado, String apellido, Date fecha_nacimiento, Boolean registro_activo){
        this.empleadoID = empleadoID;
        this.empleado = empleado;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.registro_activo = registro_activo;
    }

    public Long getEmpleadoID() {
        return empleadoID;
    }

    public void setEmpleadoID(Long empleadoID) {
        this.empleadoID = empleadoID;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public String getApellido() {return apellido;}

    public void setApellido(String apellido) {this.apellido = apellido;}

    public Date getFecha_nacimiento() {return fecha_nacimiento;}

    public void setFecha_nacimiento(Date fecha_nacimiento) {this.fecha_nacimiento = fecha_nacimiento;}

    public Boolean getRegistro_activo() {return registro_activo;}

    public void setRegistro_activo(Boolean registro_activo) {this.registro_activo = registro_activo;}
}
