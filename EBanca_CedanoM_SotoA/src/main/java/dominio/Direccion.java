/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author koine
 */
public class Direccion {

    private int codigoDireccion;
    private String numeroCasa;
    private String calle;
    private String colonia;

    /**
     * Constructor por defecto
     */
    public Direccion() {
    }

    /**
     * Constructor que inicializa la calle, la colonia y el número de casa
     *
     * @param calle
     * @param colonia
     * @param numeroCasa
     */
    public Direccion(String calle, String colonia, String numeroCasa) {
        this.numeroCasa = numeroCasa;
        this.calle = calle;
        this.colonia = colonia;
    }

    /**
     * Constructor que inicializa el codigo de la dirección, la calle, la
     * colonia y el número de casa
     *
     * @param codigoDireccion
     * @param numeroCasa
     * @param calle
     * @param colonia
     */
    public Direccion(int codigoDireccion, String numeroCasa, String calle, String colonia) {
        this.codigoDireccion = codigoDireccion;
        this.numeroCasa = numeroCasa;
        this.calle = calle;
        this.colonia = colonia;
    }

    /**
     * Método que regresa el código de la dirección
     *
     * @return código
     */
    public int getCodigoDireccion() {
        return codigoDireccion;
    }

    /**
     * Método que setea el código de la dirección
     *
     * @param codigoDireccion
     */
    public void setCodigoDireccion(int codigoDireccion) {
        this.codigoDireccion = codigoDireccion;
    }

    /**
     * Método que regresa el número de casa
     *
     * @return número casa
     */
    public String getNumeroCasa() {
        return numeroCasa;
    }

    /**
     * Método que setea el número de casa
     *
     * @param numeroCasa
     */
    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    /**
     * Método que regresa la calle
     *
     * @return calle de la dirección
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Método que setea la calle
     *
     * @param calle
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Método que regresa la colonia
     *
     * @return colonia de la dirección
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * Método que setea la colonia
     *
     * @param colonia
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }
}
