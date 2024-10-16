
package boletin06_2;

import javax.swing.JOptionPane;

/**
 *
 * @AnxoFdez
 */
public class Boletin06_2 {

     public static void main(String[] args) {
        // TODO code application logic here
        
        double meridiano = Double.parseDouble(JOptionPane.showInputDialog("Introduce meridiano : "));
        double paralelo = Double.parseDouble(JOptionPane.showInputDialog("Introduce paralelo : "));
        double distancia = Double.parseDouble(JOptionPane.showInputDialog("Introduce distancia a terra : "));
        Satelite satelite = new Satelite(meridiano, paralelo, distancia);
      
        satelite.verPosicion();
    }
    
}
