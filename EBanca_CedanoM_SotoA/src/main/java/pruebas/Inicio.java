/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import GUI.DlgRegistro;
import GUI.FrmPrincipal;
import implementaciones.*;
import interfaces.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author koine
 */
public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IConexionBD generadorConexiones = new ConexionBD("jdbc:mysql://localhost/e_banca","root","8181");
        try{
            Connection conexion = generadorConexiones.crearConexion();

            IClientesDAO clientesDAO = new ClientesDAO(generadorConexiones);
            ICuentasDAO cuentasDAO = new CuentasDAO(generadorConexiones);
            ITransferenciasDAO transDAO = new TransferenciasDAO(generadorConexiones);
            IDireccionesDAO direccionDAO = new DireccionesDAO(generadorConexiones);
            IRetirosDAO retirosDAO = new RetirosDAO(generadorConexiones);
             new FrmPrincipal(clientesDAO,cuentasDAO, transDAO, direccionDAO, retirosDAO).setVisible(true);
            
            
        }catch(SQLException ex){
            LOG.log(Level.SEVERE,ex.getMessage());
            
        }
        
        
    }
    private static final Logger LOG = Logger.getLogger(Inicio.class.getName());
    
}
