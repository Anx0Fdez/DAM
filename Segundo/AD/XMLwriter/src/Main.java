import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Datos de exemplo para crear os produtos
        String[] cod = {"p1", "p2", "p3"};
        String[] desc = {"parafusos", "cravos", "tachas"};
        int[] prezo = {3, 4, 5};

        // Creamos un array de produtos usando os datos de exemplo
        Product[] produtos = new Product[cod.length];
        for (int i = 0; i < cod.length; i++) {
            produtos[i] = new Product(cod[i], desc[i], prezo[i]);
        }

        // Escribimos os produtos nun arquivo binario
        String filePath = "produtos.bin";
        Product.escribirProdutos(produtos, filePath);

        // Lemos os produtos desde o arquivo binario
        List<Product> produtosLidos = Product.lerProdutos(filePath);
        System.out.println("Produtos lidos desde o arquivo binario:");

        // Amosamos os produtos lidos na consola
        for (Product p : produtosLidos) {
            System.out.println("Código: " + p.getCodigo() +
                    ", Descrición: " + p.getDescripcion() +
                    ", Prezo: " + p.getPrezo());
        }

        // Exportamos os produtos lidos a un arquivo XML
        String xmlFilePath = "produtos.xml";
        Product.exportarProdutosAXML(produtosLidos, xmlFilePath);
        System.out.println("Produtos exportados a XML no arquivo: " + xmlFilePath);
    }
}