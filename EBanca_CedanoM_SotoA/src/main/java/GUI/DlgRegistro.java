/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import dominio.Cliente;
import dominio.Direccion;
import excepciones.PersistenciaException;
import interfaces.IClientesDAO;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Platform.exit;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import validador.Validadores;

/**
 *
 * @author koine
 */
public class DlgRegistro extends javax.swing.JDialog {

    private Validadores val = new Validadores();
    private static final Logger LOG = Logger.getLogger(DlgRegistro.class.getName());

    private final IClientesDAO clientesDAO;

    /**
     * Constructor que incializa los atributos al valor de sus parámetros
     *
     * @param parent
     * @param modal
     * @param clientesDAO
     */
    public DlgRegistro(java.awt.Frame parent, boolean modal, IClientesDAO clientesDAO) {
        super(parent, modal);
        this.clientesDAO = clientesDAO;
        initComponents();
    }

    /**
     * Método que valida que los datos ingresados sean correctos
     *
     * @return Cliente validado
     */
    private Cliente validadorCliente() {
        Cliente cliente = null;
        if (!val.validaCadena(30, this.txtNombre.getText())) {
            JOptionPane.showMessageDialog(this, "No fue posible agregar al cliente: El nombre no es valido", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (!val.validaCadena(30, this.txtApellidoP.getText())) {
            JOptionPane.showMessageDialog(this, "No fue posible agregar al cliente: El apellido paterno no es valido", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (!val.validaCadena(30, this.txtApellidoM.getText())) {
            JOptionPane.showMessageDialog(this, "No fue posible agregar al cliente: El apellido materno no es valido", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (!val.validaEntero(this.txtPin2.getText())) {
            JOptionPane.showMessageDialog(this, "No fue posible agregar al cliente: El pin no es valido", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            String nombres = this.txtNombre.getText();
            Integer codigoDireccion = 2;
            Integer nip = Integer.parseInt(this.txtPin2.getText());
            String apPaterno = this.txtApellidoP.getText();
            String apMaterno = this.txtApellidoM.getText();
            cliente = new Cliente(nombres, apPaterno, apMaterno, codigoDireccion, nip);

            return cliente;
        }
        return cliente;
    }

    /**
     * Método que valida que los datos de una dirección sean correctos
     *
     * @return Direccion validada
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
     * Método que valida la fecha de nacimiento
     *
     * @return String con la fecha de nacimiento valida
     */
    private String validarFechaNacimiento() {
        int dia = Integer.parseInt(this.cmbDia.getSelectedItem().toString());
        int mes = Integer.parseInt(this.cmbMes.getSelectedItem().toString());
        int anio = Integer.parseInt(this.cmbAnio.getSelectedItem().toString());
        return anio + "-" + mes + "-" + dia;
    }

    /**
     * Método que guarda los datos del cliente
     */
    private void guardar() {

        try {
            Direccion direccion = validadorDireccion();
            Cliente cliente = validadorCliente();
            String fecha = validarFechaNacimiento();
            this.clientesDAO.insertar(cliente, direccion, fecha);
            JOptionPane.showMessageDialog(this, "Se agrego al cliente: " + cliente.getCodigo(), "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
        } catch (PersistenciaException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            JOptionPane.showMessageDialog(this, "No fue posible agregar al cliente: ", "ERROR", JOptionPane.ERROR_MESSAGE);
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
        lblNombre = new javax.swing.JLabel();
        lblApellidoPaterno = new javax.swing.JLabel();
        lblApellidoMaterno = new javax.swing.JLabel();
        lblNumeroCasa = new javax.swing.JLabel();
        lblColonia = new javax.swing.JLabel();
        lblCasa = new javax.swing.JLabel();
        lblFechaNacimiento = new javax.swing.JLabel();
        lblPin = new javax.swing.JLabel();
        lblRegistro = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        txtApellidoP = new javax.swing.JTextField();
        txtApellidoM = new javax.swing.JTextField();
        cmbDia = new javax.swing.JComboBox<>();
        cmbMes = new javax.swing.JComboBox<>();
        cmbAnio = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        txtCalle = new javax.swing.JTextField();
        txtColonia = new javax.swing.JTextField();
        txtNumCasa = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtPin2 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(640, 772));
        setResizable(false);
        setSize(new java.awt.Dimension(640, 772));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(149, 194, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombre.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(14, 47, 132));
        lblNombre.setText("Nombre(s):");
        jPanel2.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        lblApellidoPaterno.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        lblApellidoPaterno.setForeground(new java.awt.Color(14, 47, 132));
        lblApellidoPaterno.setText("Apellido paterno:");
        jPanel2.add(lblApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));

        lblApellidoMaterno.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        lblApellidoMaterno.setForeground(new java.awt.Color(14, 47, 132));
        lblApellidoMaterno.setText("Apellido materno:");
        jPanel2.add(lblApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, -1));

        lblNumeroCasa.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        lblNumeroCasa.setForeground(new java.awt.Color(14, 47, 132));
        lblNumeroCasa.setText("Numero casa:");
        jPanel2.add(lblNumeroCasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, -1, -1));

        lblColonia.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        lblColonia.setForeground(new java.awt.Color(14, 47, 132));
        lblColonia.setText("Colonia");
        jPanel2.add(lblColonia, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, -1, 20));

        lblCasa.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        lblCasa.setForeground(new java.awt.Color(14, 47, 132));
        lblCasa.setText("Calle");
        jPanel2.add(lblCasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, -1, -1));

        lblFechaNacimiento.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        lblFechaNacimiento.setForeground(new java.awt.Color(14, 47, 132));
        lblFechaNacimiento.setText("Fecha nacimiento:");
        jPanel2.add(lblFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, -1, -1));

        lblPin.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        lblPin.setForeground(new java.awt.Color(14, 47, 132));
        lblPin.setText("Pin");
        jPanel2.add(lblPin, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 590, -1, -1));

        lblRegistro.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        lblRegistro.setForeground(new java.awt.Color(14, 47, 132));
        lblRegistro.setText("Registro Cliente");
        jPanel2.add(lblRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));

        lblDireccion.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        lblDireccion.setForeground(new java.awt.Color(14, 47, 132));
        lblDireccion.setText("Dirección");
        jPanel2.add(lblDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, -1, -1));

