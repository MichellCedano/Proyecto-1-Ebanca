/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Cliente;
import dominio.Cuenta;
import dominio.Transferencia;
import excepciones.PersistenciaException;
import java.util.List;
import utils.ConfiguracionPaginado;

/**
 *
 * @author alexa
 */
public interface ITransferenciasDAO {
    
    Transferencia realizar(Integer cliente, Integer cuenta, float cantidad) throws PersistenciaException;
    
    List<Transferencia> consultarLista(ConfiguracionPaginado paginado, Integer codigoCuenta) throws PersistenciaException;
}
