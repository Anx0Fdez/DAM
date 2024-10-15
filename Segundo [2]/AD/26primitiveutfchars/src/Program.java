import java.io.*;
import java.util.Scanner;

public class Program {
    public void escribirELeer(String cadea) {
        cadea = "Está na casa";
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce a ruta do arquivo para escribir: ");
        String writePath = scanner.nextLine();

        System.out.print("Introduce a ruta do arquivo para ler: ");
        String readPath = scanner.nextLine();

        try {
            FileOutputStream fos = new FileOutputStream(writePath);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            DataOutputStream dos = new DataOutputStream(bos);

            System.out.println("Write UTF escribindo: " + cadea);
            dos.writeUTF(cadea);
            System.out.println("Bytes escritos: " + dos.size() + " bytes");

            System.out.println("WriteChars escribindo: " + cadea);
            for (int i = 0; i < cadea.length(); i++) {
                dos.writeChar(cadea.charAt(i));
            }
            System.out.println("Bytes escritos: " + dos.size() + " bytes");

            System.out.println("Write UTF escribindo: " + cadea);
            dos.writeUTF(cadea);
            System.out.println("Bytes escritos: " + dos.size() + " bytes");

            dos.close();

            FileInputStream fil = new FileInputStream(readPath);
            BufferedInputStream bis = new BufferedInputStream(fil);
            DataInputStream dis = new DataInputStream(bis);

            System.out.println("bytes totais por ler: " + dis.available() + " bytes");
            String primeiraCadea = dis.readUTF();
            System.out.println("Lemos a primeira cadea en UTF: " + primeiraCadea);

            System.out.println("número de bytes por ler: " + dis.available() + " bytes.");
            StringBuilder segundaCadea = new StringBuilder();
            for (int i = 0; i < cadea.length(); i++) {
                segundaCadea.append(dis.readChar());
            }
            System.out.println("Lemos a segunda cadea con readChar() en bucle: " + segundaCadea.toString());

            System.out.println("bytes totais por ler: " + dis.available() + " bytes");
            String terceiraCadea = dis.readUTF();
            System.out.println("Lemos a terceira cadea en UTF: " + terceiraCadea);

            dis.close();

        } catch (IOException e) {
            System.out.println("Erro");
        }
    }
}