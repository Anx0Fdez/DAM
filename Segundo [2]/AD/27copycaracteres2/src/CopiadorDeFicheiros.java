import java.io.*;

public class CopiadorDeFicheiros {
    // Copia o contido do ficheiro de entrada no ficheiro de saída
    public void copiar(String ficheiroEntrada, String ficheiroSaida) {
        try (
                // O arquivo de entrada é aberto para lectura
                BufferedReader br = new BufferedReader(new FileReader(ficheiroEntrada));
                // O arquivo de saída é aberto para escritura
                PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(ficheiroSaida)))
        ) {
            // Léase o arquivo de entrada liña a liña
            String liña;
            while ((liña = br.readLine()) != null) {
                pw.println(liña);
            }
        } catch (IOException e) {
            System.err.println("Erro durante a copia dos ficheiros: " + e.getMessage());
        }
    }
}
