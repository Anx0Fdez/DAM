
package boletin07_4;

import java.util.Scanner;

public class Boletin07_4 {

     public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un nome persoa 1: ");
        String nom1 = sc.nextLine();
        System.out.print("Introduce un peso persoa 1: ");
        short peso1 = sc.nextShort();
        
        sc.nextLine(); // limpia el buffer, si no se pone se salta el nombre de persoa 2 por alguna razon
        
        System.out.print("Introduce un nome persoa 2: ");
        String nom2 = sc.nextLine();
        System.out.print("Introduce un peso persoa 2: ");
        short peso2 = sc.nextShort();
        
        nome_peso obx = new nome_peso();
        obx.comprobarPeso(nom1, peso1, nom2, peso2);

          }
    }
    
