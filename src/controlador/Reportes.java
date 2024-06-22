//package controlador;
//
//import com.itextpdf.text.BaseColor;
//import com.itextpdf.text.Chunk;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Element;
//import com.itextpdf.text.Font;
//import com.itextpdf.text.FontFactory;
//import com.itextpdf.text.Image;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.Phrase;
//import com.itextpdf.text.pdf.PdfPCell;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfWriter;
//import conexion.Conexion;
//import java.awt.Desktop;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import javax.swing.JOptionPane;
//
///**
// *
// * @author Jean
// */
//public class Reportes {
//
//    /**
//     * ***************************************************************************
//     * Metodo para crear reportes de los clientes registrados en el sistema
//     ***************************************************************************
//     */
//    public void ReportesClientes() {
//        Document documento = new Document();
//        try {
//            String ruta = System.getProperty("user.home");
//            String path = ruta + "/Desktop/Reportes_Clientes.pdf";
//            System.out.println("Guardando PDF en: " + path); // Línea de depuración
//            PdfWriter.getInstance(documento, new FileOutputStream(path));
//            Image header = Image.getInstance("src/img/header1.jpg");
//            header.scaleToFit(650, 1000);
//            header.setAlignment(Chunk.ALIGN_CENTER);
//            // Formato al texto
//            Paragraph parrafo = new Paragraph();
//            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
//            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
//            parrafo.add("Reporte creado por \nJean Phaima Sainte © JeanPai\n\n");
//            parrafo.add("Reporte de clientes \n\n");
//
//            documento.open();
//            // Agregamos los datos
//            documento.add(header);
//            documento.add(parrafo);
//
//            PdfPTable tabla = new PdfPTable(5);
//            tabla.addCell("Codigo");
//            tabla.addCell("Nombres");
//            tabla.addCell("Cedula");
//            tabla.addCell("Telefono");
//            tabla.addCell("Direccion");
//
//            try {
//                Connection cn = Conexion.conectar();
//                PreparedStatement pst = cn.prepareStatement(
//                        "select idCliente, concat(nombre, ' ', apellido) as nombres, cedula, telefono, direccion from tb_cliente");
//                ResultSet rs = pst.executeQuery();
//                if (rs.next()) {
//                    do {
//                        tabla.addCell(rs.getString(1));
//                        tabla.addCell(rs.getString(2));
//                        tabla.addCell(rs.getString(3));
//                        tabla.addCell(rs.getString(4));
//                        tabla.addCell(rs.getString(5));
//
//                    } while (rs.next());
//                    documento.add(tabla);
//                }
//
//            } catch (SQLException e) {
//                System.out.println("Error al obtener datos de clientes: " + e);
//            }
//            documento.close();
//            JOptionPane.showMessageDialog(null, "Reporte creado");
//
//            // Abrir el archivo automáticamente (opcional)
//            if (Desktop.isDesktopSupported()) {
//                try {
//                    File myFile = new File(path);
//                    Desktop.getDesktop().open(myFile);
//                } catch (IOException ex) {
//                    System.out.println("Error al abrir el archivo: " + ex);
//                }
//            }
//
//        } catch (DocumentException e) {
//            System.out.println("Error al crear el documento: " + e);
//        } catch (FileNotFoundException ex) {
//            System.out.println("Archivo no encontrado: " + ex);
//        } catch (IOException ex) {
//            System.out.println("Error de entrada/salida: " + ex);
//        }
//    }
//}
package controlador;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import conexion.Conexion;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Jean
 */
public class Reportes {

    /**
     * ***************************************************************************
     * Metodo para crear reportes de los clientes registrados en el sistema
     * **************************************************************************
     */
    public void ReportesClientes() {
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            String path = ruta + "/Desktop/Reportes_Clientes.pdf";
            System.out.println("Guardando PDF en: " + path); // Línea de depuración
            PdfWriter.getInstance(documento, new FileOutputStream(path));
            Image header = Image.getInstance("src/img/header1.jpg");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);
            // Formato al texto
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte creado por \nJean Phaima Sainte © JeanPai\n\n");
            parrafo.add("Reporte de clientes \n\n");

            documento.open();
            // Agregamos los datos
            documento.add(header);
            documento.add(parrafo);

