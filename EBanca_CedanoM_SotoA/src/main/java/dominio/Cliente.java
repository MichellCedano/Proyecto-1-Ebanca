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

    /**
     * Constructor por defecto
     */
    public Cliente() {
    }

    /**
     * Constructor que inicializa el nombre completo, codigoDireccion y el nip
     *
     * @param nombres
     * @param apPaterno
     * @param apMaterno
     * @param codigoDireccion
     * @param nip
     */
    public Cliente(String nombres, String apPaterno, String apMaterno, Integer codigoDireccion, int nip) {
        this.nombres = nombres;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.codigoDireccion = codigoDireccion;
        this.nip = nip;
    }

    /**
     * Constructor que inicializa el codigo, el nombre completo,
     * codigoDireccion, fecha de nacimiento, edad y el nip
     *
     * @param codigo
     * @param nombres
     * @param apPaterno
     * @param apMaterno
     * @param codigoDireccion
     * @param fechaNacimiento
     * @param edad
     * @param nip
     */
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

    /**
     * Constructor que inicializa el nombre completo, codigoDireccion, la fecha
     * de nacimiento y el nip
     *
     * @param nombres
     * @param apPaterno
     * @param apMaterno
     * @param codigoDireccion
     * @param fechaNacimiento
     * @param nip
     */
    public Cliente(String nombres, String apPaterno, String apMaterno, Integer codigoDireccion, Date fechaNacimiento, int nip) {
        this.nombres = nombres;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.codigoDireccion = codigoDireccion;
        this.fechaNacimiento = fechaNacimiento;
        this.nip = nip;
    }

    /**
     * Constructor que inicializa el codigo
     *
     * @param codigo
     */
    public Cliente(Integer codigo) {
        this.codigo = codigo;
    }

    /**
     * Constructor que inicializa el nombre completo
     *
     * @param nombres
     * @param apPaterno
     * @param apMaterno
     */
    public Cliente(String nombres, String apPaterno, String apMaterno) {
        this.nombres = nombres;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
    }

    /**
     * Constructor que inicializa el codigo y el nombre completo
     *
     * @param codigo
     * @param nombres
     * @param apPaterno
     * @param apMaterno
     */
    public Cliente(Integer codigo, String nombres, String apPaterno, String apMaterno) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
    }

    /**
     * M??todo que regresa el c??digo del cliente
     *
     * @return c??digo del cliente
     */
    public Integer getCodigo() {
        return codigo;
    }

    /**
     * M??todo que setea el c??digo del cliente
     *
     * @param codigo codigo del cliente
     */
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    /**
     * M??todo que regresa los nombres del cliente
     *
     * @return nombres del cliente
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * M??todo que setea los nombres del cliente
     *
     * @param nombres nombres del cliente
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * M??todo q regresa el apellido paterno del cliente
     *
     * @return apueellido paterno del cliente
     */
    public String getApPaterno() {
        return apPaterno;
    }

    /**
     * M??todo que setea el apellido paterno del clietnte
     *
     * @param apPaterno apellido paterno del cliente
     */
    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    /**
     * M??todo que regresa el apellido materno del cliente
     *
     * @return apellido paterno del cliente
     */
    public String getApMaterno() {
        return apMaterno;
    }

    /**
     * M??todo que setea el apellido materno del cliente
     *
     * @param apMaterno apellido materno del cliente
     */
    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    /**
     * M??todo que regresa el c??digo de direcci??n del cliente
     *
     * @return c??digo de direcci??n del cliente
     */
    public Integer getCodigoDireccion() {
        return codigoDireccion;
    }

    /**
     * M??todo que setea el c??digo de direcci??n del cliente
     *
     * @param codigoDireccion c??digo de direcci??n del cliente
     */
    public void setCodigoDireccion(Integer codigoDireccion) {
        this.codigoDireccion = codigoDireccion;
    }

    /**
     * M??todo que regresa el la fecha de nacimiento del cliente
     *
     * @return fecha de nacimiento del cliente
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * M??todo que setea la fecha de nacimiento del cliente
     *
     * @param fechaNacimiento fecha de nacimiento del cliente
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * M??todo que regresa el nip del cliente
     *
     * @return nip del cliente
     */
    public int getNip() {
        return nip;
    }

    /**
     * M??todo que setea el nip del cliente
     *
     * @param nip nip del cliente
     */
    public void setNip(int nip) {
        this.nip = nip;
    }

}
