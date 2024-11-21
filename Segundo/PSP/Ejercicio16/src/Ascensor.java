import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ascensor implements Runnable {
    private final Scanner sc = new Scanner(System.in);
    private int plantaActual = (int)(Math.random() * 20);  // Planta inicial aleatoria entre 0 y 20
    private boolean movendose = true; // Indica se o ascensor está en movemento
    private final List<Integer> peticiónsDeAscensor = new ArrayList<>(); // Lista de peticións do ascensor

    // Metodo para chamar o ascensor
    public synchronized void chamarAscensor(int planta) {
        peticiónsDeAscensor.add(planta); // Engade a petición á lista
        notifyAll(); // Notifica a todos os fíos que están esperando
    }

    @Override
    public void run() {
        while (movendose) { // Mentras o ascensor esté en movemento
            try { // Intenta mover o ascensor
                synchronized (this) { // Sincroniza o ascensor
                    while (peticiónsDeAscensor.isEmpty()) { // Mentras non haxa peticións
                        wait(); // Espera
                    }
                }
                int plantaChamada; // Planta á que se chama
                synchronized (this) { // Sincroniza o ascensor
                    plantaChamada = peticiónsDeAscensor.remove(0); // Elimina a primeira petición da lista
                }
                while (plantaActual != plantaChamada) { // Mentras o ascensor non estea na planta á que se chamou
                    Thread.sleep(1000); // Espera 1 segundo
                    plantaActual += (plantaActual < plantaChamada) ? 1 : -1; // Move o ascensor unha planta cara arriba ou cara abaixo
                    System.out.println(plantaActual); // Imprime a planta actual
                }
                System.out.println("Ascensor na planta " + plantaChamada); // Imprime a planta á que se chamou
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Problema co ascensor: " + e.getMessage());
            }
        }
    }

    // Metodo para presionar o botón do ascensor
    public void presionarBotón() {
        System.out.println("O ascensor está na planta " + plantaActual); // Imprime a planta actual do ascensor
        System.out.print("Introduza o número de planta ao que desexa ir (0-20) ou -1 para saír: "); // Pide a planta á que se quere ir
        int planta; // Planta á que se quere ir
        do { // Mentras non se prema -1
            planta = sc.nextInt(); // Garda a planta introducida
            if (planta >= 0 && planta <= 20) { // Se a planta é válida
                chamarAscensor(planta); // Chama ao ascensor
            } else if (planta != -1) { // Se a planta non é válida
                System.out.println("Número de planta inválido"); // Imprime unha mensaxe de erro
            }
        } while (planta != -1);
        parar(); // Para o ascensor cando se prema -1
    }

    // Metodo para parar o ascensor
    public void parar() {
        movendose = false; // O ascensor deixa de moverse
    }
}