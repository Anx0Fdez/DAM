import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;

public class App {

    // Crear unha instancia de XMLOutputFactory
    XMLOutputFactory xml = XMLOutputFactory.newInstance();

    public void crearXML() {
        try {
            // Crear un XMLStreamWriter
            XMLStreamWriter xmlStreamWriter = xml.createXMLStreamWriter(new FileWriter("autores.xml"));
            // Escribir a declaración XML
            xmlStreamWriter.writeStartDocument("1.0");
            // Escribir o elemento raíz
            xmlStreamWriter.writeStartElement("autores");
            // Escribir un elemento
            xmlStreamWriter.writeStartElement("autor");
            // Escribir un atributo
            xmlStreamWriter.writeAttribute("codigo", "a1");
            // Escribir un elemento
            xmlStreamWriter.writeStartElement("nome");
            // Escribir o contido do elemento
            xmlStreamWriter.writeCharacters("Alexandre Dumas");
            // Pechar o elemento
            xmlStreamWriter.writeEndElement();
            // Escribir un elemento
            xmlStreamWriter.writeStartElement("titulo");
            // Escribir o contido do elemento
            xmlStreamWriter.writeCharacters("El conde de montecristo");
            // Pechar o elemento
            xmlStreamWriter.writeEndElement();
            // Escribir un elemento
            xmlStreamWriter.writeStartElement("titulo");
            // Escribir o contido do elemento
            xmlStreamWriter.writeCharacters(" Los miserables");
            // Pechar o elemento
            xmlStreamWriter.writeEndElement();
            // Pechar o elemento
            xmlStreamWriter.writeEndElement();
            // Escribir un elemento
            xmlStreamWriter.writeStartElement("autor");
            // Escribir un atributo
            xmlStreamWriter.writeAttribute("codigo", "a2");
            // Escribir un elemento
            xmlStreamWriter.writeStartElement("nome");
            // Escribir o contido do elemento
            xmlStreamWriter.writeCharacters("Fiodor Dostoyevski");
            // Pechar o elemento
            xmlStreamWriter.writeEndElement();
            // Escribir un elemento
            xmlStreamWriter.writeStartElement("titulo");
            // Escribir o contido do elemento
            xmlStreamWriter.writeCharacters("El idiota");
            // Pechar o elemento
            xmlStreamWriter.writeEndElement();
            // Escribir un elemento
            xmlStreamWriter.writeStartElement("titulo");
            // Escribir o contido do elemento
            xmlStreamWriter.writeCharacters("Noches blancas");
            // Pechar o elemento
            xmlStreamWriter.writeEndElement();
            // Pechar o elemento
            xmlStreamWriter.writeEndElement();
            // Pechar o elemento raíz
            xmlStreamWriter.writeEndElement();

            // Limpar o XMLStreamWriter
            xmlStreamWriter.flush();

        } catch (IOException | XMLStreamException e) {
            // Imprimir a mensaxe de erro
            System.out.println(e.getMessage());
        }
    }

}