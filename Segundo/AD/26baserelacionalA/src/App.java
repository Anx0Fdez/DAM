import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {
    private final Conection conn = new Conection(); // Declara e inicializa unha instancia de Conection

    public App() { // Constructor da clase App
        conn.connect(); // Chama ao metodo connect para establecer a conexión
    }

    public void addProduct(String codigo, String descricion, int prezo, Date data) {
        if (codigo.isEmpty() || descricion.isEmpty() || prezo == 0 || data == null) { // Comproba se algún campo está baleiro
            System.out.println("Todos os campos deben estar cubertos"); // Mensaxe de erro se algún campo está baleiro
            return; // Sae do método
        }
        if (tryConnection()) return; // Comproba a conexión e sae se non está establecida
        try (PreparedStatement pstmt = conn.getConn().prepareStatement("INSERT INTO produtos (codigo, descricion, prezo, datac) VALUES (?, ?, ?, ?)")) { // Prepara a consulta SQL para engadir un produto
            pstmt.setString(1, codigo); // Establece o valor do primeiro parámetro
            pstmt.setString(2, descricion); // Establece o valor do segundo parámetro
            pstmt.setInt(3, prezo); // Establece o valor do terceiro parámetro
            pstmt.setDate(4, data); // Establece o valor do cuarto parámetro
            pstmt.executeUpdate(); // Executa a consulta
            System.out.println("Produto engadido con éxito"); // Mensaxe de éxito
        } catch (SQLException e) { // Captura excepcións SQL
            System.out.println(e.getMessage()); // Imprime a mensaxe de erro
        }
    }

    public void listProducts() { // Método para listar todos os produtos
        if (tryConnection()) return; // Comproba a conexión e sae se non está establecida
        try (PreparedStatement pstmt = conn.getConn().prepareStatement("SELECT * FROM produtos"); // Prepara a consulta SQL para listar todos os produtos
             ResultSet rs = pstmt.executeQuery()) { // Executa a consulta e obtén o resultado
            System.out.println("Código\tDescrición\tPrezo\tData"); // Imprime os encabezados das columnas
            System.out.println("------\t-----------\t-----\t----"); // Imprime unha liña de separación
            while (rs.next()) { // Itera sobre os resultados
                System.out.println(rs.getString("codigo") + "\t" + rs.getString("descricion") + "\t" + rs.getInt("prezo") + "\t" + rs.getDate("datac")); // Imprime os valores de cada fila
            }
        } catch (SQLException e) { // Captura excepcións SQL
            System.out.println(e.getMessage()); // Imprime a mensaxe de erro
        }
    }

    public void listProductFromCode(String codigo) { // Metodo para listar un produto polo seu código
        if (tryConnection()) return; // Comproba a conexión e sae se non está establecida
        if (codigo.isEmpty()) { // Comproba se o código está baleiro
            System.out.println("Introduce o código"); // Mensaxe de erro se o código está baleiro
            return; // Sae do método
        }
        try (PreparedStatement pstmt = conn.getConn().prepareStatement("SELECT * FROM produtos WHERE codigo = ?")) { // Prepara a consulta SQL para listar un produto polo seu código
            pstmt.setString(1, codigo); // Establece o valor do parámetro
            try (ResultSet rs = pstmt.executeQuery()) { // Executa a consulta e obtén o resultado
                if (!rs.next()) { // Comproba se non hai resultados
                    System.out.println("Este código non existe na base de datos"); // Mensaxe de erro se o código non existe
                } else { // Se hai resultados
                    System.out.println("Código\tDescrición\tPrezo\tData"); // Imprime os encabezados das columnas
                    System.out.println("------\t-----------\t-----\t----"); // Imprime unha liña de separación
                    System.out.println(rs.getString("codigo") + "\t" + rs.getString("descricion") + "\t" + rs.getInt("prezo") + "\t" + rs.getDate("datac")); // Imprime os valores do produto
                }
            }
        } catch (SQLException e) { // Captura excepcións SQL
            System.out.println(e.getMessage()); // Imprime a mensaxe de erro
        }
    }

    public void updatePrice(int prezo, String codigo) { // Método para actualizar o prezo dun produto
        if (tryConnection()) return; // Comproba a conexión e sae se non está establecida
        try (PreparedStatement pstmt = conn.getConn().prepareStatement("UPDATE produtos SET prezo = ? WHERE codigo = ?")) { // Prepara a consulta SQL para actualizar o prezo dun produto
            pstmt.setInt(1, prezo); // Establece o valor do primeiro parámetro
            pstmt.setString(2, codigo); // Establece o valor do segundo parámetro
            pstmt.executeUpdate(); // Executa a consulta
            System.out.println("Prezo de " + codigo + " actualizado."); // Mensaxe de éxito
        } catch (SQLException e) { // Captura excepcións SQL
            System.out.println(e.getMessage()); // Imprime a mensaxe de erro
        }
    }

    public void deleteProduct(String codigo) { // Método para eliminar un produto
        if (tryConnection()) return; // Comproba a conexión e sae se non está establecida
        try (PreparedStatement pstmt = conn.getConn().prepareStatement("DELETE FROM produtos WHERE codigo = ?")) { // Prepara a consulta SQL para eliminar un produto
            pstmt.setString(1, codigo); // Establece o valor do parámetro
            pstmt.executeUpdate(); // Executa a consulta
            System.out.println("Produto eliminado."); // Mensaxe de éxito
        } catch (SQLException e) { // Captura excepcións SQL
            System.out.println(e.getMessage()); // Imprime a mensaxe de erro
        }
    }

    private boolean tryConnection() { // Metodo para comprobar a conexión
        if (conn.getConn() == null) { // Comproba se a conexión é nula
            System.out.println("Erro ao establecer a conexión!"); // Mensaxe de erro se a conexión é nula
            return true; // Devolve true se a conexión é nula
        }
        return false; // Devolve false se a conexión non é nula
    }
}