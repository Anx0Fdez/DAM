import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        // Crear un escáner para o usuario
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce un numero grande e contareiche a cantidade de numeros '2', '4', '6', '8'");
        String texto = scanner.nextLine();

        // Crear un contador atómico para almacenar o total de díxitos pares
        AtomicInteger totalDixitosPares = new AtomicInteger(0);

        // Crear e iniciar fíos para contar os numeros '2', '4', '6' e '8'
        Thread fío2 = new Thread(new ContadorDixitos(texto, '2', totalDixitosPares));
        Thread fío4 = new Thread(new ContadorDixitos(texto, '4', totalDixitosPares));
        Thread fío6 = new Thread(new ContadorDixitos(texto, '6', totalDixitosPares));
        Thread fío8 = new Thread(new ContadorDixitos(texto, '8', totalDixitosPares));

        // Iniciamos os fios
        fío2.start();
        fío4.start();
        fío6.start();
        fío8.start();

        // Esperar a que todos os fíos rematen
        try {
            fío2.join();
            fío4.join();
            fío6.join();
            fío8.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Total de dixitos pares: " + totalDixitosPares.get());
    }
}