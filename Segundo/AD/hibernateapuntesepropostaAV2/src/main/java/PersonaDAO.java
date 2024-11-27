import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// Clase para realizar operacións CRUD na táboa "personas"
public class PersonaDAO {
    private static final String URL = "jdbc:postgresql://localhost:5432/your_database";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    // Método para gardar unha nova persoa na base de datos
    public void gardarPersona(Persona persona) {
        String sql = "INSERT INTO personas (id, nome, apelido, salario) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, persona.getId());
            pstmt.setString(2, persona.getNome());
            pstmt.setString(3, persona.getApelido());
            pstmt.setDouble(4, persona.getSalario());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para actualizar unha persoa existente na base de datos
    public void actualizarPersona(Persona persona) {
        String sql = "UPDATE personas SET nome = ?, apelido = ?, salario = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, persona.getNome());
            pstmt.setString(2, persona.getApelido());
            pstmt.setDouble(3, persona.getSalario());
            pstmt.setLong(4, persona.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar unha persoa da base de datos
    public void eliminarPersona(Long id) {
        String sql = "DELETE FROM personas WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}