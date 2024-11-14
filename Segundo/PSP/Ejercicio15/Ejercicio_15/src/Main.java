import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Creación dun obxecto Scanner para ler a entrada do usuario
        Buzon buzon = new Buzon(); // Creación dun obxecto Buzon
        int opcion; // Variable para almacenar a opción seleccionada polo usuario

        do {
            // Mostra o menú de opcións
            System.out.println("1. Escribir mensaxe");
            System.out.println("2. Ler mensaxes");
            System.out.println("3. Saír");
            System.out.print("Selecciona unha opción: ");
            opcion = sc.nextInt(); // Lese a opción seleccionada polo usuario
            sc.nextLine(); // Lese a liña seguinte para evitar problemas co Scanner

            switch (opcion) {
                case 1:
                    System.out.print("Escribindo mensaxe: ");
                    String mensaxe = sc.nextLine(); // Lese a mensaxe escrita polo usuario
                    Thread escritorThread = new Thread(new Escritor(buzon, mensaxe)); // Créase un fío para o escritor
                    escritorThread.start(); // Iníciase o fío
                    break;
                case 2:
                    Thread lectorThread = new Thread(new Lector(buzon)); // Créase un fío para o lector
                    lectorThread.start(); // Iníciase o fío
                    break;
                case 3:
                    System.out.println("Saíndo...");
                    break;
                default:
                    System.out.println("Opción non válida");
                    break;
            }
        } while (opcion != 3); // O bucle repítese mentres a opción non sexa 3

        sc.close(); // Péchase o Scanner
    }
}