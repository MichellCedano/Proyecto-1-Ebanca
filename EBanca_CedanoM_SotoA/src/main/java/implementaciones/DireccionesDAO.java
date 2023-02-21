/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import dominio.Direccion;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.IDireccionesDAO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexa
 */
public class DireccionesDAO implements IDireccionesDAO {

    private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());
    private final IConexionBD generadorConexiones;

    /**
     * Constructor que genera la conexión con la base de datos
     *
     * @param generadorConexiones
     */
    public DireccionesDAO(IConexionBD generadorConexiones) {
        this.generadorConexiones = generadorConexiones;
    }

    /**
     * Método que actualiza la dirección
     *
     * @param codigoDireccion Dirección a actualizar
     * @param nvaCalle Nueva calle
     * @param nvoNumero Nuevo número
     * @param nvaColonia Nuev colonia
     * @throws PersistenciaException
     */
    @Override
    public void actualizarDireccion(Integer codigoDireccion, String nvaCalle,
            String nvoNumero, String nvaColonia) throws PersistenciaException {

        String sqlT = "{call actualizarDireccion(?,?,?,?)}";

        try (Connection conexion = this.generadorConexiones.crearConexion(); CallableStatement cst = conexion.prepareCall(sqlT);) {

            cst.setInt(1, codigoDireccion);
            cst.setString(2, nvaCalle);
            cst.setString(3, nvoNumero);
            cst.setString(4, nvaColonia);
            cst.executeUpdate();

        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No fue posible actualizar la dirección");
        }
    }
}
