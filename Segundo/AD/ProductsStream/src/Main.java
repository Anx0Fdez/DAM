import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Escribe a URL onde queres escribir: ");
        String filePath = sc.nextLine();

        Product p1 = new Product("cod1", "parafusos", 3.0);
        saveProducts(p1, filePath);
        Product p2 = new Product("cod2", "cravos", 4.0);
        Product p3 = new Product("cod3", "tachas", 6.0);
        Product p4 = new Product("cod4", "grapas", 2.0);
        saveProducts(p2, filePath);
        saveProducts(p3, filePath);
        saveProducts(p4, filePath);

        List<Product> po3 = showProducts(filePath);
        System.out.println("Produtos almacenados en po3:");
        for (Product p : po3) {
            System.out.println(p.getCodigo() + ", " + p.getDescripcion() + ", " + p.getPrecio());
        }
    }

    public static void saveProducts(Product p, String filePath) {
        try {
            FileOutputStream searchTxt = new FileOutputStream(filePath, true);
            DataOutputStream writeInTxt = new DataOutputStream(searchTxt);
            writeInTxt.writeUTF(p.getCodigo());
            writeInTxt.writeUTF(p.getDescripcion());
            writeInTxt.writeDouble(p.getPrecio());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Product> showProducts(String filePath) {
        List<Product> products = new ArrayList<>();
        try {
            FileInputStream searchTxt = new FileInputStream(filePath);
            DataInputStream readInTxt = new DataInputStream(searchTxt);
            while (readInTxt.available() > 0) {
                Product p = new Product();
                p.setCodigo(readInTxt.readUTF());
                p.setDescripcion(readInTxt.readUTF());
                p.setPrecio(readInTxt.readDouble());
                products.add(p);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return products;
    }
}