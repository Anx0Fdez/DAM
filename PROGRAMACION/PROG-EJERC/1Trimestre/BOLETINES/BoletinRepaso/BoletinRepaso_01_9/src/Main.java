import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int suma = 0;

        while (suma < 100) {
            System.out.print("Ingresa un número: ");
            int numero = scanner.nextInt();

            suma += numero;

            if (suma >= 100) {
                System.out.println("La suma ha alcanzado o superado 100. Resultado: " + suma);
                break;
            }
        }

        // Cierra el scanner para evitar posibles problemas de fuga de recursos
        scanner.close();
    }
}
