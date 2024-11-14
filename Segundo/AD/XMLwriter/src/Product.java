import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Clase Product que implementa Serializable para gardar e ler obxectos en binario
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

    // Getters e Setters para os atributos da clase
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public double getPrezo() { return prezo; }
    public void setPrezo(double prezo) { this.prezo = prezo; }

    // Metodo para escribir produtos nun arquivo binario
    public static void escribirProdutos(Product[] produtos, String filePath) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            for (Product produto : produtos) {
                out.writeObject(produto); // Escribimos cada produto
            }
            out.writeObject(null); // Indicamos o final do arquivo cun null
        } catch (IOException e) {
            System.out.println("Erro ao escribir produtos: " + e.getMessage());
        }
    }

    // Metodo para ler produtos desde un arquivo binario
    public static List<Product> lerProdutos(String filePath) {
        List<Product> produtos = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            Product produto;
            while ((produto = (Product) in.readObject()) != null) {
                produtos.add(produto); // Engadimos cada produto á lista
            }
        } catch (EOFException e) {
            // Esperado ao final do arquivo
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao ler produtos: " + e.getMessage());
        }
        return produtos;
    }

    // Metodo para exportar produtos a un arquivo XML
    public static void exportarProdutosAXML(List<Product> produtos, String xmlFilePath) {
        XMLOutputFactory factory = XMLOutputFactory.newInstance();

        try (FileOutputStream fileOutputStream = new FileOutputStream(xmlFilePath)) {
            // Creamos o escritor XML e especificamos o formato
            XMLStreamWriter writer = factory.createXMLStreamWriter(fileOutputStream, "UTF-8");

            // Comezamos o documento XML
            writer.writeStartDocument("UTF-8", "1.0");
            writer.writeStartElement("produtos"); // Elemento raíz

            // Escribimos cada produto dentro do elemento raíz
            for (Product produto : produtos) {
                writer.writeStartElement("produto");

                // Escribimos o elemento <codigo>
                writer.writeStartElement("codigo");
                writer.writeCharacters(produto.getCodigo());
                writer.writeEndElement();

                // Escribimos o elemento <descripcion>
                writer.writeStartElement("descripcion");
                writer.writeCharacters(produto.getDescripcion());
                writer.writeEndElement();

                // Escribimos o elemento <prezo>
                writer.writeStartElement("prezo");
                writer.writeCharacters(String.valueOf(produto.getPrezo()));
                writer.writeEndElement();

                writer.writeEndElement(); // Pechamos o elemento <produto>
            }

            writer.writeEndElement(); // Pechamos o elemento raíz <produtos>
            writer.writeEndDocument(); // Finalizamos o documento XML

            writer.close(); // Pechamos o escritor XML
        } catch (Exception e) {
            System.out.println("Erro ao exportar produtos a XML: " + e.getMessage());
        }
    }
}