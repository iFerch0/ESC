

package Clases;

import java.sql.*;
import java.util.LinkedList;

public class Clientes
{

    public Clientes()
    {
    }

    public void Guardar(Connection con)
        throws SQLException
    {
        PreparedStatement stmt = con.prepareCall("INSERT INTO Clientes (RUT, Nombres, Departamento, Ciudad, Direccion, Telefono) VALUES (?,?,?,?,?,?) ");
        stmt.setString(1, getRUT());
        stmt.setString(2, getNombres());
        stmt.setString(3, getDepartamento());
        stmt.setString(4, getCiudad());
        stmt.setString(5, getDireccion());
        stmt.setString(6, getTelefono());
        stmt.executeUpdate();
    }

    public LinkedList Listar(Connection con)
        throws SQLException
    {
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM clientes");
        LinkedList list = new LinkedList();
        Clientes clie;
        for(ResultSet result = stmt.executeQuery(); result.next(); list.add(clie))
        {
            clie = new Clientes();
            clie.setRUT(result.getString("RUT"));
            clie.setNombres(result.getString("Nombres"));
            clie.setDireccion(result.getString("Direccion"));
            clie.setDepartamento(result.getString("Departamento"));
            clie.setCiudad(result.getString("Ciudad"));
            clie.setTelefono(result.getString("Telefono"));
        }

        return list;
    }

    public void Buscar_Nombre(Connection con)
        throws SQLException
    {
        PreparedStatement stmt = con.prepareCall("SELECT * FROM clientes WHERE Nombres=?");
        stmt.setString(1, getNombres());
        ResultSet result = stmt.executeQuery();
        if(result.next())
        {
            setRUT(result.getString("RUT"));
            setNombres(result.getString("Nombres"));
            setDireccion(result.getString("Direccion"));
            setDepartamento(result.getString("Departamento"));
            setCiudad(result.getString("Ciudad"));
            setTelefono(result.getString("Telefono"));
        }
    }

    public void eliminar(Connection con)
        throws SQLException
    {
        PreparedStatement stmt = con.prepareStatement("DELETE FROM clientes WHERE RUT = ?");
        stmt.setString(1, getRUT());
        stmt.executeUpdate();
    }

    public void modificar(Connection con)
        throws SQLException
    {
        PreparedStatement stmt = con.prepareStatement("UPDATE clientes SET Nombres= ?, Direccion= ?, Departamento= ?, Ciudad = ?, Telefono = ? WHERE RUT = ?");
        stmt.setString(6, getRUT());
        stmt.setString(1, getNombres());
        stmt.setString(2, getDireccion());
        stmt.setString(3, getDepartamento());
        stmt.setString(4, getCiudad());
        stmt.setString(5, getTelefono());
        stmt.executeUpdate();
    }

    public String getRUT()
    {
        return RUT;
    }

    public void setRUT(String RUT)
    {
        this.RUT = RUT;
    }

    public String getNombres()
    {
        return nombres;
    }

    public void setNombres(String nombres)
    {
        this.nombres = nombres;
    }

    public String getDepartamento()
    {
        return departamento;
    }

    public void setDepartamento(String departamento)
    {
        this.departamento = departamento;
    }

    public String getCiudad()
    {
        return ciudad;
    }

    public void setCiudad(String ciudad)
    {
        this.ciudad = ciudad;
    }

    public String getDireccion()
    {
        return direccion;
    }

    public void setDireccion(String direccion)
    {
        this.direccion = direccion;
    }

    public String getTelefono()
    {
        return telefono;
    }

    public void setTelefono(String telefono)
    {
        this.telefono = telefono;
    }

    private String RUT;
    private String nombres;
    private String departamento;
    private String ciudad;
    private String direccion;
    private String telefono;
}
