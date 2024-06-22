/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Jean
 */
/**
 * Modelo de datos para el IVA.
 */
public class Iva {
    private int idIva;
    private double porcentajeIva;

    public Iva() {
    }

    public Iva(int idIva, double porcentajeIva) {
        this.idIva = idIva;
        this.porcentajeIva = porcentajeIva;
    }

    public int getIdIva() {
        return idIva;
    }

    public void setIdIva(int idIva) {
        this.idIva = idIva;
    }

    public double getPorcentajeIva() {
        return porcentajeIva;
    }

    public void setPorcentajeIva(double porcentajeIva) {
        this.porcentajeIva = porcentajeIva;
    }
}
