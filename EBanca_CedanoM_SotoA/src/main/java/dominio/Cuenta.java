/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.Date;

/**
 *
 * @author alexa
 */
public class Cuenta {
    
    private Integer codigo;
    private String estado;
    private Date fechaApertura;
    private float saldo;
    private Integer codigoCliente;

    public Cuenta() {
    }

    public Cuenta(Integer codigo, String estado, Date fechaApertura, float saldo, Integer codigoCliente) {
        this.codigo = codigo;
        this.estado = "Activo";
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
        this.codigoCliente = codigoCliente;
    }

    public Cuenta(String estado, Date fechaApertura, float saldo, Integer codigoCliente) {
        this.estado = "Activo";
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
        this.codigoCliente = codigoCliente;
    }

    public Cuenta(String estado, Date fechaApertura, Integer codigoCliente) {
        this.estado = "Activo";
        this.fechaApertura = fechaApertura;
        this.codigoCliente = codigoCliente;
    }

    public Cuenta(Integer codigo, String estado, float saldo, Integer codigoCliente) {
        this.codigo = codigo;
        this.estado = estado;
        this.saldo = saldo;
        this.codigoCliente = codigoCliente;
    }

    
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public Integer getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Integer codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
