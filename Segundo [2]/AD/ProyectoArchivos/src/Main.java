import java.util.Scanner;

/**
 * La clase Main sirve como punto de entrada para la aplicación.
 * Crea una instancia de la clase Rutas y proporciona una interfaz basada en un menú
 * para demostrar varias funcionalidades relacionadas con operaciones de archivos y directorios.
 */
public class Main {
    public static void main(String[] args) {
        Rutas rutas = new Rutas();

        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            // Mostrar las opciones del menú al usuario
            System.out.println("1. Crear directorio");
            System.out.println("2. Crear archivo");
            System.out.println("3. Modo de acceso");
            System.out.println("4. Calcular longitud");
            System.out.println("5. Cambiar permisos de lectura");
            System.out.println("6. Cambiar permisos de escritura");
            System.out.println("7. Eliminar archivo");
            System.out.println("8. Eliminar directorio");
            System.out.println("9. Mostrar contenido de un archivo");
            System.out.println("10. Salir");
            System.out.println("Introduce una opción: ");
            opcion = sc.nextInt();

            // Ejecutar el método correspondiente según la elección del usuario
            switch (opcion) {
                case 1:
                    rutas.crearDirectorio();
                    break;
                case 2:
                    rutas.crearFicheiro();
                    break;
                case 3:
                    rutas.modoAcceso();
                    break;
                case 4:
                    rutas.calculaLonxitude();
                    break;
                case 5:
                    rutas.mLectura();
                    break;
                case 6:
                    rutas.mEscritura();
                    break;
                case 7:
                    rutas.borraFicheiro();
                    break;
                case 8:
                    rutas.borraDirectorio();
                    break;
                case 9:
                    rutas.mContido();
                    break;
                case 10:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcion != 10); // Continuar hasta que el usuario elija salir
    }
}