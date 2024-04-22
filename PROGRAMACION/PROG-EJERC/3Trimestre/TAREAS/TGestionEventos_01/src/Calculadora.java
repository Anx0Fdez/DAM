import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculadora extends JFrame {
    private JTextField primerNum;
    private JTextField segundoNum;
    private JTextArea areaTexto;
    private JButton botonSuma;
    private JButton botonResta;


    public Calculadora() {
        super("Calculadora");
        setLayout(new FlowLayout());

        primerNum = new JTextField(5);
        add(primerNum);

        segundoNum = new JTextField(5);
        add(segundoNum);

        // Inicializar el botón y agregar un ActionListener
        botonSuma = new JButton("SUMA");
        botonResta = new JButton("RESTA");

        botonSuma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = Integer.parseInt(primerNum.getText());
                int num2 = Integer.parseInt(segundoNum.getText());

                areaTexto.append(String.valueOf(num + num2 + "\n"));
                primerNum.setText("");
            }
        });
        add(botonSuma);

        botonResta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int res = Integer.parseInt(primerNum.getText());
                int res2 = Integer.parseInt(segundoNum.getText());

                areaTexto.append(String.valueOf(res - res2 + "\n"));
                primerNum.setText("");
                primerNum.setText("");

            }
        });
        add(botonResta);

        // Inicializar el área de texto y agregarla al JFrame dentro de un JScrollPane
        areaTexto = new JTextArea(5, 20);
        add(new JScrollPane(areaTexto));

        // Establecer el tamaño del JFrame, la operación de cierre predeterminada y la visibilidad
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
