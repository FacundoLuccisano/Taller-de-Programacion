/*

 */

package Parciales.ViajeEscolar;

/**
 *
 * @author Usuario
 */
public class Viaje {
    private String colegio; 
    private String fecha; 
    private String destino; 
    private Minibus minibus1; 
    private Minibus minibus2;
    
    public Viaje(String nombreColegio, String fecha, String destino, Minibus m1, Minibus m2) {
        this.colegio = nombreColegio;
        this.fecha = fecha;
        this.destino = destino;
        this.minibus1 = m1;
        this.minibus2 = m2;
    }
    
    // en Viaje
    public String agregarAlumno(Alumno a) {
        Minibus elegido;

        // comparar lugares libres (no diml)
        if (minibus1.getLugaresLibres() >= minibus2.getLugaresLibres()) {
            elegido = minibus1;
        } else {
            elegido = minibus2;
        }

    // intentar agregar en el elegido; si no hay lugar (caso borde) probamos el otro
        if (elegido.agregarAlumno(a)) {
            return elegido.getPatente();
        } else {
            // intento en el otro minibus (por si hubo empate y el elegido quedó lleno)
            Minibus otro = (elegido == minibus1) ? minibus2 : minibus1;
        if (otro.agregarAlumno(a)) {
            return otro.getPatente();
        } 
        else {
            return "No hay lugar en ninguno de los minibuses";
        }
    }
        
    
}

    public void asignarPoliza(int dni, int nuevaPoliza) {
        minibus1.asignarPoliza(dni, nuevaPoliza);
        minibus2.asignarPoliza(dni, nuevaPoliza);
    }

    
    public int alumnosObraSocial(String obra) {
        int total = 0;
        total += minibus1.alumnosObraSocial(obra);
        total += minibus2.alumnosObraSocial(obra);
        return total;
    }
    
    @Override
    public String toString (){
        String aux = ""; 
        int totalAlumnos= minibus1.getDiml() + minibus2.getDiml(); 
        aux += "Fecha: "+ fecha;
        aux+= "Minibus 1: "+ minibus1.toString() + "\n";
        aux+= "Minibus 2: "+ minibus2.toString() + "\n";
        return aux; 
    }
    
}

