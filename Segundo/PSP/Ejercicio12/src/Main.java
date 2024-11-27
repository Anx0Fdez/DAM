public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Crear unha instancia de Contador compartida por todos os fíos
        Contador contador = new Contador();

        // Crear catro fíos que executarán o mesmo obxecto Contador
        Thread hilo1 = new Thread(contador, "Fío 1");
        Thread hilo2 = new Thread(contador, "Fío 2");
        Thread hilo3 = new Thread(contador, "Fío 3");
        Thread hilo4 = new Thread(contador, "Fío 4");

        // Iniciar os fíos
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();

        // Esperar a que todos os fíos rematen
        hilo1.join();
        hilo2.join();
        hilo3.join();
        hilo4.join();
    }
}