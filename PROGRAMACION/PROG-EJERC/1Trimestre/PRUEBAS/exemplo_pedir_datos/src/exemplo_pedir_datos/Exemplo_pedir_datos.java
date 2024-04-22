package exemplo_pedir_datos;

import java.util.Scanner;

public class Exemplo_pedir_datos {

    public static void main(String[] args) {


//      area dun rectagulo
//      pedir datos

            float base, altura, area;
            Scanner sc = new Scanner (System.in);
            System.out.println("teclea base:");
            base = sc.nextFloat();
            System.out.println("teclea altura:");
            altura = sc.nextFloat();
            area = base*altura;
            System.out.println("a area do rectangulo é =" +area); 
            
            
//       calculo area dun circulo

            System.out.println("teclea o radio:");
            float ra=sc.nextFloat();
            float lonxitude = (float) (2*Math.PI*ra);
            System.out.println("lonxitude =" + lonxitude); 
            
            
            
    }
        
}
