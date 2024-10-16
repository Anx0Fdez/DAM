import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * La clase CopyTXT proporciona un método para copiar el contenido de un archivo a otro.
 */
public class CopyTXT {

    /**
     * Copia el contenido de un archivo a otro.
     *
     * @param fileName La ruta del archivo donde se pegará el contenido.
     */
    public void copiarTexto(String fileName) {
        // Verifica si el archivo existe
        Path path = Paths.get(fileName);
        if (!Files.exists(path)) {
            // Si el archivo no existe, imprime un mensaje y termina el metodo
            System.out.println("El archivo no existe");
            return;
        } else {
            // Si el archivo existe, copia el contenido a otro archivo
            try {
                // Abre el archivo en modo lectura
                FileInputStream in = new FileInputStream(path.toFile());
                // Pide al usuario la ruta del archivo donde se pegará el contenido
                System.out.println("Escribe la ruta del archivo que quieres copiar:");
                Scanner sc = new Scanner(System.in);
                String a = sc.nextLine();
                // Abre el archivo en modo escritura
                FileOutputStream out = new FileOutputStream(a);
                // Copia el contenido del archivo
                byte[] buffer = new byte[1024];
                int bytesRead;
                // Lee el archivo y escribe en el otro archivo
                while ((bytesRead = in.read(buffer)) != -1) {
                    // Escribe en el archivo
                    out.write(buffer, 0, bytesRead);
                }
                // Cierra los archivos
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}