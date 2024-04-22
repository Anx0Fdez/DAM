import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double lado;

        do {
            System.out.print("Ingresa la longitud del lado del cuadrado (debe ser mayor o igual a cero): ");
            lado = scanner.nextDouble();

            if (lado < 0) {
                System.out.println("Error: La longitud del lado no puede ser negativa. Inténtalo de nuevo.");
            }
        } while (lado < 0);

        // Calcula el área del cuadrado (lado * lado)
        double area = lado * lado;

        System.out.println("El área del cuadrado con lado " + lado + " es: " + area);

    }
}