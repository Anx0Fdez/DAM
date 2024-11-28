class Camareiro extends Thread {
    private boolean ocupado = false; // Indica se o camareiro está ocupado

    public synchronized void atenderCliente(String nomeCliente) {
        while (ocupado) {
            try {
                wait(); // Espera a que o camareiro estea dispoñible
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); //
            }
        }
        ocupado = true; // Marca o camareiro como ocupado
        System.out.println(nomeCliente + " está sendo atendido.");
        try {
            Thread.sleep(2000); // Simula o tempo de preparación do café
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(nomeCliente + " foi atendido.");
        ocupado = false; // Marca o camareiro como dispoñible
        notifyAll(); // Notifica a todos os fíos que están esperando
    }
}