public class Escritor implements Runnable {

    private Buzon buzon; // Buzón onde se vai escribir a mensaxe
    private String mensaxe; // Mensaxe a escribir

    public Escritor(Buzon buzon, String mensaxe) {
        this.buzon = buzon; // Inicialízase o buzón
        this.mensaxe = mensaxe; // Inicialízase a mensaxe
    }

    @Override
    public void run() {
        buzon.engadirMensaxe(mensaxe); // Engádese a mensaxe ao buzón
    }
}