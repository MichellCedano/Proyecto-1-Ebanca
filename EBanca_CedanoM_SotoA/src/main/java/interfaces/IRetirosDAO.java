/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Cliente;
import dominio.Retiro;

/**
 *
 * @author alexa
 */
public interface IRetirosDAO {
    
    Retiro consultar(Cliente codigo);
    
    Retiro retirar();
}
