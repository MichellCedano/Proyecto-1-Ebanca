/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import dominio.Cliente;
import dominio.Cuenta;
import dominio.Retiro;
import dominio.Transferencia;
import excepciones.PersistenciaException;
import interfaces.IClientesDAO;
import interfaces.ICuentasDAO;
import interfaces.IRetirosDAO;
import interfaces.ITransferenciasDAO;
import java.awt.event.ItemEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import utils.ConfiguracionPaginado;
import validador.Validadores;

/**
 *
 * @author koine
 */
public class DlgConsultar extends javax.swing.JDialog {

    private Cliente cliente = null;
    private Validadores val = new Validadores();
    private static final Logger LOG = Logger.getLogger(DlgConsultar.class.getName());

    private final IClientesDAO clientesDAO;
    private final ICuentasDAO cuentasDAO;
    private final ITransferenciasDAO transDAO;
    private final IRetirosDAO retiroDAO;
    private int tamañoLista;
    private List<Cuenta> listaCuentas;
    private ConfiguracionPaginado paginado;
    private ConfiguracionPaginado paginadoRetiro;

    /**
     * Constructor que inicializa los atributos al valor de sus parámetros
     *
     * @param parent
     * @param modal
     * @param clientesDAO
     * @param cliente
     * @param cuentasDAO
     * @param transDAO
     * @param retiroDAO
     * @throws PersistenciaException
     */
    public DlgConsultar(java.awt.Frame parent, boolean modal, IClientesDAO clientesDAO, Cliente cliente, ICuentasDAO cuentasDAO, ITransferenciasDAO transDAO, IRetirosDAO retiroDAO) throws PersistenciaException {
        super(parent, modal);
        this.clientesDAO = clientesDAO;
        this.cliente = cliente;
        this.cuentasDAO = cuentasDAO;
        this.transDAO = transDAO;
        this.retiroDAO = retiroDAO;
        this.listaCuentas = null;
        this.tamañoLista = 0;
        initComponents();
        this.paginado = new ConfiguracionPaginado(0, 3);
        this.paginadoRetiro = new ConfiguracionPaginado(0, 3);

        try {
            tamañoLista = cuentasDAO.consultarLista(cliente.getCodigo()).size();
            listaCuentas = cuentasDAO.consultarLista(cliente.getCodigo());
        } catch (PersistenciaException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No se pudo consultar la lista de cuentas");
        }
        for (int i = 0; i < tamañoLista; i++) {
            this.cbxCuentas.addItem(listaCuentas.get(i).getCodigo().toString());
        }
        this.lblCliente.setText(cliente.getNombres() + " " + cliente.getApPaterno() + " " + cliente.getApMaterno());
    }

    /**
     * Método que llena la tabla de transferencias
     */
    private void llenarTablaTransferencias() {
        try {
            Integer codigoCuenta = Integer.parseInt(this.cbxCuentas.getSelectedItem().toString());
            List<Transferencia> listaTransferencias = this.transDAO.consultarLista(paginado, codigoCuenta);
            DefaultTableModel modeloTabla = (DefaultTableModel) this.tblTransferencias.getModel();
            modeloTabla.setRowCount(0);
            for (Transferencia trans : listaTransferencias) {
                Object[] fila = {
                    trans.getFechaTransferencia().toString(),
                    trans.getCodigoDestino(),
                    trans.getCantidad()
                };
                modeloTabla.addRow(fila);
            }
        } catch (PersistenciaException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
        }
    }

    /**
     * Método que llena la tabla de retiros
     */
    private void llenarTablaRetiros() {
        try {
            Integer codigoCuenta = Integer.parseInt(this.cbxCuentas.getSelectedItem().toString());
            List<Retiro> listaRetiros = this.retiroDAO.consultarLista(paginadoRetiro, codigoCuenta);
            DefaultTableModel modeloTabla = (DefaultTableModel) this.tblRetiros.getModel();
            modeloTabla.setRowCount(0);
            for (Retiro retiro : listaRetiros) {
                Object[] fila = {
                    retiro.getFechaRetiro().toString(),
                    retiro.getCantidad()
                };
                modeloTabla.addRow(fila);
            }
        } catch (PersistenciaException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
        }
    }

    /**
     * Método que avanza de página de transferencias
     */
    private void avanzarPaginaTransferencias() {
        this.paginado.avanzarPagina();
        this.llenarTablaTransferencias();
    }

