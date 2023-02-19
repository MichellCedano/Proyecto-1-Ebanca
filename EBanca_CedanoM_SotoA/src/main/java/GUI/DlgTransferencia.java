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
import validador.Validadores;

/**
 *
 * @author koine
 */
public class DlgTransferencia extends javax.swing.JDialog {
    private Cliente cliente = null;
    private Validadores val = new Validadores();
    private static final Logger LOG = Logger.getLogger(DlgRegistro.class.getName());
    
    private final IClientesDAO clientesDAO;
    private final ICuentasDAO cuentasDAO;
    
    private int tamañoLista;
    private List<Cuenta> listaCuentas;
    /**
     * Creates new form DlgTransferencia
     */
    public DlgTransferencia(java.awt.Frame parent, boolean modal, IClientesDAO clientesDAO, ICuentasDAO cuentasDAO , Cliente cliente) throws PersistenciaException {
        super(parent, modal);
        this.clientesDAO = clientesDAO;
        this.cuentasDAO = cuentasDAO;
        this.cliente = cliente;
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
        
        this.txtNombre.setText(cliente.getNombres()+" "+cliente.getApPaterno()+" "+cliente.getApMaterno());
        
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
        lblOrigen = new javax.swing.JLabel();
        txtCuentaDestino1 = new javax.swing.JTextField();
        lblCuenta = new javax.swing.JLabel();
        lblMonto = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        lblCliente = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblCuenta3 = new javax.swing.JLabel();
        cbxCuentas = new javax.swing.JComboBox<>();
        btnAceptar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lblDestino = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Transferencias");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(149, 194, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblOrigen.setFont(new java.awt.Font("Microsoft YaHei", 1, 36)); // NOI18N
        lblOrigen.setForeground(new java.awt.Color(14, 47, 132));
        lblOrigen.setText("Origen");
        jPanel2.add(lblOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, -1, -1));
        jPanel2.add(txtCuentaDestino1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 262, 49));

        lblCuenta.setFont(new java.awt.Font("Microsoft YaHei", 1, 36)); // NOI18N
        lblCuenta.setForeground(new java.awt.Color(14, 47, 132));
        lblCuenta.setText("Cuenta:");
        jPanel2.add(lblCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, -1));

        lblMonto.setFont(new java.awt.Font("Microsoft YaHei", 1, 36)); // NOI18N
        lblMonto.setForeground(new java.awt.Color(14, 47, 132));
        lblMonto.setText("Monto:");
        jPanel2.add(lblMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, -1, -1));
        jPanel2.add(txtMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, 133, 49));

        lblCliente.setFont(new java.awt.Font("Microsoft YaHei", 1, 36)); // NOI18N
        lblCliente.setForeground(new java.awt.Color(14, 47, 132));
        lblCliente.setText("Cliente:");
        jPanel2.add(lblCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        txtNombre.setEditable(false);
        txtNombre.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 262, 49));

        lblCuenta3.setFont(new java.awt.Font("Microsoft YaHei", 1, 36)); // NOI18N
        lblCuenta3.setForeground(new java.awt.Color(14, 47, 132));
        lblCuenta3.setText("Cuenta:");
        jPanel2.add(lblCuenta3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        cbxCuentas.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        jPanel2.add(cbxCuentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 256, 41));

        btnAceptar.setBackground(new java.awt.Color(72, 77, 197));
        btnAceptar.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptar.setText("Aceptar");
        jPanel2.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 470, 170, 70));

        jPanel4.setBackground(new java.awt.Color(56, 115, 205));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 510, 10));

        lblDestino.setFont(new java.awt.Font("Microsoft YaHei", 1, 36)); // NOI18N
        lblDestino.setForeground(new java.awt.Color(14, 47, 132));
        lblDestino.setText("Destino");
        jPanel2.add(lblDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, -1, -1));

        jButton1.setBackground(new java.awt.Color(72, 77, 197));
        jButton1.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 470, 170, 70));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 32, 510, 580));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 650));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JComboBox<String> cbxCuentas;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblCuenta;
    private javax.swing.JLabel lblCuenta3;
    private javax.swing.JLabel lblDestino;
    private javax.swing.JLabel lblMonto;
    private javax.swing.JLabel lblOrigen;
    private javax.swing.JTextField txtCuentaDestino1;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
