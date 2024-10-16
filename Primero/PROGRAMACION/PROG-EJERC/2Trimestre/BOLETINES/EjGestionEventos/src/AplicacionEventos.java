import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Esta clase representa una aplicación simple de Java Swing que demuestra el manejo de ActionEvents.
 * La aplicación consta de una sola clase, AplicacionEventos, que extiende JFrame.
 */
public class AplicacionEventos extends JFrame {
    // Variables de instancia que representan un campo de texto, un área de texto y un botón, respectivamente.
    private JTextField campoTexto;
    private JTextArea areaTexto;
    private JButton botonMostrar;

    /**
     * Constructor para la clase AplicacionEventos.
     * Establece el diseño del JFrame a FlowLayout e inicializa las variables de instancia.
     * El campo de texto campoTexto se agrega al JFrame con un ancho de 10 caracteres.
     * El botón botonMostrar también se agrega al JFrame con un ActionListener adjunto.
     * El área de texto areaTexto se inicializa con 5 filas y 20 columnas, y se agrega al JFrame dentro de un JScrollPane.
     * El tamaño del JFrame se establece en 300x200 píxeles, la operación de cierre predeterminada se establece en EXIT_ON_CLOSE y la visibilidad del JFrame se establece en verdadero.
     */
    public AplicacionEventos() {
        super("Demostración de Eventos");
        setLayout(new FlowLayout());

        // Inicializar y agregar el campo de texto al JFrame
        campoTexto = new JTextField(10);
        add(campoTexto);

        // Inicializar el botón y agregar un ActionListener
        botonMostrar = new JButton("Mostrar en Área de Texto");
        botonMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cuando se hace clic en el botón, se recupera el texto de campoTexto, se agrega a areaTexto y luego se borra el campo de texto.
                String texto = campoTexto.getText();
                areaTexto.append(texto + "\n");
                campoTexto.setText("");
            }
        });
        add(botonMostrar);

        // Inicializar el área de texto y agregarla al JFrame dentro de un JScrollPane
        areaTexto = new JTextArea(5, 20);
        add(new JScrollPane(areaTexto));

        // Establecer el tamaño del JFrame, la operación de cierre predeterminada y la visibilidad
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * El método principal que lanza la aplicación creando una nueva instancia de AplicacionEventos.
     * @param args argumentos de línea de comando
     */
    public static void main(String[] args) {
        new AplicacionEventos();
    }
}