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
import interfaces.ITransferenciasDAO;
import java.awt.event.ItemEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import validador.Validadores;

/**
 *
 * @author koine
 */
public class DlgConsultar extends javax.swing.JDialog {
    private Cliente cliente = null;
    private Validadores val = new Validadores();
    private static final Logger LOG = Logger.getLogger(DlgRegistro.class.getName());
    
    private final IClientesDAO clientesDAO;
    private final ICuentasDAO cuentasDAO;
    private final ITransferenciasDAO transDAO;
    private int tamañoLista;
    private List<Cuenta> listaCuentas;
    /**
     * Creates new form DlgConsultar
     */
    public DlgConsultar(java.awt.Frame parent, boolean modal, IClientesDAO clientesDAO, Cliente cliente, ICuentasDAO cuentasDAO, ITransferenciasDAO transDAO) throws PersistenciaException {
        super(parent, modal);
        this.clientesDAO= clientesDAO;
        this.cliente = cliente;
        this.cuentasDAO = cuentasDAO;
        this.transDAO = transDAO;
        this.listaCuentas = null;
        this.tamañoLista = 0;
        initComponents();
        
        try{
            tamañoLista = cuentasDAO.consultarLista(cliente.getCodigo()).size();
            listaCuentas = cuentasDAO.consultarLista(cliente.getCodigo());
        }catch (PersistenciaException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No se pudo consultar la lista de cuentas");
        }
        for (int i = 0; i < tamañoLista; i++ ){
          this.cbxCuentas.addItem(listaCuentas.get(i).getCodigo().toString());
        }
        
        this.lblCliente.setText(cliente.getNombres()+" "+cliente.getApPaterno()+" "+cliente.getApMaterno());
        
        
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
        lblCuentas = new javax.swing.JLabel();
        lblConsultar = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();
        cbxCuentas = new javax.swing.JComboBox<>();
        lblSaldo = new javax.swing.JLabel();
        lblCliente1 = new javax.swing.JLabel();
        lblCantSaldo = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnTransferir = new javax.swing.JButton();
        txtEstado = new javax.swing.JTextField();
        lblCuenta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultar cuenta");
        setAlwaysOnTop(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(149, 194, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCuentas.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        lblCuentas.setForeground(new java.awt.Color(14, 47, 132));
        lblCuentas.setText("Cuenta(s):");
        jPanel2.add(lblCuentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 172, -1, -1));

        lblConsultar.setFont(new java.awt.Font("Microsoft YaHei", 1, 36)); // NOI18N
        lblConsultar.setForeground(new java.awt.Color(14, 47, 132));
        lblConsultar.setText("Consultar cuentas");
        jPanel2.add(lblConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 22, -1, -1));

        lblCliente.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 20)); // NOI18N
        lblCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblClienteMouseEntered(evt);
            }
        });
        jPanel2.add(lblCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 173, 29));

        cbxCuentas.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        cbxCuentas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxCuentasItemStateChanged(evt);
            }
        });
        cbxCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCuentasActionPerformed(evt);
            }
        });
        jPanel2.add(cbxCuentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 175, 141, 32));

        lblSaldo.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        lblSaldo.setForeground(new java.awt.Color(14, 47, 132));
        lblSaldo.setText("Saldo:");
        jPanel2.add(lblSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(316, 172, -1, -1));

        lblCliente1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        lblCliente1.setForeground(new java.awt.Color(14, 47, 132));
        lblCliente1.setText("Cliente:");
        jPanel2.add(lblCliente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 110, -1, -1));
        jPanel2.add(lblCantSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 174, 83, 33));

        btnCancelar.setBackground(new java.awt.Color(72, 77, 197));
        btnCancelar.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 239, 170, 50));

        btnTransferir.setBackground(new java.awt.Color(72, 77, 197));
        btnTransferir.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        btnTransferir.setForeground(new java.awt.Color(255, 255, 255));
        btnTransferir.setText("Consutlar");
        btnTransferir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferirActionPerformed(evt);
            }
        });
        jPanel2.add(btnTransferir, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 239, 160, 50));

        txtEstado.setEditable(false);
        txtEstado.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jPanel2.add(txtEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 170, 120, 40));

        lblCuenta.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        lblCuenta.setForeground(new java.awt.Color(14, 47, 132));
        lblCuenta.setText("Estado:");
        jPanel2.add(lblCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 750, 320));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 390));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTransferirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransferirActionPerformed
        
    }//GEN-LAST:event_btnTransferirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void lblClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblClienteMouseEntered
        // TODO add your handling code here:
        this.lblCliente.setText(cliente.getNombres() + " " + cliente.getApPaterno() + " " + cliente.getApMaterno());
    }//GEN-LAST:event_lblClienteMouseEntered

    private void cbxCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCuentasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxCuentasActionPerformed

    private void cbxCuentasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxCuentasItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            int codigoCuenta = Integer.parseInt(evt.getItem().toString());
            String estadoCuenta = cuentasDAO.consultar(codigoCuenta).getEstado();
            this.txtEstado.setText(estadoCuenta);
        }
    }//GEN-LAST:event_cbxCuentasItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnTransferir;
    private javax.swing.JComboBox<String> cbxCuentas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCantSaldo;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblCliente1;
    private javax.swing.JLabel lblConsultar;
    private javax.swing.JLabel lblCuenta;
    private javax.swing.JLabel lblCuentas;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JTextField txtEstado;
    // End of variables declaration//GEN-END:variables
}
