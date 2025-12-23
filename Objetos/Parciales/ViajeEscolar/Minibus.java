/*

 */
package Parciales.ViajeEscolar;

/**
 *
 * @author Usuario
 */
public class Minibus {
    private String patente; 
    private int capacidadMax; 
    private int diml; 
    private Alumno[] vectorAlumnos; 
    
    public Minibus(String pat, int N){
        this.patente= pat; 
        this.capacidadMax= N; 
        this.diml=0; 
        vectorAlumnos = new Alumno[N]; 
        
    }
    
    public void inicializarVector (){
        for (int i=0; i< this.capacidadMax;i++){
            this.vectorAlumnos[i] = null; 
        }
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getCapacidadMax() {
        return capacidadMax;
    }

    public void setCapacidadMax(int capacidadMax) {
        this.capacidadMax = capacidadMax;
    }

    public Alumno[] getVectorAlumnos() {
        return vectorAlumnos;
    }

    public void setVectorAlumnos(Alumno[] vectorAlumnos) {
        this.vectorAlumnos = vectorAlumnos;
    }

    public int getDiml() {
        return diml;
    }

    public void setDiml(int diml) {
        this.diml = diml;
    }
    
    public int getLugaresLibres(){
        return this.capacidadMax - this.diml; 
    }
    
    public boolean agregarAlumno(Alumno a) {
    if (this.diml < this.capacidadMax) {
        this.vectorAlumnos[this.diml] = a;
        this.diml++;
        return true;
    } else {
        return false;
    }
}
    public void asignarPoliza(int dni, int nuevaPoliza){
        int i=0; 
        while (i<this.diml && this.vectorAlumnos[i].getDni()!= dni){
            i++;
        }
        if (i<this.diml){
            this.vectorAlumnos[i].setPolizaSeguro(nuevaPoliza);
        }
    }
    
    public int alumnosObraSocial(String obra){
        int cantAlumnos =0; 
        for (int i=0; i<this.diml; i++){
            if (this.vectorAlumnos[i].getObraSocial().equals(obra)){
                cantAlumnos++; 
            }
        }
        return cantAlumnos; 
    }
    
    @Override
    public String toString (){
        String aux="";
        aux += "Patente: "+ patente+ " Capacidad: " + capacidadMax;
        for (int i=0; i< this.diml; i++){
            if (this.vectorAlumnos[i]!=null){
                aux += this.vectorAlumnos[i].toString()+"\n";
            }
        }
        return aux; 
    }
    
}

