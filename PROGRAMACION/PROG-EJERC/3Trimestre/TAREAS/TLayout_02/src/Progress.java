
import javax.swing.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

class ProgressRunnable implements Runnable {
    private final JProgressBar progressBar;
    private final AtomicBoolean running;
    private final AtomicInteger currentProgress;

    ProgressRunnable(JProgressBar progressBar, AtomicBoolean running, AtomicInteger currentProgress) {
        this.progressBar = progressBar;
        this.running = running;
        this.currentProgress = currentProgress;
    }

    @Override
    public void run() {
        for (int i = currentProgress.get(); i <= 100; i++) {
            if (!running.get()) {
                currentProgress.set(i);
                break;
            }
            final int progress = i;
            SwingUtilities.invokeLater(() -> progressBar.setValue(progress));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
