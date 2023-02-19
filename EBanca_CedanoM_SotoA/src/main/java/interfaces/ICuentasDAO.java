/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dominio.Cliente;
import dominio.Cuenta;
import excepciones.PersistenciaException;

/**
 *
 * @author alexa
 */
public interface ICuentasDAO {
    
    Cuenta insertar(Integer codigoCliente) throws PersistenciaException;
    
    Cuenta consultar(Integer codigoCuenta);
}
