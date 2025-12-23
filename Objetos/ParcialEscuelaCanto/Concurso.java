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
public class Concurso {
    private int numCategorias;
    private int maxCancionesPorCategoria;
    private Cancion[][] canciones; // filas = categorías, columnas = canciones
    private int[] vectorCanciones; // para saber cuántas canciones hay en cada categoría
    
    public Concurso (int cantCat, int cantidadCanciones){
        this.numCategorias = cantCat;
        this.maxCancionesPorCategoria= cantidadCanciones;
        canciones = new Cancion [numCategorias][maxCancionesPorCategoria];
        this.inicializarMatriz();
        vectorCanciones = new int[numCategorias];
        this.inicializarVector();
    }
    
    public void inicializarMatriz (){
        for (int i=0; i<this.numCategorias; i++){
            for (int j=0; j< this.maxCancionesPorCategoria; j++){
                this.canciones[i][j]= null; 
            }
        }
    }
    
    public void inicializarVector (){
        for (int i=0; i<this.maxCancionesPorCategoria; i++){
            this.vectorCanciones[i] =0; 
        }
    }
    
    public void agregarCancion (int nroCat, Cancion c){
        if(this.vectorCanciones[nroCat] < this.maxCancionesPorCategoria){
            this.canciones[nroCat][this.vectorCanciones[nroCat]]= c; 
            this.vectorCanciones[nroCat]++; 
        }
    }
    
    public void interpretarCancion (int ID, Estudiante e, double punt){
        for (int i=0; i<this.numCategorias; i++){
            for (int j=0; j< this.maxCancionesPorCategoria; j++){
                if (this.canciones[i][j].getId()== ID){
                    this.canciones[i][j].setGanador(e);
                    this.canciones[i][j].setPuntaje(punt);
                }
            }
        }
    }
    
    public Estudiante conocerGanador (int IDcancion){
        Estudiante ganador = null; 
        for (int i=0; i<this.numCategorias; i++){
            for (int j=0; j<this.vectorCanciones[i]; j++){
                if (this.canciones[i][j].getId() == IDcancion){
                    ganador = this.canciones[i][j].getGanador(); 
                }
            }
        }
        return ganador; 
    }
    
    public Cancion mayorPuntaje (int cat){
        Cancion mejorPunteada = null;
        double maxPuntaje=-1; 
            for (int j=0; j<this.vectorCanciones[cat]; j++){
                if (this.canciones[cat][j].getPuntaje() > maxPuntaje){
                    maxPuntaje = this.canciones[cat][j].getPuntaje(); 
                    mejorPunteada = this.canciones[cat][j]; 
                }
                
            }
        return mejorPunteada; 
    }
    
}
