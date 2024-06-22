package controlador;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

/**
 *
 * @author Jean
 */
public class Ctrl_funciones {
    
    // Método estático para configurar un JTextField para aceptar solo números
    public static void setNumericOnly(JTextField textField) {
        AbstractDocument doc = (AbstractDocument) textField.getDocument();
        doc.setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
                if (text.matches("[0-9]*")) {
                    super.insertString(fb, offset, text, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text.matches("[0-9]*")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
    }
    
    // Método estático para convertir texto a mayúsculas
    public static String convertirAMayusculas(String texto) {
        return texto.toUpperCase();
    }
    
    // Método estático para configurar un JTextField para aceptar números, comas y puntos
    public static void setNumericCommaDot(JTextField textField) {
        AbstractDocument doc = (AbstractDocument) textField.getDocument();
        doc.setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
                // Reemplazar comas por puntos y asegurar que solo se ingresen números, puntos y una sola coma
                if (text.matches("[0-9,.]*")) {
                    String filteredText = text.replace(",", ".");
                    super.insertString(fb, offset, filteredText, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                // Reemplazar comas por puntos y asegurar que solo se ingresen números, puntos y una sola coma
                if (text.matches("[0-9,.]*")) {
                    String filteredText = text.replace(",", ".");
                    super.replace(fb, offset, length, filteredText, attrs);
                }
            }
        });
    }

}
