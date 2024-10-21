import java.io.*;

// Clase Product que implementa Serializable
public class Product implements Serializable {
    private String codigo;
    private String descripcion;
    private double prezo;

    // Constructor completo
    public Product(String codigo, String descripcion, double prezo) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.prezo = prezo;
    }

    // Constructor baleiro
    public Product() {
    }

    // Getters e Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrezo() {
        return prezo;
    }

    public void setPrezo(double prezo) {
        this.prezo = prezo;
    }

    // Método para escribir produtos nun arquivo binario
    public static void escribirProductos(Product[] productos, String filePath) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            for (Product producto : productos) {
                out.writeObject(producto);
            }
            // Escribimos un null para indicar o final do arquivo
            out.writeObject(null);
        } catch (IOException e) {
            System.out.println("Erro ao escribir produtos: " + e.getMessage());
        }
    }

    // Método para ler produtos desde un arquivo binario
    public static void leerProductos(String filePath) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            Product producto;
            while ((producto = (Product) in.readObject()) != null) {
                System.out.println("Código: " + producto.getCodigo() +
                        ", Descrición: " + producto.getDescripcion() +
                        ", Prezo: " + producto.getPrezo());
            }
        } catch (EOFException e) {
            // Espérase que esta excepción ocorra ao final do arquivo
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao ler produtos: " + e.getMessage());
        }
    }
}