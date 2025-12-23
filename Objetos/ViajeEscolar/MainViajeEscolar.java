/*
Se desea representar la información de un viaje escolar. 
Del viaje se conoce el nombre del colegio, la fecha, el destino y la información de los dos minibuses a utilizar.
Cada minibus tiene: patente, capacidad e información de los alumnos asignados allí. 
De cada alumno se conoce dni, nombre, póliza de seguro de viaje (numérica) y obra social.

1- Genere las clases necesarias y provea constructores para iniciarlas con la información necesaria. 
En particular, el viaje se crea recibiendo 2 minibuses. 
Cada minibus debe iniciarse con una capacidad máxima N e inicialmente sin alumnos.

2- Implemente los métodos necesarios, en las clases que corresponda, para:

a. Agregar un alumno al viaje. El método recibe un alumno A y lo debe agregar 
en el minibus con más lugares libres. El método debe retornar la 
patente del minibus a la cual fue agregado el alumno.

b. Dado un dni de alumno y una póliza de seguro, asignar la póliza al alumno con el dni recibido. 
El alumno puede estar en cualquiera de los dos minibuses.

c. Dada una obra social X, obtener la cantidad de alumnos con obra social X.

d. Obtener un String que represente el viaje, siguiendo el ejemplo:

Realice un programa que instancie un Viaje para el día "25/10/2024".
El Viaje recibe los minibuses con patente "AB123CD" con capacidad 20 pasajeros y "AB456CD"
con capacidad 28 pasajeros. Crear alumnos y agregarlos al viaje. Modificar la póliza de un alumno. 
Imprimir la representación del Viaje.
 */
package Parciales.ViajeEscolar;

/**
 *
 * @author Usuario
 */
public class MainViajeEscolar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Minibus minibus1 = new Minibus("AB123CD", 20); 
        Minibus minibus2 = new Minibus("AB456CD", 28); 
        Viaje viajesito = new Viaje ("Centenario","25/10/2024", "Bariloche", minibus1, minibus2 ); 
        
        Alumno alumno1 = new Alumno (46415, "Facundo", 7, "Ospedyc");
        Alumno alumno2 = new Alumno (8237, "Conra", 3, "Ioma");
        Alumno alumno3 = new Alumno (5871, "Noe", 1, "Galeno");
        Alumno alumno4 = new Alumno (56324, "Azul", 9, "Ioma");
        Alumno alumno5 = new Alumno (46415, "Veronica", 6, "Utedyc");
        
        viajesito.agregarAlumno(alumno1);
        viajesito.agregarAlumno(alumno2);
        viajesito.agregarAlumno(alumno3);
        viajesito.agregarAlumno(alumno4);
        viajesito.agregarAlumno(alumno5);
        
        System.out.println(viajesito.toString());
    }
    
}
