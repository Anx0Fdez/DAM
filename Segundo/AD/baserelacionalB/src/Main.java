import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        App app = new App(); // Crea unha instancia da clase App
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("--------------------");
            System.out.println("Escolle unha opción: ");
            System.out.println("1. Actualizar prezo dun produto");
            System.out.println("2. Insertar un novo produto");
            System.out.println("3. Eliminar un produto");
            System.out.println("4. Listar contido da táboa produtos");
            System.out.println("5. Sair");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Escolle o produto a actualizar: ");
                    System.out.println("Introduce o codigo do produto: ");
                    String codigo = sc.next();
                    System.out.println("Introduce o prezo: ");
                    double prezo = sc.nextDouble();

                    app.actualizarPrecioProducto(codigo, prezo); // Chama ao metodo actualizarPrecioProducto
                    break;
                case 2:
                    System.out.println("Escolle o produto a insertar: ");
                    System.out.println("Introduce o codigo do produto: ");
                    String cod = sc.next();
                    System.out.println("Introduce a descricion: ");
                    String descricion = sc.next();
                    System.out.println("Introduce o prezo: ");
                    double prezoInsert = sc.nextDouble();
                    System.out.println("Introduce a data (YYYY-MM-DD): ");
                    String datac = sc.next();

                    app.insertarProducto(cod, descricion, prezoInsert, datac); // Chama ao metodo insertarProducto
                    break;
                case 3:
                    System.out.println("Escolle o produto a eliminar: ");
                    System.out.println("Introduce o codigo do produto: ");
                    String codEliminar = sc.next();
                    app.eliminarProducto(codEliminar); // Chama ao metodo eliminarProducto
                    break;
                case 4:
                    System.out.println("Vamos a listar o contido da táboa produtos: ");
                    app.listarContenido(); // Chama ao metodo listarContenido
                    break;
                case 5:
                    System.out.println("Sair...");
                    break;
                default:
                    break;
            }
        } while (choice != 5);
    }
}