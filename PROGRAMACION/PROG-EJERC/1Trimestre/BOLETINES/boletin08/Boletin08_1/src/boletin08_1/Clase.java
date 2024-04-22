package boletin08_1;

import javax.swing.JOptionPane;


public class Clase {
        public void VentasProductos (){
         
         String nome = JOptionPane.showInputDialog ("Teclea o nome do producto:");
         int ventas = Integer.parseInt(JOptionPane.showInputDialog ("Teclea o numero de ventas:"));
             
                if (ventas <= 100){
                    JOptionPane.showMessageDialog(null, "O producto " + nome + "e un artigo de consumo baixo");}
                if  ( 100 > ventas && ventas <= 500){
                    JOptionPane.showMessageDialog(null, "O producto " + nome + "e un artigo de consumo medio");}
                if (500 < ventas && ventas <= 1000){
                    JOptionPane.showMessageDialog(null, "O producto " + nome + "e un artigo de consumo alto");}
                if (ventas > 1000){
                    JOptionPane.showMessageDialog(null, "O producto " + nome + "e un artigo de consumo primeira necesidade");}
  }
}
