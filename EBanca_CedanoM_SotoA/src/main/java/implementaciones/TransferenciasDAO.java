/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import dominio.Cliente;
import dominio.Cuenta;
import dominio.Transferencia;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.ITransferenciasDAO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexa
 */
public class TransferenciasDAO implements ITransferenciasDAO {

    private static final Logger LOG = Logger.getLogger(CuentasDAO.class.getName());
    private final IConexionBD generadorConexiones;
    private Transferencia trans;

    public TransferenciasDAO(IConexionBD generadorConexiones) {
        this.generadorConexiones = generadorConexiones;
    }
    
    @Override
    public Transferencia consultar(Cliente codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Transferencia realizar(Integer cuentaOrigen, Integer cuentaDestino, float cantidad) throws PersistenciaException {
        
            String sqlT = "{call realizaTransferencias (?,?,?)}";

        try (Connection conexion = this.generadorConexiones.crearConexion();
                CallableStatement cst = conexion.prepareCall(sqlT);) {

            cst.setFloat(1, cantidad);
            cst.setInt(2, cuentaOrigen);
            cst.setInt(3, cuentaDestino);
            cst.executeUpdate();
            
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No fue posible realizar la transferencia");
        }
        return null;
    }

    
}