    /**
     * Método que retrocede de página de transferencias
     */
    private void retrocederPaginaTransferencias() {
        this.paginado.retrocederPagina();
        this.llenarTablaTransferencias();
    }

    /**
     * Método que avanza de página de retiros
     */
    private void avanzarPaginaRetiros() {
        this.paginadoRetiro.avanzarPagina();
        this.llenarTablaRetiros();
    }

    /**
     * Método que retrocede de página de retiros
     */
    private void retrocederPaginaRetiros() {
        this.paginadoRetiro.retrocederPagina();
        this.llenarTablaRetiros();
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
        btnCancelar = new javax.swing.JButton();
        btnTransferencias = new javax.swing.JButton();
        txtSaldo = new javax.swing.JTextField();
        lblCuenta = new javax.swing.JLabel();
        btnRetiros = new javax.swing.JButton();
        cbxElementosPagina = new javax.swing.JComboBox<>();
        btnRetroceder = new javax.swing.JButton();
        btnAvanzar = new javax.swing.JButton();
        pnlTransferencias = new javax.swing.JScrollPane();
        tblTransferencias = new javax.swing.JTable();
        pnlRetiros = new javax.swing.JScrollPane();
        tblRetiros = new javax.swing.JTable();
        txtEstado = new javax.swing.JTextField();
        btnAvanzarRetiros = new javax.swing.JButton();
        btnRetrocederRetiros = new javax.swing.JButton();
        cbxElementosPaginaRetiros = new javax.swing.JComboBox<>();

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
        jPanel2.add(lblConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

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
        jPanel2.add(lblSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, -1));

        lblCliente1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        lblCliente1.setForeground(new java.awt.Color(14, 47, 132));
        lblCliente1.setText("Cliente:");
        jPanel2.add(lblCliente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 110, -1, -1));

