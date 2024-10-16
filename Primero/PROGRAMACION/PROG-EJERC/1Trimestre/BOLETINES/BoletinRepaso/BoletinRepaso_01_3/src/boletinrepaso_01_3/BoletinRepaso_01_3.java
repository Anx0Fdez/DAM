
package boletinrepaso_01_3;

import java.util.Scanner;

public class BoletinRepaso_01_3 {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Ingresa números (presiona 0 para terminar):");

            int numero;
            do {
                System.out.print("Número: ");
                numero = scanner.nextInt();
                System.out.println("Ingresaste el número: " + numero);
            } while (numero != 0);
        }
    }
