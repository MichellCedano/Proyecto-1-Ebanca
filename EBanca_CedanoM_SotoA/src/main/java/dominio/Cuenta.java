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

    /**
     * Constructor por defecto
     */
    public Cuenta() {
    }
    
    /**
     * Constructor que inicializa el codigo, el estado, fecha de apertura, saldo
     * y codigo de la cuenta
     * @param codigo
     * @param estado
     * @param fechaApertura
     * @param saldo
     * @param codigoCliente 
     */
    public Cuenta(Integer codigo, String estado, Date fechaApertura, float saldo, Integer codigoCliente) {
        this.codigo = codigo;
        this.estado = estado;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
        this.codigoCliente = codigoCliente;
    }

    /**
     * Constructor que inicializa el estado, fecha de apertura, saldo
     * y codigo de la cuenta
     * @param estado
     * @param fechaApertura
     * @param saldo
     * @param codigoCliente 
     */
    public Cuenta(String estado, Date fechaApertura, float saldo, Integer codigoCliente) {
        this.estado = estado;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
        this.codigoCliente = codigoCliente;
    }

    /**
     * Constructor que inicializa el estado, fecha de apertura y codigo de 
     * la cuenta
     * @param estado
     * @param fechaApertura
     * @param codigoCliente 
     */
    public Cuenta(String estado, Date fechaApertura, Integer codigoCliente) {
        this.estado = estado;
        this.fechaApertura = fechaApertura;
        this.codigoCliente = codigoCliente;
    }

    /**
     * Constructor que inicializa el codigo, el estado, el saldo,
     * y codigo de la cuenta
     * @param codigo
     * @param estado
     * @param saldo
     * @param codigoCliente 
     */
    public Cuenta(Integer codigo, String estado, float saldo, Integer codigoCliente) {
        this.codigo = codigo;
        this.estado = estado;
        this.saldo = saldo;
        this.codigoCliente = codigoCliente;
    }

    /**
     * Constructor que inicializa el codigo de la cuenta
     * @param codigo 
     */
    public Cuenta(Integer codigo) {
        this.codigo = codigo;
    }
    
    /**
     * Método que regresa el código de la cuenta
     * @return codigo
     */
    public Integer getCodigo() {
        return codigo;
    }

    /**
     * Método que setea el codigo de la cuenta
     * @param codigo codigo
     */
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    /**
     * Método que regresa la fecha de apertura de la cuenta
     * @return fecha de apertura
     */
    public Date getFechaApertura() {
        return fechaApertura;
    }

    /**
     * Método que setea la fecha de apertura de la cuenta
     * @param fechaApertura 
     */
    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    /**
     * Método que regresa el saldo de la cuenta
     * @return saldo de la cuenta
     */
    public float getSaldo() {
        return saldo;
    }

    /**
     * Método que setea el saldo de la cuenta
     * @param saldo 
     */
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    /**
     * Método que regresa el codigo del cliente al cual pertenece la cuenta
     * @return codigo del cliente dueño de la cuenta
     */
    public Integer getCodigoCliente() {
        return codigoCliente;
    }

    /**
     * Método que setea el codigo del cliente al cual pertenece la cuenta
     * @param codigoCliente 
     */
    public void setCodigoCliente(Integer codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    /**
     * Método que regresa el estado de la cuenta
     * @return estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Método que setea el estado de la cuenta
     * @param estado 
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
