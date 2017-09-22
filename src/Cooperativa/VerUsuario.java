/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cooperativa;

import java.awt.HeadlessException;
import java.awt.Point;
import java.sql.Array;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Luis
 */
public final class VerUsuario extends javax.swing.JFrame {

    /**
     * Creates new form VerUsuario
     */
    EstablecerConexion conexion;
    DefaultListModel modelo_lista;
    JScrollPane scrollLista;
    
    public VerUsuario(EstablecerConexion conexion) {
        this.conexion = conexion;
        initComponents();
        lista_privilegios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.modelo_lista = new DefaultListModel();
        this.scrollLista = new JScrollPane();
        cmb_tipo_rol.setEnabled(false);
        btnModificar.setVisible(false);
        verUsuario();
    }
    
    public VerUsuario(EstablecerConexion conexion, boolean modificar)
    {
        this.conexion = conexion;
        initComponents();
        lbl_usuario.setText("Modificar Usuario");
        cmb_tipo_rol.setEnabled(false);
        accionesDeModificacion();
    }
    
    public void accionesDeModificacion()
    {
        lista_privilegios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.modelo_lista = new DefaultListModel();
        this.scrollLista = new JScrollPane();
        lista_privilegios.setEnabled(false);
        verUsuario();
    }
    
    public VerUsuario(){}
    
    public void verUsuario()
    {
        
        try
        {
            conexion.callableStatement = conexion.connection.prepareCall("{call SP_USUARIO_READ(?)}");
            conexion.callableStatement.setString(1, conexion.loggedUser);
            conexion.resultSet = conexion.callableStatement.executeQuery();
            
            while(conexion.resultSet.next())
            {
                text_id_usuario.setText(conexion.resultSet.getString("ID_USUARIO"));
                text_contrasena.setText(conexion.resultSet.getString("CONTRASEÑA"));
                cmb_tipo_rol.addItem(conexion.resultSet.getString("TIPO_ROL"));
                modelo_lista.addElement(conexion.resultSet.getString("DESCRIPCION"));
                lista_privilegios.setModel(modelo_lista);
            }
            conexion.callableStatement.close();
            conexion.resultSet.close();
        }catch(Exception e){}
    }
    
    public int buscarCodigoEmpleado()
    {
        try
        {
            conexion.callableStatement = conexion.connection.prepareCall("{call SP_USUARIO_GET_CODIGO_EMPLEADO(?,?)}");
            conexion.callableStatement.setString(1, conexion.loggedUser);
            conexion.callableStatement.registerOutParameter(2, java.sql.Types.BIGINT);
            conexion.callableStatement.execute();
            
            return conexion.callableStatement.getInt(2);
        }catch(Exception e){}
        return -1;
    }
    
    public String buscarIdUsuario(String id_usuario)
    {
        try
        {
            conexion.callableStatement = conexion.connection.prepareCall("{call SP_USUARIO_BUSCAR(?,?)}");
            conexion.callableStatement.setString(1, id_usuario);
            conexion.callableStatement.registerOutParameter(2, java.sql.Types.NVARCHAR);
            conexion.callableStatement.execute();
            
            return conexion.callableStatement.getString(2);
        }
        catch(Exception e){}
        return null;
    }
    
    public void modificarUsuario()
    {
        String id_usuario = buscarIdUsuario(text_id_usuario.getText());
        int codigo_empleado = buscarCodigoEmpleado();
        if(codigo_empleado != -1 && id_usuario == null)
        {
            try
            {
                conexion.preparedStatement = conexion.connection.prepareStatement("exec SP_USUARIO_UPDATE ?,?,?,?");
                conexion.preparedStatement.setString(1, text_id_usuario.getText());
                conexion.preparedStatement.setInt(2, codigo_empleado);
                conexion.preparedStatement.setString(3, text_contrasena.getText());
                conexion.preparedStatement.setString(4, conexion.loggedUser);
                conexion.callableStatement.registerOutParameter(1, java.sql.Types.NVARCHAR);
                conexion.preparedStatement.executeQuery();
                
                conexion.loggedUser = conexion.callableStatement.getString(1);

                
            }catch(SQLException | HeadlessException e){}
            JOptionPane.showOptionDialog(null, "Usuario modificado exitosamente..!", "Notificación",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, "OK");
        }
        else{
            JOptionPane.showOptionDialog(null, "No se pudo modificar el usuario. El codigo o el ID de Usuario son invalidos..!", "Notificación",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, "OK");
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

        lbl_usuario = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        text_id_usuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        text_contrasena = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista_privilegios = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        cmb_tipo_rol = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Usuarios");
        setLocationByPlatform(true);

        lbl_usuario.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbl_usuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_usuario.setText("VER USUARIO");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Id Usuario:");

        text_id_usuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Contraseña:");

        text_contrasena.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Tipo de Rol:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Privilegios:");

        jScrollPane1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lista_privilegios.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jScrollPane1.setViewportView(lista_privilegios);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("SALIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        cmb_tipo_rol.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(text_id_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(cmb_tipo_rol, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(text_contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(22, 22, 22)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(text_id_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmb_tipo_rol, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        modificarUsuario();
    }//GEN-LAST:event_btnModificarActionPerformed

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
            java.util.logging.Logger.getLogger(VerUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cmb_tipo_rol;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_usuario;
    private javax.swing.JList<String> lista_privilegios;
    private javax.swing.JTextField text_contrasena;
    private javax.swing.JTextField text_id_usuario;
    // End of variables declaration//GEN-END:variables

    
}