        txtNombre.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 213, 34));

        jPanel3.setBackground(new java.awt.Color(56, 115, 205));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 504, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, -1, -1));

        txtApellidoP.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        txtApellidoP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoPKeyTyped(evt);
            }
        });
        jPanel2.add(txtApellidoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 213, 40));

        txtApellidoM.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        txtApellidoM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoMKeyTyped(evt);
            }
        });
        jPanel2.add(txtApellidoM, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 210, 40));

        cmbDia.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        cmbDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jPanel2.add(cmbDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 60, -1));

        cmbMes.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        cmbMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        jPanel2.add(cmbMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, 60, -1));

        cmbAnio.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        cmbAnio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004" }));
        cmbAnio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAnioActionPerformed(evt);
            }
        });
        jPanel2.add(cmbAnio, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 260, 90, -1));

        jPanel4.setBackground(new java.awt.Color(56, 115, 205));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 504, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, -1));

        txtCalle.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        txtCalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCalleKeyTyped(evt);
            }
        });
        jPanel2.add(txtCalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, 230, 40));

        txtColonia.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        txtColonia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtColoniaKeyTyped(evt);
            }
        });
        jPanel2.add(txtColonia, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 430, 230, 40));

        txtNumCasa.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        txtNumCasa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumCasaKeyTyped(evt);
            }
        });
        jPanel2.add(txtNumCasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 490, 230, 40));

        btnGuardar.setBackground(new java.awt.Color(72, 77, 197));
        btnGuardar.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 650, 160, 50));

        btnCancelar.setBackground(new java.awt.Color(72, 77, 197));
        btnCancelar.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 650, 170, 50));

        txtPin2.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        txtPin2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPin2KeyTyped(evt);
            }
        });
        jPanel2.add(txtPin2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 580, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 580, 720));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 780));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        int key = evt.getKeyChar();

        boolean mayusculas = key >= 65 && key <= 90;
        boolean minusculas = key >= 97 && key <= 122;
        boolean espacio = key == 32;
        
        if(txtNombre.getText().length() >= 31)
        {
            evt.consume();
        }
        
         if (!(minusculas || mayusculas || espacio))
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtNumCasaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumCasaKeyTyped
        if(this.txtNumCasa.getText().length() >= 10)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtNumCasaKeyTyped

    private void txtApellidoPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoPKeyTyped
        int key = evt.getKeyChar();

        boolean mayusculas = key >= 65 && key <= 90;
        boolean minusculas = key >= 97 && key <= 122;
        boolean espacio = key == 32;
        
        if(txtApellidoP.getText().length() >= 31)
        {
            evt.consume();
        }
        
         if (!(minusculas || mayusculas || espacio))
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtApellidoPKeyTyped

    private void txtApellidoMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoMKeyTyped
        int key = evt.getKeyChar();

        boolean mayusculas = key >= 65 && key <= 90;
        boolean minusculas = key >= 97 && key <= 122;
        boolean espacio = key == 32;
        
        if(txtApellidoM.getText().length() >= 31)
        {
            evt.consume();
        }
        
         if (!(minusculas || mayusculas || espacio))
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtApellidoMKeyTyped

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardar();
        dispose();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtCalleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCalleKeyTyped
        if(this.txtCalle.getText().length() >= 50)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtCalleKeyTyped

    private void txtColoniaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtColoniaKeyTyped
        if(this.txtColonia.getText().length() >= 50)
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtColoniaKeyTyped

    private void cmbAnioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAnioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbAnioActionPerformed

    private void txtPin2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPin2KeyTyped
        // TODO add your handling code here:
         int key = evt.getKeyChar();
        boolean numeros = key >= 48 && key <= 57;
        if (!numeros) {
            evt.consume();
        }
        if (txtPin2.getText().trim().length() == 4) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPin2KeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cmbAnio;
    private javax.swing.JComboBox<String> cmbDia;
    private javax.swing.JComboBox<String> cmbMes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblApellidoMaterno;
    private javax.swing.JLabel lblApellidoPaterno;
    private javax.swing.JLabel lblCasa;
    private javax.swing.JLabel lblColonia;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblFechaNacimiento;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNumeroCasa;
    private javax.swing.JLabel lblPin;
    private javax.swing.JLabel lblRegistro;
    private javax.swing.JTextField txtApellidoM;
    private javax.swing.JTextField txtApellidoP;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JTextField txtColonia;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumCasa;
    private javax.swing.JPasswordField txtPin2;
    // End of variables declaration//GEN-END:variables
}
