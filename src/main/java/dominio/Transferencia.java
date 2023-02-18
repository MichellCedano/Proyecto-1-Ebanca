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
public class Transferencia {
    
    private Integer codigo;
    private Date fechaTransferencia;
    private String tipo;
    private float cantidad;
    private Integer codigoCuentaOrigen;
    private Integer codigoDestino;

    public Transferencia() {
    }

    public Transferencia(Integer codigo, Date fechaTransferencia, String tipo, float cantidad, Integer codigoCuentaOrigen, Integer codigoDestino) {
        this.codigo = codigo;
        this.fechaTransferencia = fechaTransferencia;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.codigoCuentaOrigen = codigoCuentaOrigen;
        this.codigoDestino = codigoDestino;
    }

    public Transferencia(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Date getFechaTransferencia() {
        return fechaTransferencia;
    }

    public void setFechaTransferencia(Date fechaTransferencia) {
        this.fechaTransferencia = fechaTransferencia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getCodigoCuentaOrigen() {
        return codigoCuentaOrigen;
    }

    public void setCodigoCuentaOrigen(Integer codigoCuentaOrigen) {
        this.codigoCuentaOrigen = codigoCuentaOrigen;
    }

    public Integer getCodigoDestino() {
        return codigoDestino;
    }

    public void setCodigoDestino(Integer codigoDestino) {
        this.codigoDestino = codigoDestino;
    }
    
    
    
}
