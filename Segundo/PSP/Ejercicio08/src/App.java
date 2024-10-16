import java.util.Random; // Importa a clase Random para xerar números aleatorios

/**
 * A clase App estende Thread para crear unha aplicación multi-fío.
 * Cada fío crea un fío fillo ata un máximo de cinco fíos.
 * Cada fío imprime o seu nome, procesa con demoras aleatorias, e espera a que o seu fillo remate.
 */
public class App extends Thread {
    // Número máximo de fíos a ser creados
    private final int HILOSMAX = 5;
    // O nivel do fío actual
    private int nivel;

    /**
     * Constructor para inicializar o nivel do fío.
     */
    public App(int nivel) {
        this.nivel = nivel; // Asigna o nivel do fío
    }

    /**
     * O método run execútase cando o fío comeza.
     * Crea un fío fillo se o nivel actual é menor que o máximo,
     * imprime o seu nome, procesa con demoras aleatorias, e espera a que o seu fillo remate.
     */
    @Override
    public void run() {
        System.out.println("Fío " + nivel + " comezou."); // Imprime o inicio do fío
        if (nivel < HILOSMAX) { // Se o nivel é menor que o máximo permitido
            App fillo = new App(nivel + 1); // Crea un novo fío fillo cun nivel incrementado
            fillo.start(); // Inicia o fío fillo
            try {
                fillo.join(); // Espera a que o fío fillo remate
            } catch (InterruptedException e) {
                e.printStackTrace(); // Manexa a excepción se o fío é interrompido
            }
        }
        Random random = new Random(); // Crea unha instancia de Random para xerar demoras aleatorias
        for (int i = 0; i < 10; i++) { // Bucle que se executa 10 veces
            System.out.println("Fío " + nivel + " procesando."); // Imprime o estado de procesamento do fío
            try {
                Thread.sleep(100 + random.nextInt(600)); // Pausa o fío por un tempo aleatorio
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Fío " + nivel + " finalizou."); // Imprime o final do fío
    }
}