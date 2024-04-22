import javax.swing.*;
import java.util.Arrays;

public class Array {

    private int[] pato = {121, 3, 5123, 4, 83, 92, 12};

    public int[] getPato() {
        return pato;
    }

    public void setPato(int[] pato) {
        this.pato = pato;
    }

    public void buscar() {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Dime un numero para buscar: "));
        int busqueda = Arrays.binarySearch(pato, numero);
        System.out.println(busqueda);

    }

    public void ordenar() {
        Arrays.sort(pato);
        System.out.println("Array ordenado: " + Arrays.toString(pato));


    }
}
