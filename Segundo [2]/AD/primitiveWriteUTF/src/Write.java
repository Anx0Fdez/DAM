import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Write {
    public void writeUTF() {
        try (FileOutputStream fout = new FileOutputStream("texto1.txt");
             DataOutputStream out = new DataOutputStream(fout)) {
            for (int i = 0; i < 3; i++) {
                out.writeUTF("O tempo está xelido\n");
                System.out.println(i + ".- Tamaño del archivo: " + fout.getChannel().size());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}