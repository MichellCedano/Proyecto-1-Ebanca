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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author koine
 */
public class DlgCancelarCuenta extends javax.swing.JDialog {

    private Cliente cliente = null;
    private final IClientesDAO clientesDAO;
    private final ICuentasDAO cuentasDAO;
    private Cuenta cuenta = null;
    private static final Logger LOG = Logger.getLogger(DlgRegistro.class.getName());
    private int tamañoLista;
    private List<Cuenta> listaCuentas;

    /**
     * Constructor que inicializa todos los atributos al valor de sus parámetros
     *
     * @param parent
     * @param modal
     * @param clientesDAO
     * @param cuentasDAO
     * @param cliente
     * @throws PersistenciaException
     */
    public DlgCancelarCuenta(java.awt.Frame parent, boolean modal, IClientesDAO clientesDAO, ICuentasDAO cuentasDAO, Cliente cliente) throws PersistenciaException {
        super(parent, modal);
        this.cuentasDAO = cuentasDAO;
        this.clientesDAO = clientesDAO;
        this.cliente = cliente;
        this.listaCuentas = null;
        this.tamañoLista = 0;
        initComponents();

        try {
            tamañoLista = cuentasDAO.consultarLista(cliente.getCodigo()).size();
            listaCuentas = cuentasDAO.consultarLista(cliente.getCodigo());
        } catch (PersistenciaException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No se pudo consultar la lista de cuentas");
        }
        for (int i = 0; i < tamañoLista; i++) {
            if (listaCuentas.get(i).getEstado().equals("activo")) {
                this.cbxCuentas.addItem(listaCuentas.get(i).getCodigo().toString());
            }
        }
        this.txtNombre.setText(cliente.getNombres() + " " + cliente.getApPaterno() + " " + cliente.getApMaterno());
    }

    /**
     * Método que actualiza el estado de una cuenta
     */
    private void actualizarEstado() {
        Cuenta cuenta = new Cuenta();
        cuenta.setCodigo(Integer.parseInt(cbxCuentas.getSelectedItem().toString()));
        try {
            cuentasDAO.actualizarEstado(cuenta);
            JOptionPane.showMessageDialog(this, "Se canceló la cuenta: " + cuenta.getCodigo(), "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
        } catch (PersistenciaException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            JOptionPane.showMessageDialog(this, "No fue posible cancelar la cuenta ", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        //TODO: label que muestre si esta activa o cancelada la cuenta
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
        cbxCuentas = new javax.swing.JComboBox<>();
        lblCliente = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblCuenta1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cancelar cuenta");
        setAlwaysOnTop(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(149, 194, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbxCuentas.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        jPanel2.add(cbxCuentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 220, 50));

        lblCliente.setFont(new java.awt.Font("Microsoft YaHei", 1, 36)); // NOI18N
        lblCliente.setForeground(new java.awt.Color(14, 47, 132));
        lblCliente.setText("Cliente:");
        jPanel2.add(lblCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        txtNombre.setEditable(false);
        txtNombre.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 210, 49));

        btnCancelar.setBackground(new java.awt.Color(72, 77, 197));
        btnCancelar.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, 160, 50));

        btnAceptar.setBackground(new java.awt.Color(72, 77, 197));
        btnAceptar.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel2.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 160, 50));

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(14, 47, 132));
        jLabel1.setText("Cancelar cuenta");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, -1, -1));

        lblCuenta1.setFont(new java.awt.Font("Microsoft YaHei", 1, 36)); // NOI18N
        lblCuenta1.setForeground(new java.awt.Color(14, 47, 132));
        lblCuenta1.setText("Cuenta:");
        jPanel2.add(lblCuenta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 510, 370));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 440));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        actualizarEstado();
    }//GEN-LAST:event_btnAceptarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<String> cbxCuentas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblCuenta1;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
