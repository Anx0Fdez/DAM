package boletinrepaso_01_2;

import java.util.Scanner;

public class BoletinRepaso_01_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa 5 números:");

        for (int i = 0; i < 5; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            int numero = scanner.nextInt();
            System.out.println("Ingresaste: " + numero);
        }
    }
}

