
package boletin06_1;

import javax.swing.JOptionPane;

/**
 *
 * @Anx0Fdez
 */
public class Boletin06_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        // TODO O COCHE
        Coche coche = new Coche();
        
        coche.acelerar((int) Float.parseFloat(JOptionPane.showInputDialog("Introduce aceleracion : ")));
        
        coche.frenar((int) Float.parseFloat(JOptionPane.showInputDialog("Introduce frenada : ")));
        
        JOptionPane.showMessageDialog(null, "Velocidad final = "+coche.getVelocidade());
    }
    
}   
    

