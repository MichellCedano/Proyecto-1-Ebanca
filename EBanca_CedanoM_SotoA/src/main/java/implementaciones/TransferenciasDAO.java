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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ConfiguracionPaginado;

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

    @Override
    public List<Transferencia> consultarLista(ConfiguracionPaginado paginado, Integer codigoCuenta) throws PersistenciaException {
        String sql = "select codigo, fechaTransferencia, tipo, cantidad, codigoCuenta, codigoCuentaDestino "
                + "from transferencias "
                + "where codigoCuenta = ? LIMIT ? OFFSET ?";
        List<Transferencia> listaTransferencias = new LinkedList<>();
        
        try (
                Connection conexion = this.generadorConexiones.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(sql);) {
            comando.setInt(1, codigoCuenta);
            comando.setInt(2, paginado.getElementosPagina());
            comando.setInt(3, paginado.getNumPagina());
            ResultSet registro = comando.executeQuery();
            while (registro.next()) {
                Integer codigo = registro.getInt("codigo");
                Date fechaTransferencia = registro.getDate("fechaTransferencia");
                String tipo = registro.getString("tipo");
                float cant = registro.getFloat("cantidad");
                Integer codigoCuenta2 = registro.getInt("codigoCuenta");
                Integer codigoCuentaDestino = registro.getInt("codigoCuentaDestino");
                
                Transferencia trans = new Transferencia(codigo, fechaTransferencia, 
                        tipo, cant, codigoCuenta, codigoCuentaDestino);
                listaTransferencias.add(trans);
            }
            return listaTransferencias;
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No se pudo consultar la lista de transferencias");
        }
    }
}
