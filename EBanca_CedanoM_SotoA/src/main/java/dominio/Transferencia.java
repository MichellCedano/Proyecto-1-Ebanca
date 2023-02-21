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

    /**
     * Constructor por defecto
     */
    public Transferencia() {
    }

    /**
     * Constructor que inicializa el codigo, la fecha transferencia, tipo,
     * cantidad, cuenta origen y cuenta destino
     *
     * @param codigo
     * @param fechaTransferencia
     * @param tipo
     * @param cantidad
     * @param codigoCuentaOrigen
     * @param codigoDestino
     */
    public Transferencia(Integer codigo, Date fechaTransferencia, String tipo, float cantidad, Integer codigoCuentaOrigen, Integer codigoDestino) {
        this.codigo = codigo;
        this.fechaTransferencia = fechaTransferencia;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.codigoCuentaOrigen = codigoCuentaOrigen;
        this.codigoDestino = codigoDestino;
    }

    /**
     * Constructor que inicializa el código
     *
     * @param codigo
     */
    public Transferencia(Integer codigo) {
        this.codigo = codigo;
    }

    /**
     * Método que regresa el codigo
     *
     * @return código de transferencia
     */
    public Integer getCodigo() {
        return codigo;
    }

    /**
     * Método que setea el código
     *
     * @param codigo
     */
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    /**
     * Método que regresa la fecha
     *
     * @return fecha de transferencia
     */
    public Date getFechaTransferencia() {
        return fechaTransferencia;
    }

    /**
     * Método que setea la fecha de transferencia
     *
     * @param fechaTransferencia
     */
    public void setFechaTransferencia(Date fechaTransferencia) {
        this.fechaTransferencia = fechaTransferencia;
    }

    /**
     * Método que regresa el tipo
     *
     * @return tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Método que setea el tipo
     *
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Método que regresa la cantidad de dinero
     *
     * @return cantidad de dinero a transferir
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
     * Método que regresa el código de la cuenta de origen
     *
     * @return código de la cuenta origen
     */
    public Integer getCodigoCuentaOrigen() {
        return codigoCuentaOrigen;
    }

    /**
     * Método que setea el códigoOrigen
     *
     * @param codigoCuentaOrigen
     */
    public void setCodigoCuentaOrigen(Integer codigoCuentaOrigen) {
        this.codigoCuentaOrigen = codigoCuentaOrigen;
    }

    /**
     * Método que regresa el código de la cuenta destino
     *
     * @return código cuenta destino
     */
    public Integer getCodigoDestino() {
        return codigoDestino;
    }

    /**
     * Método que setea el codigoDestino
     *
     * @param codigoDestino
     */
    public void setCodigoDestino(Integer codigoDestino) {
        this.codigoDestino = codigoDestino;
    }
}
