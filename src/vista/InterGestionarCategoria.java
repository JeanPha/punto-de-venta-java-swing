package vista;

import com.mysql.jdbc.PreparedStatement;
import conexion.Conexion;
import controlador.Ctrl_Categoria;
import controlador.Ctrl_funciones;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Categoria;
//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.Statement;

/**
 *
 * @author Jean
 */
public class InterGestionarCategoria extends javax.swing.JInternalFrame {

    private int idCategoria;

    public InterGestionarCategoria() {
        initComponents();
        this.setSize(600, 400); // Establecer el tamaño directamente aquí
        this.setTitle("Gestionar Categoria");

        this.CargarTablaCategorias();
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
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_categorias = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton_actualizar = new javax.swing.JButton();
        jButton_eliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txt_descripcion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Administrar Categoría");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 590, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_categorias.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable_categorias);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 330, 230));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 350, 250));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton_actualizar.setBackground(new java.awt.Color(51, 204, 0));
        jButton_actualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_actualizar.setText("Actualizar");
        jButton_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_actualizarActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jButton_eliminar.setBackground(new java.awt.Color(255, 51, 51));
        jButton_eliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_eliminar.setText("Eliminar");
        jButton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminarActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 90, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 130, 80));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_descripcion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_descripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_descripcionActionPerformed(evt);
            }
        });
        jPanel3.add(txt_descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 170, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Decripción:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, 190, 90));

        jLabel1_wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo3.jpg"))); // NOI18N
        getContentPane().add(jLabel1_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizarActionPerformed

        if (!txt_descripcion.getText().isEmpty()) {
            Categoria categoria = new Categoria();
            Ctrl_Categoria controlCategoria = new Ctrl_Categoria();

            categoria.setDescripcion(Ctrl_funciones.convertirAMayusculas(txt_descripcion.getText().trim()));
            if (controlCategoria.actualizar(categoria, idCategoria)) {
                JOptionPane.showMessageDialog(null, "Categoria Actualizada");
                txt_descripcion.setText("");
                this.CargarTablaCategorias();

            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar Categoria");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una categoria");
        }
    }//GEN-LAST:event_jButton_actualizarActionPerformed

    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarActionPerformed

        if (!txt_descripcion.getText().isEmpty()) {
            Categoria categoria = new Categoria();
            Ctrl_Categoria controlCategoria = new Ctrl_Categoria();

            categoria.setDescripcion(Ctrl_funciones.convertirAMayusculas(txt_descripcion.getText().trim()));
            if (controlCategoria.eliminar(idCategoria)) {
                JOptionPane.showMessageDialog(null, "Categoria Eliminada");
                txt_descripcion.setText("");
                this.CargarTablaCategorias();

            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar Categoria");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una categoria");
        }
    }//GEN-LAST:event_jButton_eliminarActionPerformed

    private void txt_descripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_descripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_descripcionActionPerformed

    private Dimension Dimension(int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_actualizar;
    private javax.swing.JButton jButton_eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel1_wallpaper;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_categorias;
    private javax.swing.JTextField txt_descripcion;
    // End of variables declaration//GEN-END:variables

    /**
     *
     * Metodo para mostrar todas las categorias
     */
    private void CargarTablaCategorias() {
        Connection con = Conexion.conectar();
        DefaultTableModel model = new DefaultTableModel();
        String sql = "SELECT idCategoria, descripcion, estado FROM tb_categoria";
        Statement st;

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            model.addColumn("ID CATEGORÍA");
            model.addColumn("DESCRIPCIÓN");
            model.addColumn("ESTADO");

            while (rs.next()) {
                Object fila[] = new Object[3];
                for (int i = 0; i < 3; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }

            InterGestionarCategoria.jTable_categorias.setModel(model);
            con.close();

        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla categoria: " + e);
        }

        jTable_categorias.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_categorias.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    idCategoria = (int) model.getValueAt(fila_point, columna_point);
                    EnviarDatosCategoriaSeleccionada(idCategoria);
                }
            }

        });

    }

    private void EnviarDatosCategoriaSeleccionada(int idCategoria) {
        try {
            Connection con = Conexion.conectar();
            java.sql.PreparedStatement pst = con.prepareStatement("SELECT * FROM tb_categoria WHERE idCategoria = ?");
            pst.setInt(1, idCategoria);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                txt_descripcion.setText(rs.getString("descripcion"));
                
            }

            con.close();

        } catch (SQLException e) {
            System.out.println("Error al seleccionar categoria: " + e);
        }
    }

}
