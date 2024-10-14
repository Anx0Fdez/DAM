package examenprogramacion;

import java.util.Scanner;

/**
 * @author Anxo
 */
public class FeriaCoches {

    Scanner scanner = new Scanner(System.in);
    int opcion;
    Coche c;

    public void amosar() {
        System.out.println("Marca: " + c.marca + ".\nPrezo: " + c.prezo);
    }

    public float baixarPrezo(float porcentaxe) {
        float resultado = c.prezo - (c.prezo * porcentaxe / 100f);
        System.out.println("Has bajado el precio en un " + porcentaxe + "%.");
        return resultado;
    }

    public void programa() {
        do {
            System.out.println("\n1. Amosar Coche");
            System.out.println("2. Rebaixar Prezo");
            System.out.println("0. Saír");
            System.out.print("Escolle unha opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> amosar();
                case 2 -> {
                    System.out.print("Introduce a porcentaxe de desconto: ");
                    float porcentaxe = scanner.nextFloat();
                    float prezoFinalDesconto = baixarPrezo(porcentaxe);
                    System.out.println("Prezo final co desconto: " + prezoFinalDesconto);
                }
                case 0 -> System.out.println("Saíndo do programa.");
                default -> System.out.println("Opción non válida.");
            }

        } while (opcion != 0);

        scanner.close();
    }

}