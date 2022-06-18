/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.modelo;

import cine.modelo.*;
import cine.controlador.clsPeliculas;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoPeliculas {

    private static final String SQL_SELECT = "SELECT idPeliculas, Nombre, Clasificación, Genero, Subtitulado, Idioma ,precio FROM Peliculas";
    private static final String SQL_INSERT = "INSERT INTO Peliculas( Nombre, Clasificación, Genero, Subtitulado, Idioma, precio) VALUES ( ?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE Peliculas SET Nombre = ?,Clasificación = ?,Genero = ?, Subtitulado = ?, Idioma = ?, precio = ? WHERE Peliculas.idPeliculas = ?";
    private static final String SQL_DELETE = "DELETE FROM Peliculas WHERE Peliculas.idPeliculas = ?";
    private static final String SQL_QUERY = "SELECT idPeliculas, Nombre, Clasificación,Genero ,Subtitulado  ,Idioma ,precio FROM Peliculas WHERE Peliculas.idPeliculas = ?";

    public List<clsPeliculas> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsPeliculas producto = null;
        List<clsPeliculas> product = new ArrayList<clsPeliculas>();
        try {
            conn = ClsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idPeliculas = rs.getInt("idPeliculas");
                String Nombre = rs.getString("Nombre");
                String Clasificación = rs.getString("Clasificación");
                String Genero = rs.getString("Genero");
                String Subtitulado = rs.getString("Subtitulado");
                String Idioma = rs.getString("Idioma");
                int precio = rs.getInt("precio");

                producto = new clsPeliculas();
                producto.setProdid(idPeliculas);
                producto.setNombre(Nombre);
                producto.setClasificación(Clasificación);
                producto.setGenero(Genero);
                producto.setSubtitulado(Subtitulado);
                producto.setIdioma(Idioma);
                producto.setprecio(precio);

                product.add(producto);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ClsConexion.close(rs);
            ClsConexion.close(stmt);
            ClsConexion.close(conn);
        }

        return product;
    }

    public int insert(clsPeliculas producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = ClsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, producto.getNombre());
            stmt.setString(2, producto.getClasificación());
            stmt.setString(3, producto.getGenero());
            stmt.setString(4, producto.getSubtitulado());
            stmt.setString(5,producto.getIdioma());
            stmt.setInt(6, producto.getidprecio());
            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ClsConexion.close(stmt);
            ClsConexion.close(conn);
        }

        return rows;
    }


    public int update(clsPeliculas producto) {
       Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = ClsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, producto.getNombre());
            stmt.setString(2, producto.getClasificación());
            stmt.setString(3, producto.getGenero());
            stmt.setString(4, producto.getSubtitulado());
            stmt.setString(5, producto.getIdioma());
            stmt.setInt(6, producto.getidprecio());                      
            stmt.setInt(7, producto.getidPeliculas());
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ClsConexion.close(stmt);
            ClsConexion.close(conn);
        }

        return rows;
    }

    public int delete(clsPeliculas producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = ClsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, producto.getidPeliculas());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ClsConexion.close(stmt);
            ClsConexion.close(conn);
        }

        return rows;
    }

    public clsPeliculas query(clsPeliculas producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = ClsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, producto.getidPeliculas());
             
            rs = stmt.executeQuery();
            while (rs.next()) {
                String Nombre = rs.getString("Nombre");
                String Clasificación = rs.getString("Clasificación");
                String Genero = rs.getString("Genero");
                String Subtitulado = rs.getString("Subtitulado");
                String Idioma = rs.getString("Idioma");
                int precio = rs.getInt("precio");

                producto = new clsPeliculas();
                producto.setNombre(Nombre);
                producto.setClasificación(Clasificación);
                producto.setGenero(Genero);
                producto.setSubtitulado(Subtitulado);
                producto.setIdioma(Idioma);
                producto.setprecio(precio);
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ClsConexion.close(rs);
            ClsConexion.close(stmt);
            ClsConexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return producto;
    }

}
