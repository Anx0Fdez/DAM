import java.io.RandomAccessFile;
import java.util.Scanner;

public class Aleatorio {
    String[] codigos = {"p1", "p2", "p3"};
    String[] descricions = {"parafusos", "cravos ", "tachas"};
    int[] prezos = {3, 4, 5};

    int lonxitudeCodigo = 3;
    int lonxitudeDescricion = 10;

    private void imprimirLista() {
        for (int i = 0; i < codigos.length; i++) {
            codigos[i] = String.format("%-" + lonxitudeCodigo + "s", codigos[i]).replace(' ', ' ');
            descricions[i] = String.format("%-" + lonxitudeDescricion + "s", descricions[i]).replace(' ', ' ');
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce a ruta do arquivo: ");
        String ruta = scanner.nextLine();

        try (RandomAccessFile arquivo = new RandomAccessFile(ruta, "rw")) {
            for (int i = 0; i < codigos.length; i++) {
                arquivo.writeChars(codigos[i]);
                arquivo.writeChars(descricions[i]);
                arquivo.writeInt(prezos[i]);
            }

            arquivo.seek(30);

            char[] codigoChars = new char[lonxitudeCodigo];
            for (int i = 0; i < lonxitudeCodigo; i++) {
                codigoChars[i] = arquivo.readChar();
            }
            String codigo = new String(codigoChars).trim();

            char[] descrChars = new char[lonxitudeDescricion];
            for (int i = 0; i < lonxitudeDescricion; i++) {
                descrChars[i] = arquivo.readChar();
            }
            String descricion = new String(descrChars).trim();

            int prezo = arquivo.readInt();

            System.out.println(codigo);
            System.out.println(descricion);
            System.out.println(prezo);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void executar() {
        imprimirLista();
    }
}