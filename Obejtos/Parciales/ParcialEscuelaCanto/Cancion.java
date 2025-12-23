/*
Una escuela de canto quiere organizar un concurso entre sus estudiantes y necesita un sistema que le permita 
administrar las canciones a interpretar, organizadas por categoría; además de conocer a los estudiantes 
que participan en el concurso. De las canciones se desea conocer su nombre, su compositor, 
su identificador (un número único para cada canción), el estudiante que hizo la mejor 
interpretación de la canción (el “ganador” de la canción) y el puntaje otorgado por los profesores. 
De los estudiantes se desea conocer su nombre, apellido y dni.
El concurso de canto debería crearse conociendo la cantidad de categorías y la cantidad máxima 
de canciones por categoría (la misma cantidad para todas las categorías). Las canciones deberían 
crearse con su identificador único, nombre, compositor y con el puntaje en cero. 
Los estudiantes deberían crearse con todos sus atributos.
Implemente las clases, atributos y métodos necesarios para poder realizar:
 */
package Parciales.ParcialEscuelaCanto;

/**
 *
 * @author Usuario
 */
public class Cancion {
    private int id;
    private String nombre;
    private String compositor;
    private double puntaje;
    private Estudiante ganador; 

    public Cancion(int id, String nombre, String compositor) {
        this.id = id;
        this.nombre = nombre;
        this.compositor = compositor;
        this.puntaje = 0; 
        this.ganador=null; 
    }

    public int getId() {
        return id;
    }

    public void setPuntaje(double puntaje) {
        this.puntaje = puntaje;
    }

    public void setGanador(Estudiante ganador) {
        this.ganador = ganador;
    }

    public String getNombre() {
        return nombre;
    }

    public Estudiante getGanador() {
        return ganador;
    }

    public double getPuntaje() {
        return puntaje;
    }

    
    
    
    
}
