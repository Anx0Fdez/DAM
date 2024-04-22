
package boletin05;

import java.util.Scanner;

public class Boletin05 {

    public static void main(String[] args) {
        consumo obxCon = new consumo ( );
        obxCon.setLitros(50f);
        obxCon.setPGas( 1.57f);
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce kilometros : ");
        float km = sc.nextFloat();
        System.out.print("Introduce litros : ");
        float li = sc.nextFloat();
        System.out.print("Introduce velocidad media : ");
        float vM = sc.nextFloat();
        System.out.print("Introduce precio gasolina : ");
        float pG = sc.nextFloat();
  
    
   consumo obxConP = new consumo (km, li, vM, pG );
   obxConP.consumoEuros ( );
   obxConP.consumoMedio ( );
    
 }
    
}
