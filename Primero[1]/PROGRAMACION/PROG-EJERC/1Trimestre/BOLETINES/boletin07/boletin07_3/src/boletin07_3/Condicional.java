
package boletin07_3;

import java.util.Scanner;

public class Condicional {
    int num1;
    
    Scanner sc= new Scanner (System.in);
    
    public void VerConAnidados () {
            System.out.println("Dame un valor ");

            int num1 = sc.nextInt();
            
            if(num1>0) {
                System.out.println("+");
                        }

            else if (num1 == 0){
                System.out.println("0");
                        }   
            else{
                System.out.println("-");
                        }           
            
            
            
         }            
}
    

