public class Prioridades extends Thread {
    int num;

    public Prioridades(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        if (num == 1) {
            System.out.println("Soy el hilo uno");
        } else if (num == 2) {
            System.out.println("Soy el hilo dos");
        } else {
            System.out.println("Desconocido...");
        }
    }

}
