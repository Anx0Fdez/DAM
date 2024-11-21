// Clase principal que inicia o programa
public class Main {
    public static void main(String[] args) {
        int numPrazas = 6; // Número de prazas no aparcadoiro
        int numCoches = 5; // Número de coches no sistema
        Parking parking = new Parking(numPrazas); // Creamos o aparcadoiro

        // Creamos e iniciamos un fío para cada coche
        for (int i = 1; i <= numCoches; i++) {
            new Thread(new Coche(i, parking)).start();
        }
    }
}