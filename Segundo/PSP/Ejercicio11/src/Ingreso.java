public class Ingreso implements Runnable {
    // Variable estática que representa o diñeiro
    public static Integer dinero = 0;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            // Engadir 500 á variable estática 'dinero'
            dinero += 500;
            // Imprimir o valor actual de 'dinero' despois do ingreso
            System.out.println("Ingreso: " + dinero + "$");
            try {
                // Pausar o fío durante 300 milisegundos
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}