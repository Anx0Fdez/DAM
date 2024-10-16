public class Main {
    public static void main(String[] args) {
        Product pro2 = new Product("cod2", "cravos", 4.0);
        Product pro3 = new Product("cod3", "tachas", 6.0);
        Product pro4 = new Product("cod4", "grapas", 2.0);

        Product product = new Product();
        product.escribirTXT(pro2, pro3, pro4);
    }
}