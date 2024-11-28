import java.util.concurrent.atomic.AtomicInteger;

class ContadorDixitos implements Runnable {
    private final String texto;
    private final char dixito;
    private final AtomicInteger totalDixitosPares; //Variable para almacenar os dixitos pares

    public ContadorDixitos(String texto, char dixito, AtomicInteger totalDixitosPares) {
        this.texto = texto;
        this.dixito = dixito;
        this.totalDixitosPares = totalDixitosPares;
    }

    @Override
    public void run() {
        int conta = 0;
        for (char c : texto.toCharArray()) {
            if (c == dixito) {
                conta++; // Incrementar o contador
            }
        }
        totalDixitosPares.addAndGet(conta);
        System.out.println("Dixito " + dixito + " conta: " + conta); // Imprimir o resultado para este díxito
    }
}