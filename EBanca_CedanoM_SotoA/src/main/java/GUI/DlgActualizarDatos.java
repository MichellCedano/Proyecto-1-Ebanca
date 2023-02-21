/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import dominio.Cliente;
import dominio.Direccion;
import excepciones.PersistenciaException;
import interfaces.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import validador.Validadores;

/**
 *
 * @author koine
 */
public class DlgActualizarDatos extends javax.swing.JDialog {

    private Cliente cliente = null;
    private Validadores val = new Validadores();
    private static final Logger LOG = Logger.getLogger(DlgRegistro.class.getName());

    private final IClientesDAO clientesDAO;
    private final IDireccionesDAO direccionDAO;

    /**
     * Creates new form DlgActualizarDatos
     */
    public DlgActualizarDatos(java.awt.Frame parent, boolean modal, IClientesDAO clientesDAO, Cliente cliente, IDireccionesDAO direccionDAO) {
        super(parent, modal);
        this.clientesDAO = clientesDAO;
        this.cliente = cliente;
        this.direccionDAO = direccionDAO;
        initComponents();
    }

    /**
     * Método que valida los datos del cliente
     *
     * @return Cliente con los datos correctos
     */
    private Cliente validadorCliente() {
        Cliente cliente = null;

        if (!val.validaCadena(30, this.txtApellidoP.getText())) {
            JOptionPane.showMessageDialog(this, "No fue posible agregar al cliente: El apellido paterno no es valido", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (!val.validaCadena(30, this.txtApellidoM.getText())) {
            JOptionPane.showMessageDialog(this, "No fue posible agregar al cliente: El apellido materno no es valido", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {

            String nombres = this.txtNombre.getText();
            String apPaterno = this.txtApellidoP.getText();
            String apMaterno = this.txtApellidoM.getText();
            cliente = new Cliente(this.cliente.getCodigo(), nombres, apPaterno, apMaterno);
            return cliente;
        }
        return cliente;
    }

    /**
     * Método que valida los datos de una dirección
     *
     * @return Dirección con los datos correctos
     */
    private Direccion validadorDireccion() {
        Direccion direccion = null;
        if (val.cadenaVacia(this.txtCalle.getText())) {
            JOptionPane.showMessageDialog(this, "No fue posible agregar al cliente: La calle no es valida", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (val.cadenaVacia(this.txtColonia.getText())) {
            JOptionPane.showMessageDialog(this, "No fue posible agregar al cliente: La colonia no es valida", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (val.cadenaVacia(this.txtNumCasa.getText())) {
            JOptionPane.showMessageDialog(this, "No fue posible agregar al cliente: El numero de casa no es valido", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            String numCasa = this.txtNumCasa.getText();
            String calle = this.txtCalle.getText();
            String colonia = this.txtColonia.getText();
            direccion = new Direccion(calle, colonia, numCasa);

            return direccion;
        }
        return direccion;
    }

    /**
     * Método que guarda los datos personales del cliente
     */
    private void guardarDatosPersonales() {

        try {
            Cliente cliente = validadorCliente();
            this.clientesDAO.actualizarDatosPersonales(cliente.getCodigo(), cliente.getNombres(),
                    cliente.getApPaterno(), cliente.getApMaterno());
            JOptionPane.showMessageDialog(this, "Se actualizó al cliente: " + cliente.getCodigo(), "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
        } catch (PersistenciaException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            JOptionPane.showMessageDialog(this, "No fue posible actualizar al cliente: ", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * Método que guarda los datos de la dirección
     */
    private void guardarDireccion() {

        try {
            Direccion direccion = validadorDireccion();
            this.direccionDAO.actualizarDireccion(cliente.getCodigoDireccion(),
                    direccion.getCalle(), direccion.getNumeroCasa(), direccion.getColonia());
            JOptionPane.showMessageDialog(this, "Se actualizó la dirección: " + cliente.getCodigoDireccion(), "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
        } catch (PersistenciaException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            JOptionPane.showMessageDialog(this, "No fue posible actualizar la dirección ", "ERROR", JOptionPane.ERROR_MESSAGE);
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
        lblActualizar = new javax.swing.JLabel();
        lblApellidoPaterno = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellidoMaterno = new javax.swing.JLabel();
        txtApellidoP = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellidoM = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        lblActualizar1 = new javax.swing.JLabel();
        lblCasa = new javax.swing.JLabel();
        lblColonia = new javax.swing.JLabel();
        lblNumeroCasa = new javax.swing.JLabel();
        txtCalle = new javax.swing.JTextField();
        txtColonia = new javax.swing.JTextField();
        txtNumCasa = new javax.swing.JTextField();
        btnAceptarDireccion = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnAceptarDatos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Actualizar datos");
        setAlwaysOnTop(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(149, 194, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblActualizar.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        lblActualizar.setForeground(new java.awt.Color(14, 47, 132));
        lblActualizar.setText("Dirección");
        jPanel2.add(lblActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, -1, -1));

        lblApellidoPaterno.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        lblApellidoPaterno.setForeground(new java.awt.Color(14, 47, 132));
        lblApellidoPaterno.setText("Apellido paterno:");
        jPanel2.add(lblApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        lblNombre.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(14, 47, 132));
        lblNombre.setText("Nombre(s):");
        jPanel2.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        lblApellidoMaterno.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        lblApellidoMaterno.setForeground(new java.awt.Color(14, 47, 132));
        lblApellidoMaterno.setText("Apellido materno:");
        jPanel2.add(lblApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        txtApellidoP.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        txtApellidoP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoPKeyTyped(evt);
            }
        });
        jPanel2.add(txtApellidoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 213, 40));

        txtNombre.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 213, 34));

        txtApellidoM.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        txtApellidoM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoMKeyTyped(evt);
            }
        });
        jPanel2.add(txtApellidoM, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 210, 40));

        jPanel4.setBackground(new java.awt.Color(56, 115, 205));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 470, -1));

        lblActualizar1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        lblActualizar1.setForeground(new java.awt.Color(14, 47, 132));
        lblActualizar1.setText("Actualizar datos");
        jPanel2.add(lblActualizar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        lblCasa.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        lblCasa.setForeground(new java.awt.Color(14, 47, 132));
        lblCasa.setText("Calle");
        jPanel2.add(lblCasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, -1, -1));

        lblColonia.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        lblColonia.setForeground(new java.awt.Color(14, 47, 132));
        lblColonia.setText("Colonia");
        jPanel2.add(lblColonia, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, -1, 20));

        lblNumeroCasa.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        lblNumeroCasa.setForeground(new java.awt.Color(14, 47, 132));
        lblNumeroCasa.setText("Número casa:");
        jPanel2.add(lblNumeroCasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 510, -1, -1));

        txtCalle.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        txtCalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCalleKeyTyped(evt);
            }
        });
        jPanel2.add(txtCalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 380, 230, 40));

