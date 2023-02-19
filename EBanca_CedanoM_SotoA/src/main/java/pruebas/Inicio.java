/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import GUI.DlgRegistro;
import GUI.FrmPrincipal;
import implementaciones.ClientesDAO;
import implementaciones.ConexionBD;
import implementaciones.CuentasDAO;
import interfaces.IClientesDAO;
import interfaces.IConexionBD;
import interfaces.ICuentasDAO;
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
        IConexionBD generadorConexiones = new ConexionBD("jdbc:mysql://localhost/e_banca","root","AlexaSoto1");
        try{
  
    
            Connection conexion = generadorConexiones.crearConexion();

            Statement comando = conexion.createStatement();

            IClientesDAO clientesDAO = new ClientesDAO(generadorConexiones);
            ICuentasDAO cuentasDAO = new CuentasDAO(generadorConexiones);
            
             new FrmPrincipal(clientesDAO,cuentasDAO).setVisible(true);
            
            
        }catch(SQLException ex){
            LOG.log(Level.SEVERE,ex.getMessage());
            
        }
        
        
    }
    private static final Logger LOG = Logger.getLogger(Inicio.class.getName());
    
}
