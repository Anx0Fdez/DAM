import java.util.concurrent.ThreadLocalRandom;

// Clase Coche que implementa Runnable para simular o comportamento dos coches
public class Coche implements Runnable {
    private final int id; // Identificador do coche
    private final Parking parking; // Referencia ao aparcadoiro

    // Constructor que inicializa o identificador e o aparcadoiro
    public Coche(int id, Parking parking) {
        this.id = id;
        this.parking = parking;
    }

    // Metodo run que define o comportamento do coche
    @Override
    public void run() {
        try {
            while (true) {
                parking.entrar(id); // O coche entra no aparcadoiro
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000)); // Espera un tempo aleatorio
                parking.sair(id); // O coche sae do aparcadoiro
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000)); // Espera un tempo aleatorio antes de volver a entrar
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}