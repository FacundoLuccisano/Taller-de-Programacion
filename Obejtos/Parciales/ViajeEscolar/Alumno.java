/*

 */
package Parciales.ViajeEscolar;

/**
 *
 * @author Usuario
 */
public class Alumno {
    private int dni;
    private String nombre;
    private int polizaSeguro; // numérica
    private String obraSocial;

    public Alumno(int dni, String nombre, int polizaSeguro, String obraSocial) {
        this.dni = dni;
        this.nombre = nombre;
        this.polizaSeguro = polizaSeguro;
        this.obraSocial = obraSocial;
    }

    public int getDni() {
        return dni;
    }

    public String getObraSocial() {
        return obraSocial;
    }





    public void setPolizaSeguro(int polizaSeguro) {
        this.polizaSeguro = polizaSeguro;
    }

    @Override
    public String toString() {
        return "DNI: " + dni + ", nombre: " + nombre + ", poliza de seguro: " + polizaSeguro + ", obraSocial: " + obraSocial + '}';
    }
    
    
    
}
