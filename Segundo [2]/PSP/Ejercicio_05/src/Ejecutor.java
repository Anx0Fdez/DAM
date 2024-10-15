import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
     * Executa comandos cos parámetros dados.
     */

public class Ejecutor {
    public String executeCommand(String command, String params) {
        StringBuilder output = new StringBuilder();
        Process process;
        try {
            process = new ProcessBuilder("cmd.exe", "/c", command + " " + params).start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            return "Erro: " + e.getMessage();
        }
        return output.toString();
    }
}