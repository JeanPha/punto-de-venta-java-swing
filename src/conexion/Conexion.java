package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jean
 */
public class Conexion {

    // Conexión local
    public static Connection conectar() {
        try {
            String url = "jdbc:mysql://localhost/bd_sistema_ventas?useSSL=false&allowPublicKeyRetrieval=true";
            System.out.println("Conectando a la base de datos con URL: " + url);
            Connection cn = DriverManager.getConnection(url, "root", "12345");
            return cn;
        } catch (SQLException e) {
            System.out.println("Error en la conexión local " + e);
        }
        return null;
    }
}




