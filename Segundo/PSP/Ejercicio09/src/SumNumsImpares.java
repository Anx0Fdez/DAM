class SumNumsImpares extends Thread {
    @Override
    public void run() {
        int suma = 0;
        // Sumar números impares do 1 ao 2500
        for (int i = 1; i <= 2500; i++) {
            if (i % 2 != 0) {
                suma += i;
            }
        }
        System.out.println("Suma dos números impares: " + suma);
    }
}