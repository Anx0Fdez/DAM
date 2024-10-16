import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa la longitud del lado del cuadrado: ");
        double lado = scanner.nextDouble();

        // Calcula el área del cuadrado (lado * lado)
        double area = lado * lado;

        System.out.println("El área del cuadrado con lado " + lado + " es: " + area);

    }
}