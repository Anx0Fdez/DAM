
package valoresaleatorios_compararstrings;

import java.util.Random;

public class RandomNumber {

public class Main {
    
    public static void main(String[] args) {
        Random random = new Random();
       
        int min = 1;
        int max = 40;
        for (int i = 0; i < 3; i++) {
        int numeroAleatorio = random.nextInt(max - min + 1) + min;
                System.out.println("Número aleatorio " + (i + 1) + ": " + numeroAleatorio);
        }
    }
}

}

