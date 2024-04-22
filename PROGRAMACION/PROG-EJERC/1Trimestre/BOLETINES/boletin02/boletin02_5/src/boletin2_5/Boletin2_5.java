package boletin2_5;

import java.util.Scanner;

public class Boletin2_5 {
    
    public static void main(String[] args) {
    
    float conversion=1852;
   Scanner sc = new Scanner (System.in);
           
    float mm, metros;
    
    System.out.println("Introduce la equivalencia en millas marinas:");

        mm = sc.nextFloat();
        metros = mm*conversion;
    
    
    System.out.println("Cantidad de metros = " + metros);

            
    }
    
}
