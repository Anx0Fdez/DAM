import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {

    Conection conn = new Conection(); // Crea unha instancia da clase Conection

    public App() { // Constructor da clase App
        conn.connect(); // Chama ao metodo connect para establecer a conexión
    }

    public void listarContenido(){
        if (tryConnection()) return;
        try {
            PreparedStatement stmt = conn.getConn().prepareStatement("SELECT * FROM produtos", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE); // Crea unha instancia da clase PreparedStatement
            ResultSet rs = stmt.executeQuery(); // Executa a consulta
            while (rs.next()) { // Mentres haxa resultados
                System.out.println("Codigo: " + rs.getString("codigo") + ", Descricion: " + rs.getString("descricion") + ", Prezo: " + rs.getDouble("prezo") + ", Data: " + rs.getDate("datac")); // Imprime os detalles do produto
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage()); // Imprime a mensaxe de erro se hai unha excepción
        }
    }

    public void actualizarPrecioProducto(String codigo, double prezo) {
        if (tryConnection()) return;
        try {
            PreparedStatement stmt = conn.getConn().prepareStatement("SELECT * FROM produtos WHERE codigo = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE); // Crea unha instancia da clase PreparedStatement
            stmt.setString(1, codigo);
            ResultSet rs = stmt.executeQuery(); // Executa a consulta
            if (rs.next()) { // Se hai resultados
                rs.updateDouble("prezo", prezo); // Actualiza o campo prezo
                rs.updateRow(); // Actualiza a fila
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage()); // Imprime a mensaxe de erro se hai unha excepción
        }
    }

    public void insertarProducto(String codigo, String descricion, double prezo, String datac) {
        if (tryConnection()) return;
        try {
            Statement stmt = conn.getConn().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE); // Crea unha instancia da clase Statement
            ResultSet rs = stmt.executeQuery("SELECT * FROM produtos"); // Executa a consulta
            rs.moveToInsertRow(); // Móvese á fila de inserción
            rs.updateString("codigo", codigo); // Actualiza o campo codigo
            rs.updateString("descricion", descricion); // Actualiza o campo descricion
            rs.updateDouble("prezo", prezo); // Actualiza o campo prezo
            rs.updateDate("datac", java.sql.Date.valueOf(datac)); // Actualiza o campo datac
            rs.insertRow(); // Inserta a fila
        } catch (SQLException e) {
            System.out.println(e.getMessage()); // Imprime a mensaxe de erro se hai unha excepción
        }
    }

    public void eliminarProducto(String codigo) {
        if (tryConnection()) return;
        try {
            PreparedStatement stmt = conn.getConn().prepareStatement("SELECT * FROM produtos WHERE codigo = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE); // Crea unha instancia da clase PreparedStatement
            stmt.setString(1, codigo);
            ResultSet rs = stmt.executeQuery(); // Executa a consulta
            if (rs.next()) { // Se hai resultados
                rs.deleteRow(); // Borra a fila
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage()); // Imprime a mensaxe de erro se hai unha excepción
        }
    }

    private boolean tryConnection() {
        if (conn.getConn() == null) {
            System.out.println("Non se puido establecer a conexión coa base de datos");
            return true;
        }
        return false;
    }
}