package Hibernate.Metodos;

import Datos.Adestrador;
import Datos.Pokedex;
import Hibernate.Utilidad.Utilidad;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.xml.stream.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class LecturaDatosXML {

    /**
     * Metodo que lee toda la informacion de Adestrador
     * Y lo guarda en un archivo xml
     */
    public void leerDatosAdestrador(List<Adestrador> adestradorL){
        try{
            XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
            XMLStreamWriter xmlStreamWriter = xmlOutputFactory.createXMLStreamWriter(new FileWriter("adestrador.xml"));

            xmlStreamWriter.writeStartDocument();
            xmlStreamWriter.writeStartElement("Adestradores");

            for(Adestrador adestrador: adestradorL){
                xmlStreamWriter.writeStartElement("Adestrador");
                xmlStreamWriter.writeAttribute("id",String.valueOf(adestrador.getId()));
                xmlStreamWriter.writeStartElement("Nome");
                xmlStreamWriter.writeCharacters(adestrador.getNome());
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeStartElement("Nacemento");
                xmlStreamWriter.writeCharacters(String.valueOf(adestrador.getNacemento()));
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeEndElement();
            }
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeEndDocument();
            xmlStreamWriter.flush();
            xmlStreamWriter.close();

        }catch (IOException | XMLStreamException e){
            System.out.println("Error al leer los datos de adestrador: "+e.getMessage());
        }
    }

    /**
     * Metodo que lee toda la informacion de Pokedex
     * Y lo guarda en un archivo xml
     */
    public void leerDatosPokedex(List<Pokedex> pokedexL){
        try{
            XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
            XMLStreamWriter xmlStreamWriter = xmlOutputFactory.createXMLStreamWriter(new FileWriter("pokedex.xml"));

            xmlStreamWriter.writeStartDocument();
            xmlStreamWriter.writeStartElement("Pokedex");

            for(Pokedex pokedex: pokedexL){
                xmlStreamWriter.writeStartElement("Pokedex");
                xmlStreamWriter.writeAttribute("id",String.valueOf(pokedex.getId()));
                xmlStreamWriter.writeStartElement("Nome");
                xmlStreamWriter.writeCharacters(pokedex.getNome());
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeStartElement("Peso");
                xmlStreamWriter.writeCharacters(String.valueOf(pokedex.getPeso()));
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeStartElement("Misc");
                xmlStreamWriter.writeCharacters(pokedex.getMisc());
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeEndElement();
            }
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeEndDocument();
            xmlStreamWriter.flush();
            xmlStreamWriter.close();

        }catch (IOException | XMLStreamException e){
            System.out.println("Error al leer los datos de pokedex: "+e.getMessage());
        }
    }

    /**
     * Metodo que exporta dos entradas de la pokedex serializadas a un archivo
     */
    public void exportarPokedexSerializada(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("pokedex.ser"));
            Session session = Utilidad.getSessionFactory().openSession()){
            List<Pokedex> pokedexEntries = session.createQuery("from Pokedex",Pokedex.class)
                    .setMaxResults(2)
                    .list();
            for(Pokedex pokedex : pokedexEntries){
                oos.writeObject(pokedex);
            }
        } catch (IOException e){
            System.out.println("Error al exportar la pokedex: "+e.getMessage());
        }
    }

    public void importarPokedexSerializado(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("pokedex.ser"));
            Session session = Utilidad.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();

            Pokedex pokedex1 = (Pokedex) ois.readObject();
            Pokedex pokedex2 = (Pokedex) ois.readObject();

            session.update(pokedex1);
            session.update(pokedex2);

            transaction.commit();
        } catch (IOException | ClassNotFoundException e){
            System.out.println("Error al importar la pokedex: "+e.getMessage());
        }
    }

    public void importarAdestradoresXML() {
        XMLStreamReader xmlReader = null;
        try (FileInputStream fileInputStream = new FileInputStream("adestrador.xml");
             Session session = Utilidad.getSessionFactory().openSession()) {
            xmlReader = XMLInputFactory.newInstance().createXMLStreamReader(fileInputStream);
            Transaction transaction = session.beginTransaction();
            Adestrador adestrador = null;
            while (xmlReader.hasNext()) {
                int event = xmlReader.next();
                if (event == XMLStreamConstants.START_ELEMENT) {
                    String elementName = xmlReader.getLocalName();
                    if (elementName.equals("Adestrador")) {
                        String id = xmlReader.getAttributeValue(null, "id");
                        adestrador = new Adestrador();
                        adestrador.setId(Integer.parseInt(id));
                    } else if (elementName.equals("Nome")) {
                        adestrador.setNome(xmlReader.getElementText());
                    } else if (elementName.equals("Nacemento")) {
                        String dateText = xmlReader.getElementText();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
                        LocalDate date = LocalDate.parse(dateText, formatter);
                        adestrador.setNacemento(java.sql.Date.valueOf(date));
                    }
                } else if (event == XMLStreamConstants.END_ELEMENT) {
                    String elementName = xmlReader.getLocalName();
                    if (elementName.equals("Adestrador") && adestrador != null) {
                        session.update(adestrador);
                    }
                }
            }
            transaction.commit();
        } catch (XMLStreamException | IOException e) {
            System.out.println("Error al importar adestradores desde XML: " + e.getMessage());
        } finally {
            if (xmlReader != null) {
                try {
                    xmlReader.close();
                } catch (XMLStreamException e) {
                    System.out.println("Error al cerrar XMLStreamReader: " + e.getMessage());
                }
            }
        }
    }



}
