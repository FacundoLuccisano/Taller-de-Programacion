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
 */
package Parciales.ParcialBanco;

/**
 *
 * @author Usuario
 */
public class BancoTradicional extends Banco{
    private String direccion; 
    private String localidad; 
    private int cantCuentas; 

    public BancoTradicional(String direccion, String localidad, String nom, int N) {
        super(nom, N);
        this.direccion = direccion;
        this.localidad = localidad;
        this.cantCuentas = 0;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getCantCuentas() {
        return cantCuentas;
    }

    public void setCantCuentas(int cantCuentas) {
        this.cantCuentas = cantCuentas;
    }
    
    @Override
    public boolean agregarCuenta (Cuenta C){
        if (C.getMoneda().equals("dolares")){
            if (this.cantCuentas < 100){
                boolean agregado= super.agregarCuenta(C); 
                if (agregado)
                    this.cantCuentas++;
                return agregado; 
            }
            else
                return false; 
        }
        else{
            return super.agregarCuenta(C); 
        }
    }
    
    @Override
    public boolean puedeRecibirTarjeta(int cbu){ 
        Cuenta c = super.obtenerCuenta(cbu); 
        boolean ok= false; 
        if (c.getMoneda().equals("pesos") && c.getMonto() >70000){
            ok = true;  
        }
        else {
            if (c.getMoneda().equals("dolares") && c.getMonto() > 500){
                ok = true; 
            } 
        }
        return ok; 
    }

    @Override
    public String toString() {
        return "direccion: " + direccion + ", localidad: " + localidad + ", canttidad de cuentas en dolares: " + cantCuentas +"\n"+ super.toString()+ "\n";
    }
    
    
    
}
