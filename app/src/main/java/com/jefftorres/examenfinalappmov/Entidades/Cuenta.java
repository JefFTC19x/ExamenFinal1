package com.jefftorres.examenfinalappmov.Entidades;

import com.google.gson.annotations.SerializedName;

public class Cuenta {
    @SerializedName("nombre")
    private String nombre;
    @SerializedName("monto")
    private String monto;
    @SerializedName("fecha_creacion")
    private String fecha;
    @SerializedName("sucursal_1")
    private String sucursal1;
    @SerializedName("sucursal_2")
    private String sucursal2  ;
    @SerializedName("sucursal_3")
    private String sucursal3;
    @SerializedName("imagen")
    private String imagen;

    public Cuenta() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getSucursal1() {
        return sucursal1;
    }

    public void setSucursal1(String sucursal1) {
        this.sucursal1 = sucursal1;
    }

    public String getSucursal2() {
        return sucursal2;
    }

    public void setSucursal2(String sucursal2) {
        this.sucursal2 = sucursal2;
    }

    public String getSucursal3() {
        return sucursal3;
    }

    public void setSucursal3(String sucursal3) {
        this.sucursal3 = sucursal3;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
