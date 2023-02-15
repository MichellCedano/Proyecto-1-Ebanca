/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementaciones;

import dominio.Cliente;
import excepciones.PersistenciaException;
import interfaces.IClientesDAO;
import interfaces.IConexionBD;
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
 * @author lv1013
 */
public class ClientesDAO implements IClientesDAO {

    private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());
    private final IConexionBD generadorConexiones;

    public ClientesDAO(IConexionBD generadorConexiones) {
        this.generadorConexiones = generadorConexiones;
    }

    @Override
    public Cliente consultar(Integer codigoCliente) {
        String sql = "select codigo, nombres, apellidoPaterno, apellidoMaterno, "
                + "fechaNacimiento, nip, codigoDireccion"
                + "from clientes where codigo = ?";
        try (
                Connection conexion = this.generadorConexiones.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(sql);) {
            comando.setInt(1, codigoCliente);
            ResultSet registro = comando.executeQuery();
            // SI SE ENCONTRÓ AL CLIENTE...
            Cliente cliente = null;
            if (registro.next()) {
                Integer codigo = registro.getInt("codigo");
                String nombres = registro.getString("nombres");
                String ap_paterno = registro.getString("apellidoPaterno");
                String ap_materno = registro.getString("apellidoMaterno");
                Date fechaNacimiento = registro.getDate("fechaNacimiento");
                int edad = registro.getInt("edad");
                int nip = registro.getInt("nip");
                Integer codigoDireccion = registro.getInt("codigoDireccion");
                cliente = new Cliente(codigo, nombres, ap_paterno, ap_materno,
                        codigoDireccion, fechaNacimiento, edad, nip);
            }
            return cliente;
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            return null;
        }
    }

    @Override
    public Cliente insertar(Cliente cliente) throws PersistenciaException {
        String sql = "insert into clientes("
                + "nombres, ap_paterno, ap_materno, codigo_direccion)"
                + "values (?,?,?,?)";
        try (
                Connection conexion = this.generadorConexiones.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(
                        sql, Statement.RETURN_GENERATED_KEYS);) {
            comando.setString(1, cliente.getNombres());
            comando.setString(2, cliente.getApPaterno());
            comando.setString(3, cliente.getApMaterno());
            comando.setInt(4, cliente.getCodigoDireccion());
            comando.executeUpdate();
            // ResultSet: objeto que devuelve la base al consultar
            ResultSet llavesGeneradas = comando.getGeneratedKeys();
            if (llavesGeneradas.next()) {
                Integer llavePrimaria = llavesGeneradas.getInt(1);
                cliente.setCodigo(llavePrimaria);
                return cliente;
            }
            LOG.log(Level.WARNING, "Cliente registrado, pero código no generado");
            throw new PersistenciaException("Cliente registrado, pero código no generado");
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No fue posible registrar al cliente");
        } 
    }

    @Override
    public Cliente eliminar(Integer codigoCliente) {
        String sql = "delete from clientes where codigo = ?";
        try (
                Connection conexion = this.generadorConexiones.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(sql);) {
            Cliente cliente = consultar(codigoCliente);
            comando.setInt(1, codigoCliente);
            int numClientesEliminados = comando.executeUpdate();
            return numClientesEliminados > 0 ? cliente : null;
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Cliente> consultarLista(ConfiguracionPaginado paginado) throws PersistenciaException {
        String sql = "select codigo, nombres, ap_paterno, ap_materno, codigo_direccion "
                + "from clientes LIMIT ? OFFSET ?";
        List <Cliente> listaClientes = new LinkedList<>();
        try (
                Connection conexion = this.generadorConexiones.crearConexion();
                PreparedStatement comando = conexion.prepareStatement(sql);) {
            comando.setInt(1, paginado.getElementosPagina());
            comando.setInt(2, paginado.getNumPagina());
            ResultSet registro = comando.executeQuery();
            while (registro.next()) {
                Integer codigo = registro.getInt("codigo");
                String nombres = registro.getString("nombres");
                String ap_paterno = registro.getString("apellidoPaterno");
                String ap_materno = registro.getString("apellidoMaterno");
                Date fechaNacimiento = registro.getDate("fechaNacimiento");
                int edad = registro.getInt("edad");
                int nip = registro.getInt("nip");
                Integer codigoDireccion = registro.getInt("codigoDireccion");
                Cliente cliente = new Cliente(codigo, nombres, ap_paterno, ap_materno,
                        codigoDireccion, fechaNacimiento, edad, nip);
                listaClientes.add(cliente);
            }
            return listaClientes;
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No se pudo consultar la lista de clientes");
        }
    }
}