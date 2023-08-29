package com.example.pp_grupo2.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Contacto implements Serializable {

    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String direccion;
    private Date fechaNacimiento;

    private String nivelEstudios;
    private ArrayList intereses;
    private Boolean recibirInformacion;

    public Contacto2(String nombre, String apellido, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNivelEstudios() {
        return nivelEstudios;
    }

    public void setNivelEstudios(String nivelEstudios) {
        this.nivelEstudios = nivelEstudios;
    }

    public ArrayList getIntereses() {
        return intereses;
    }

    public void setIntereses(ArrayList intereses) {
        this.intereses = intereses;
    }

    public Boolean getRecibirInformacion() {
        return recibirInformacion;
    }

    public void setRecibirInformacion(Boolean recibirInformacion) {
        this.recibirInformacion = recibirInformacion;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " - " + email;
    }
}