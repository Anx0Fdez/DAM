import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce a ruta do arquivo para escribir e ler: ");
        String path = scanner.nextLine();

        Program app = new Program();
        app.escribirELeer(path);
    }
}