
package boletin3_2;

import java.util.Scanner;


public class Boletin3_2 {

    public static void main(String[] args) {
        float grados_c, grados_f, grados_k;
        Scanner sc = new Scanner (System.in);
        System.out.println("Dime que grados hace en grados Centigrados y te los pasare a Fahrenheit y Kelvin :");
            grados_c = sc.nextFloat();
        
            grados_f = grados_c * 9/5;
            grados_k = grados_c + 273;
            
            System.out.println("Equivale a " + grados_f + " Fahrenheit y a " + grados_k + " Kelvin" );

        
        









    }
    
}
