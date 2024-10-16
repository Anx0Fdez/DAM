import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * La clase App proporciona funcionalidad para editar o crear un archivo usando un editor de texto.
 */
public class FileEditor {

    // Objeto Scanner para leer la entrada del usuario
    Scanner sc = new Scanner(System.in);

    /**
     * Este método permite al usuario editar un archivo existente o crear uno nuevo usando un editor de texto.
     * Se le pide al usuario que ingrese la ruta del archivo que desea editar o crear.
     */
    public void userEdit() {
        // Pedir al usuario que ingrese la ruta del archivo
        System.out.print("Introduce la ruta del archivo que deseas editar o crear: ");
        String path = sc.nextLine();

        // Convertir la entrada del usuario a un objeto Path
        Path path1 = Paths.get(path);

        // Verificar si el archivo existe
        boolean exists = Files.isRegularFile(path1);

        // Crear un ProcessBuilder para abrir el archivo con KWrite
        ProcessBuilder processBuilder = new ProcessBuilder("kwrite", path1.toString());

        if (exists) {
            // Si el archivo existe, intentar abrirlo con KWrite
            try {
                processBuilder.start();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else {
            // Si el archivo no existe, crearlo y luego abrirlo con KWrite
            try {
                Files.createFile(path1);
                processBuilder.start();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}