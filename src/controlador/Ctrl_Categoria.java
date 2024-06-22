package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import modelo.Categoria;

/**
 *
 * @author Jean
 */
public class Ctrl_Categoria {

    // método para registrar categoria
    public boolean guardar(Categoria objeto) {
        boolean respuesta = false;
        Connection cn = null;
        PreparedStatement consulta = null;

        try {
            cn = Conexion.conectar();
            consulta = cn.prepareStatement("INSERT INTO tb_categoria VALUES (?, ?, ?)");
            consulta.setInt(1, 0);
            consulta.setString(2, objeto.getDescripcion());
            consulta.setInt(3, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.print("Error al guardar categoria: " + e);
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

    // método para consultar si existe categoria
    public boolean existeCategoria(String categoria) {
        boolean respuesta = false;
        String sql = "SELECT descripcion FROM tb_categoria WHERE descripcion = ?";
        Connection cn = null;
        PreparedStatement consulta = null;
        ResultSet rs = null;

        try {
            cn = Conexion.conectar();
            consulta = cn.prepareStatement(sql);
            consulta.setString(1, categoria);
            rs = consulta.executeQuery();

            if (rs.next()) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.print("Error al consultar categoria: " + e);
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

    // Método para actualizar categoría
    public boolean actualizar(Categoria objeto, int idCategoria) {
        boolean respuesta = false;
        Connection cn = null;
        PreparedStatement consulta = null;

        try {
            cn = Conexion.conectar();
            consulta = cn.prepareStatement("UPDATE tb_categoria SET descripcion=? WHERE idCategoria = ?");
            consulta.setString(1, objeto.getDescripcion());
            consulta.setInt(2, idCategoria);

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.print("Error al actualizar categoría: " + e);
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

    // Método para eliminar categoría
    public boolean eliminar(int idCategoria) {
        boolean respuesta = false;
        Connection cn = null;
        PreparedStatement consulta = null;

        try {
            cn = Conexion.conectar();
            consulta = cn.prepareStatement("DELETE FROM tb_categoria WHERE idCategoria = ?");
            consulta.setInt(1, idCategoria);

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.print("Error al eliminar categoría: " + e);
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

}
