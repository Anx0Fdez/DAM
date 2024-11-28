public class Main {
    public static void main(String[] args) {
        // Crear un camareiro e iniciar o seu fío
        Camareiro camareiro = new Camareiro();
        camareiro.start();

        // Crear e iniciar fíos dos 5 clientes
        for (int i = 1; i <= 5; i++) {
            Cliente cliente = new Cliente("Cliente " + i, camareiro);
            cliente.start();
        }
    }
}