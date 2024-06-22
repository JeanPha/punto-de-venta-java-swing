package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Producto;

/**
 * Clase que controla las operaciones relacionadas con los productos.
 *
 * @autor Jean
 */
public class Ctrl_Producto {

    /**
     * Método para registrar un nuevo producto en la base de datos.
     *
     * @param producto El objeto Producto a guardar.
     * @return true si el producto se guardó correctamente, false de lo
     * contrario.
     */
    //Metodo para guardar nuevo producto
    public boolean guardar(Producto producto) {
        boolean respuesta = false;
        Connection cn = null;
        PreparedStatement consulta = null;

        try {
            cn = Conexion.conectar();
            consulta = cn.prepareStatement("INSERT INTO tb_producto VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            consulta.setInt(1, 0); // id producto
            consulta.setString(2, producto.getNombre());
            consulta.setInt(3, producto.getCantidad());
            consulta.setDouble(4, producto.getPrecio());
            consulta.setString(5, producto.getDescripcion());
            consulta.setDouble(6, producto.getPorcentajeIva());
            consulta.setInt(7, producto.getIdCategoria()); // id categoria
            consulta.setInt(8, producto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.print("Error al guardar producto: " + e);
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

    /**
     * Método para consultar si un producto ya está registrado en la base de
     * datos.
     *
     * @param nombre El nombre del producto a verificar.
     * @return true si el producto ya existe, false de lo contrario.
     */
    //metodo para consultar si el producto ya esta registrado en la BBDD
    public boolean existeProducto(String nombre) {
        boolean respuesta = false;
        String sql = "SELECT nombre FROM tb_producto WHERE nombre = ?";
        Connection cn = null;
        PreparedStatement consulta = null;
        ResultSet rs = null;

        try {
            cn = Conexion.conectar();
            consulta = cn.prepareStatement(sql);
            consulta.setString(1, nombre);
            rs = consulta.executeQuery();

            if (rs.next()) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.print("Error al consultar producto: " + e);
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

    // Método para actualizar producto
    public boolean actualizar(Producto objeto, int idProducto) {
        boolean respuesta = false;
        Connection cn = null;
        PreparedStatement consulta = null;

        try {
            cn = Conexion.conectar();
            consulta = cn.prepareStatement(
                    "UPDATE tb_producto SET nombre=?, cantidad=?, precio=?, descripcion=?, porcentajeIva=?, idCategoria=?, estado=? WHERE idProducto = ?"
            );
            consulta.setString(1, objeto.getNombre());       // Nombre del producto
            consulta.setInt(2, objeto.getCantidad());        // Cantidad del producto
            consulta.setDouble(3, objeto.getPrecio());       // Precio del producto
            consulta.setString(4, objeto.getDescripcion());  // Descripción del producto
            consulta.setDouble(5, objeto.getPorcentajeIva()); // Porcentaje de IVA del producto
            consulta.setInt(6, objeto.getIdCategoria());     // ID de la categoría
            consulta.setInt(7, objeto.getEstado());          // Estado del producto
            consulta.setInt(8, idProducto);                  // ID del producto a actualizar (en la cláusula WHERE)

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.print("Error al actualizar Producto: " + e);
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

    // Método para eliminar Producto
    public boolean eliminar(int idProducto) {
        boolean respuesta = false;
        Connection cn = null;
        PreparedStatement consulta = null;

        try {
            cn = Conexion.conectar();
            consulta = cn.prepareStatement("DELETE FROM tb_producto WHERE idProducto = ?");
            consulta.setInt(1, idProducto);

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.print("Error al eliminar Producto: " + e);
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

    // Método para actualizar stock del Producto
    public boolean ActualizarStock(Producto object, int idProducto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();

        try {
            PreparedStatement consulta = cn.prepareStatement("update tb_producto set cantidad=? where idProducto ='" + idProducto + "'");
            consulta.setInt(1, object.getCantidad());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.print("Error al actualizar stock del producto: " + e);
        }
        return respuesta;
    }

}
