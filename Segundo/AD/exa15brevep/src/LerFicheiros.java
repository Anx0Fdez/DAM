import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class LerFicheiros {
    //Ruta do arquivo proporcionada
    String rutaFicheiro = "/home/accesodatos/Escritorio/platoss";

    // Este metodo le o ficheiro e devolve un Map cos pratos
    public Map<String, Platos> lerFicheiro(){
        Map<String, Platos> pratosMap = new HashMap<>();
        try {
            //ObjectInputStream que colle a ruta do ficheiro da variable "rutaFicheiro"
            ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(rutaFicheiro))); // Abrimos o ficheiro

            // Lemos os obxectos do ficheiro e gardámolos nun obxecto de tipo Platos
            Platos p1 = (Platos) ois.readObject();
            Platos p2 = (Platos) ois.readObject();

            // Engadimos os obxectos ao Map
            pratosMap.put(p1.getCodigop(), p1);
            pratosMap.put(p2.getCodigop(), p2);

        }catch (IOException | ClassNotFoundException e){
            System.out.println("Erro ao localizar o arquivo");
        }

        return pratosMap;
    }
}