public class Parking {
    private final int[] prazas; // Array que representa as prazas do aparcadoiro
    private int prazasLibres; // Contador de prazas libres

    // Constructor que inicializa o número de prazas
    public Parking(int numPrazas) {
        this.prazas = new int[numPrazas];
        this.prazasLibres = numPrazas;
    }

    // Metodo para que un coche entre no aparcadoiro
    public synchronized void entrar(int coche) throws InterruptedException {
        while (prazasLibres == 0) {
            wait(); // Espera ata que haxa prazas libres
        }
        for (int i = 0; i < prazas.length; i++) {
            if (prazas[i] == 0) {
                prazas[i] = coche; // Asignamos a praza ao coche
                prazasLibres--;
                System.out.println("ENTRADA: Coche " + coche + " aparca en " + i + ".");
                mostrarEstado(); // Mostramos o estado actual do aparcadoiro
                break;
            }
        }
    }

    // Méçetodo para que un coche saia do aparcadoiro
    public synchronized void sair(int cocheID) {
        for (int i = 0; i < prazas.length; i++) {
            if (prazas[i] == cocheID) {
                prazas[i] = 0; // Liberamos a praza
                prazasLibres++; // Incrementamos o contador de prazas libres
                System.out.println("SAÍDA: Coche " + cocheID + " saíndo.");
                mostrarEstado(); // Mostramos o estado actual do aparcadoiro
                notifyAll(); // Notificamos a todos os fíos que están esperando
                break;
            }
        }
    }

    // Metodo para mostrar o estado actual do aparcadoiro
    private void mostrarEstado() {
        System.out.println("Prazas libres: " + prazasLibres);
        System.out.print("Parking: ");
        for (int praza : prazas) {
            System.out.print("[" + praza + "] ");
        }
        System.out.println();
    }
}