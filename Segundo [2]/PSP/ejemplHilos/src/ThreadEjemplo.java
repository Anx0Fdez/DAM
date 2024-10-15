public class ThreadEjemplo extends Thread {
    public ThreadEjemplo(String str) {
        super(str);
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + getName());
        }
    }

    public static void main(String[] args) {
        new ThreadEjemplo("Lucas").start();
        new ThreadEjemplo("Andy").start();
        System.out.println("Termina hilo principal.");
    }
}