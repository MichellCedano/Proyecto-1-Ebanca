/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dominio.Cliente;
import dominio.Cuenta;
import excepciones.PersistenciaException;
import java.util.List;
import utils.ConfiguracionPaginado;

/**
 *
 * @author alexa
 */
public interface ICuentasDAO {
    
    Cuenta insertar(Cuenta cuenta) throws PersistenciaException;
    
    Cuenta actualizarEstado(Cuenta cuenta) throws PersistenciaException;
    
    Cuenta consultar(Integer codigoCuenta);
    
    List<Cuenta> consultarLista(int codigoCliente) throws PersistenciaException;
    
    boolean compruebaCuenta(int codigoCuenta);
}
