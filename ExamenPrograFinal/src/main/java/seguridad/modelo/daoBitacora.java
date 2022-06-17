/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seguridad.modelo;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import seguridad.controlador.clsBitacora;

/**
 *
 * @author movi2
 */
public class daoBitacora {

    private static final String SQL_SELECT = "SELECT id_bitacora, fecha, area, accion, id_usuario, ip, nombrepc FROM tbl_bitacora";
    private static final String SQL_INSERT = "INSERT INTO tbl_bitacora(fecha, area, accion, id_usuario, ip, nombrepc) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_QUERY = "SELECT id_bitacora, fecha, area, accion, id_usuario, ip, nombrepc FROM tbl_bitacora WHERE id_bitacora = ?";
     private static final String SQL_QUERY2 = "SELECT usuid FROM tbl_usuario WHERE tbl_usuario.usunombre=?";
//se agrega metodo para bitacora
//averiguar IP
    public List<clsBitacora> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsBitacora bitacora = null;
        List<clsBitacora> bitacoras = new ArrayList<clsBitacora>();

        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_bitacora = rs.getInt("id_bitacora");
                String fecha = rs.getString("fecha");
                String area = rs.getString("area");
                String accion = rs.getString("accion");
                String ip = rs.getString("ip");
                String nombrepc = rs.getString("nombrepc");
                int id_usuario = rs.getInt("id_usuario");
                

                bitacora = new clsBitacora();
                bitacora.fSetId_Bitacora(id_bitacora);
                bitacora.fSetfecha_Bitacora(fecha);
                bitacora.fSetarea_Bitacora(area);
                bitacora.fSetaccion_Bitacora(accion);
                bitacora.fSetip_Bitacora(ip);
                bitacora.fSetnombrepc_Bitacora(nombrepc);
                bitacora.fSetId_Usuario(id_usuario);
             
                bitacoras.add(bitacora);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return bitacoras;
    }
    
    public int insert(clsBitacora bitacora) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, bitacora.fGetfecha_Bitacora());
            stmt.setString(2, bitacora.fGetarea_Bitacora());
            stmt.setString(3, bitacora.fGetaccion_Bitacora());
            stmt.setInt(4, bitacora.fGetId_Usuario());
            stmt.setString(5, bitacora.fGetip_Bitacora());
            stmt.setString(6, bitacora.fGetnombrepc_Bitacora());

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
    
   


//    public List<Persona> query(Persona vendedor) { // Si se utiliza un ArrayList
    public clsBitacora query(clsBitacora bitacora) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsBitacora> bitacoras = new ArrayList<clsBitacora>();
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, bitacora.fGetId_bitacora());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_bitacora = rs.getInt("id_bitacora");
                String fecha = rs.getString("fecha");
                String area = rs.getString("area");
                String accion = rs.getString("accion");
                String ip = rs.getString("ip");
                String nombrepc = rs.getString("nombrepc");
                int id_usuario = rs.getInt("id_usuario");
                

                bitacora = new clsBitacora();
                bitacora.fSetId_Bitacora(id_bitacora);
                bitacora.fSetfecha_Bitacora(fecha);
                bitacora.fSetarea_Bitacora(area);
                bitacora.fSetaccion_Bitacora(accion);
                bitacora.fSetip_Bitacora(ip);
                bitacora.fSetnombrepc_Bitacora(nombrepc);
                bitacora.fSetId_Usuario(id_usuario);
               

                //vendedores.add(vendedor); // Si se utiliza un ArrayList
            }
            //System.out.println("Registros buscado:" + vendedor);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        //return vendedores;  // Si se utiliza un ArrayList
        return bitacora;
    }
        

}
