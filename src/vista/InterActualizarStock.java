package vista;

import com.mysql.jdbc.PreparedStatement;
import conexion.Conexion;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import controlador.Ctrl_Producto;
import modelo.Producto;

/**
 *
 * @author Jean
 */
public class InterActualizarStock extends javax.swing.JInternalFrame {

    // Variables
    int idProducto = 0;
    int cantidad = 0;

    public InterActualizarStock() {
        initComponents();
        setTitle("Actualizar Stock de los Productos");
        setSize(new Dimension(400, 300));

        this.CargarComboProductos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_cantidad_nueva = new javax.swing.JTextField();
        txt_cantidad_actual = new javax.swing.JTextField();
        jComboBox_producto = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Actualizar Stock de Productos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 388, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Stock Actual:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 100, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Stock Nuevo:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 100, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Producto:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 100, -1));

        txt_cantidad_nueva.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(txt_cantidad_nueva, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 170, -1));

        txt_cantidad_actual.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_cantidad_actual.setEnabled(false);
        getContentPane().add(txt_cantidad_actual, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 170, -1));

        jComboBox_producto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione producto:" }));
        jComboBox_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_productoActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 170, -1));

        jButton1.setBackground(new java.awt.Color(102, 204, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 170, 30));

        jLabel_wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo3.jpg"))); // NOI18N
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Validamos seleccion del producto
        if (!jComboBox_producto.getSelectedItem().equals("Seleccione producto:")) {
            //Validamos campos vacios
            if (!txt_cantidad_nueva.getText().isEmpty()) {
                //Validamos que el usuario no ingrese otros caracteres no numericos
                boolean validacion = Validar(txt_cantidad_nueva.getText().trim());
                if (validacion == true) {
                    // Validar que la cantidad sea mayor a cero (0)
                    if (Integer.parseInt(txt_cantidad_nueva.getText()) > 0){
                        
                        Producto producto = new Producto();
                        Ctrl_Producto controlProducto = new Ctrl_Producto();
                        int stockActual = Integer.parseInt(txt_cantidad_actual.getText().trim());
                        int stockNuevo = Integer.parseInt(txt_cantidad_nueva.getText().trim());
                        
                        stockNuevo = stockActual + stockNuevo;
                        producto.setCantidad(stockNuevo);
                        
                        if(controlProducto.ActualizarStock(producto, idProducto)){
                            JOptionPane.showMessageDialog(null, "Stock Actualizado");
                            jComboBox_producto.setSelectedItem("Seleccione producto:");
                            txt_cantidad_actual.setText("");
                            txt_cantidad_nueva.setText("");
                            this.CargarComboProductos();
                        } else{
                            JOptionPane.showMessageDialog(null, "Error al Actualizar Stock");
                        }
                        
                    } else {
                         JOptionPane.showMessageDialog(null, "La cantidad no puede ser cero, ni negativa");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "En la cantidad no se admiten caracteres no numericos");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Ingrese la nueva cantidad para sumar al stock del producto");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un producto");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_productoActionPerformed
        this.MostrarStock();
    }//GEN-LAST:event_jComboBox_productoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox_producto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JTextField txt_cantidad_actual;
    private javax.swing.JTextField txt_cantidad_nueva;
    // End of variables declaration//GEN-END:variables

//Metodo para cargar los productos en el jComboBox
    private void CargarComboProductos() {

        Connection cn = Conexion.conectar();
        String sql = "select * from tb_producto";
        Statement st;
        try {

            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jComboBox_producto.removeAll();
            //jComboBox_producto.addItem("Seleccione producto:");
            while (rs.next()) {
                jComboBox_producto.addItem(rs.getString("nombre"));
            }

        } catch (SQLException e) {
            System.out.println("Error al cargar los productos en: " + e);

        }
    }

    // Metodo para mostrar stock del producto seleccionado
    private void MostrarStock() {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String productoSeleccionado = this.jComboBox_producto.getSelectedItem().toString();

            String sql = "SELECT * FROM tb_producto WHERE nombre = ?";
            cn = Conexion.conectar();
            pst = (PreparedStatement) cn.prepareStatement(sql);
            pst.setString(1, productoSeleccionado);
            rs = pst.executeQuery();

            if (rs.next()) {
                idProducto = rs.getInt("idProducto");
                cantidad = rs.getInt("cantidad");
                txt_cantidad_actual.setText(String.valueOf(cantidad));
            } else {
                txt_cantidad_actual.setText("");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener stock del producto: " + e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e);
            }
        }
    }
    
    // Metodo de validacion de caracteres no numericos
    private boolean Validar(String valor){
        int num;
        try {
            num = Integer.parseInt(valor);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

}
