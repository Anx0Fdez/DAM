import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileReader;
import java.io.IOException;

public class App {

    // Crear unha instancia de XMLInputFactory
    XMLInputFactory factory = XMLInputFactory.newInstance();

    public void lerXML() {
        try {
            // Crear un XMLStreamReader para ler o arquivo XML
            XMLStreamReader reader = factory.createXMLStreamReader(new FileReader("autores.xml"));

            // Iterar a través dos eventos do lector XML
            while (reader.hasNext()) {
                int i = reader.next();
                if (i == XMLStreamConstants.START_ELEMENT) {
                    // Procesar o inicio dun elemento
                    System.out.println(reader.getLocalName());
                    for (int j = 0; j < reader.getAttributeCount(); j++) {
                        // Imprimir os atributos do elemento
                        System.out.println(reader.getAttributeValue(j));
                    }
                } else if (i == XMLStreamConstants.CHARACTERS) {
                    // Procesar o texto dentro dun elemento
                    System.out.println(reader.getText());
                } else if (i == XMLStreamConstants.END_ELEMENT) {
                    // Procesar o final dun elemento
                    System.out.println(reader.getLocalName());
                }
            }
        } catch (IOException | XMLStreamException e) {
            // Capturar e manexar excepcións
            System.out.println("Erro ao ler o arquivo XML: " + e.getMessage());
        }
    }
}