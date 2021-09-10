package com.nexos.inventario.dto;
import com.nexos.inventario.model.Cargo;

import javax.persistence.*;
import java.io.Serializable;

public class CargoDTO implements Serializable {

    private long id;

    private String nombre;

    public CargoDTO(){

    }

    public CargoDTO(String nombre) {
        this.nombre = nombre;
    }

    public CargoDTO(Cargo cargo) {

        this.id = cargo.getId();
        this.nombre = cargo.getNombre();
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}

