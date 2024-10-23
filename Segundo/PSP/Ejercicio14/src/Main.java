import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce unha frase:");
        String frase = sc.nextLine();

        // Creación de fíos para contar cada vogal
        Thread fío1 = new Thread(new ContadorVogais("Fío 1", 'a', frase));
        Thread fío2 = new Thread(new ContadorVogais("Fío 2", 'e', frase));
        Thread fío3 = new Thread(new ContadorVogais("Fío 3", 'i', frase));
        Thread fío4 = new Thread(new ContadorVogais("Fío 4", 'o', frase));
        Thread fío5 = new Thread(new ContadorVogais("Fío 5", 'u', frase));

        // Inicio dos fíos
        fío1.start();
        fío2.start();
        fío3.start();
        fío4.start();
        fío5.start();

        // Espera a que todos os fíos rematen
        try {
            fío1.join();
            fío2.join();
            fío3.join();
            fío4.join();
            fío5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}