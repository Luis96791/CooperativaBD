/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cooperativa;

import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luis
 */
public final class EstadosDeCuenta extends javax.swing.JFrame {

    /**
     * Creates new form EstadosDeCuenta
     */
    
    EstablecerConexion conexion;
    DefaultTableModel mt_aportaciones, mt_ahorro, mt_prestamos, mt_ganancias;
    int autoincrmentables[] = {0,0,0,0};
    
    public EstadosDeCuenta(EstablecerConexion conexion) {
        this.conexion = conexion;
        initComponents();
        configuracionDeTablas();
    }
    
    public EstadosDeCuenta(){}
    
    public void verAbonosAportaciones()
    {
        try
        {
            conexion.callableStatement = conexion.connection.prepareCall("SELECT * FROM FN_ABONOS_APORTACIONES_ANIO_ACTUAL(?,?)");
            conexion.callableStatement.setString(1, conexion.loggedUser);
            conexion.callableStatement.setInt(2, Integer.parseInt(text_anio.getText()));
            conexion.resultSet = conexion.callableStatement.executeQuery();

            while(conexion.resultSet.next())
            {
                mt_aportaciones.addRow(new Object[]
                {
                    ++autoincrmentables[0],
                    conexion.resultSet.getString("CODIGO_ABONO"),
                    conexion.resultSet.getDouble("MONTO_ABONO"),
                    conexion.resultSet.getString("FECHA_ABONO")
                });
            }
            conexion.callableStatement.close();
            conexion.resultSet.close();
        }
        catch(SQLException | NumberFormatException e){}
    }
    
    public void verAbonosAhorro()
    {
        try
        {
            conexion.callableStatement = conexion.connection.prepareCall("SELECT * FROM FN_ABONOS_AHORRO_ANIO_ACTUAL(?,?)");
            conexion.callableStatement.setString(1, conexion.loggedUser);
            conexion.callableStatement.setInt(2, Integer.parseInt(text_anio.getText()));
            conexion.resultSet = conexion.callableStatement.executeQuery();

            while(conexion.resultSet.next())
            {
                mt_ahorro.addRow(new Object[]
                {
                    ++autoincrmentables[1],
                    conexion.resultSet.getString("CODIGO_ABONO"),
                    conexion.resultSet.getDouble("MONTO_ABONO"),
                    conexion.resultSet.getString("FECHA_ABONO")
                });
            }
            conexion.callableStatement.close();
            conexion.resultSet.close();
        }
        catch(SQLException | NumberFormatException e){}
    }
    
    public void verPagosPrestamo()
    {
        try
        {
            conexion.callableStatement = conexion.connection.prepareCall("SELECT * FROM FN_PAGOS_PRESTAMOS_ANIO_ACTUAL(?,?)");
            conexion.callableStatement.setString(1, conexion.loggedUser);
            conexion.callableStatement.setInt(2, Integer.parseInt(text_anio.getText()));
            conexion.resultSet = conexion.callableStatement.executeQuery();

            while(conexion.resultSet.next())
            {
                mt_prestamos.addRow(new Object[]
                {
                    ++autoincrmentables[2],
                    conexion.resultSet.getString("NUMERO_PAGO"),
                    conexion.resultSet.getString("FECHA_PAGO"),
                    conexion.resultSet.getDouble("CAPITAL_PAGADO"),
                    conexion.resultSet.getDouble("INTERES_PAGADO")
                    
                });
            }
            conexion.callableStatement.close();
            conexion.resultSet.close();
        }
        catch(SQLException | NumberFormatException e){}
    }
    
    public void verGanancias()
    {
        try
        {
            conexion.callableStatement = conexion.connection.prepareCall("SELECT * FROM FN_GANANCIAS_ANIO_ACTUAL(?,?)");
            conexion.callableStatement.setString(1, conexion.loggedUser);
            conexion.callableStatement.setInt(2, Integer.parseInt(text_anio.getText()));
            conexion.resultSet = conexion.callableStatement.executeQuery();

            while(conexion.resultSet.next())
            {
                mt_ganancias.addRow(new Object[]
                {
                    ++autoincrmentables[3],
                    conexion.resultSet.getString("ID_GANANCIA"),
                    conexion.resultSet.getString("FECHA_REGISTRO"),
                    conexion.resultSet.getDouble("GANANCIA")
                    
                });
            }
            conexion.callableStatement.close();
            conexion.resultSet.close();
        }
        catch(SQLException | NumberFormatException e){}
    }
    
    public void configuracionDeTablas()
    {
        mt_aportaciones = (DefaultTableModel) tabla_aportaciones.getModel();
        tabla_aportaciones.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        mt_ahorro = (DefaultTableModel) tabla_ahorro.getModel();
        tabla_ahorro.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        mt_prestamos = (DefaultTableModel) tabla_prestamos.getModel();
        tabla_prestamos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        mt_ganancias = (DefaultTableModel) tabla_ganancias.getModel();
        tabla_ganancias.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tabbed_cuentas = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_ahorro = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_aportaciones = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla_prestamos = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabla_ganancias = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        text_anio = new javax.swing.JTextField();
        btnVer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Estados de Cuentas");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ESTADOS DE CUENTAS");

