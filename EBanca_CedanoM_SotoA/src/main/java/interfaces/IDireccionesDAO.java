/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;
import dominio.Direccion;
import excepciones.PersistenciaException;

/**
 *
 * @author alexa
 */
public interface IDireccionesDAO {
    //IN codigoDireccion INT,
    //IN nvaCalle VARCHAR(50), IN nvoNumero VARCHAR(50), IN nvaColonia VARCHAR(50))
    void actualizarDireccion(Integer codigoDireccion, String nvaCalle, 
            String nvoNumero, String nvaColonia) throws PersistenciaException;
}
