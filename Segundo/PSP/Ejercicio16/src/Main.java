public class Main {
    public static void main(String[] args) {
        Ascensor ascensor = new Ascensor();
        Thread hiloAscensor = new Thread(ascensor);
        hiloAscensor.start();
        ascensor.presionarBotón();
    }
}