/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import dominio.Cliente;
import dominio.Retiro;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.IRetirosDAO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexa
 */
public class RetirosDAO implements IRetirosDAO{

    private static final Logger LOG = Logger.getLogger(CuentasDAO.class.getName());
    private final IConexionBD generadorConexiones;

    public RetirosDAO(IConexionBD generadorConexiones) {
        this.generadorConexiones = generadorConexiones;
    }

    @Override
    public Retiro consultar(Cliente codigo) {
//        String sql = "select codigo, nombre, apellidoPaterno, apellidoMaterno, "
//                + "fechaNacimiento, edad, nip, codigoDireccion "
//                + "from clientes where codigo = ?";
//        try (
//                Connection conexion = this.generadorConexiones.crearConexion();
//                PreparedStatement comando = conexion.prepareStatement(sql);) {
//            comando.setInt(1, codigoCliente);
//            ResultSet registro = comando.executeQuery();
//            // SI SE ENCONTRÓ AL CLIENTE...
//            Cliente cliente = null;
//            if (registro.next()) {
//                Integer codigo = registro.getInt("codigo");
//                String nombres = registro.getString("nombre");
//                String ap_paterno = registro.getString("apellidoPaterno");
//                String ap_materno = registro.getString("apellidoMaterno");
//                Date fechaNacimiento = registro.getDate("fechaNacimiento");
//                int edad = registro.getInt("edad");
//                int nip = registro.getInt("nip");
//                Integer codigoDireccion = registro.getInt("codigoDireccion");
//                cliente = new Cliente(codigo, nombres, ap_paterno, ap_materno,
//                        codigoDireccion, fechaNacimiento, edad, nip);
//            }
//            return cliente;
//        } catch (SQLException ex) {
//            LOG.log(Level.SEVERE, ex.getMessage());
            return null;
//        }
    }

    @Override
    public void retirar(Integer codigoCuenta, float cantidad, String contrasenia) throws PersistenciaException {
        String sql = "{call retiroSinCuenta (?,?,?)}";

        try (Connection conexion = this.generadorConexiones.crearConexion(); 
                CallableStatement cst = conexion.prepareCall(sql);) {
            cst.setInt(1, codigoCuenta);
            cst.setFloat(2, cantidad);
            cst.setString(3, contrasenia);
            cst.executeUpdate();
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No fue posible realizar el retiro");
        }
    }

    @Override
    public Retiro retirar2(Integer codigoCuenta, float cantidad, String contrasenia) throws PersistenciaException {
        String sql = "update cuentas set saldo = saldo - ?"
                + "where codigo = ?";

        String sql2 = "INSERT INTO RETIROS (cantidad, contrasenia, "
                + "codigoCuenta, estado)"
                + "VALUES (?,?,?, 'retirado')";
        
        try (              
                Connection conexion = this.generadorConexiones.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(
                        sql);
                PreparedStatement comando2 = conexion.prepareStatement(
                        sql2, Statement.RETURN_GENERATED_KEYS);
                ) {
            
            comando.setFloat(1, cantidad);
            comando.setInt(2, codigoCuenta);
            comando.executeUpdate();
            // ResultSet: objeto que devuelve la base al consultar
            
            comando2.setFloat(1, cantidad);
            comando2.setString(2, contrasenia);
            comando2.setInt(3, codigoCuenta);
            comando2.executeUpdate();

            // ResultSet: objeto que devuelve la base al consultar
            ResultSet llavesGeneradas = comando2.getGeneratedKeys();
            if (llavesGeneradas.next()) {
                Retiro retiro = new Retiro();
                Integer llavePrimaria = llavesGeneradas.getInt(1);
                retiro.setFolio(llavePrimaria);
                retiro.setCantidad(cantidad);
                retiro.setContrasena(contrasenia);
                retiro.setCodigoCuentaDestino(codigoCuenta);
                return retiro;
            }
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No fue posible realizar el retiro");
        }
        return null;
    }
}
