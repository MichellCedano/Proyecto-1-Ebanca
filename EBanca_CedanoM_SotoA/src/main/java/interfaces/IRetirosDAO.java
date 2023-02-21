/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Cliente;
import dominio.Retiro;
import excepciones.PersistenciaException;
import java.util.List;
import utils.ConfiguracionPaginado;

/**
 *
 * @author alexa
 */
public interface IRetirosDAO {
    
    Retiro consultar(Cliente codigo);
    
    void retirar(Integer codigoCuenta, float cantidad, String contrasenia) throws PersistenciaException;
    
    Retiro retirar2(Integer codigoCuenta, float cantidad, String contrasenia) throws PersistenciaException;
    
    List<Retiro> consultarLista(ConfiguracionPaginado paginado, Integer codigoCuenta) throws PersistenciaException;
    
}
