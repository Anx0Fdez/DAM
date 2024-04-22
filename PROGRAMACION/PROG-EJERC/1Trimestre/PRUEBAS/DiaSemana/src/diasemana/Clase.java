
package diasemana;


public class Clase {
    public void comprobarMaior (int num, int dia){

        if (dia == 1){
            System.out.println("Lunes");
        }
        else if (dia == 2){
            System.out.println("Martes");
        }
        else if (dia == 3){
            System.out.println("Miercoles");
        }
        else if (dia == 4) {
            System.out.println("Jueves");
        }
        else if (dia == 5) {
            System.out.println("Viernes");
        }
        else if (dia == 6) {
            System.out.println("Sabado");
        }
        else if (dia == 7) {
            System.out.println("Domingo");
        }
         else if (dia > 8) {
            System.out.println("O numero non corresponde a ningun dia da semana");
        }
         else if (dia < 1) {
            System.out.println("O numero non corresponde a ningun dia da semana");
        }
        
    }
}
    
    
