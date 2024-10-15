import java.io.*;
import java.text.NumberFormat;
import java.util.Locale;

public class ExercicioFicheiro {
    public static void main(String[] args) {
        // Arrays cos datos dos produtos
        String[] cod = {"p1", "p2", "p3"};
        String[] desc = {"parafusos", "cravos", "tachas"};
        int[] prezo = {3, 4, 5};

        // Ficheiro onde imos gravar os datos
        File ficheiro = new File("produtos.txt");

        // Gravación dos datos no ficheiro
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(ficheiro)))) {
            for (int i = 0; i < cod.length; i++) {
                // Gravamos os datos separados por tabuladores
                pw.print(cod[i] + "\t");
                pw.print(desc[i] + "\t");
                pw.println(prezo[i]);
            }
        } catch (IOException e) {
            System.err.println("Erro ao escribir no ficheiro: " + e.getMessage());
        }

        // Lectura dos datos desde o ficheiro
        try (BufferedReader br = new BufferedReader(new FileReader(ficheiro))) {
            String liña;
            while ((liña = br.readLine()) != null) {
                // Dividimos a liña lida usando o tabulador como separador
                String[] campos = liña.split("\t");

                // Obtemos os valores dos campos
                String codigo = campos[0];
                String descricion = campos[1];
                int prezoProduto = Integer.parseInt(campos[2]);

                // Opción: formateamos o prezo como moeda (en euros)
                NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(Locale.FRANCE);
                String prezoFormateado = formatoMoeda.format(prezoProduto);

                // Imprimimos os valores en formato amigable
                System.out.println("Codigo: \t" + codigo);
                System.out.println("Descricion: \t" + descricion);
                System.out.println("Prezo: \t\t" + prezoFormateado);
                System.out.println();  // Liña en branco entre rexistros
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler do ficheiro: " + e.getMessage());
        }
    }
}
