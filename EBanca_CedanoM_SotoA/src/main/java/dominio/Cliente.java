/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author alexa
 */
public class Cliente {
    
    private Integer codigo;
    private String nombres;
    private String apPaterno;
    private String apMaterno;
    private Integer codigoDireccion;
    private Date fechaNacimiento;
    private int edad;
    private int nip;

    public Cliente() {
    }

    public Cliente(String nombres, String apPaterno, String apMaterno, Integer codigoDireccion, int nip) {
        this.nombres = nombres;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.codigoDireccion = codigoDireccion;
        this.nip = nip;
    }

    public Cliente(Integer codigo, String nombres, String apPaterno, String apMaterno, Integer codigoDireccion, Date fechaNacimiento, int edad, int nip) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.codigoDireccion = codigoDireccion;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.nip = nip;
    }

    public Cliente(String nombres, String apPaterno, String apMaterno, Integer codigoDireccion, Date fechaNacimiento, int nip) {
        this.nombres = nombres;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.codigoDireccion = codigoDireccion;
        this.fechaNacimiento = fechaNacimiento;
        this.nip = nip;
    }

    public Cliente(Integer codigo) {
        this.codigo = codigo;
    }

    public Cliente(String nombres, String apPaterno, String apMaterno) {
        this.nombres = nombres;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
    }
    
    public Cliente(Integer codigo, String nombres, String apPaterno, String apMaterno) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public Integer getCodigoDireccion() {
        return codigoDireccion;
    }

    public void setCodigoDireccion(Integer codigoDireccion) {
        this.codigoDireccion = codigoDireccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public int getNip() {
        return nip;
    }

    public void setNip(int nip) {
        this.nip = nip;
    }
    
    
}