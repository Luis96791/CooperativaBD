/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cooperativa;
import java.sql.*;
/**
 *
 * @author Luis
 */
public class EstablecerConexion {
    
    String driverJDBC = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String URL_Driver = "jdbc:sqlserver://DESKTOP-CHGF1UJ\\SQLEXPRESS;databaseName=CooperativaBD";
    String usuario = "sa";
    String contrasenia = "1626"; 
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    String loggedUser, loggedUserRol;
    PreparedStatement preparedStatement;
    CallableStatement callableStatement;
    
    public EstablecerConexion()
    {
        try{
            Class.forName(driverJDBC);
            connection = DriverManager.getConnection(URL_Driver, usuario, contrasenia);
            statement = connection.createStatement();
        }
        catch(ClassNotFoundException | SQLException  exception){}
    }
    
    public boolean abrirSesion(String id_usuario, String contrasena)
    {
        //Los valores de Estos campos son temporales
        //id_usuario = "admin";
        //contrasena = "1626";
        String QUERY = "SELECT * FROM USUARIO";
        
        try
        {
            resultSet = statement.executeQuery(QUERY);
            
            while(resultSet.next())
            {
                if(id_usuario.equalsIgnoreCase(resultSet.getString("id_usuario")))
                    if(contrasena.equals(resultSet.getString("contraseña")))
                    {
                        loggedUser = id_usuario;
                        getLoggedUserRol(id_usuario);
                        return true;
                    }
            }
        }
        catch(Exception exception){}
        return false;
    }
    
    public void getLoggedUserRol(String loggedUser)
    {
        try
        {
            this.callableStatement = connection.prepareCall("{call SP_ROL_GET_ROL (?,?)}");
            this.callableStatement.setString(1, loggedUser);
            this.callableStatement.registerOutParameter(2, java.sql.Types.NVARCHAR);
            this.callableStatement.execute();
            
            loggedUserRol = callableStatement.getString(2);
        }
        catch(Exception exception){}
    }
    
    public void cerrarConexion(Connection connection)
    {
        try
        {
            connection.close();
        }
        catch(Exception exception){}
        System.out.println("Conexion cerrada..!");
    }
}
