class Cliente extends Thread {
    private String nome;
    private Camareiro camareiro;

    // Constructor para inicializar o nome do cliente e o camareiro
    public Cliente(String nome, Camareiro camareiro) {
        this.nome = nome;
        this.camareiro = camareiro;
    }

    @Override
    public void run() {
        // Solicitar ao camareiro que atenda ao cliente
        camareiro.atenderCliente(nome);
    }
}