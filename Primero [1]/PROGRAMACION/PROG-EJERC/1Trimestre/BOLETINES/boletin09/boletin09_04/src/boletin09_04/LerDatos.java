package boletin09_04;

import javax.swing.JOptionPane;

public class LerDatos {

    public static int lerEnteiro(String mensaxe) {

        int resposta = Integer.parseInt(JOptionPane.showInputDialog(mensaxe));
        return resposta;

    }

    public static float leerFloatPositivo(String mensaxe) {
        float dato;

        do {
            dato = Float.parseFloat(JOptionPane.showInputDialog(mensaxe));
        } while (dato <= 0);

        return dato;

    }

}
                            