package vista;

import conexion.Conexion;
import controlador.Ctrl_Categoria;
import controlador.Ctrl_Producto;
import controlador.Ctrl_funciones;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Categoria;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modelo.Producto;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.ImageIcon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.Statement;
/**
 *
 * @author Jean
 */
public class InterGestionarProducto extends javax.swing.JInternalFrame {

    private int idProducto;
    int obtenerIdCategoriaCombo = 0;
    //int obtenerIdIvaCombo = 0;

    public InterGestionarProducto() {
        initComponents();
        this.setSize(1000, 500); // Establecer el tamaño directamente aquí
        this.setTitle("Gestionar Productos");
        //cargar tabla
        this.CargarTablaProductos();
        this.CargarComboCategoria();
        //this.CargarComboIva();
        
        Ctrl_funciones.setNumericCommaDot(txt_precio);
        Ctrl_funciones.setNumericOnly(txt_cantidad);

        // Agregar el componente listener para redimensionar la imagen
        jLabel_wallpaper.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                redimensionarImagen();
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_productos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton_actualizar = new javax.swing.JButton();
        jButton_eliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_descripcion = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        txt_cantidad = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_precio = new javax.swing.JTextField();
        jComboBox_categoria = new javax.swing.JComboBox<>();
        jComboBox_iva = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable_productos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 810, 250));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 830, 270));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton_actualizar.setBackground(new java.awt.Color(51, 204, 0));
        jButton_actualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_actualizar.setText("Actualizar");
        jButton_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_actualizarActionPerformed(evt);
            }
        });

        jButton_eliminar.setBackground(new java.awt.Color(255, 51, 51));
        jButton_eliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_eliminar.setText("Eliminar");
        jButton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_actualizar)
                    .addComponent(jButton_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jButton_actualizar)
                .addGap(18, 18, 18)
                .addComponent(jButton_eliminar))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 50, 130, 270));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Descripción:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 90, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Nombre:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Cantidad:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 90, -1));

        txt_descripcion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_descripcion.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_descripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_descripcionActionPerformed(evt);
            }
        });
        jPanel3.add(txt_descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 230, -1));

        txt_nombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreActionPerformed(evt);
            }
        });
        jPanel3.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 170, -1));

        txt_cantidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_cantidad.setEnabled(false);
        txt_cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cantidadActionPerformed(evt);
            }
        });
        jPanel3.add(txt_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 170, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("IVA:");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, 90, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Categoría:");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 40, 90, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Precio:");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 90, -1));

        txt_precio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_precio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_precioActionPerformed(evt);
            }
        });
        jPanel3.add(txt_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 170, -1));

        jComboBox_categoria.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Categoría:", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(jComboBox_categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 40, 170, -1));

        jComboBox_iva.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_iva.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Iva:", "No grava iva", "10.5%", "21%", "27%" }));
        jComboBox_iva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_ivaActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBox_iva, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, 170, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 970, 110));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Administrar Productos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, -1));

        jLabel_wallpaper.setAlignmentY(0.0F);
        jLabel_wallpaper.setDoubleBuffered(true);
        jLabel_wallpaper.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jLabel_wallpaperComponentAdded(evt);
            }
        });
        jLabel_wallpaper.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jLabel_wallpaperComponentResized(evt);
            }
        });
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreActionPerformed

    private void txt_precioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_precioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_precioActionPerformed

    private void txt_cantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cantidadActionPerformed

    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarActionPerformed
        Ctrl_Producto controlProducto = new Ctrl_Producto();
        int filaSeleccionada = jTable_productos.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "¡Seleccione un producto!");
        } else {
            // Obtener el ID del producto desde la tabla
            idProducto = (int) jTable_productos.getValueAt(filaSeleccionada, 0); // Suponiendo que la primera columna es el ID del producto

            if (controlProducto.eliminar(idProducto)) {
                JOptionPane.showMessageDialog(null, "¡Producto Eliminado!");
                this.CargarTablaProductos();
                this.CargarComboCategoria();
                this.Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "¡Error al eliminar producto!");
            }
        }
    }//GEN-LAST:event_jButton_eliminarActionPerformed

    private void jButton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizarActionPerformed

        Producto producto = new Producto();
        Ctrl_Producto controlProducto = new Ctrl_Producto();
        String iva = "";
        String categoria = "";
        iva = jComboBox_iva.getSelectedItem().toString().trim();
        categoria = jComboBox_categoria.getSelectedItem().toString().trim();
        int filaSeleccionada = jTable_productos.getSelectedRow();

        // Validar campos
        if (txt_nombre.getText().equals("") || txt_cantidad.getText().equals("") || txt_precio.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
        } else {
            if (iva.equalsIgnoreCase("Seleccione Iva:")) {
                JOptionPane.showMessageDialog(null, "Seleccione iva.");
            } else if (categoria.equalsIgnoreCase("Seleccione categoria:")) {
                JOptionPane.showMessageDialog(null, "Seleccione categoria.");
            } else {
                try {
                    producto.setNombre(txt_nombre.getText().trim());
                    producto.setCantidad(Integer.parseInt(txt_cantidad.getText().trim()));
                    String precioTXT = "";
                    double Precio = 0.0;
                    precioTXT = txt_precio.getText().trim();
                    boolean aux = false;

                    // si el usuario ingresa , (coma) como punto decimal, lo transforma a punto (.)
                    for (int i = 0; i < precioTXT.length(); i++) {
                        if (precioTXT.charAt(i) == ',') {
                            String precioNuevo = precioTXT.replace(",", ".");
                            Precio = Double.parseDouble(precioNuevo);
                            aux = true;
                        }
                    }

                    // Evaluar la condicion 
                    if (aux == true) {
                        producto.setPrecio(Precio);
                    } else {
                        Precio = Double.parseDouble(precioTXT);
                        producto.setPrecio(Precio);
                    }

                    producto.setDescripcion(txt_descripcion.getText().trim());

                    // Porcentaje de IVA
                    if (iva.equalsIgnoreCase("No grava iva")) {
                        producto.setPorcentajeIva(0);
                    } else if (iva.equalsIgnoreCase("10.5%")) {
                        producto.setPorcentajeIva(10.5);
                    } else if (iva.equalsIgnoreCase("21%")) {
                        producto.setPorcentajeIva(21);
                    } else if (iva.equalsIgnoreCase("27%")) {
                        producto.setPorcentajeIva(27);
                    }

                    // IdCategoria - cargar metodo que obtiene el id de categoria
                    this.IdCategoria();
                    producto.setIdCategoria(obtenerIdCategoriaCombo);
                    producto.setEstado(1);

                    // Obtener el ID del producto desde la tabla
                    idProducto = (int) jTable_productos.getValueAt(filaSeleccionada, 0); // Suponiendo que la primera columna es el ID del producto

                    if (controlProducto.actualizar(producto, idProducto)) {
                        JOptionPane.showMessageDialog(null, "Registro Actualizado");
                        this.CargarComboCategoria();
                        this.CargarTablaProductos();
                        this.jComboBox_iva.setSelectedItem("Seleccione Iva:");
                        this.Limpiar();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al Actualizar");
                    }
                } catch (HeadlessException | NumberFormatException e) {
                    System.out.println("Error: " + e);
                }
            }
        }
    }//GEN-LAST:event_jButton_actualizarActionPerformed

    private void jLabel_wallpaperComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jLabel_wallpaperComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_wallpaperComponentAdded

    private void jLabel_wallpaperComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jLabel_wallpaperComponentResized
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel_wallpaperComponentResized

    private void txt_descripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_descripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_descripcionActionPerformed

    private void jComboBox_ivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_ivaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_ivaActionPerformed

    private Dimension Dimension(int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_actualizar;
    private javax.swing.JButton jButton_eliminar;
    private javax.swing.JComboBox<String> jComboBox_categoria;
    private javax.swing.JComboBox<String> jComboBox_iva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_productos;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_descripcion;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_precio;
    // End of variables declaration//GEN-END:variables

    //Metodo limpiar
    private void Limpiar() {
        txt_nombre.setText("");
        txt_cantidad.setText("");
        txt_precio.setText("");
        txt_descripcion.setText("");
        jComboBox_iva.setSelectedItem("Seleccione Iva:");
        jComboBox_categoria.setSelectedItem("Seleccione Iva:");

    }

    /**
     *
     * Metodo para cargar las categorias en el JCombox
     */
    private void CargarComboCategoria() {
        Connection cn = Conexion.conectar();
        String sql = "select * from tb_categoria ";
        Statement st;
        try {

            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jComboBox_categoria.removeAllItems();
            jComboBox_categoria.addItem("Seleccione categoria:");
            while (rs.next()) {
                jComboBox_categoria.addItem(rs.getString("descripcion"));
            }

        } catch (SQLException e) {
            System.out.println("Error al cargar categorias!");

        }

    }

    /**
     *
     * Metodo para cargar las ivas en el JCombox
     */
//    private void CargarComboIva() {
//        Connection cn = Conexion.conectar();
//        String sql = "SELECT * FROM tb_iva";
//        Statement st;
//        try {
//            st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            jComboBox_iva.removeAllItems();
//            jComboBox_iva.addItem("Seleccione IVA:");
//            while (rs.next()) {
//                jComboBox_iva.addItem(rs.getString("porcentajeIva"));
//            }
//        } catch (SQLException e) {
//            System.out.println("Error al cargar IVA: " + e);
//        }
//    }
    //Metodo para mostrar todas las categorias registradas
    String descripcionCategoria = "";
    double precio = 0.0;
    double porcentajeIva = 0.0;
    double IVA = 0.0;

    private void CargarTablaProductos() {
        Connection con = Conexion.conectar();
        DefaultTableModel model = new DefaultTableModel();
        String sql = "SELECT p.idProducto, p.nombre, p.cantidad, p.precio, p.descripcion, p.porcentajeIva, c.descripcion AS categoria, p.estado FROM tb_producto AS p JOIN tb_categoria AS c ON p.idCategoria = c.idCategoria;";
        Statement st;

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            InterGestionarProducto.jTable_productos = new JTable(model);
            InterGestionarProducto.jScrollPane1.setViewportView(InterGestionarProducto.jTable_productos);

            model.addColumn("N°"); //ID
            model.addColumn("NOMBRE");
            model.addColumn("CANTIDAD");
            model.addColumn("PRECIO");
            model.addColumn("DESCRIPCIÓN");
            model.addColumn("IVA");
            model.addColumn("CATEGORIA");
            model.addColumn("ESTADO");

            while (rs.next()) {
                precio = rs.getDouble("precio");
                porcentajeIva = rs.getDouble("porcentajeIva");

                Object fila[] = new Object[8];
                for (int i = 0; i < 8; i++) {

                    if (i == 5) {
                        this.calcularIva(precio, porcentajeIva);
                        fila[i] = IVA;
                        rs.getObject(i + 1);

                    } else {
                        fila[i] = rs.getObject(i + 1);
                    }
                }

                model.addRow(fila);
            }

            con.close();

        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla productos: " + e);
        }

        // Evento para obtener campo al cual el usuario da click
        // y obtener la interfaz que mostrará la información general
        jTable_productos.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            // Prevenir llamadas múltiples cuando el evento cambia (por ejemplo, al cambiar de una selección a otra)
            if (!event.getValueIsAdjusting()) {
                int selectedRow = jTable_productos.getSelectedRow();
                if (selectedRow != -1) {
                    int idProducto1 = (int) jTable_productos.getValueAt(selectedRow, 0);
                    EnviarDatosPoductoSeleccionado(idProducto1);// metodo
                }
            }
        });

    }

    // Metodo para calcular Iva
    private double calcularIva(double precio, double iva) {
        //double IVA = 0.0; // Definición de la variable IVA
        int ivaInt = (int) (iva * 10); // Convertir el valor de IVA a un entero multiplicando por 10

        switch (ivaInt) {
            case 0:
                IVA = 0.0;
                break;
            case 105:
                IVA = precio * 0.105;
                break;
            case 210:
                IVA = precio * 0.21;
                break;
            case 270:
                IVA = precio * 0.27;
                break;
            default:
                throw new IllegalArgumentException("Porcentaje de IVA no válido: " + iva);
        }

        // Redondear decimales
        IVA = (double) Math.round(IVA * 100) / 100.0;
        return IVA;
    }

    //Metodo que envia datos seleccionados
    private void EnviarDatosPoductoSeleccionado(int idProducto) {
        try {
            Connection con = Conexion.conectar();
            PreparedStatement pst = con.prepareStatement(
                    "SELECT * from tb_producto where idProducto = '" + idProducto + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                txt_nombre.setText(rs.getString("nombre"));
                txt_cantidad.setText(rs.getString("cantidad"));
                txt_precio.setText(rs.getString("precio"));
                txt_descripcion.setText(rs.getString("descripcion"));
                double iva = rs.getDouble("porcentajeIva");

                int ivaInt = (int) (iva * 10); // Convertir el valor de IVA a un entero multiplicando por 10

                switch (ivaInt) {
                    case 0:
                        jComboBox_iva.setSelectedItem("No grava iva");
                        break;
                    case 105:
                        jComboBox_iva.setSelectedItem("10.5%");
                        break;
                    case 210:
                        jComboBox_iva.setSelectedItem("21%");
                        break;
                    case 270:
                        jComboBox_iva.setSelectedItem("27%");
                        break;
                    default:
                        throw new IllegalArgumentException("Porcentaje de IVA no válido: " + iva);
                }
                int idCate = rs.getInt("idCategoria");
                jComboBox_categoria.setSelectedItem(relacionarCategoria(idCate));
            }

            con.close();
        } catch (SQLException e) {
            System.out.println("Error al seleccionar producto: " + e);
        }
    }

    // Método para obtener id de la categoría
    private int IdCategoria() {
        try ( Connection cn = Conexion.conectar();  Statement st = cn.createStatement();  ResultSet rs = st.executeQuery("SELECT * FROM tb_categoria WHERE descripcion = '" + this.jComboBox_categoria.getSelectedItem() + "'")) {
            if (rs.next()) {
                obtenerIdCategoriaCombo = rs.getInt("idCategoria");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener id categoria: " + e.getMessage());
        }
        return obtenerIdCategoriaCombo;
    }

    // Método para relacionar categorias
    private String relacionarCategoria(int idCategoria) {

        String sql = "select descripcion from tb_categoria where idCategoria =  '" + idCategoria + "'";
        Statement st;
        try {
            Connection cn = Conexion.conectar();

            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                descripcionCategoria = rs.getString("descripcion");
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener el id de la categoria!");

        }
        return descripcionCategoria;
    }

    //Metodo para insertar imagen de fondo
    private void redimensionarImagen() {
        ImageIcon wallpaper = new ImageIcon(getClass().getResource("/img/fondo3.jpg"));
        Image img = wallpaper.getImage();
        Image imgScaled = img.getScaledInstance(jLabel_wallpaper.getWidth(), jLabel_wallpaper.getHeight(), Image.SCALE_SMOOTH);
        jLabel_wallpaper.setIcon(new ImageIcon(imgScaled));
    }
}
