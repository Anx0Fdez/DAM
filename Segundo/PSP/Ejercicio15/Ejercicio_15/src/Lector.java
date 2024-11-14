public class Lector implements Runnable {

    private Buzon buzon; // Buzón do que se van ler as mensaxes

    public Lector(Buzon buzon) {
        this.buzon = buzon; // Inicialízase o buzón
    }

    @Override
    public void run() {
        while (true) { // Bucle infinito para ler mensaxes continuamente
            buzon.lerMensaxes(); // Chámase ao método para ler as mensaxes do buzón
        }
    }
}