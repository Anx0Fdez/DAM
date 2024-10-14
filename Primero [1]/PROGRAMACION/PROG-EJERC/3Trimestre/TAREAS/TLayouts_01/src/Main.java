import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private static String operation = "";
    private static double firstNumber = 0;
    private static double secondNumber = 0;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JTextField textField = new JTextField();
        frame.add(textField, BorderLayout.NORTH);

        JPanel numberPanel = new JPanel(new GridLayout(4, 4));
        for (int i = 0; i <= 9; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textField.setText(textField.getText() + button.getText());
                }
            });
            numberPanel.add(button);
        }

        String[] operations = {"+", "-"};
        for (String op : operations) {
            JButton button = new JButton(op);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    firstNumber = Double.parseDouble(textField.getText());
                    operation = op;
                    textField.setText("");
                }
            });
            numberPanel.add(button);
        }

        JButton equalsButton = new JButton("=");
        equalsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secondNumber = Double.parseDouble(textField.getText());
                switch (operation) {
                    case "+":
                        textField.setText(String.valueOf(firstNumber + secondNumber));
                        break;
                    case "-":
                        textField.setText(String.valueOf(firstNumber - secondNumber));
                        break;
                }
            }
        });
        numberPanel.add(equalsButton);

        frame.add(numberPanel, BorderLayout.CENTER);

        JPanel operationPanel = new JPanel();
        operationPanel.setLayout(new BoxLayout(operationPanel, BoxLayout.Y_AXIS));
        JButton clearButton = new JButton("Limpiar");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
                firstNumber = 0;
                secondNumber = 0;
                operation = "";
            }
        });
        operationPanel.add(clearButton);
        frame.add(operationPanel, BorderLayout.EAST);

        frame.pack();
        frame.setVisible(true);
    }
}