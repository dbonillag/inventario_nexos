package com.nexos.inventario.dto;

import com.nexos.inventario.model.Usuario;

import java.io.Serializable;
import java.util.Date;


public class UsuarioDTO implements Serializable {

    private long id;


    private String nombre;

    private Integer edad;

    private Date fechaIngreso;

    public UsuarioDTO() {

    }
    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nombre = usuario.getNombre();
        this.edad = usuario.getEdad();
        this.fechaIngreso = usuario.getFechaIngreso();

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad='" + edad + '\'' +
                ", fechaIngreso=" + fechaIngreso +
                '}';
    }
}
