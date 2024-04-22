# ***JAVA DAM1***
## *3ª EVALUACIÓN*
### *by: [Anxo Fdez]*
#### *github: [Anx0Fdez](https://github.com/Anx0Fdez)*

---

# **INDICE**
1. [**Gestión de eventos**](#gestión-de-eventos)

---

## *Gestion de eventos*

```java
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JFrame {
    private JPanel panel;
    private JButton boton;

    public Ventana() {
        panel = new JPanel();
        boton = new JButton("Pulsa");

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Pulsado");
            }
        });

        panel.add(boton);
        add(panel);
    }
}
```
