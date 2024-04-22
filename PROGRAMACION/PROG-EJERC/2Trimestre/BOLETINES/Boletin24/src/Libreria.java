import java.util.ArrayList;
import java.util.Scanner;

public class Libreria {

    Scanner sc = new Scanner(System.in);
    Libro li = new Libro();
    ArrayList<Libro> listadoLibros = new ArrayList<>();


    public void crearLibro(){
        System.out.println("METE TITULO:");
        li.setTitulo(sc.nextLine());
        System.out.println("METE AUTOR:");
        li.setAutor(sc.nextLine());
        System.out.println("METE ISBN:");
        li.setISBN(sc.nextLine());
        System.out.println("METE PREZO:");
        li.setPrezo(sc.nextFloat());
        System.out.println("METE UNIDADES:");
        li.setNumUnidades(sc.nextInt());
    }
    public void engadirLibro() {
        listadoLibros.add(li);
    }
}
