package boletin09_03;

import javax.swing.JOptionPane;

public class AreaRect {
            
        float area;
        float alt ;
        float base ;
        
    public void CalcularArea (){

        
        float base = LerDatos.leerFloatPositivo("Introduce o valor da base: ");
        float alt = LerDatos.leerFloatPositivo("Introduce o valor da altura: ");

        float area = (base * alt) / 2;
        
        System.out.println("El area es --> " + area);
            return;
            }
    
}
