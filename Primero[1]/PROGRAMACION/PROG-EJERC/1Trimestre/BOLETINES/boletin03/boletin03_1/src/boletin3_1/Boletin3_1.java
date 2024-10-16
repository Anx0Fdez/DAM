
package boletin3_1;

import java.util.Scanner;


public class Boletin3_1 {


    public static void main(String[] args) {
        float precio_tarifa, precio_pagado, descuento1, descuento_final;
        Scanner sc = new Scanner (System.in);
        
         System.out.println("teclea el precio de la tarifa:");
            precio_tarifa = sc.nextFloat();
            System.out.println("teclea el precio pagado:");
            precio_pagado = sc.nextFloat();

                descuento1 = (precio_pagado * 100) / precio_tarifa ;
                descuento_final = 100 - descuento1;
                    
                System.out.println("El porcentaje descontado en la factura final es de " + descuento_final + "%" );



    }
    
}
