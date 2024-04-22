package boletin2_4;

import java.util.Scanner;

public class Boletin2_4 {

    public static void main(String[] args) {
        float n1, n2, suma, resta, producto, cociente;
        Scanner sc = new Scanner (System.in);
            System.out.println("teclea el numero 1:");
            n1 = sc.nextFloat();
            System.out.println("teclea el numero 2:");
            n2 = sc.nextFloat();
            
            suma = n1+n2;
            resta = n1-n2;
            producto = n1*n2;
            cociente = n1/n2;
            
            System.out.println("La suma es =" + suma);
            System.out.println("La resta es =" + resta); 
            System.out.println("La producto es =" + producto);
            System.out.println("La cociente es =" + cociente);             
    }
    
}
