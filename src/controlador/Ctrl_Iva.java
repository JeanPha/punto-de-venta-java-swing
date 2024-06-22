/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Iva;

/**
 *
 * @author Jean
 */
/**
 * Controlador para las operaciones con el IVA.
 */
public class Ctrl_Iva {
    
     public boolean actualizar(Iva iva, int idIva) {
        Connection con = Conexion.conectar();
        try {
            PreparedStatement pst = con.prepareStatement("UPDATE tb_iva SET porcentajeIva=? WHERE idIva=?");
            pst.setDouble(1, iva.getPorcentajeIva());
            pst.setInt(2, idIva);
            pst.executeUpdate();
            con.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar IVA: " + e);
            return false;
        }
    }

    public boolean eliminar(int idIva) {
        Connection con = Conexion.conectar();
        try {
            PreparedStatement pst = con.prepareStatement("DELETE FROM tb_iva WHERE idIva=?");
            pst.setInt(1, idIva);
            pst.executeUpdate();
            con.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar IVA: " + e);
            return false;
        }
    }

    public boolean guardar(Iva objeto) {
        boolean respuesta = false;
        Connection cn = null;
        PreparedStatement consulta = null;

        try {
            cn = Conexion.conectar();
            consulta = cn.prepareStatement("INSERT INTO tb_iva (porcentajeIva) VALUES (?)");
            consulta.setDouble(1, objeto.getPorcentajeIva());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.print("Error al guardar IVA: " + e);
        } finally {
            try {
                if (consulta != null) {
                    consulta.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException ex) {
                System.out.print("Error al cerrar conexión: " + ex);
            }
        }

        return respuesta;
    }

    public boolean existeIva(double porcentajeIva) {
        boolean respuesta = false;
        String sql = "SELECT porcentajeIva FROM tb_iva WHERE porcentajeIva = ?";
        Connection cn = null;
        PreparedStatement consulta = null;
        ResultSet rs = null;

        try {
            cn = Conexion.conectar();
            consulta = cn.prepareStatement(sql);
            consulta.setDouble(1, porcentajeIva);
            rs = consulta.executeQuery();

            if (rs.next()) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.print("Error al consultar IVA: " + e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (consulta != null) {
                    consulta.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException ex) {
                System.out.print("Error al cerrar conexión: " + ex);
            }
        }

        return respuesta;
    }
}