public class Main {
    public static void main(String[] args) {
        // Datos de exemplo
        String[] cod = {"p1", "p2", "p3"};
        String[] desc = {"parafusos", "cravos", "tachas"};
        int[] prezo = {3, 4, 5};

        // Crear un array de produtos
        Product[] productos = new Product[cod.length];
        for (int i = 0; i < cod.length; i++) {
            productos[i] = new Product(cod[i], desc[i], prezo[i]);
        }

        // Escribir produtos nun arquivo binario
        String filePath = "productos.bin";
        Product.escribirProductos(productos, filePath);

        // Ler produtos desde o arquivo binario
        System.out.println("Lendo produtos desde o arquivo:");
        Product.leerProductos(filePath);
    }
}