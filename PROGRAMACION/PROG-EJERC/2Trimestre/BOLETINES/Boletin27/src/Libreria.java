import java.util.ArrayList;
import java.util.Scanner;

/**
 * La clase Librería representa una librería con varias funcionalidades
 */
public class Libreria {
    Libro l = new Libro();
    Scanner scanner = new Scanner(System.in);
    ArrayList<Libro> books = new ArrayList<>();

    /**
     * Permite al usuario elegir qué hacer
     */
    public void pickWhatToDo() {
        options();
        switch (scanner.nextInt()) {
            case 1 -> addBook();
            case 2 -> searchBook();
            case 3 -> showEveryBook();
            case 4 -> removeUnits0();
            case 5 -> modifyBook();
            case 6 -> System.out.println("Goodbye!");
            default -> {
                System.out.println("Invalid option");
                pickWhatToDo();
            }
        }
    }

    /**
     * Muestra las opciones disponibles para el usuario
     */
    private static void options() {
        System.out.println("What do you want to do?");
        System.out.println("1. Add a book");
        System.out.println("2. Consult prize of a book");
        System.out.println("3. Show all books");
        System.out.println("4. Remove a book");
        System.out.println("5. Modify a book");
        System.out.println("6. Exit");
        System.out.print("Opción: ");
    }

    /**
     * Permite al usuario modificar el costo de un libro
     */
    private void modifyBook() {
        System.out.println("Modify a book's cost. Tittle: ");
        String name = scanner.nextLine();
        if (name.equals(l.getName())) {
            System.out.print("New cost: ");
            l.setCost(scanner.nextFloat());
        } else {
            System.out.println("Sorry, we don't have that book.");
        }
    }

    /**
     * Elimina los libros sin unidades disponibles
     */
    private void removeUnits0() {
        for (int i = 0; i < books.size(); i++) {
            if (l.getUnits() == 0) {
                books.remove(l);
            } else {
                System.out.println("We are updated.");
            }
        }
    }

    /**
     * Muestra todos los libros disponibles
     */
    private void showEveryBook() {
        System.out.println("Books: \nTittle: " + l.getName() + "\nAuthor: " + l.getAuthor() + "\nCost: " + l.getCost() + "\nUnits: " + l.getUnits());
    }

    /**
     * Busca un libro por su título
     */
    private void searchBook() {
        System.out.print("Search a book:\nTittle: ");
        String nombre = scanner.nextLine();
        if (nombre.equals(l.getName())) {
            System.out.println("Cost: " + l.getCost());
        } else {
            System.out.println("Sorry, we don't have that book.");
        }
    }

    /**
     * Agrega un nuevo libro
     */
    private void addBook() {
        System.out.println("Add a new book ");
        System.out.println("Title: ");
        l.setName(scanner.nextLine());
        System.out.println("Author: ");
        l.setAuthor(scanner.nextLine());
        System.out.print("Cost: ");
        l.setCost(scanner.nextFloat());
        System.out.print("Units: ");
        l.setUnits(scanner.nextInt());
        books.add(l);
    }

}
