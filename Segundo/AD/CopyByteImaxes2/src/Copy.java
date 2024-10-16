import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
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
                FileOutputStream out = new FileOutputStream("foto2.jpg");
                BufferedInputStream bin = new BufferedInputStream(in);
                BufferedOutputStream bout = new BufferedOutputStream(out);

                int i;
                while ((i = bin.read()) != -1) {

                    bout.write(i);
                }
                System.out.println("Imagen copiado");
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
