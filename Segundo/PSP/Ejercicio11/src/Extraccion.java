public class Extraccion implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            // Restar 100 á variable estática 'dinero' da clase Ingreso
            Ingreso.dinero -= 100;
            // Imprimir o valor actual de 'dinero' despois da extracción
            System.out.println("Extracción: " + Ingreso.dinero + "$");
            try {
                // Pausar o fío durante 600 milisegundos
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}