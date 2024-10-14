
package boletin07_4;

public class nome_peso {
        public void comprobarPeso(String nom1, short peso1, String nom2, short peso2){
        if (peso1 > peso2){
            System.out.println(nom1+" pesa "+(peso1-peso2)+" kilos más que "+nom2);
        } else {
            System.out.println(nom2+" pesa "+(peso2-peso1)+" kilos más que "+nom1);
        }
    }
}
