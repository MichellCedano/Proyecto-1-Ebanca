/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;
import java.util.Random;
/**
 *
 * @author alexa
 */
public class Utilerias {
    
    public static String generarContrasenia(int numeroCaracteres) {
        int leftLimit = 48; // caracter '0'
        int rightLimit = 57; // caracter '9'
        Random random = new Random();
        String contrasenia = random.ints(leftLimit, rightLimit + 1)
          .limit(numeroCaracteres)
          .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
          .toString();
        return contrasenia;
    }
}
