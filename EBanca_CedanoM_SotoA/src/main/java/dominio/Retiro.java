/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.Date;

/**
 *
 * @author alexa
 */
public class Retiro {

    private Integer folio;
    private float cantidad;
    private String contrasena;
    private Integer codigoCuenta;
    private Date fechaRetiro;
    private String estado;

    /**
     * Constructor por defecto
     */
    public Retiro() {
    }

    /**
     * Constructor que inicializa el folio
     *
     * @param folio
     */
    public Retiro(Integer folio) {
        this.folio = folio;
    }

    /**
     * Constructor que inicializa el folio, la cantidad, contraseña, codigo de
     * cuenta, fecha del retiro y el estado
     *
     * @param folio
     * @param cantidad
     * @param contrasena
     * @param codigoCuenta
     * @param fechaRetiro
     * @param estado
     */
    public Retiro(Integer folio, float cantidad, String contrasena, Integer codigoCuenta, Date fechaRetiro, String estado) {
        this.folio = folio;
        this.cantidad = cantidad;
        this.contrasena = contrasena;
        this.codigoCuenta = codigoCuenta;
        this.fechaRetiro = fechaRetiro;
        this.estado = estado;
    }

    /**
     * Método que regresa el folio
     *
     * @return folio
     */
    public Integer getFolio() {
        return folio;
    }

    /**
     * Método que setea el folio
     *
     * @param folio
     */
    public void setFolio(Integer folio) {
        this.folio = folio;
    }

    /**
     * Método que regresa la cantidad
     *
     * @return cantidad a retirar
     */
    public float getCantidad() {
        return cantidad;
    }

    /**
     * Método que setea la cantidad
     *
     * @param cantidad
     */
    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Método que regresa la contraseña
     *
     * @return contraseña del retiro
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Método que setea la contraseña
     *
     * @param contrasena
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Método que regresa el código de la cuenta origen
     *
     * @return código de la cuenta origen
     */
    public Integer getCodigoCuenta() {
        return codigoCuenta;
    }

    /**
     * Método que setea el código de la cuenta origen
     *
     * @param codigoCuenta
     */
    public void setCodigoCuenta(int codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }

    /**
     * Método que regresa la fecha del retiro
     *
     * @return fecha del retiro
     */
    public Date getFechaRetiro() {
        return fechaRetiro;
    }

    /**
     * Método que setea la fecha del retiro
     *
     * @param fechaRetiro
     */
    public void setFechaRetiro(Date fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }

    /**
     * Método que regresa el estado
     *
     * @return estado del retiro
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Método que setea el estado
     *
     * @param estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
