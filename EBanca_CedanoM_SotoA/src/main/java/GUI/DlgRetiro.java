/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import dominio.Cliente;
import interfaces.IClientesDAO;
import java.util.logging.Logger;
import validador.Validadores;

/**
 *
 * @author koine
 */
public class DlgRetiro extends javax.swing.JDialog {
    private Validadores val = new Validadores();
    private static final Logger LOG = Logger.getLogger(DlgRegistro.class.getName());
    
    private final IClientesDAO clientesDAO;
    
    /**
     * Creates new form DlgRetiro
     * @param parent
     */
    public DlgRetiro(java.awt.Frame parent, boolean modal, IClientesDAO clientesDAO) {
        super(parent, modal);
        this.clientesDAO= clientesDAO;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
