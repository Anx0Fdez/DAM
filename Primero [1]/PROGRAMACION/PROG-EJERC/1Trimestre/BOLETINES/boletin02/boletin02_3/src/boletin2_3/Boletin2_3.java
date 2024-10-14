package boletin2_3;

import java.util.Scanner;

public class Boletin2_3 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner (System.in);
        System.out.println("teclea la cantidad en euros:");
        float euros = sc.nextFloat();
        float cambio =1,0831;
        float $ = (cambio*euros);
        System.out.println($ + "dolares");

    }
    
}

