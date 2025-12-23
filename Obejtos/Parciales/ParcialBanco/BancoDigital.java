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
public class BancoDigital extends Banco{
    private String direccionWeb; 

    public BancoDigital(String direccionWeb, String nom, int N) {
        super(nom, N);
        this.direccionWeb = direccionWeb;
    }

    public String getDireccionWeb() {
        return direccionWeb;
    }

    public void setDireccionWeb(String direccionWeb) {
        this.direccionWeb = direccionWeb;
    }
    
    @Override
    public boolean agregarCuenta (Cuenta C){
        return super.agregarCuenta(C); 
    }
    
    @Override
    public boolean puedeRecibirTarjeta(int cbu){
        Cuenta c= super.obtenerCuenta(cbu); 
        boolean ok = false; 
        if (c.getMoneda().equals("pesos") && c.getMonto() >100000){
            ok= true; 
        }
        return ok; 
    } 
    
    @Override
    public String toString (){
        return "direccion web: "+ direccionWeb+super.toString() + "\n";
    }
    
}
