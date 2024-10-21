public class Main {
    public static void main(String[] args) {
        // Crear un novo fío para a clase Ingreso
        Thread ingreso = new Thread(new Ingreso());
        // Crear un novo fío para a clase Extraccion
        Thread extraccion = new Thread(new Extraccion());

        // Iniciar o fío de ingreso
        ingreso.start();
        // Iniciar o fío de extracción
        extraccion.start();
    }
}