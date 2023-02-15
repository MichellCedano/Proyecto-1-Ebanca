 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author lv1013
 */
public class ConfiguracionPaginado {
    private int numPagina;
    private int elementosPagina;

    public ConfiguracionPaginado() {
        this.numPagina = 0;
        this.elementosPagina = 5;
    }

    public ConfiguracionPaginado(int numPagina, int elementosPagina) {
        this.numPagina = numPagina;
        this.elementosPagina = elementosPagina;
    }

    public int getNumPagina() {
        return numPagina;
    }

    public void setNumPagina(int numPagina) {
        this.numPagina = numPagina;
    }

    public int getElementosPagina() {
        return elementosPagina;
    }

    public void setElementosPagina(int elementosPagina) {
        this.elementosPagina = elementosPagina;
    }
    
    public int getOffset() {
        return this.numPagina * this.elementosPagina;
    }
    
    public void avanzarPagina() {
        this.numPagina++;
    }
    
    public void retrocederPagina() {
        while(this.numPagina > 0)
        this.numPagina--;
    }
}
