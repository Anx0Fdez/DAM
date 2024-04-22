
package diasemana;

import javax.swing.JOptionPane;

public class CondicionalSwitch {
        public void verDiaSemana (){
            
            int dia = Integer.parseInt(JOptionPane.showInputDialog ("Teclea numero do dia :"));
            switch (dia){
                
                case 1 : System.out.println("Luns");
                           break;
                case 2: System.out.println("Martes");
                           break;
                case 3 : System.out.println("Mercores");
                           break;
                case 4 : System.out.println("Xoves");
                           break;
                case 5 : System.out.println("Venres");
                           break;
                case 6 : System.out.println("Sábado");
                           break;
                case 7 : System.out.println("Domingo");
                           break;
                default : System.out.println("Erro na opcion");

               }
            
            
            
            
            
            
            
            
            
        }

}
