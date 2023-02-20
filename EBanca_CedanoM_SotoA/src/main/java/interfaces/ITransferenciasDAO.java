/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Cliente;
import dominio.Cuenta;
import dominio.Transferencia;
import excepciones.PersistenciaException;

/**
 *
 * @author alexa
 */
public interface ITransferenciasDAO {
    
    Transferencia consultar(Cliente codigo);
    
    Transferencia realizar(Integer cliente, Integer cuenta, float cantidad) throws PersistenciaException;
}
