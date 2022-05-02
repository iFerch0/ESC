
package Clases;

import java.sql.*;
import java.util.LinkedList;

public class Empleado
{

    public Empleado()
    {
    }

    public void Guardar(Connection con)
        throws SQLException
    {
        PreparedStatement stmt = con.prepareCall("INSERT INTO empleado (idEmpleado,em_Nombres,em_Telefono) VALUES (NULL,?,?) ");
        stmt.setString(1, getNombres());
        stmt.setString(2, getTelefono());
        stmt.executeUpdate();
    }

    public LinkedList Listar(Connection con)
        throws SQLException
    {
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM empleado");
        LinkedList list = new LinkedList();
        Empleado em;
        for(ResultSet result = stmt.executeQuery(); result.next(); list.add(em))
        {
            em = new Empleado();
            em.setIdTrabajador(result.getInt("idEmpleado"));
            em.setNombres(result.getString("em_Nombres"));
            em.setTelefono(result.getString("em_Telefono"));
        }

        return list;
    }

    public void eliminar(Connection con)
        throws SQLException
    {
        PreparedStatement stmt = con.prepareStatement("DELETE FROM empleado WHERE idEmpleado = ?");
        stmt.setString(1, String.valueOf(getIdTrabajador()));
        stmt.executeUpdate();
    }

    public void modificar(Connection con)
        throws SQLException
    {
        PreparedStatement stmt = con.prepareStatement("UPDATE empleado SET em_Nombres= ?, em_Telefono = ? WHERE idEmpleado = ?");
        stmt.setString(3, String.valueOf(getIdTrabajador()));
        stmt.setString(1, getNombres());
        stmt.setString(2, getTelefono());
        stmt.executeUpdate();
    }

    public int getIdTrabajador()
    {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador)
    {
        this.idTrabajador = idTrabajador;
    }

    public String getNombres()
    {
        return nombres;
    }

    public void setNombres(String nombres)
    {
        this.nombres = nombres;
    }

    public String getTelefono()
    {
        return telefono;
    }

    public void setTelefono(String telefono)
    {
        this.telefono = telefono;
    }

    private int idTrabajador;
    private String nombres;
    private String telefono;
}
