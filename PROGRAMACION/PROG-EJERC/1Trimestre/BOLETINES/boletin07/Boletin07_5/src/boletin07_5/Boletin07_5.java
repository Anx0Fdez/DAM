
package boletin07_5;

import java.util.Scanner;


public class Boletin07_5 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduce el primer número");
        int num1 = sc.nextShort();
        
        System.out.println("Introduce el segundo número");
        int num2 = sc.nextShort();
        
        System.out.println("Introduce el tercer número");
        int num3 = sc.nextShort();     
        
        NumMayor obx = new NumMayor();

        obx.comprobarMaior(num1, num2, num3);

    }
    
}
