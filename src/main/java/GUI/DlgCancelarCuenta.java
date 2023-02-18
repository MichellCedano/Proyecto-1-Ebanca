/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import dominio.Cliente;
import interfaces.IClientesDAO;
import java.util.logging.Logger;

/**
 *
 * @author koine
 */
public class DlgCancelarCuenta extends javax.swing.JDialog {
    private Cliente cliente = null;
    private final IClientesDAO clientesDAO;
    private static final Logger LOG = Logger.getLogger(DlgRegistro.class.getName());
    /**
     * Creates new form DlgCancelarCuenta
     */
    public DlgCancelarCuenta(java.awt.Frame parent, boolean modal, IClientesDAO clientesDAO, Cliente cliente) {
        super(parent, modal);
        this.clientesDAO= clientesDAO;
        this.cliente = cliente;
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblCuenta = new javax.swing.JLabel();
        cbxCuentas = new javax.swing.JComboBox<>();
        lblCliente = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cancelar cuenta");
        setAlwaysOnTop(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(149, 194, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCuenta.setFont(new java.awt.Font("Microsoft YaHei", 1, 36)); // NOI18N
        lblCuenta.setForeground(new java.awt.Color(14, 47, 132));
        lblCuenta.setText("Cuenta:");
        jPanel2.add(lblCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        cbxCuentas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cbxCuentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 256, 41));

        lblCliente.setFont(new java.awt.Font("Microsoft YaHei", 1, 36)); // NOI18N
        lblCliente.setForeground(new java.awt.Color(14, 47, 132));
        lblCliente.setText("Cliente:");
        jPanel2.add(lblCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 210, 49));

        btnCancelar.setBackground(new java.awt.Color(72, 77, 197));
        btnCancelar.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 160, 50));

        btnAceptar.setBackground(new java.awt.Color(72, 77, 197));
        btnAceptar.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel2.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 160, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 450, 370));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 440));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        
    }//GEN-LAST:event_btnAceptarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<String> cbxCuentas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblCuenta;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
