import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        AtomicBoolean running = new AtomicBoolean(false);
        AtomicInteger currentProgress = new AtomicInteger(0);

        JButton playButton = new JButton("Play");
        JButton pauseButton = new JButton("Pause");
        JButton stopButton = new JButton("Stop");

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.X_AXIS));
        controlPanel.add(playButton);
        controlPanel.add(pauseButton);
        controlPanel.add(stopButton);

        JPanel keypadPanel = new JPanel(new GridLayout(3, 3));
        for (int i = 1; i <= 9; i++) {
            keypadPanel.add(new JButton(String.valueOf(i)));
        }

        JProgressBar progressBar = new JProgressBar();
        progressBar.setMinimum(0);
        progressBar.setMaximum(100);

        playButton.addActionListener(e -> {
            running.set(true);
            new Thread(new ProgressRunnable(progressBar, running, currentProgress)).start();
        });

        pauseButton.addActionListener(e -> running.set(false));

        stopButton.addActionListener(e -> {
            running.set(false);
            currentProgress.set(0);
            progressBar.setValue(0);
        });

        JFrame frame = new JFrame("Media Control Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(progressBar, BorderLayout.NORTH);
        frame.add(keypadPanel, BorderLayout.CENTER);
        frame.add(controlPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }
}