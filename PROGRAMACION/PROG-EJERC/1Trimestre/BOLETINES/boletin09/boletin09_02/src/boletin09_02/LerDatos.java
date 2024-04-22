package boletin09_02;

import javax.swing.JOptionPane;

public class LerDatos {
    
    public static int lerEnteiro(String mensaxe){
        
        int resposta = Integer.parseInt(JOptionPane.showInputDialog(mensaxe));
        return resposta;
        
    }
    
    
    
    
}
