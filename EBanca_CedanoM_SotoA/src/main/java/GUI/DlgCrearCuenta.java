/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import dominio.Cliente;
import dominio.Cuenta;
import excepciones.PersistenciaException;
import interfaces.IClientesDAO;
import interfaces.ICuentasDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import validador.Validadores;

/**
 *
 * @author koine
 */
public class DlgCrearCuenta extends javax.swing.JDialog {

    private Cliente cliente = null;
    private Cuenta cuenta = null;
    private Validadores val = new Validadores();
    private static final Logger LOG = Logger.getLogger(DlgRegistro.class.getName());

    private final IClientesDAO clientesDAO;
    private final ICuentasDAO cuentasDAO;

    /**
     * Constructor que inicializa los atributos al valor de sus parámetros
     *
     * @param parent
     * @param modal
     * @param clientesDAO
     * @param cuentasDAO
     * @param cliente
     */
    public DlgCrearCuenta(java.awt.Frame parent, boolean modal, IClientesDAO clientesDAO, ICuentasDAO cuentasDAO, Cliente cliente) {
        super(parent, modal);
        this.clientesDAO = clientesDAO;
        this.cuentasDAO = cuentasDAO;
        this.cliente = cliente;
        initComponents();

        this.lblClienteNombre.setText(cliente.getNombres() + " " + cliente.getApPaterno() + " " + cliente.getApMaterno());

    }

    /**
     * Método que guarda la cuenta según los datos registrados
     */
    private void guardar() {
        Cuenta cuenta = new Cuenta();
        try {
            cuenta.setCodigoCliente(cliente.getCodigo());
            cuenta.setSaldo(Float.parseFloat(this.txtSaldo.getText()));
            cuentasDAO.insertar(cuenta);
            JOptionPane.showMessageDialog(this, "Se agrego la cuenta: " + cuenta.getCodigo(), "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
        } catch (PersistenciaException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            JOptionPane.showMessageDialog(this, "No fue posible agregar la cuenta ", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
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
        lblSaldo = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        txtSaldo = new javax.swing.JTextField();
        lblCliente = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        lblClienteNombre = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Crear cuenta");
        setAlwaysOnTop(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(149, 194, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSaldo.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        lblSaldo.setForeground(new java.awt.Color(14, 47, 132));
        lblSaldo.setText("Saldo inicial:");
        jPanel2.add(lblSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        lblTitulo.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(14, 47, 132));
        lblTitulo.setText("Crear cuenta");
        jPanel2.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, -1, -1));

        txtSaldo.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        txtSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSaldoActionPerformed(evt);
            }
        });
        jPanel2.add(txtSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 140, 50));

        lblCliente.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        lblCliente.setForeground(new java.awt.Color(14, 47, 132));
        lblCliente.setText("Cliente:");
        jPanel2.add(lblCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        btnCancelar.setBackground(new java.awt.Color(72, 77, 197));
        btnCancelar.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 120, 50));

        btnGuardar.setBackground(new java.awt.Color(72, 77, 197));
        btnGuardar.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 120, 50));

        lblClienteNombre.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        lblClienteNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblClienteNombreMouseEntered(evt);
            }
        });
        jPanel2.add(lblClienteNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 170, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 380, 310));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 370));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardar();
        dispose();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void lblClienteNombreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblClienteNombreMouseEntered

    }//GEN-LAST:event_lblClienteNombreMouseEntered

    private void txtSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSaldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSaldoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblClienteNombre;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtSaldo;
    // End of variables declaration//GEN-END:variables
}
