
package boletin06_3;

/**
 *
 * @author AnxoFdez
 */
public class Boletin06_3 {

    public static void main(String[] args) {
        // TODO code application logic here
        //constructor parametrizado
        Circulo circulo = new Circulo(100);
        System.out.println("Area del circulo = "+circulo.calcularArea());
        System.out.println("Lonxitude del circulo = "+circulo.calcularLonxitude());
        
        //constructor por defecto
        Circulo circ = new Circulo();
        circ.setRadio(50);
        
        System.out.println("Area del circulo = "+circulo.calcularArea());
        System.out.println("Lonxitude del circulo = "+circulo.calcularLonxitude());
         
    }
    
}
