import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Copy {
    public void copiarTexto(String fileName) {
        Path path = Paths.get(fileName);
        if (!Files.exists(path)) {
            System.out.println("El archivo no existe");
            return;
        } else {
            try {
                FileInputStream in = new FileInputStream(path.toFile());
                FileOutputStream out = new FileOutputStream("texto2.txt");
                int i;
                while ((i = in.read()) != -1) {

                    out.write(i);
                }
                System.out.println("Texto copiado");
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
