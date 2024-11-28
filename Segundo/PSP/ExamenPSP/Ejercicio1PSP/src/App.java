class App implements Runnable {
    private String nome;

    public App(String nome) {
        this.nome = nome; // Asigna o nome do fío
    }

    @Override
    public void run() {
        for (int i = 1; i <= 8; i++) { // Bucle que se executa 8 veces
            System.out.println("Iteración " + i + " do fío " + nome); // Imprime a iteración actual e o nome do fío
            try {
                Thread.sleep(500); // Durme o fío
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Interrompe o fío actual
                System.out.println("Fío " + nome + " interrompido.");
            }
        }
    }
}