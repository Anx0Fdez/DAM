public class NumsFIN3x4 extends Thread {
    @Override
    public void run() {
        int suma = 0;
        // Sumar números que terminan en 3 ou 4 do 1 ao 2500
        for (int i = 1; i <= 2500; i++) {
            if (i % 10 == 3 || i % 10 == 4) {
                suma += i;
            }
        }
        System.out.println("Suma dos números que terminan en 3 ou 4: " + suma);
    }
}