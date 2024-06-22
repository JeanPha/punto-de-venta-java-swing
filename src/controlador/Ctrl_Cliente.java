package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Cliente;

public class Ctrl_Cliente {
    

    //Metodo para guardar nuevo cliente
    public boolean guardar(Cliente cliente) {
        boolean respuesta = false;
        Connection cn = null;
        PreparedStatement consulta = null;

        try {
            cn = Conexion.conectar();
            String sql = "INSERT INTO tb_cliente (nombre, apellido, cedula, telefono, direccion, estado) VALUES (?, ?, ?, ?, ?, ?)";
            consulta = cn.prepareStatement(sql);
            consulta.setString(1, cliente.getNombre());
            consulta.setString(2, cliente.getApellido());
            consulta.setString(3, cliente.getCedula());
            consulta.setString(4, cliente.getTelefono());
            consulta.setString(5, cliente.getDireccion());
            consulta.setInt(6, cliente.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.print("Error al guardar cliente: " + e);
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

    public boolean existeCliente(String cedula) {
        boolean respuesta = false;
        String sql = "SELECT cedula FROM tb_cliente WHERE cedula = ?";
        Connection cn = null;
        PreparedStatement consulta = null;
        ResultSet rs = null;

        try {
            cn = Conexion.conectar();
            consulta = cn.prepareStatement(sql);
            consulta.setString(1, cedula);
            rs = consulta.executeQuery();

            if (rs.next()) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.print("Error al consultar cliente: " + e);
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

    public boolean actualizar(Cliente objeto, int idCliente) {
        boolean respuesta = false;
        Connection cn = null;
        PreparedStatement consulta = null;

        try {
            cn = Conexion.conectar();
            String sql = "UPDATE tb_cliente SET nombre=?, apellido=?, cedula=?, telefono=?, direccion=?, estado=? WHERE idCliente=?";
            consulta = cn.prepareStatement(sql);

            consulta.setString(1, objeto.getNombre());
            consulta.setString(2, objeto.getApellido());
            consulta.setString(3, objeto.getCedula());
            consulta.setString(4, objeto.getTelefono());
            consulta.setString(5, objeto.getDireccion());
            consulta.setInt(6, objeto.getEstado());
            consulta.setInt(7, idCliente);

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.print("Error al actualizar Cliente: " + e);
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

    public boolean eliminar(int idCliente) {
        boolean respuesta = false;
        Connection cn = null;
        PreparedStatement consulta = null;

        try {
            cn = Conexion.conectar();
            String sql = "DELETE FROM tb_cliente WHERE idCliente = ?";
            consulta = cn.prepareStatement(sql);
            consulta.setInt(1, idCliente);

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.print("Error al eliminar Cliente: " + e);
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
