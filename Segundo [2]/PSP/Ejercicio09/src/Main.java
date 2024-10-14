public class Main {
    public static void main(String[] args) {
        // Crear e iniciar os fíos
        Thread fíoEspecíficos = new Thread(new NumsFIN3x4());
        Thread fíoPares = new Thread(new SumNumsPares());
        Thread fíoImpares = new Thread(new SumNumsImpares());

        fíoPares.start();
        fíoImpares.start();
        fíoEspecíficos.start();
    }
}