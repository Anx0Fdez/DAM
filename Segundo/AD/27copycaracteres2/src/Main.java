// Código para copiar un ficheiro de texto a outro ficheiro de texto
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduza a ruta do ficheiro de entrada");
        String ficheiroEntrada = sc.nextLine();
        System.out.println("Introduza a ruta do ficheiro de saída");
        String ficheiroSaida = sc.nextLine();

        CopiadorDeFicheiros copiador = new CopiadorDeFicheiros();
        copiador.copiar(ficheiroEntrada, ficheiroSaida);
    }
}


