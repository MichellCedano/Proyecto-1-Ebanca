/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementaciones;

import dominio.Cliente;
import dominio.Cuenta;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.ICuentasDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
public class CuentasDAO implements ICuentasDAO{

    private static final Logger LOG = Logger.getLogger(CuentasDAO.class.getName());
    private final IConexionBD generadorConexiones;

    public CuentasDAO(IConexionBD generadorConexiones) {
        this.generadorConexiones = generadorConexiones;
    }
    
    @Override
    public Cuenta insertar(Cuenta cuenta) throws PersistenciaException {
        String sql = "insert into cuentas("
                + "estado, saldo, codigoCliente)"
                + "values (?,?,?)";
        try (
                Connection conexion = this.generadorConexiones.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(
                        sql, Statement.RETURN_GENERATED_KEYS);) {
            comando.setString(1, "Activo");
            comando.setFloat(2, cuenta.getSaldo());
            comando.setInt(3, cuenta.getCodigoCliente());
            comando.executeUpdate();
            // ResultSet: objeto que devuelve la base al consultar
            ResultSet llavesGeneradas = comando.getGeneratedKeys();
            if (llavesGeneradas.next()) {
                Integer llavePrimaria = llavesGeneradas.getInt(1);
                cuenta.setCodigo(llavePrimaria);
                return cuenta;
            }
            LOG.log(Level.WARNING, "Cuenta registrada, pero código no generado");
            throw new PersistenciaException("Cuenta registrada, pero código no generado");
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No fue posible registrar la cuenta");
        } 
    }

    @Override
    public Cuenta consultar(Integer codigoCuenta) {
        String sql = "select codigo, estado, fechaApertura, saldo, codigoCliente "
                + "from cuentas where codigo = ? ;";
        try (
                Connection conexion = this.generadorConexiones.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(sql);) {
            comando.setInt(1, codigoCuenta);
            ResultSet registro = comando.executeQuery();
            // SI SE ENCONTRÓ A LA CUENTA
            Cuenta cuenta = null;
            if (registro.next()) {
                Integer codigo = registro.getInt("codigo");
                String estado = registro.getString("estado");
                Date fechaApertura = registro.getDate("fechaApertura");
                float saldo = registro.getFloat("saldo");
                Integer codigoCliente = registro.getInt("codigoCliente");
                cuenta = new Cuenta(codigo, estado, fechaApertura, saldo,
                        codigoCliente);
            }
            return cuenta;
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Cuenta> consultarLista(int codigoCliente) throws PersistenciaException {
        String sql = "select codigo, estado, fechaApertura, saldo, codigoCliente "
                + "from cuentas where codigoCliente = ?";
        List <Cuenta> listaCuentas = new LinkedList<>();
        try (
                Connection conexion = this.generadorConexiones.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(sql);) {
            comando.setInt(1, codigoCliente);
            ResultSet registro = comando.executeQuery();
            while (registro.next()) {
                Integer codigo = registro.getInt("codigo");
                String nombre = registro.getString("estado");
                float saldo = registro.getFloat("saldo");
                Cuenta cuenta = new Cuenta(codigo, nombre, saldo, codigoCliente);
                listaCuentas.add(cuenta);
            }
            return listaCuentas;
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No se pudo consultar la lista de cuentas");
        }
    }

    @Override
    public Cuenta actualizarEstado(Cuenta cuenta) throws PersistenciaException {
        String sql = "update cuentas set estado='cancelada' where codigo=? ";
        try (
                Connection conexion = this.generadorConexiones.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(sql);) {
            //Cuenta cuenta = consultar(codigoCuenta);
            comando.setInt(1, cuenta.getCodigo());
            int numCuentasActualizadas = comando.executeUpdate();
            return numCuentasActualizadas > 0 ? cuenta : null;
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            return null;
        }
    }
    
    @Override
    public boolean compruebaCuenta(int codigoCuenta){
        String sql = "select codigo, estado, fechaApertura, saldo, codigoCliente "
                + "from cuentas where codigo = ?";
        try (
                Connection conexion = this.generadorConexiones.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(sql);) {
            comando.setInt(1, codigoCuenta);
            ResultSet registro = comando.executeQuery();
            // SI SE ENCONTRÓ A LA CUENTA
            Cuenta cuenta = null;
            if (registro.next()) {
                
            }
            return true;
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            return false;
        }
        
    }
    
}
