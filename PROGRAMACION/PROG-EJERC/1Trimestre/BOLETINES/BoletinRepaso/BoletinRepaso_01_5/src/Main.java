import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa 4 números (los números no pueden ser negativos):");

        int suma = 0;

        for (int i = 0; i < 4; i++) {
            int numero;
            do {
                System.out.print("Número " + (i + 1) + ": ");
                numero = scanner.nextInt();
                if (numero < 0) {
                    System.out.println("Error: No se permiten números negativos. Inténtalo de nuevo.");
                }
            } while (numero < 0);
            suma += numero;
            System.out.println("Ingresaste: " + numero);
        }

        System.out.println("La suma de los 4 números es: " + suma);
    }
}
