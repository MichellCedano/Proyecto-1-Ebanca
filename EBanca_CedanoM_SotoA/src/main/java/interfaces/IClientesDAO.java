/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dominio.Cliente;
import dominio.Direccion;
import excepciones.PersistenciaException;
import java.util.List;
import utils.ConfiguracionPaginado;

/**
 *
 * @author lv1013
 */
public interface IClientesDAO {
    
    Cliente consultar(Integer codigoCliente);
    
    Cliente insertar(Cliente cliente, Direccion direccion) throws PersistenciaException; 
    
    List <Cliente> consultarLista(ConfiguracionPaginado paginado) throws PersistenciaException;
    
    void actualizarDatosPersonales(Integer codigoCliente, String nvoNombre, String nvoApPaterno, String nvoApMaterno) throws PersistenciaException;
}
