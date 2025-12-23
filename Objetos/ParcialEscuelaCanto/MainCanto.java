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

--> Agregar una nueva canción al concurso en una determinada categoría (
suponga que en dicha categoría hay lugar para la canción).

--> Interpretar una canción. Se recibe el identificador de la canción (que seguro existe),
el estudiante que hace la interpretación y el puntaje otorgado por los profesores. 
Si el puntaje otorgado es más grande que el puntaje actual de la canción, 
se actualiza el puntaje y el estudiante “ganador” para la canción.

--> Conocer el estudiante “ganador” de una canción, dado el identificador de la canción (que seguro existe)
devuelve el estudiante que haya obtenido el puntaje más alto, o null si ningún estudiante interpretó la canción.

--> Conocer la canción con el puntaje más grande en una determinada categoría.

Implemente un programa principal que realice lo siguiente:

--> Cree un concurso de tres categorías y cinco canciones como máximo para cada categoría.

--> Agregue cinco nuevas canciones.

--> Vaya leyendo de teclado nombre, apellido y dni del estudiante, junto con el
identificador de la canción y puntaje otorgado, hasta ingresar un identificador igual a cero.
“Simule” las interpretaciones de las canciones por los estudiantes invocando al método correspondiente.

--> Lea un identificador de canción por teclado (que seguro existe) e informe el nombre,
apellido y dni del estudiante “ganador”. OJO que la canción puede no haber sido
interpretada por ningún estudiante, en cuyo caso se debería informar “Nadie”.

--> El nombre y compositor de la canción mejor interpretada para cada una de las cinco categoríasr.
 */
package Parciales.ParcialEscuelaCanto;

/**
 *
 * @author Usuario
 */
public class MainCanto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // 1️⃣ Crear concurso con 3 categorías y 5 canciones máximo por categoría
        Concurso concurso = new Concurso(3, 5);

        // 2️⃣ Agregar 5 canciones
        concurso.agregarCancion(0, new Cancion(1, "Cancion A", "Compositor 1"));
        concurso.agregarCancion(0, new Cancion(2, "Cancion B", "Compositor 2"));
        concurso.agregarCancion(1, new Cancion(3, "Cancion C", "Compositor 3"));
        concurso.agregarCancion(1, new Cancion(4, "Cancion D", "Compositor 4"));
        concurso.agregarCancion(2, new Cancion(5, "Cancion E", "Compositor 5"));

        // 3️⃣ Simular interpretaciones de los estudiantes
        Estudiante e1 = new Estudiante("Juan", "Perez", 12345678);
        Estudiante e2 = new Estudiante("Ana", "Gomez", 87654321);
        Estudiante e3 = new Estudiante("Luis", "Diaz", 11223344);

        concurso.interpretarCancion(1, e1, 8.5); // Juan interpreta Cancion A
        concurso.interpretarCancion(2, e2, 9.0); // Ana interpreta Cancion B
        concurso.interpretarCancion(3, e3, 7.5); // Luis interpreta Cancion C
        concurso.interpretarCancion(1, e2, 9.2); // Ana supera a Juan en Cancion A

        // 4️⃣ Mostrar ganador de una canción específica
        int idBuscar = 1; // Cancion A
        Estudiante ganador = concurso.conocerGanador(idBuscar);
        if(ganador != null) {
            System.out.println("Ganador de la canción " + idBuscar + ": " + ganador);
        } else {
            System.out.println("Ganador de la canción " + idBuscar + ": Nadie");
        }

        // 5️⃣ Mostrar canción mejor interpretada por categoría
        System.out.println("\nCanción mejor interpretada por categoría:");
        for(int i=0; i<3; i++) {
            Cancion mejor = concurso.mayorPuntaje(i);
            if(mejor != null) {
                System.out.println("Categoría " + i + ": " + mejor.getNombre() + " de " + mejor.getNombre()+
                                   " con puntaje " + mejor.getPuntaje());
            } else {
                System.out.println("Categoría " + i + ": No hay canciones");
            }
        }
    }
}


    
