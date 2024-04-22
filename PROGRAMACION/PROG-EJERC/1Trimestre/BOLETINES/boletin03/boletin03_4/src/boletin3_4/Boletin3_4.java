
package boletin3_4;

import java.util.Scanner;

public class Boletin3_4 {


    public static void main(String[] args) {
        float dinero, b100, b20, b5, moneda1;
        Scanner sc = new Scanner (System.in);
        System.out.println("Escribe una cantidad de dinero:");
        dinero = sc.nextFloat();
        
            b100 = dinero / 100;
            b20 = dinero / 20;
            b5 = dinero / 5;
            moneda1 = dinero;
            
        System.out.println("Esa cantidad de dinero equivale a: " + b100 + " billetes de 100 euros");
        System.out.println("Esa cantidad de dinero equivale a:" + b20 + " billetes de 20 euros");
        System.out.println("Esa cantidad de dinero equivale a: "+ b5 + " billetes de 5 euros");
        System.out.println("Esa cantidad de dinero equivale a: " + moneda1 + " monedas de 1 euro");
                    
        
        
        
        
        
        
    }
    
}
