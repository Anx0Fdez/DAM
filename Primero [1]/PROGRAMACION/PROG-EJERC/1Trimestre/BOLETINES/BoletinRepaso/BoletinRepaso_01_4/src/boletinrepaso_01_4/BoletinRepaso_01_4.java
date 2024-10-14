package boletinrepaso_01_4;

import java.util.Scanner;

public class BoletinRepaso_01_4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa 4 números (los números no pueden ser negativos):");

        for (int i = 0; i < 4; i++) {
            int numero;
            do {
                System.out.print("Número " + (i + 1) + ": ");
                numero = scanner.nextInt();
                if (numero < 0) {
                    System.out.println("Error: No se permiten números negativos. Inténtalo de nuevo.");
                }
            } while (numero < 0);

            System.out.println("Ingresaste: " + numero);
        }
    }
}