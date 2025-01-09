import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        try {
            // InetSocketAddress nos permite encapsular dirección y puerto en un único punto
            InetSocketAddress dir = new InetSocketAddress("localhost", 6666);
            ServerSocket servidor = new ServerSocket();
            servidor.bind(dir);

            System.out.println("Esperando conexiones...");
            Socket socket = servidor.accept();
            System.out.println("Cliente conectado!");

            OutputStream salida = socket.getOutputStream();
            // AutoFlush = true envía los datos inmediatamente
            PrintWriter escritor = new PrintWriter(salida, true);

            // Enviamos el mensaje al cliente
            escritor.println("Hola, cliente!");


            socket.close();
            servidor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
