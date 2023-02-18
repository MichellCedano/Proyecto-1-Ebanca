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
    private int contrasena;
    private int codigoCuentaDestino;
    private Date fechaRetiro;
    private String estado;

    public Retiro() {
    }

    public Retiro(Integer folio) {
        this.folio = folio;
    }

    public Retiro(Integer folio, float cantidad, int contrasena, int codigoCuentaDestino, Date fechaRetiro, String estado) {
        this.folio = folio;
        this.cantidad = cantidad;
        this.contrasena = contrasena;
        this.codigoCuentaDestino = codigoCuentaDestino;
        this.fechaRetiro = fechaRetiro;
        this.estado = estado;
    }

    public Integer getFolio() {
        return folio;
    }

    public void setFolio(Integer folio) {
        this.folio = folio;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public int getContrasena() {
        return contrasena;
    }

    public void setContrasena(int contrasena) {
        this.contrasena = contrasena;
    }

    public int getCodigoCuentaDestino() {
        return codigoCuentaDestino;
    }

    public void setCodigoCuentaDestino(int codigoCuentaDestino) {
        this.codigoCuentaDestino = codigoCuentaDestino;
    }

    public Date getFechaRetiro() {
        return fechaRetiro;
    }

    public void setFechaRetiro(Date fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