        txtColonia.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        jPanel2.add(txtColonia, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 440, 230, 40));

        txtNumCasa.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        txtNumCasa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumCasaKeyTyped(evt);
            }
        });
        jPanel2.add(txtNumCasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 500, 230, 40));

        btnAceptarDireccion.setBackground(new java.awt.Color(72, 77, 197));
        btnAceptarDireccion.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        btnAceptarDireccion.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptarDireccion.setText("Aceptar");
        btnAceptarDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarDireccionActionPerformed(evt);
            }
        });
        jPanel2.add(btnAceptarDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 560, 160, 50));

        btnCancelar.setBackground(new java.awt.Color(72, 77, 197));
        btnCancelar.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("X");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 50, 40));

        btnAceptarDatos.setBackground(new java.awt.Color(72, 77, 197));
        btnAceptarDatos.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        btnAceptarDatos.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptarDatos.setText("Aceptar");
        btnAceptarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarDatosActionPerformed(evt);
            }
        });
        jPanel2.add(btnAceptarDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 160, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 490, 640));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 710));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        int key = evt.getKeyChar();

        boolean mayusculas = key >= 65 && key <= 90;
        boolean minusculas = key >= 97 && key <= 122;
        boolean espacio = key == 32;

        if (txtNombre.getText().length() >= 31) {
            evt.consume();
        }

        if (!(minusculas || mayusculas || espacio)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApellidoPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoPKeyTyped
        int key = evt.getKeyChar();

        boolean mayusculas = key >= 65 && key <= 90;
        boolean minusculas = key >= 97 && key <= 122;
        boolean espacio = key == 32;

        if (txtApellidoP.getText().length() >= 31) {
            evt.consume();
        }

        if (!(minusculas || mayusculas || espacio)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtApellidoPKeyTyped

    private void txtApellidoMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoMKeyTyped
        int key = evt.getKeyChar();

        boolean mayusculas = key >= 65 && key <= 90;
        boolean minusculas = key >= 97 && key <= 122;
        boolean espacio = key == 32;

        if (txtApellidoM.getText().length() >= 31) {
            evt.consume();
        }

        if (!(minusculas || mayusculas || espacio)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtApellidoMKeyTyped

    private void txtCalleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCalleKeyTyped
        if (this.txtCalle.getText().length() >= 50) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCalleKeyTyped

    private void txtNumCasaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumCasaKeyTyped
        int key = evt.getKeyChar();
        boolean numeros = key >= 48 && key <= 57;
        if (!numeros) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNumCasaKeyTyped

    private void btnAceptarDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarDireccionActionPerformed
        // TODO add your handling code here:
        this.guardarDireccion();
    }//GEN-LAST:event_btnAceptarDireccionActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarDatosActionPerformed
        // TODO add your handling code here:
        this.guardarDatosPersonales();
    }//GEN-LAST:event_btnAceptarDatosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptarDatos;
    private javax.swing.JButton btnAceptarDireccion;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblActualizar;
    private javax.swing.JLabel lblActualizar1;
    private javax.swing.JLabel lblApellidoMaterno;
    private javax.swing.JLabel lblApellidoPaterno;
    private javax.swing.JLabel lblCasa;
    private javax.swing.JLabel lblColonia;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNumeroCasa;
    private javax.swing.JTextField txtApellidoM;
    private javax.swing.JTextField txtApellidoP;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JTextField txtColonia;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumCasa;
    // End of variables declaration//GEN-END:variables
}
