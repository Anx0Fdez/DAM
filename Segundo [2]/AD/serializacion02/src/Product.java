import javax.imageio.IIOException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Product {
    private String codigo;
    private String descripcion;
    private double prezo;

    public Product(String codigo, String descripcion, double prezo) {
        this.prezo = prezo;
        this.descripcion = descripcion;
        this.codigo = codigo;
    }
    public Product(){
    }

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

    File file = new File("datos.txt");

    public void escribirTXT (){
        try {
            FileWriter writer = new FileWriter("datos.txt");
            file.createNewFile();
            writer.write(getCodigo());
            writer.write(getDescripcion());
            writer.write((int)getPrezo());

        }catch (IOException io){
            System.out.println("Error: " + io.getMessage());
        }

    }
}


