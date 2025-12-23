/*
El concurso de canto debería crearse conociendo la cantidad de categorías y la cantidad máxima 
de canciones por categoría (la misma cantidad para todas las categorías). Las canciones deberían 
crearse con su identificador único, nombre, compositor y con el puntaje en cero. 
Los estudiantes deberían crearse con todos sus atributos.
 */
package Parciales.ParcialEscuelaCanto;

/**
 *
 * @author Usuario
 */
public class Estudiante {
    private String nombre; 
    private  String apellido; 
    private int dni; 

    public Estudiante(String nombre, String apellido, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public int getDni() {
        return dni;
    }
    
    
    
}
