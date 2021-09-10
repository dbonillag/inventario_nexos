package com.nexos.inventario.model;

import com.querydsl.core.types.EntityPath;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mercancias")
public class Mercancia  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre", unique = true, nullable = false)
    private String nombre;


    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "fecha_ingreso", nullable = false)
    private Date fechaIngreso;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "create_uid")
    private Usuario createUid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "write_uid")
    private Usuario writeUid;

    @Column(name = "write_date")
    private Date writeDate;

    public Mercancia() {

    }

    public Mercancia(long id) {
        this.id = id;
    }

    public Mercancia(String nombre, Integer cantidad, Date fechaIngreso, Usuario createUid) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.fechaIngreso = fechaIngreso;
        this.createUid = createUid;

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

    public Usuario getCreateUid() {
        return createUid;
    }

    public void setCreateUid(Usuario createUid) {
        this.createUid = createUid;
    }

    public Usuario getWriteUid() {
        return writeUid;
    }

    public void setWriteUid(Usuario writeUid) {
        this.writeUid = writeUid;
    }

    public Date getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(Date writeDate) {
        this.writeDate = writeDate;
    }


    @Override
    public String toString() {
        return "Mercancia{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", fechaIngreso=" + fechaIngreso +
                ", createUid=" + createUid +
                ", writeUid=" + writeUid +
                ", writeDate=" + writeDate +
                '}';
    }
}
