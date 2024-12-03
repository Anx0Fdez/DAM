import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Clase que formatea un XML nunha cadea de texto para que ao imprimilo apareza indentado.
 */
public class XMLFormatter {

    /**
     * Metodo que formatea un XML nunha cadea de texto para que ao imprimilo apareza indentado.
     *
     * @param xml Cadea de texto co XML a formatear.
     * @return Cadea de texto co XML formateado.
     */
    public static String formatXML(String xml) {
        try {
            // Instancia da fábrica de transformadores.
            TransformerFactory factory = TransformerFactory.newInstance();
            // Instancia do transformador.
            Transformer transformer = factory.newTransformer();
            // Indícase que se quere indentar.
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            // Indícase o número de espazos para a indentación.
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            // Fonte de datos do XML a formatear para o transformador.
            StreamSource source = new StreamSource(new StringReader(xml));
            // Escritor para capturar o XML formateado nunha cadea de texto.
            StringWriter writer = new StringWriter();
            // Resultado da transformación do XML.
            StreamResult result = new StreamResult(writer);

            // Transfórmase o XML.
            transformer.transform(source, result);
            // Devólvese o XML formateado.
            return writer.toString();
        } catch (Exception e) {
            // Imprímese a mensaxe de erro se ocorre unha excepción.
            System.out.println("Erro ao formatear o XML: " + e.getMessage());
            return null;
        }
    }
}