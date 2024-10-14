import java.io.*;

public class Main {
    public static void main(String[] args) {
        // Serialización do obxecto
        try {
            // Crear un obxecto de Mclase con valores iniciais
            Mclase obj1 = new Mclase("ola", -7, 2.7E10);

            // Serializar o obxecto e gardalo nun ficheiro chamado 'serial'
            FileOutputStream fileOut = new FileOutputStream("serial");
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(obj1);  // Gardar o obxecto
            objOut.close();
            fileOut.close();

            System.out.println("Obxecto serializado correctamente.");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialización do obxecto
        try {
            // Crear un obxecto baleiro de Mclase
            Mclase obj2 = null;

            // Ler o obxecto dende o ficheiro 'serial'
            FileInputStream fileIn = new FileInputStream("serial");
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            obj2 = (Mclase) objIn.readObject();  // Deserializar o obxecto
            objIn.close();
            fileIn.close();

            // Amosar o estado do obxecto deserializado
            System.out.println("Obxecto deserializado:");
            System.out.println(obj2.toString());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}