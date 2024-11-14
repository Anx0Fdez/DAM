import java.sql.Date; // Importa a clase Date do paquete java.sql
import java.util.InputMismatchException; // Importa a clase InputMismatchException do paquete java.util
import java.util.Scanner; // Importa a clase Scanner do paquete java.util

public class Main { // Define a clase Main
    public static void main(String[] args) { // Metodo principal
        try (Scanner sc = new Scanner(System.in)) { // Crea un obxecto Scanner para ler a entrada do usuario
            App app = new App(); // Crea unha instancia da clase App
            int opcion; // Declara unha variable para almacenar a opción do usuario

            do {
                System.out.println("Menú:"); // Imprime o menú
                System.out.println("1. Engadir produto"); // Opción para engadir un produto
                System.out.println("2. Listar produtos"); // Opción para listar todos os produtos
                System.out.println("3. Listar produto por código"); // Opción para listar un produto polo seu código
                System.out.println("4. Actualizar prezo do produto"); // Opción para actualizar o prezo dun produto
                System.out.println("5. Eliminar produto"); // Opción para eliminar un produto
                System.out.println("6. Saír"); // Opción para saír do programa
                System.out.print("Escolle unha opción: "); // Pide ao usuario que escolla unha opción

                try {
                    opcion = sc.nextInt(); // Le a opción do usuario
                    sc.nextLine(); // Consumir a nova liña
                } catch (InputMismatchException e) { // Captura excepcións de tipo InputMismatchException
                    System.out.println("Entrada non válida. Por favor, introduce un número."); // Mensaxe de erro se a entrada non é válida
                    sc.next(); // Limpar a entrada non válida
                    opcion = -1; // Establecer opción a un valor non válido para continuar o bucle
                    continue; // Continúa co seguinte ciclo do bucle
                }

                switch (opcion) { // Avalía a opción do usuario
                    case 1:
                        System.out.println("Engadindo produto..."); // Mensaxe de engadir produto
                        System.out.print("Introduce o código do produto: "); // Pide ao usuario que introduza o código do produto
                        String codigo = sc.nextLine(); // Lê o código do produto
                        System.out.print("Introduce a descrición do produto: "); // Pide ao usuario que introduza a descrición do produto
                        String descricion = sc.nextLine(); // Lê a descrición do produto
                        System.out.print("Introduce o prezo do produto: "); // Pide ao usuario que introduza o prezo do produto
                        int prezo = Integer.parseInt(sc.nextLine()); // Lê o prezo do produto
                        System.out.print("Introduce a data do produto (yyyy-MM-dd): "); // Pide ao usuario que introduza a data do produto
                        Date data = Date.valueOf(sc.nextLine()); // Lê a data do produto
                        app.addProduct(codigo, descricion, prezo, data); // Chama ao metodo addProduct para engadir o produto
                        break;
                    case 2:
                        System.out.println("Listando produtos..."); // Mensaxe de listar produtos
                        app.listProducts(); // Chama ao metodo listProducts para listar todos os produtos
                        break;
                    case 3:
                        System.out.print("Introduce o código do produto: "); // Pide ao usuario que introduza o código do produto
                        String codigo2 = sc.nextLine(); // Le o código do produto
                        app.listProductFromCode(codigo2); // Chama ao metodo listProductFromCode para listar o produto polo seu código
                        break;
                    case 4:
                        System.out.println("Actualizando prezo do produto..."); // Mensaxe de actualizar prezo do produto
                        System.out.print("Introduce o código do produto: "); // Pide ao usuario que introduza o código do produto
                        String codigo3 = sc.nextLine(); // Le o código do produto
                        System.out.print("Introduce o novo prezo: "); // Pide ao usuario que introduza o novo prezo do produto
                        int prezo2 = sc.nextInt(); // Le o novo prezo do produto
                        sc.nextLine(); // Consumir a nova liña
                        app.updatePrice(prezo2, codigo3); // Chama ao metodo updatePrice para actualizar o prezo do produto
                        break;
                    case 5:
                        System.out.println("Eliminando produto..."); // Mensaxe de eliminar produto
                        System.out.print("Introduce o código do produto: "); // Pide ao usuario que introduza o código do produto
                        String codigo4 = sc.next(); // Le o código do produto
                        app.deleteProduct(codigo4); // Chama ao metodo deleteProduct para eliminar o produto
                        break;
                    case 6:
                        System.out.println("Saíndo..."); // Mensaxe de saír do programa
                        break;
                    default:
                        System.out.println("Opción non válida. Por favor, inténtao de novo."); // Mensaxe de opción non válida
                }
            } while (opcion != 6); // Repite o bucle mentres a opción non sexa 6
        } catch (NumberFormatException e) { // Captura excepcións de tipo NumberFormatException
            System.out.println(e.getMessage()); // Imprime a mensaxe de erro
        }
    }
}