 
package boletin3_3;

import java.util.Scanner;

public class Boletin3_3 {


    public static void main(String[] args) {
    float billete_100, billete_20, billete_5, moneda1, euros100, euros20, euros5, euros_final;
        Scanner sc = new Scanner (System.in);
        
         System.out.println("Escribe el numero de billetes de 100:");
            billete_100 = sc.nextFloat();
         System.out.println("Escribe el numero de billetes de 20:");
            billete_20 = sc.nextFloat();
         System.out.println("Escribe el numero de billetes de 5:");
            billete_5 = sc.nextFloat();
         System.out.println("Escribe el numero de monedas de un euro:");
            moneda1 = sc.nextFloat();
            
            
         euros100 = billete_100 * 100;
         euros20 = billete_20 * 20;
         euros5 = billete_5 * 5;
         
         euros_final = euros100 + euros20 + euros5 + moneda1;
         
         System.out.println("La cantidad de dinero total es de: " + euros_final + " euros" );

                 
                 
               









    }
    
}
