import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Clase principal que manexa a entrada de texto e a execución dos fíos
 * para contar o número total de vogais no texto.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce o texto: ");
        String text = scanner.nextLine();
        scanner.close();

        // Variable compartida para almacenar o contador total de vogais
        AtomicInteger totalVowelCount = new AtomicInteger(0);
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};

        // Crear e iniciar un fío para cada vogal
        Thread[] threads = new Thread[5];
        for (int i = 0; i < vowels.length; i++) {
            threads[i] = new Thread(new ContadorVogais(text, vowels[i], totalVowelCount));
            threads[i].start();
        }

        // Agardar a que todos os fíos rematen
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        // Imprimir o número total de vogais
        System.out.println("Número total de vogais: " + totalVowelCount.get());
    }
}