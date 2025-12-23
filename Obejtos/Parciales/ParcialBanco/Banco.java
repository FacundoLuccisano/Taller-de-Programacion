/*
Se desea representar un Banco. El Banco tiene su nombre, cantidad de empleados y 
la información de sus cuentas (máximo N cuentas). 
De cada cuenta se conoce su CBU, alias, DNI del titular, moneda y monto. 
Existen dos tipos de bancos: el tradicional que posee su 
dirección, localidad y cantidad de cuentas en dólares abiertas; 
y el digital que define su dirección web. 

1- Genere las clases necesarias. Provea constructores para iniciar los objetos 
del modelo a partir de la información necesaria. 
En particular, los bancos deben iniciarse para un máximo de N cuentas 
(inicialmente sin cuentas); el banco tradicional debe iniciar 
con cantidad 0 de cuentas en dólares abiertas; una cuenta debe iniciarse con monto en 0.

b) obtenerCuenta: Dado un CBU, obtener la cuenta con dicho CBU.

c) depositarDinero: Dado un CBU y un monto, incrementar el monto de la cuenta en dicha cantidad.
 */
package Parciales.ParcialBanco;

/**
 *
 * @author Usuario
 */
public abstract class Banco {
    private String nombre; 
    private int cantEmpleados; 
    private int diml; 
    private int maxCuentas; 
    private Cuenta [] vectorCuentas; 
    
    public Banco (String nom, int N){
        this.nombre= nom; 
        this.maxCuentas = N; 
        this.diml=0; 
        vectorCuentas = new Cuenta [maxCuentas];
        this.inicializarVector();
    }
    
    public void inicializarVector(){
        for (int i=0; i<this.maxCuentas; i++){
            this.vectorCuentas[i]= null; 
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantEmpleados() {
        return cantEmpleados;
    }

    public void setCantEmpleados(int cantEmpleados) {
        this.cantEmpleados = cantEmpleados;
    }

    public int getDiml() {
        return diml;
    }

    public void setDiml(int diml) {
        this.diml = diml;
    }

    public int getMaxCuentas() {
        return maxCuentas;
    }

    public void setMaxCuentas(int maxCuentas) {
        this.maxCuentas = maxCuentas;
    }

    public Cuenta[] getVectorCuentas() {
        return vectorCuentas;
    }

    public void setVectorCuentas(Cuenta[] vectorCuentas) {
        this.vectorCuentas = vectorCuentas;
    }
    
    public boolean hayEspacio(){
        return this.getDiml() < this.getMaxCuentas();
    }
    
    public boolean agregarCuenta (Cuenta C){
        if (hayEspacio()){
            this.vectorCuentas[diml++] = C; 
            return true; 
        }
        else
            return false; 
    }
    
    public Cuenta obtenerCuenta (int cbu){
        Cuenta cuentaBuscada=null; 
        int i=0; 
        while (i < this.diml && this.vectorCuentas[i].getCBU() != cbu){
            i++;
        }
        if (i<this.diml){
            cuentaBuscada = this.vectorCuentas[i];
        }
        return cuentaBuscada; 
    }
    
    public void depositarDinero (int cbu, double monto){
        int i=0; 
        while (i < this.diml && this.vectorCuentas[i].getCBU() != cbu){
            i++;
        }
        if (i<this.diml){
            this.vectorCuentas[i].setMonto(this.vectorCuentas[i].getMonto()+monto);
        }
    }
    
    public abstract boolean puedeRecibirTarjeta(int cbu); 
    
    @Override
    public String toString (){
        String aux =""; 
        aux += "Nombre: "+nombre; 
        for (int i=0; i<this.diml; i++){
            if (this.vectorCuentas[i] != null){
                aux+= this.vectorCuentas[i].toString() + "\n"; 
            }
        }
        return aux; 
    }
    
}

