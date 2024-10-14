import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame {
    public Ventana() {
        setTitle("Conversor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(600, 200));
        setLocationRelativeTo(null);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;

        JTextField celText = new JTextField();
        celText.setColumns(15);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(celText, gbc);

        JTextField farText = new JTextField();
        farText.setColumns(15);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(farText, gbc);

        JButton convertToF = new JButton("Convertir a Farenheit");
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(convertToF, gbc);
        convertToF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Float cel = Float.parseFloat(celText.getText());
                Float far = Conversor.celsiusFarenheit(cel);
                farText.setText(String.valueOf(far));
            }
        });

        JButton convertToC = new JButton("Convertir a Celsius");
        convertToC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Float far = Float.parseFloat(farText.getText());
                Float cel = Conversor.fahrenheitCelsius(far);
                celText.setText(String.valueOf(cel));
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(convertToC, gbc);


    }
}
