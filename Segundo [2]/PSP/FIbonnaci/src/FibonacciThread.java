/**
 * A clase FibonacciThread estende a clase Thread para calcular os primeiros N números
 * da sucesión de Fibonacci. A sucesión de Fibonacci comeza con 1 e 1, e cada
 * número subseguinte é a suma dos dous números anteriores.
 */
public class FibonacciThread extends Thread {
    private int N;

    /**
     * Constructor da clase FibonacciThread.
     *
     * @param N o número de números de Fibonacci a calcular
     */
    public FibonacciThread(int N) {
        this.N = N;
    }

    /**
     * O método run execútase cando se inicia o fío. Calcula os primeiros N
     * números da sucesión de Fibonacci e imprímeos na consola.
     */
    @Override
    public void run() {
        if (N <= 0) {
            System.out.println("N debe ser maior que 0");
            return;
        }

        long[] fibonacci = new long[N];
        if (N >= 1) fibonacci[0] = 1;
        if (N >= 2) fibonacci[1] = 1;

        for (int i = 2; i < N; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }

        for (int i = 0; i < N; i++) {
            System.out.print(fibonacci[i] + " ");
        }
        System.out.println();
    }
}