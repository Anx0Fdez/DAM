public class Contador implements Runnable {
    private int contador = 0; // Variable compartida entre os fíos

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (contador >= 400) { // Comprobar se o contador chegou a 400
                    break; // Saír do bucle se o contador chegou a 400
                }
                contador++; // Incrementar o contador
                System.out.println(Thread.currentThread().getName() + " " + contador); // Imprimir o valor do contador
            }
            try {
                Thread.sleep(100); // Durmir o fío durante 100 milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace(); // Imprimir a traza de excepción se ocorre unha interrupción
            }
        }
    }
}