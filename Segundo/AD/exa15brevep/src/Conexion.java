import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    // Metodo para realizar a conexión ca base de datos
    public Connection conexion(){
        Connection conn = null;
        try {
            String driver = "jdbc:postgresql:";
            String host = "//localhost:";
            String porto = "5432"; // Porto usado para a conexión
            String sid = "postgres"; // nome da base de datos
            String usuario = "postgres"; //Usuario para conectarse a base de datos
            String password = "postgres"; //Contraseña para conectarse a base de datos
            String url = driver + host + porto + "/" + sid;

            // Intenta establecer a conexión ca base de datos mediante os parámetros da parte de arriba
            conn = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexión establecida con éxito"); // Conexión realizada
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao conectarse á base de datos"); // Conexión fallida
        }
        return conn;
    }
}