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
    private Date fechaApertura;
    private float saldo;
    private Integer codigoCliente;

    public Cuenta() {
    }

    public Cuenta(Integer codigo, Date fechaApertura, float saldo, Integer codigoCliente) {
        this.codigo = codigo;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
        this.codigoCliente = codigoCliente;
    }

    public Cuenta(Date fechaApertura, float saldo, Integer codigoCliente) {
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
        this.codigoCliente = codigoCliente;
    }

    public Cuenta(Date fechaApertura, Integer codigoCliente) {
        this.fechaApertura = fechaApertura;
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
    
}
