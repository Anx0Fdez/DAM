import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CopyTXT co = new CopyTXT();
        System.out.println("Escribe la ruta del archivo donde lo quieres pegar:");
        Scanner sc = new Scanner(System.in);
        String b = sc.nextLine();
        co.copiarTexto(b);


    }
}