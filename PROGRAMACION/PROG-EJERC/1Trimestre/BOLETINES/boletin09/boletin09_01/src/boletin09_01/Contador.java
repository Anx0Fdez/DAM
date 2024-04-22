
package boletin09_01;

public class Contador {


        public void contarNumeros(){

        int i = 0;
        int negativo = 0;
        int positivo = 0;
        int cero = 0;

    while (i < 10){

            int num = LerDatos.lerEnteiro("Teclea numero");

            if (num == 0){
                cero++;
            }

            else if (num < 0) {
                negativo++;
            }

            else {
                positivo++ ;
            }
            
            i++;
            
        }
    
            System.out.println("Numero de ceros --> " + cero);
            System.out.println("Numeros positivos --> " + positivo);
            System.out.println("Numero negativos --> " + negativo);

        }
    }