        tabbed_cuentas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tabbed_cuentas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tabbed_cuentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabbed_cuentasMouseClicked(evt);
            }
        });

        tabla_ahorro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabla_ahorro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "CODIGO ABONO", "MONTO ABONO", "FECHA ABONO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabla_ahorro);
        if (tabla_ahorro.getColumnModel().getColumnCount() > 0) {
            tabla_ahorro.getColumnModel().getColumn(0).setPreferredWidth(40);
            tabla_ahorro.getColumnModel().getColumn(1).setPreferredWidth(150);
            tabla_ahorro.getColumnModel().getColumn(2).setPreferredWidth(150);
            tabla_ahorro.getColumnModel().getColumn(3).setPreferredWidth(150);
        }

        tabbed_cuentas.addTab("CUENTA AHORRO", jScrollPane2);

        tabla_aportaciones.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabla_aportaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "CODIGO ABONO", "MONTO ABONO", "FECHA ABONO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla_aportaciones);
        if (tabla_aportaciones.getColumnModel().getColumnCount() > 0) {
            tabla_aportaciones.getColumnModel().getColumn(0).setPreferredWidth(40);
            tabla_aportaciones.getColumnModel().getColumn(1).setPreferredWidth(150);
            tabla_aportaciones.getColumnModel().getColumn(2).setPreferredWidth(150);
            tabla_aportaciones.getColumnModel().getColumn(3).setPreferredWidth(150);
        }

        tabbed_cuentas.addTab("CUENTA APORTACIONES", jScrollPane1);

        tabla_prestamos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "NUMERO PAGO", "FECHA PAGO", "CAPITAL PAGADO", "INTERES PAGADO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tabla_prestamos);
        if (tabla_prestamos.getColumnModel().getColumnCount() > 0) {
            tabla_prestamos.getColumnModel().getColumn(0).setPreferredWidth(40);
            tabla_prestamos.getColumnModel().getColumn(1).setPreferredWidth(150);
            tabla_prestamos.getColumnModel().getColumn(2).setPreferredWidth(150);
            tabla_prestamos.getColumnModel().getColumn(3).setPreferredWidth(150);
            tabla_prestamos.getColumnModel().getColumn(4).setPreferredWidth(150);
        }

        tabbed_cuentas.addTab("PRESTAMOS", jScrollPane3);

        tabla_ganancias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "ID GANANCIA", "FECHA REGISTRO", "GANANCIA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tabla_ganancias);
        if (tabla_ganancias.getColumnModel().getColumnCount() > 0) {
            tabla_ganancias.getColumnModel().getColumn(0).setPreferredWidth(40);
            tabla_ganancias.getColumnModel().getColumn(1).setPreferredWidth(150);
            tabla_ganancias.getColumnModel().getColumn(2).setPreferredWidth(150);
            tabla_ganancias.getColumnModel().getColumn(3).setPreferredWidth(150);
        }

        tabbed_cuentas.addTab("GANANCIAS", jScrollPane4);

        btnSalir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("AÑO:");

        text_anio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        btnVer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnVer.setText("VER");
        btnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tabbed_cuentas)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(text_anio, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38)
                                        .addComponent(btnVer, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 131, Short.MAX_VALUE)))))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnVer, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(text_anio)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 28, Short.MAX_VALUE)
                .addComponent(tabbed_cuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabbed_cuentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabbed_cuentasMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tabbed_cuentasMouseClicked

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed
        // TODO add your handling code here:}
        if(this.tabla_aportaciones.getRowCount() == 0 && this.tabla_aportaciones.getSelectedRow() == -1
           && this.tabla_ahorro.getRowCount() == 0 && this.tabla_ahorro.getSelectedRow() == -1
           && this.tabla_prestamos.getRowCount() == 0 && this.tabla_prestamos.getSelectedRow() == -1
           && this.tabla_ganancias.getRowCount() == 0 && this.tabla_ganancias.getSelectedRow() == -1
        ){
            verAbonosAportaciones();
            verAbonosAhorro();
            verPagosPrestamo();
            verGanancias();
        }
    }//GEN-LAST:event_btnVerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EstadosDeCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EstadosDeCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EstadosDeCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EstadosDeCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EstadosDeCuenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane tabbed_cuentas;
    private javax.swing.JTable tabla_ahorro;
    private javax.swing.JTable tabla_aportaciones;
    private javax.swing.JTable tabla_ganancias;
    private javax.swing.JTable tabla_prestamos;
    private javax.swing.JTextField text_anio;
    // End of variables declaration//GEN-END:variables
}
