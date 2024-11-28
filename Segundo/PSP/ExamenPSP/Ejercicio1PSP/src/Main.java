public class Main {
    public static void main(String[] args) {
        // Creamos 3 fios con tres nomes distintos
        Thread fío1 = new Thread(new App("Fío 1"));
        Thread fío2 = new Thread(new App("Fío 2"));
        Thread fío3 = new Thread(new App("Fío 3"));

        // Iniciamos os fios
        try {
            fío3.start();
            fío3.join(); // Espera a que o fío 3 remate

            fío2.start();
            fío2.join(); // Espera a que o fío 2 remate

            fío1.start();
            fío1.join(); // Espera a que o fío 1 remate

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("O fío principal foi interrompido.");
        }

        System.out.println("O programa rematou.");
    }
}