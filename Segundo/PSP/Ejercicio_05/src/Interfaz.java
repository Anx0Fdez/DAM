import java.util.Scanner;

/**
 * Interactúa co usuario para executar comandos.
 */

public class Interfaz {
    /**
     * Punto de entrada do programa.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Por favor, introduce o comando que queres executar: ");
        String command = sc.nextLine();

        System.out.print("Por favor, introduce os parámetros para o comando: ");
        String params = sc.nextLine();

        Ejecutor e = new Ejecutor();
        String result = e.executeCommand(command, params);

        System.out.println("Comando executado: " + command + " " + params);
        System.out.println("Saída do proceso: \n" + result);
    }
}