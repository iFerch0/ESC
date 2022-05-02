
package Clases;

import java.sql.*;

public class Login
{

    public Login()
    {
    }

    public String getUser()
    {
        return user;
    }

    public void setUser(String user)
    {
        this.user = user;
    }

    public String getPass()
    {
        return pass;
    }

    public void setPass(String pass)
    {
        this.pass = pass;
    }

    public boolean Buscar(Connection con)
        throws SQLException
    {
        boolean b = false;
        PreparedStatement stmt = con.prepareStatement("SELECT*FROM Login WHERE usuario=? AND contrase\361a=?");
        stmt.setString(1, getUser());
        stmt.setString(2, getPass());
        ResultSet r = stmt.executeQuery();
        if(r.next())
            b = true;
        return b;
    }

    private String user;
    private String pass;
}
