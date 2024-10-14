import java.util.InputMismatchException;
import java.util.Scanner;

public class Solicitud implements Validador{
    Scanner sc = new Scanner(System.in);
    int a;
    @Override
    public boolean numAceptado() {
         a = sc.nextInt();
        return false;
    }

    public void bucleSolicitudes() {
        System.out.println("\n Para introducir numero pulsa: 1 \n Para salir del programa pulsa: 0");
        numAceptado();
        switch (a) {
            case 1:
                System.out.println("Introduce un número: ");
                int numIntroducido;
                try {
                    numIntroducido = sc.nextInt();

                    if (numIntroducido % 2 == 0) {
                        System.out.println("El número es Par \n");
                    } else {
                        System.out.println("El número es Impar \n");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error: Solo se puede entroducir numeros enteros.");
                }
            case 0:
                System.out.println("Saliste del Programa");
                break;
        }
    }


}
