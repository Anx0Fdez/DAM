import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {
        try {
            // InetSocketAddress nos permite encapsular dirección y puerto en un único punto
            InetSocketAddress dir = new InetSocketAddress("localhost", 6666);
            Socket socket = new Socket();
            socket.connect(dir);
            System.out.println("Conectado al servidor!");

            // Obtenemos el flujo de entrada
            BufferedReader lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String mensaje = lector.readLine(); // Aquí nos detendremos hasta recibir un mensaje
            System.out.println("Servidor dice: " + mensaje);

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}