/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compras.modelo;

import compras.modelo.*;
import seguridad.modelo.*;
import compras.controlador.clsCompras;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoCompras {
    //programado por josue moran 

    private static final String SQL_SELECT = "SELECT comid ,provid, comserie, ordid , comfechaemi, comfechavenci FROM tbl_compraencabezado";
    private static final String SQL_SELECT2 = "SELECT prodid, ordcantidad, ordcosto FROM tbl_compradetalle";
    private static final String SQL_INSERT = "INSERT INTO tbl_compraencabezado ( comid ,provid , comserie, ordid ,comfechaemi ,comfechavenci ) VALUES ( ?, ?, ?,?,?,?)";
    private static final String SQL_INSERT2 = "INSERT INTO tbl_compradetalle (comid ,prodid, ordcantidad, ordcosto) VALUES (?, ?, ?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_compraencabezado SET provid = ?, comserie = ?, ordid = ?, comfechaemi = ?, comfechavenci = ? WHERE tbl_compraencabezado.comid = ?";
    private static final String SQL_UPDATE2 = "UPDATE tbl_compradetalle SET prodid = ?, ordcantidad = ?, ordcosto = ? WHERE tbl_compradetalle.comid = ?";
    private static final String SQL_UPDATE3 = "UPDATE tbl_producto SET prodexistencia = ? WHERE tbl_producto.prodid = ?";
    private static final String SQL_UPDATE4 = "UPDATE tbl_proveedor SET provsaldo = ? WHERE tbl_proveedor.provid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_compraencabezado WHERE tbl_compraencabezado.comid = ?";
    private static final String SQL_DELETE2 = "DELETE FROM tbl_compradetalle WHERE tbl_compradetalle.comid = ?";
    private static final String SQL_QUERY = "SELECT comid ,provid, comserie, ordid , comfechaemi, comfechavenci FROM tbl_compraencabezado WHERE tbl_compraencabezado.comid = ?";
    private static final String SQL_QUERY2 = "SELECT prodid, ordcantidad, ordcosto FROM tbl_compradetalle WHERE tbl_compradetalle.comid = ?";
    private static final String SQL_QUERY3 = "SELECT prodexistencia FROM tbl_producto WHERE prodid = ?";
    private static final String SQL_QUERY4 = "SELECT ordcantidad FROM tbl_compradetalle WHERE comid = ?";
    private static final String SQL_QUERY5 = "SELECT prodid FROM tbl_compradetalle WHERE tbl_compradetalle.comid=?";
    private static final String SQL_QUERY6 = "SELECT provsaldo FROM tbl_proveedor WHERE tbl_proveedor.provid=?";
    private static final String SQL_QUERY7 = "SELECT ordcosto FROM tbl_compradetalle WHERE tbl_compradetalle.comid = ?";

    public List<clsCompras> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsCompras compras = null;
        List<clsCompras> compra = new ArrayList<clsCompras>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int comid = rs.getInt("comid");
                int provid = rs.getInt("provid");
                int comserie = rs.getInt("comserie");
                int ordid = rs.getInt("ordid");
                String comfechaemi = rs.getString("comfechaemi");
                String comfechavenci = rs.getString("comfechavenci");

                compras = new clsCompras();
                compras.setComid(comid);
                compras.setProvid(provid);
                compras.setComserie(comserie);
                compras.setOrdid(ordid);
                compras.setComfechaemi(comfechaemi);
                compras.setComfechavenci(comfechavenci);

                compra.add(compras);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return compra;
    }

    public List<clsCompras> select2() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsCompras compras = null;
        List<clsCompras> compra = new ArrayList<clsCompras>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT2);
            rs = stmt.executeQuery();
            while (rs.next()) {

                int prodid = rs.getInt("prodid");
                int ordcantidad = rs.getInt("ordcantidad");
                int ordcosto = rs.getInt("ordcosto");

                compras = new clsCompras();

                compras.setProdid(prodid);
                compras.setOrdcantidad(ordcantidad);
                compras.setOrdcosto(ordcosto);

                compra.add(compras);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return compra;
    }

    public int insert(clsCompras producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1,producto.getComid());
            stmt.setInt(2, producto.getProvid());
            stmt.setInt(3, producto.getComserie());
            stmt.setInt(4, producto.getOrdid());
            stmt.setString(5, producto.getComfechaemi());
            stmt.setString(6, producto.getComfechavenci());
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

    public int insert2(clsCompras producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT2);
            stmt.setInt(1,producto.getComid());
            stmt.setInt(2, producto.getProdid());
            stmt.setInt(3, producto.getOrdcantidad());
            stmt.setInt(4, producto.getOrdcosto());

            System.out.println("ejecutando query:" + SQL_INSERT2);
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

    public int update(clsCompras producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, producto.getProvid());
            stmt.setInt(2, producto.getComserie());
            stmt.setInt(3, producto.getOrdid());
            stmt.setString(4,producto.getComfechaemi());
            stmt.setString(5, producto.getComfechavenci());
            stmt.setInt(6, producto.getComid());

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

    public int update2(clsCompras producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE2);
            stmt = conn.prepareStatement(SQL_UPDATE2);
            stmt.setInt(1, producto.getProdid());
            stmt.setInt(2, producto.getOrdcantidad());
            stmt.setInt(3, producto.getOrdcosto());
            stmt.setInt(4, producto.getComid());

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
 
    public int update3(clsCompras producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query3: " + SQL_UPDATE3);
            stmt = conn.prepareStatement(SQL_UPDATE3);
            System.out.println(producto.getComid());
            System.out.println(producto.getProdexistenciaA());
            stmt.setInt(1,producto.getProdexistenciaA());
            stmt.setInt(2, producto.getComid2()); 

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
    public int update4(clsCompras producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query3: " + SQL_UPDATE4);
            stmt = conn.prepareStatement(SQL_UPDATE4);

            stmt.setInt(1,producto.getProvsadoO());
            stmt.setInt(2, producto.getProvid()); 

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

    public int delete(clsCompras producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, producto.getComid());
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

    public int delete2(clsCompras producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE2);
            stmt = conn.prepareStatement(SQL_DELETE2);
            stmt.setInt(1, producto.getComid());
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

    public clsCompras query(clsCompras compras) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, compras.getComid());

            rs = stmt.executeQuery();
            while (rs.next()) {
                int comid = rs.getInt("comid");
                int provid = rs.getInt("provid");
                int comserie = rs.getInt("comserie");
                int ordid = rs.getInt("ordid");
                String comfechaemi = rs.getString("comfechaemi");
                String comfechavenci = rs.getString("comfechavenci");

                compras = new clsCompras();
                compras.setComid(comid);
                compras.setProvid(provid);
                compras.setComserie(comserie);
                compras.setOrdid(ordid);
                compras.setComfechaemi(comfechaemi);
                compras.setComfechavenci(comfechavenci);
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
        return compras;
    }

    public clsCompras query2(clsCompras compras) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY2);
            stmt = conn.prepareStatement(SQL_QUERY2);
            stmt.setInt(1, compras.getComid());

            rs = stmt.executeQuery();
            while (rs.next()) {
                int prodid = rs.getInt("prodid");
                int ordcantidad = rs.getInt("ordcantidad");
                int ordcosto = rs.getInt("ordcosto");
                

                compras = new clsCompras();
                compras.setProdid(prodid);
                compras.setOrdcantidad(ordcantidad);
                compras.setOrdcosto(ordcosto);
               
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
        return compras;
    }

    public clsCompras query3(clsCompras compras) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY3);
            stmt = conn.prepareStatement(SQL_QUERY3);
            stmt.setInt(1, compras.getProdid());

            rs = stmt.executeQuery();
            while (rs.next()) {
                int prodexistencia = rs.getInt("prodexistencia");
                

                compras = new clsCompras();
                compras.setProdexistencia(prodexistencia);

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
        return compras;
    }
    public clsCompras query4(clsCompras compras) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY4);
            stmt = conn.prepareStatement(SQL_QUERY4);
            stmt.setInt(1, compras.getComid());

            rs = stmt.executeQuery();
            while (rs.next()) {
                int ordcantidad= rs.getInt("ordcantidad");
                

                compras = new clsCompras();
                compras.setProdexistencia(ordcantidad);

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
        return compras;
    }

        public clsCompras query5(clsCompras compras) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY5);
            stmt = conn.prepareStatement(SQL_QUERY5);
            stmt.setInt(1, compras.getComid());

            rs = stmt.executeQuery();
            while (rs.next()) {
                int ordcantidad= rs.getInt("prodid");
                

                compras = new clsCompras();
                compras.setProdexistencia(ordcantidad);

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
        return compras;
    }
         public clsCompras query6(clsCompras compras) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query6:" + SQL_QUERY6);
            stmt = conn.prepareStatement(SQL_QUERY6);
            stmt.setInt(1, compras.getProvid());

            rs = stmt.executeQuery();
            while (rs.next()) {
                int provsaldo= rs.getInt("provsaldo");
                

                compras = new clsCompras();
                compras.setProvsaldo(provsaldo);

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
        return compras;
    }
                  public clsCompras query7(clsCompras compras) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query6:" + SQL_QUERY7);
            stmt = conn.prepareStatement(SQL_QUERY7);
            stmt.setInt(1, compras.getComid());

            rs = stmt.executeQuery();
            while (rs.next()) {
                int ordcosto= rs.getInt("ordcosto");
                

                compras = new clsCompras();
                compras.setProvsaldo(ordcosto);

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
        return compras;
    }
}
