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
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ConfiguracionPaginado;

/**
 *
 * @author alexa
 */
public class RetirosDAO implements IRetirosDAO {

    private static final Logger LOG = Logger.getLogger(CuentasDAO.class.getName());
    private final IConexionBD generadorConexiones;

    /**
     * Constructor que genera la conexión con la base de datos
     *
     * @param generadorConexiones
     */
    public RetirosDAO(IConexionBD generadorConexiones) {
        this.generadorConexiones = generadorConexiones;
    }

    /**
     * Método que hace un retiro
     *
     * @param codigoCuenta Cuenta origen
     * @param cantidad Cantidad a retirar
     * @param contrasenia Contraseña del retiro
     * @throws PersistenciaException
     */
    @Override
    public void retirar(Integer codigoCuenta, float cantidad, String contrasenia) throws PersistenciaException {
        String sql = "{call retiroSinCuenta (?,?,?)}";

        try (Connection conexion = this.generadorConexiones.crearConexion(); CallableStatement cst = conexion.prepareCall(sql);) {
            cst.setInt(1, codigoCuenta);
            cst.setFloat(2, cantidad);
            cst.setString(3, contrasenia);
            cst.executeUpdate();
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No fue posible realizar el retiro");
        }
    }

    /**
     * Método que hace un retiro
     *
     * @param codigoCuenta Cuenta origen
     * @param cantidad Cantidad a retirar
     * @param contrasenia Contraseña del retiro
     * @throws PersistenciaException
     */
    @Override
    public Retiro retirar2(Integer codigoCuenta, float cantidad, String contrasenia) throws PersistenciaException {
        String sql = "update cuentas set saldo = saldo - ?"
                + "where codigo = ?";

        String sql2 = "INSERT INTO RETIROS (cantidad, contrasenia, "
                + "codigoCuenta, estado)"
                + "VALUES (?,?,?, 'retirado')";

        try (
                Connection conexion = this.generadorConexiones.crearConexion(); PreparedStatement comando = conexion.prepareStatement(
                sql); PreparedStatement comando2 = conexion.prepareStatement(
                        sql2, Statement.RETURN_GENERATED_KEYS);) {

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
                retiro.setCodigoCuenta(codigoCuenta);
                return retiro;
            }
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No fue posible realizar el retiro");
        }
        return null;
    }

    /**
     * Método que consulta la lista de retiros
     *
     * @param paginado
     * @param codigoCuenta Cuenta de la que se desea saber los retiros
     * @return Lista de retiros
     * @throws PersistenciaException
     */
    @Override
    public List<Retiro> consultarLista(ConfiguracionPaginado paginado, Integer codigoCuenta) throws PersistenciaException {
        String sql = "select folio, cantidad, contrasenia, codigoCuenta, fechaRetiro, estado "
                + "from retiros "
                + "where codigoCuenta = ? LIMIT ? OFFSET ?";
        List<Retiro> listaRetiros = new LinkedList<>();

        try (
                Connection conexion = this.generadorConexiones.crearConexion(); PreparedStatement comando = conexion.prepareStatement(sql);) {
            comando.setInt(1, codigoCuenta);
            comando.setInt(2, paginado.getElementosPagina());
            comando.setInt(3, paginado.getNumPagina());
            ResultSet registro = comando.executeQuery();
            while (registro.next()) {
                Integer folio = registro.getInt("folio");
                float cant = registro.getFloat("cantidad");
                String contrasena = registro.getString("contrasenia");
                Integer codigoCuenta2 = registro.getInt("codigoCuenta");
                Date fechaRetiro = registro.getDate("fechaRetiro");
                String estado = registro.getString("estado");

                Retiro retiro = new Retiro(folio, cant, contrasena, codigoCuenta,
                        fechaRetiro, estado);
                listaRetiros.add(retiro);
            }
            return listaRetiros;
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No se pudo consultar la lista de retiros");
        }
    }
}
