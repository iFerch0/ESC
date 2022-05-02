
package Clases;

import java.sql.*;
import java.util.LinkedList;

public class Equipo
{

    public Equipo()
    {
    }

    public void Guardar(Connection con)
        throws SQLException
    {
        PreparedStatement stmt = con.prepareCall("INSERT INTO equipos (tipo, marca, modelo, sn, observaciones, cli_rut) VALUES (?,?,?,?,?,?) ");
        stmt.setString(1, getDescripcion());
        stmt.setString(2, getMarca());
        stmt.setString(3, getModelo());
        stmt.setString(4, getSerial());
        stmt.setString(5, getObservaciones());
        stmt.setString(6, getCli_rut());
        stmt.executeUpdate();
    }

    public LinkedList Listar(Connection con)
        throws SQLException
    {
        PreparedStatement stmt = con.prepareStatement("SELECT * from equipos");
        LinkedList list = new LinkedList();
        Equipo eq;
        for(ResultSet result = stmt.executeQuery(); result.next(); list.add(eq))
        {
            eq = new Equipo();
            eq.setCli_rut(result.getString("cli_RUT"));
            eq.setDescripcion(result.getString("tipo"));
            eq.setMarca(result.getString("marca"));
            eq.setModelo(result.getString("modelo"));
            eq.setSerial(result.getString("sn"));
            eq.setObservaciones(result.getString("observaciones"));
        }

        return list;
    }

    public void eliminar(Connection con)
        throws SQLException
    {
        PreparedStatement stmt = con.prepareStatement("DELETE FROM equipos WHERE sn = ?");
        stmt.setString(1, getSerial());
        stmt.executeUpdate();
    }
    
    public void modificar(Connection con) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("UPDATE equipos SET Tipo= ?, marca= ?, modelo= ?, observaciones = ?, cli_rut = ? WHERE sn = ?");
        stmt.setString(6, getSerial());
        stmt.setString(1, getDescripcion());
        stmt.setString(2, getMarca());
        stmt.setString(3, getModelo());
        stmt.setString(4, getObservaciones());
        stmt.setString(5, getCli_rut());
        stmt.executeUpdate();
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public String getMarca()
    {
        return marca;
    }

    public void setMarca(String marca)
    {
        this.marca = marca;
    }

    public String getModelo()
    {
        return modelo;
    }

    public void setModelo(String modelo)
    {
        this.modelo = modelo;
    }

    public String getSerial()
    {
        return serial;
    }

    public void setSerial(String serial)
    {
        this.serial = serial;
    }

    public String getObservaciones()
    {
        return observaciones;
    }

    public void setObservaciones(String observaciones)
    {
        this.observaciones = observaciones;
    }

    public String getCli_rut()
    {
        return cli_rut;
    }

    public void setCli_rut(String cli_rut)
    {
        this.cli_rut = cli_rut;
    }

    public String getNombres()
    {
        return nombres;
    }

    public void setNombres(String nombres)
    {
        this.nombres = nombres;
    }

    private String descripcion;
    private String marca;
    private String modelo;
    private String serial;
    private String observaciones;
    private String cli_rut;
    private String nombres;
}
