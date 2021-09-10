package com.nexos.inventario.dto;

import com.nexos.inventario.model.Mercancia;

import java.io.Serializable;
import java.util.Date;

public class MercanciaDTO implements Serializable {


    private long id;

    private String nombre;

    private Integer cantidad;

    private Date fechaIngreso;

    private Date fechaEdicion;


    public MercanciaDTO() {

    }

    public MercanciaDTO(Mercancia mercancia) {
        this.id = mercancia.getId();
        this.nombre = mercancia.getNombre();
        this.cantidad = mercancia.getCantidad();
        this.fechaIngreso = mercancia.getFechaIngreso();
        this.fechaEdicion = mercancia.getWriteDate();
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

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaEdicion() {
        return fechaEdicion;
    }

    public void setFechaEdicion(Date fechaEdicion) {
        this.fechaEdicion = fechaEdicion;
    }

    @Override
    public String toString() {
        return "MercanciaDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", fechaIngreso=" + fechaIngreso +
                ", writeDate=" + fechaEdicion +
                '}';
    }
}