            PdfPTable tabla = new PdfPTable(5);
            tabla.addCell("Codigo");
            tabla.addCell("Nombres");
            tabla.addCell("Cedula");
            tabla.addCell("Telefono");
            tabla.addCell("Direccion");

            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select idCliente, concat(nombre, ' ', apellido) as nombres, cedula, telefono, direccion from tb_cliente");
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));

                    } while (rs.next());
                    documento.add(tabla);
                }

            } catch (SQLException e) {
                System.out.println("Error al obtener datos de clientes: " + e);
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte creado");

            // Abrir el archivo automáticamente (opcional)
            if (Desktop.isDesktopSupported()) {
                try {
                    File myFile = new File(path);
                    Desktop.getDesktop().open(myFile);
                } catch (IOException ex) {
                    System.out.println("Error al abrir el archivo: " + ex);
                }
            }

        } catch (DocumentException e) {
            System.out.println("Error al crear el documento: " + e);
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado: " + ex);
        } catch (IOException ex) {
            System.out.println("Error de entrada/salida: " + ex);
        }
    }

    /**
     * ***************************************************************************
     * Metodo para crear reportes de los clientes registrados en el sistema
     * **************************************************************************
     */
    public void ReportesProductos() {
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            String path = ruta + "/Desktop/Reportes_Productos.pdf";
            System.out.println("Guardando PDF en: " + path); // Línea de depuración
            PdfWriter.getInstance(documento, new FileOutputStream(path));
            Image header = Image.getInstance("src/img/header1.jpg");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);
            // Formato al texto
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte creado por \nJean Phaima Sainte © JeanPai\n\n");
            parrafo.add("Reporte de Productos \n\n");

            documento.open();
            // Agregamos los datos
            documento.add(header);
            documento.add(parrafo);

            float[] columnsWidths = {4, 8, 4, 5, 10, 5, 6};

            PdfPTable tabla = new PdfPTable(7);

            try {
                tabla.setWidths(columnsWidths);
            } catch (DocumentException e) {
                e.printStackTrace();
            }

            Font fontNegrita = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.BLACK);

            // Celdas con texto en negrita
            PdfPCell celdaCod = new PdfPCell(new Phrase("Cod.", fontNegrita));
            PdfPCell celdaNombre = new PdfPCell(new Phrase("Nombre", fontNegrita));
            PdfPCell celdaCant = new PdfPCell(new Phrase("Cant.", fontNegrita));
            PdfPCell celdaPrecio = new PdfPCell(new Phrase("Precio", fontNegrita));
            PdfPCell celdaDescripcion = new PdfPCell(new Phrase("Descripcion", fontNegrita));
            PdfPCell celdaPorIva = new PdfPCell(new Phrase("Por. Iva", fontNegrita));
            PdfPCell celdaCategoria = new PdfPCell(new Phrase("Categoria", fontNegrita));

            // Agregar celdas a la tabla
            tabla.addCell(celdaCod);
            tabla.addCell(celdaNombre);
            tabla.addCell(celdaCant);
            tabla.addCell(celdaPrecio);
            tabla.addCell(celdaDescripcion);
            tabla.addCell(celdaPorIva);
            tabla.addCell(celdaCategoria);

            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select p.idProducto, p.nombre, p.cantidad, p.precio, p.descripcion, "
                        + "p.porcentajeIva, c.descripcion as categoria, p.estado "
                        + "from tb_producto as p, tb_categoria as c "
                        + "where p.idCategoria = c.idCategoria ;");
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        tabla.addCell(rs.getString(6));
                        tabla.addCell(rs.getString(7));

                        //Quitar bordes
                        celdaCod.setBorder(0);
                        celdaNombre.setBorder(0);
                        celdaCant.setBorder(0);
                        celdaPrecio.setBorder(0);
                        celdaDescripcion.setBorder(0);
                        celdaPorIva.setBorder(0);
                        celdaCategoria.setBorder(0);

                    } while (rs.next());
                    documento.add(tabla);
                }

            } catch (SQLException e) {
                System.out.println("Error al obtener datos de Productos: " + e);
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte creado");

            // Abrir el archivo automáticamente (opcional)
            if (Desktop.isDesktopSupported()) {
                try {
                    File myFile = new File(path);
                    Desktop.getDesktop().open(myFile);
                } catch (IOException ex) {
                    System.out.println("Error al abrir el archivo: " + ex);
                }
            }

        } catch (DocumentException e) {
            System.out.println("Error al crear el documento: " + e);
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado: " + ex);
        } catch (IOException ex) {
            System.out.println("Error de entrada/salida: " + ex);
        }
    }

    /**
     * ***************************************************************************
     * Metodo para crear reportes de las Categorias registradas en el sistema
     * **************************************************************************
     */
    public void ReportesCategorias() {
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            String path = ruta + "/Desktop/Reportes_Categorias.pdf";
            System.out.println("Guardando PDF en: " + path); // Línea de depuración
            PdfWriter.getInstance(documento, new FileOutputStream(path));
            Image header = Image.getInstance("src/img/header1.jpg");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);
            // Formato al texto
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte creado por \nJean Phaima Sainte © JeanPai\n\n");
            parrafo.add("Reporte de Categorias \n\n");

            documento.open();
            // Agregamos los datos
            documento.add(header);
            documento.add(parrafo);

            float[] columnsWidths = {4, 8, 8};

            PdfPTable tabla = new PdfPTable(3);

            try {
                tabla.setWidths(columnsWidths);
            } catch (DocumentException e) {
                e.printStackTrace();
            }

            Font fontNegrita = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.BLACK);

            // Celdas con texto en negrita
            PdfPCell celdaCod = new PdfPCell(new Phrase("Cod.", fontNegrita));
            PdfPCell celdaNombre = new PdfPCell(new Phrase("Nombre", fontNegrita));
            PdfPCell celdaEstado = new PdfPCell(new Phrase("Estado", fontNegrita));

            // Agregar celdas a la tabla
            tabla.addCell(celdaCod);
            tabla.addCell(celdaNombre);
            tabla.addCell(celdaEstado);

            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("select * from tb_categoria");
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));

                    } while (rs.next());
                    documento.add(tabla);
                }

            } catch (SQLException e) {
                System.out.println("Error al obtener datos de Categoria de productos: " + e);
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte creado");

            // Abrir el archivo automáticamente (opcional)
            if (Desktop.isDesktopSupported()) {
                try {
                    File myFile = new File(path);
                    Desktop.getDesktop().open(myFile);
                } catch (IOException ex) {
                    System.out.println("Error al abrir el archivo: " + ex);
                }
            }

        } catch (DocumentException e) {
            System.out.println("Error al crear el documento: " + e);
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado: " + ex);
        } catch (IOException ex) {
            System.out.println("Error de entrada/salida: " + ex);
        }
    }

    /**
     * ***************************************************************************
     * Metodo para crear reportes de los Ventas registradas en el sistema
     * **************************************************************************
     */
    public void ReportesVentas() {
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            String path = ruta + "/Desktop/Reportes_Ventas.pdf";
            System.out.println("Guardando PDF en: " + path); // Línea de depuración
            PdfWriter.getInstance(documento, new FileOutputStream(path));
            Image header = Image.getInstance("src/img/header1.jpg");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);
            // Formato al texto
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte creado por \nJean Phaima Sainte © JeanPai\n\n");
            parrafo.add("Reporte de Ventas \n\n");

            documento.open();
            // Agregamos los datos
            documento.add(header);
            documento.add(parrafo);

            float[] columnsWidths = {3, 9, 4, 5, 3};

            PdfPTable tabla = new PdfPTable(5);

            try {
                tabla.setWidths(columnsWidths);
            } catch (DocumentException e) {
                e.printStackTrace();
            }

            Font fontNegrita = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.BLACK);

            // Celdas con texto en negrita
            PdfPCell celdaCod = new PdfPCell(new Phrase("Cod.", fontNegrita));
            PdfPCell celdaCliente = new PdfPCell(new Phrase("Cliente", fontNegrita));
            PdfPCell celdaTotPagar = new PdfPCell(new Phrase("Tot. Pagar", fontNegrita));
            PdfPCell celdaFecha = new PdfPCell(new Phrase("Fecha Venta", fontNegrita));
            PdfPCell celdaEstado = new PdfPCell(new Phrase("Estado", fontNegrita));

            // Agregar celdas a la tabla
            tabla.addCell(celdaCod);
            tabla.addCell(celdaCliente);
            tabla.addCell(celdaTotPagar);
            tabla.addCell(celdaFecha);
            tabla.addCell(celdaEstado);

            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("select cv.idCabeceraVenta as id, concat(c.nombre, ' ', c.apellido) as cliente, "
                        + "cv.valorPagar as total, cv.fechaVenta as fecha, cv.estado "
                        + "from tb_cabecera_venta as cv "
                        + "join tb_cliente as c on cv.idCliente = c.idCliente;");
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));

                    } while (rs.next());
                    documento.add(tabla);
                }

            } catch (SQLException e) {
                System.out.println("Error al obtener datos de Productos: " + e);
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte creado");

            // Abrir el archivo automáticamente (opcional)
            if (Desktop.isDesktopSupported()) {
                try {
                    File myFile = new File(path);
                    Desktop.getDesktop().open(myFile);
                } catch (IOException ex) {
                    System.out.println("Error al abrir el archivo: " + ex);
                }
            }

        } catch (DocumentException e) {
            System.out.println("Error al crear el documento: " + e);
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado: " + ex);
        } catch (IOException ex) {
            System.out.println("Error de entrada/salida: " + ex);
        }
    }

}
