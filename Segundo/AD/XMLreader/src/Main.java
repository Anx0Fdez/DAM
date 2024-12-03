import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {
    static String ruta = "products.xml"; // Ruta do arquivo XML.
    static ArrayList<Producto> productos; // Lista de produtos.

    public static void main(String[] args) {
        FileReader fileReader = getFileReader(); // Obtén o FileReader.
        if (fileReader == null) {
            return;
        }
        XMLInputFactory factory = XMLInputFactory.newInstance(); // Obtén a fábrica de XML.
        XMLStreamReader reader = getXMLStreamReader(fileReader, factory); // Obtén o XMLStreamReader.
        if (reader == null) {
            return;
        }
        productos = leerXML(reader); // Obtén os produtos.
        if (productos != null) { // Se se obtiveron os produtos, imprímense.
            imprimirProductos(productos);
        }
    }

    public static FileReader getFileReader() {
        try {
            return new FileReader(ruta); // Tenta abrir o arquivo.
        } catch (FileNotFoundException e) {
            System.out.println("Non se atopa o arquivo: " + ruta + " " + e.getMessage());
            return null;
        }
    }

    public static XMLStreamReader getXMLStreamReader(FileReader fileReader, XMLInputFactory factory) {
        try {
            return factory.createXMLStreamReader(fileReader); // Crea o XMLStreamReader para o arquivo.
        } catch (Exception e) {
            System.out.println("Erro ao crear o XMLStreamReader: " + e.getMessage());
            return null;
        }
    }

    public static ArrayList<Producto> leerXML(XMLStreamReader reader) {
        ArrayList<Producto> productos = new ArrayList<>();
        Producto producto = null;
        StringBuilder xmlBuilder = new StringBuilder();
        try {
            while (reader.hasNext()) {
                int tipo = reader.next();
                switch (tipo) {
                    case XMLStreamReader.START_ELEMENT:
                        xmlBuilder.append("<").append(reader.getLocalName()).append(">");
                        if (reader.getLocalName().equals("Product")) {
                            producto = new Producto();
                        } else if (producto != null) {
                            switch (reader.getLocalName()) {
                                case "Code":
                                    String codigo = reader.getElementText();
                                    xmlBuilder.append(codigo).append("</Code>");
                                    producto.setCode(codigo);
                                    break;
                                case "Description":
                                    String nome = reader.getElementText();
                                    xmlBuilder.append(nome).append("</Description>");
                                    producto.setDescription(nome);
                                    break;
                                case "Price":
                                    String prezoTexto = reader.getElementText();
                                    xmlBuilder.append(prezoTexto).append("</Price>");
                                    try {
                                        producto.setPrice(Integer.parseInt(prezoTexto));
                                    } catch (NumberFormatException e) {
                                        System.out.println("Erro ao parsear o prezo: " + e.getMessage());
                                    }
                                    break;
                            }
                        }
                        break;
                    case XMLStreamReader.END_ELEMENT:
                        xmlBuilder.append("</").append(reader.getLocalName()).append(">");
                        if (reader.getLocalName().equals("Product") && producto != null) {
                            productos.add(producto);
                            producto = null;
                        }
                        break;
                }
            }
            String formattedXML = XMLFormatter.formatXML(xmlBuilder.toString());
            System.out.println(formattedXML);
        } catch (XMLStreamException e) {
            System.out.println("Erro ao ler o XML: " + e.getMessage());
            return null;
        }
        return productos;
    }

    public static void imprimirProductos(ArrayList<Producto> productos) {
        System.out.println("Comprobación dos produtos lidos:");
        for (Producto producto : productos) {
            System.out.println("Código: " + producto.getCode() + ", Descrición: " + producto.getDescription() + ", Prezo: " + producto.getPrice());
        }
    }
}