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

    public Direccion() {
    }

    public Direccion(String calle, String colonia, String numeroCasa) {
        this.numeroCasa = numeroCasa;
        this.calle = calle;
        this.colonia = colonia;
    }

    public Direccion(int codigoDireccion, String numeroCasa, String calle, String colonia) {
        this.codigoDireccion = codigoDireccion;
        this.numeroCasa = numeroCasa;
        this.calle = calle;
        this.colonia = colonia;
    }

    public int getCodigoDireccion() {
        return codigoDireccion;
    }

    public void setCodigoDireccion(int codigoDireccion) {
        this.codigoDireccion = codigoDireccion;
    }

    public String  getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }
    
    
    
}
