import java.sql.*;

public class Conection {
    private Connection conn; // Declara unha variable de instancia para a conexión
    private final String url = "jdbc:postgresql://localhost:5432/postgres"; // URL da base de datos
    private final String user = "postgres"; // Nome de usuario da base de datos
    private final String psw = "postgres"; // Contrasinal da base de datos

    /**
     * Metodo para establecer a conexión
     */
    public void connect() {
        try {
            conn = DriverManager.getConnection(url, user, psw); // Establece a conexión, pasando a URL, o nome de usuario e o contrasinal
        } catch (SQLException e) {
            System.out.println(e.getMessage()); // Imprime a mensaxe de erro se hai unha excepción
        }
    }

    public Connection getConn() {
        return conn;
    }
}