package controlador;

import conexion.Conexion;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Usuario;

/**
 *
 * @author Jean
 */
public class Ctrl_Usuario {

    // metodo para iniciar sesion
    public boolean loginUser(Usuario objeto) {

        boolean respuesta = false;

        Connection cn = Conexion.conectar();
        if (cn == null) {
            System.out.println("No se pudo establecer la conexión a la base de datos.");
            
        }
        String sql = "select usuario, password from tb_usuario where usuario = '" + objeto.getUsuario() + "' and password = '" + objeto.getPassword() + "'";
        Statement st;
        try {

            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al iniciar Sesion");
            JOptionPane.showMessageDialog(null, "Error al iniciar Sesion");

        }
        return respuesta;

    }
    
    // Metodo para guardar nuevo usuario
     public boolean guardar(Usuario objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();

        try {
            PreparedStatement consulta = cn.prepareStatement("INSERT INTO tb_usuario  VALUES (?, ?, ?, ?, ?, ?, ?)");
            consulta.setInt(1, 0); //id
            consulta.setString(2, objeto.getNombre());
            consulta.setString(3, objeto.getApellido());
            consulta.setString(4, objeto.getUsuario());
            consulta.setString(5, objeto.getPassword());
            consulta.setString(6, objeto.getTelefono());
            consulta.setInt(7,objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.print("Error al guardar usuario: " + e);
        } 

        return respuesta;
    }

     //Metodo para consultar si el usuario ya esta registrado en la BBDD
    public boolean existeUsuario(String usuario) {
        boolean respuesta = false;
        String sql = "SELECT usuario FROM tb_usuario WHERE usuario = ?";
        Connection cn = null;
        PreparedStatement consulta = null;
        ResultSet rs = null;

        try {
            cn = Conexion.conectar();
            consulta = cn.prepareStatement(sql);
            consulta.setString(1, usuario);
            rs = consulta.executeQuery();

            if (rs.next()) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.print("Error al consultar usuario: " + e);
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
    
    //Metodo para actualizar usuario
    public boolean actualizar(Usuario objeto, int idUsuario) {
        boolean respuesta = false;
        Connection cn = null;
        PreparedStatement consulta = null;

        try {
            cn = Conexion.conectar();
            String sql = "UPDATE tb_usuario SET nombre=?, apellido=?, usuario=?, password=?, telefono=?, estado=? WHERE idUsuario=?";
            consulta = cn.prepareStatement(sql);

            consulta.setString(1, objeto.getNombre());
            consulta.setString(2, objeto.getApellido());
            consulta.setString(3, objeto.getUsuario());
            consulta.setString(4, objeto.getPassword());
            consulta.setString(5, objeto.getTelefono());
            consulta.setInt(6, objeto.getEstado());
            consulta.setInt(7, idUsuario);

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.print("Error al actualizar Usuario: " + e);
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

    //Metodo para eliminar usuario
    public boolean eliminar(int idUsuario) {
        boolean respuesta = false;
        Connection cn = null;
        PreparedStatement consulta = null;

        try {
            cn = Conexion.conectar();
            String sql = "DELETE FROM tb_usuario WHERE idUsuario = ?";
            consulta = cn.prepareStatement(sql);
            consulta.setInt(1, idUsuario);

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.print("Error al eliminar Usuario: " + e);
            e.printStackTrace();
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
                ex.printStackTrace();
            }
        }

        return respuesta;
    }


}
