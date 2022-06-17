/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.modelo;

import seguridad.controlador.clsPerfil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoPerfil {

    private static final String SQL_SELECT = "SELECT per_idPerfil, per_NombrePerfil, per_EstatusPerfil FROM tbl_perfil";
    private static final String SQL_INSERT = "INSERT INTO tbl_perfil(per_idPerfil,per_EstatusPerfil) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_perfil SET per_idPerfil=?, per_EstatusPerfil=? WHERE per_idPerfil = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_perfil WHERE per_idPerfil=?";
    private static final String SQL_QUERY = "SELECT per_idPerfil, per_NombrePerfil, per_EstatusPerfil FROM tbl_perfil WHERE per_NombrePerfil = ?";

    public List<clsPerfil> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsPerfil usuario = null;
        List<clsPerfil> usuarios = new ArrayList<clsPerfil>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int iPerfil_id = rs.getInt("per_idPerfil");
                String sPerfil_nombre = rs.getString("per_NombrePerfil");
                String sPerfil_estado = rs.getString("per_EstatusPerfil");

                usuario = new clsPerfil();
                usuario.setId_perfil(iPerfil_id);
                usuario.setnombreperfil(sPerfil_nombre);
                usuario.setEstado(sPerfil_estado);

                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return usuarios;
    }

    public int insert(clsPerfil perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, perfil.getnombreperfil());
            stmt.setString(2, perfil.getEstado());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public int update(clsPerfil perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, perfil.getnombreperfil());
            stmt.setString(2, perfil.getEstado());
            stmt.setInt(3, perfil.getId_perfil());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public int delete(clsPerfil perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, perfil.getId_perfil());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public clsPerfil query(clsPerfil perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, perfil.getnombreperfil());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int iPerfil_id = rs.getInt("per_idPerfil");
                String sPerfil_nombre = rs.getString("per_NombrePerfil");
                String sPerfil_estado = rs.getString("per_EstatusPerfil");

                perfil = new clsPerfil();
                perfil.setId_perfil(iPerfil_id);
                perfil.setnombreperfil(sPerfil_nombre);
                perfil.setEstado(sPerfil_estado);
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return perfil;
    }
}
