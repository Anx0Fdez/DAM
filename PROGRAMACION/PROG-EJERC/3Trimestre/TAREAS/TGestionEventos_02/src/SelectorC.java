import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class SelectorC extends JFrame {
    private JComboBox<String> desplegable;
    private JPanel panel;

    public SelectorC() {
        String[] colores = {"Rojo", "Verde", "Azul"};
        desplegable = new JComboBox<>(colores);

        panel = new JPanel();

        desplegable.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String colorSeleccionado = (String) desplegable.getSelectedItem();
                    switch (colorSeleccionado) {
                        case "Rojo":
                            panel.setBackground(Color.RED);
                            break;
                        case "Verde":
                            panel.setBackground(Color.GREEN);
                            break;
                        case "Azul":
                            panel.setBackground(Color.BLUE);
                            break;
                    }
                }
            }
        });

        this.setLayout(new BorderLayout());
        this.add(desplegable, BorderLayout.NORTH);
        this.add(panel, BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setVisible(true);
    }
}