        btnCancelar.setBackground(new java.awt.Color(72, 77, 197));
        btnCancelar.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("X");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 0, 60, 60));

        btnTransferencias.setBackground(new java.awt.Color(72, 77, 197));
        btnTransferencias.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        btnTransferencias.setForeground(new java.awt.Color(255, 255, 255));
        btnTransferencias.setText("Transferencias");
        btnTransferencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferenciasActionPerformed(evt);
            }
        });
        jPanel2.add(btnTransferencias, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, 180, 50));

        txtSaldo.setEditable(false);
        txtSaldo.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jPanel2.add(txtSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 120, 40));

        lblCuenta.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        lblCuenta.setForeground(new java.awt.Color(14, 47, 132));
        lblCuenta.setText("Estado:");
        jPanel2.add(lblCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, -1));

        btnRetiros.setBackground(new java.awt.Color(72, 77, 197));
        btnRetiros.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        btnRetiros.setForeground(new java.awt.Color(255, 255, 255));
        btnRetiros.setText("Retiros");
        btnRetiros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetirosActionPerformed(evt);
            }
        });
        jPanel2.add(btnRetiros, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 350, 160, 50));

        cbxElementosPagina.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        cbxElementosPagina.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3", "5", "10" }));
        cbxElementosPagina.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxElementosPaginaItemStateChanged(evt);
            }
        });
        jPanel2.add(cbxElementosPagina, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 410, 60, 30));

        btnRetroceder.setBackground(new java.awt.Color(72, 77, 197));
        btnRetroceder.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 15)); // NOI18N
        btnRetroceder.setForeground(new java.awt.Color(255, 255, 255));
        btnRetroceder.setText("<--");
        btnRetroceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetrocederActionPerformed(evt);
            }
        });
        jPanel2.add(btnRetroceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 410, 70, -1));

        btnAvanzar.setBackground(new java.awt.Color(72, 77, 197));
        btnAvanzar.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 15)); // NOI18N
        btnAvanzar.setForeground(new java.awt.Color(255, 255, 255));
        btnAvanzar.setText("-->");
        btnAvanzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvanzarActionPerformed(evt);
            }
        });
        jPanel2.add(btnAvanzar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 410, 70, -1));

        tblTransferencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Fecha", "Cuenta destino", "Monto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pnlTransferencias.setViewportView(tblTransferencias);
        if (tblTransferencias.getColumnModel().getColumnCount() > 0) {
            tblTransferencias.getColumnModel().getColumn(1).setHeaderValue("Cuenta destino");
        }

        jPanel2.add(pnlTransferencias, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, 210, 260));
        pnlTransferencias.getAccessibleContext().setAccessibleDescription("");

        tblRetiros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Fecha", "Monto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pnlRetiros.setViewportView(tblRetiros);

        jPanel2.add(pnlRetiros, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, 220, 260));

        txtEstado.setEditable(false);
        txtEstado.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jPanel2.add(txtEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 120, 40));

        btnAvanzarRetiros.setBackground(new java.awt.Color(72, 77, 197));
        btnAvanzarRetiros.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 15)); // NOI18N
        btnAvanzarRetiros.setForeground(new java.awt.Color(255, 255, 255));
        btnAvanzarRetiros.setText("-->");
        btnAvanzarRetiros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvanzarRetirosActionPerformed(evt);
            }
        });
        jPanel2.add(btnAvanzarRetiros, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 410, 70, -1));

        btnRetrocederRetiros.setBackground(new java.awt.Color(72, 77, 197));
        btnRetrocederRetiros.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 15)); // NOI18N
        btnRetrocederRetiros.setForeground(new java.awt.Color(255, 255, 255));
        btnRetrocederRetiros.setText("<--");
        btnRetrocederRetiros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetrocederRetirosActionPerformed(evt);
            }
        });
        jPanel2.add(btnRetrocederRetiros, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 410, 70, -1));

        cbxElementosPaginaRetiros.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        cbxElementosPaginaRetiros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3", "5", "10" }));
        cbxElementosPaginaRetiros.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxElementosPaginaRetirosItemStateChanged(evt);
            }
        });
        jPanel2.add(cbxElementosPaginaRetiros, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 410, 60, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 900, 460));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 530));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            float saldo = cuentasDAO.consultar(codigoCuenta).getSaldo();
            this.txtEstado.setText(estadoCuenta);
            this.txtSaldo.setText(String.valueOf(saldo));
        }
    }//GEN-LAST:event_cbxCuentasItemStateChanged

    private void btnRetirosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetirosActionPerformed
        // TODO add your handling code here:
        this.llenarTablaRetiros();
    }//GEN-LAST:event_btnRetirosActionPerformed

    private void btnTransferenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransferenciasActionPerformed
        this.llenarTablaTransferencias();
    }//GEN-LAST:event_btnTransferenciasActionPerformed

    private void cbxElementosPaginaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxElementosPaginaItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED) {
            int elementosMostrados = Integer.parseInt(evt.getItem().toString());
            this.paginado.setElementosPagina(elementosMostrados);
            this.llenarTablaTransferencias();
        }
    }//GEN-LAST:event_cbxElementosPaginaItemStateChanged

    private void btnRetrocederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetrocederActionPerformed
        retrocederPaginaTransferencias();
    }//GEN-LAST:event_btnRetrocederActionPerformed

    private void btnAvanzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvanzarActionPerformed
        avanzarPaginaTransferencias();
    }//GEN-LAST:event_btnAvanzarActionPerformed

    private void btnAvanzarRetirosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvanzarRetirosActionPerformed
        avanzarPaginaRetiros();
    }//GEN-LAST:event_btnAvanzarRetirosActionPerformed

    private void btnRetrocederRetirosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetrocederRetirosActionPerformed
        retrocederPaginaRetiros();
    }//GEN-LAST:event_btnRetrocederRetirosActionPerformed

    private void cbxElementosPaginaRetirosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxElementosPaginaRetirosItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            int elementosMostrados = Integer.parseInt(evt.getItem().toString());
            this.paginadoRetiro.setElementosPagina(elementosMostrados);
            this.llenarTablaRetiros();
        }
    }//GEN-LAST:event_cbxElementosPaginaRetirosItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvanzar;
    private javax.swing.JButton btnAvanzarRetiros;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRetiros;
    private javax.swing.JButton btnRetroceder;
    private javax.swing.JButton btnRetrocederRetiros;
    private javax.swing.JButton btnTransferencias;
    private javax.swing.JComboBox<String> cbxCuentas;
    private javax.swing.JComboBox<String> cbxElementosPagina;
    private javax.swing.JComboBox<String> cbxElementosPaginaRetiros;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblCliente1;
    private javax.swing.JLabel lblConsultar;
    private javax.swing.JLabel lblCuenta;
    private javax.swing.JLabel lblCuentas;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JScrollPane pnlRetiros;
    private javax.swing.JScrollPane pnlTransferencias;
    private javax.swing.JTable tblRetiros;
    private javax.swing.JTable tblTransferencias;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtSaldo;
    // End of variables declaration//GEN-END:variables
}

