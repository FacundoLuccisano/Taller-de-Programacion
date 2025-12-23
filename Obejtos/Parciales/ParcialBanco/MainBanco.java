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

2- Implemente los métodos necesarios, en las clases que correspondan, para:

a) agregarCuenta: Agrega una cuenta al banco. Considerar que un banco 
tradicional puede tener un máximo de 100 cuentas abiertas en 
dólares. El método debe retornar true si pudo agregarse y false en caso contrario.

b) obtenerCuenta: Dado un CBU, obtener la cuenta con dicho CBU.

c) depositarDinero: Dado un CBU y un monto, incrementar el monto de la cuenta en dicha cantidad.

d) puedeRecibirTarjeta: Recibe un CBU y retorna si es posible asociarle 
una tarjeta de débito a la cuenta. Este método retorna 
verdadero en las siguientes situaciones:

   
Si el banco es digital, la cuenta debe ser en pesos y su saldo superior a $100.000.
Si el banco es tradicional, la cuenta debe ser en dólares o pesos.
 Si es en dólares, con saldo superior a U$S 500.
 Si es en pesos, con saldo superior a $70.000.

3- Realice un programa que instancie un banco tradicional y otro digital. 
Agregue cuentas bancarias y realice las operaciones 
de los puntos 2.c y 2.d.
 */
package Parciales.ParcialBanco;

/**
 *
 * @author Usuario
 */
public class MainBanco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       BancoTradicional bt = new BancoTradicional ("122 y 50", " La Plata", "Banco Nacional", 10);
       BancoDigital bd = new BancoDigital("facundo@gmail.com", " La Pampa", 9);
       Cuenta cuenta1 = new Cuenta(234, "faculuccisano", 46415, "dolares"); 
       Cuenta cuenta2 = new Cuenta(165, "nahuel", 42345, "pesos"); 
       Cuenta cuenta3 = new Cuenta(983, "conrado", 34762, "dolares"); 
       Cuenta cuenta4 = new Cuenta(763, "normayjorge", 78237, "dolares"); 
       Cuenta cuenta5 = new Cuenta(623, "juan.perez", 21873, "pesos"); 
       
       bt.agregarCuenta(cuenta1);
       bt.agregarCuenta(cuenta2);
       bt.agregarCuenta(cuenta5);
       
       bd.agregarCuenta(cuenta4);
       bd.agregarCuenta(cuenta3);
       
       bt.depositarDinero(234, 100);
       bd.depositarDinero(983, 300);
       
        System.out.println(bt.toString());
        System.out.println(bd.toString());
    }
    
}
