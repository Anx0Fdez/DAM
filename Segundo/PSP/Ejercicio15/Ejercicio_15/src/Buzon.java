import java.util.ArrayList;
import java.util.List;

public class Buzon {

    private final List<String> mensaxes = new ArrayList<>(); // Lista para almacenar os mensaxes

    public synchronized void engadirMensaxe(String mensaxe) {
        while (!mensaxes.isEmpty()) { // Mentres haxa mensaxes no buzón
            try {
                wait(); // Espérase a que se lea o mensaxe
            } catch (InterruptedException e) {
                System.out.println("Erro ao engadir mensaxe, " + e.getMessage()); // Imprímese o erro
            }
        }
        mensaxes.add(mensaxe); // Engádese o mensaxe ao buzón
        System.out.println("Mensaxe engadido ao buzón.");
        notifyAll(); // Notifícase aos fíos que están esperando
    }

    public synchronized void lerMensaxes() {
        while (mensaxes.isEmpty()) { // Mentres non haxa mensaxes no buzón
            System.out.println("Non hai mensaxes para ler."); // Imprímese que non hai mensaxes
            try {
                wait(); // Espérase a que se engada un mensaxe
            } catch (InterruptedException e) {
                System.out.println("Erro ao ler mensaxe, " + e.getMessage()); // Corrected error message
            }
        }
        for (String mensaxe : mensaxes) {
            System.out.println("Lendo mensaxe: " + mensaxe); // Imprímese o mensaxe
        }
        mensaxes.clear(); // Límpase o buzón
        System.out.println("Buzón baleiro.");
        notifyAll(); // Notifícase aos fíos que están esperando
    }
}