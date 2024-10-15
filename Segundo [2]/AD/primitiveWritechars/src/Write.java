import java.io.*;
public class Write {
    public void write() {
        String textToWrite = "O tempo está xélido\n";

        try (
                FileOutputStream fos = new FileOutputStream("texto4.txt");
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                DataOutputStream dos = new DataOutputStream(bos)
        ) {
            for (int i = 1; i <= 2; i++) {
                dos.writeUTF(textToWrite);
                System.out.println("Escribiendo...: " + textToWrite);
                System.out.println("La longitud de esta cadena: " + textToWrite.length() + " caracteres");
                System.out.println("Escritos: " + (textToWrite.length() * 2 * i) + " bytes");
            }
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (
                FileInputStream fis = new FileInputStream("texto4.txt");
                BufferedInputStream bis = new BufferedInputStream(fis);
                DataInputStream dis = new DataInputStream(bis)
        ) {
            for (int i = 1; i <= 2; i++) {
                System.out.print(dis.readUTF());
                System.out.println();
                System.out.println("Restan por leer: " + dis.available() + " bytes");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}