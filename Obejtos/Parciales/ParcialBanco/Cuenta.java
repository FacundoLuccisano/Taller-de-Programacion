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
public class Cuenta {
    private int CBU; 
    private String alias; 
    private int DNI; 
    private String moneda; 
    private double monto; 

    public Cuenta(int CBU, String alias, int DNI, String moneda) {
        this.CBU = CBU;
        this.alias = alias;
        this.DNI = DNI;
        this.moneda = moneda;
        this.monto = 0;
    }

    public int getCBU() {
        return CBU;
    }

    public void setCBU(int CBU) {
        this.CBU = CBU;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return " Cuenta: " + "CBU: " + CBU + ", alias: " + alias + ", DNI: " + DNI + ", moneda: " + moneda + ", monto: " + monto + "\n";
    }
    
    
    
}
