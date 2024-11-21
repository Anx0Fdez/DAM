import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class exa15brevep {
    public static void main(String[] args) {
        // LLamamos a la clase "lerFicheiros"
        LerFicheiros lerFicheiros = new LerFicheiros();
        // Map para leer o ficheiro
        Map<String, Platos> pratosMap = lerFicheiros.lerFicheiro();

        // Establecemos a conexión coa base de datos
        Conexion conexion = new Conexion();
        try {
            Connection conn = conexion.conexion();
            Statement stmt = conn.createStatement();

            // Agora poñeremos a query para obter as táboas de composición e compoñentes
            String query = "SELECT c.codp,c.peso,comp.graxa " + "FROM composicion c " + "JOIN componentes comp ON c.codp = comp.codigo " + "WHERE c.codp IN ('p1','p2')";
            ResultSet rs = stmt.executeQuery(query);

            // Agora imos calcular a graxa total de cada pratok
            Map<String, Double> graxaTotalMap = new HashMap<>();
            while (rs.next()){
                String codp = rs.getString("codp");
                double peso = rs.getDouble("peso");
                double graxa = rs.getDouble("graxa");
                double graxaParcial = (peso/100) * graxa;

                graxaTotalMap.put(codp, graxaTotalMap.getOrDefault(codp, 0.0) + graxaParcial);
            }

            // Agora imos sacar por consola os resultados
            for (Map.Entry<String, Platos> entry : pratosMap.entrySet()){
                String codigo = entry.getKey();
                Platos prato = entry.getValue();
                double graxaTotal = graxaTotalMap.getOrDefault(codigo, 0.0);

                System.out.println(codigo);
                System.out.println(prato);
                System.out.println("graxa total:" + graxaTotal);
                System.out.println("");
                System.out.println("xx-xx-xx-xx-xx-xx-xx-xx-xx-xx-xx-xx-xx-xx-xx-xx-xx-xx-xx");
                System.out.println("");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao conectar coa base de datos");
        }
    }
}