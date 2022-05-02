

package Controlador;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion
{

    public Conexion()
    {
        con = null;
        driver = "com.mysql.jdbc.Driver";
        url = "jdbc:mysql://localhost:3306/control_equipos";
        user = "root";
        pass = "admin";
    }

    public Connection con()
    {
        try
        {
            if(con == null)
            {
                Class.forName(driver);
                con = DriverManager.getConnection(url, user, pass);
            }
        }
        catch(SQLException E)
        {
            JOptionPane.showMessageDialog(null, E.getMessage());
        }
        catch(ClassNotFoundException E)
        {
            JOptionPane.showMessageDialog(null, E.getMessage());
        }
        return con;
    }

    public Connection getConnection()
    {
        return con;
    }

    String driver;
    String url;
    String user;
    String pass;
    Connection con;
}
