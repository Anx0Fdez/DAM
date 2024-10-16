public class Main {
    public static void main(String[] args) {
        int N = 10; // Por exemplo, calcular os primeiros 10 números de Fibonacci
        FibonacciThread thread = new FibonacciThread(N);
        thread.start();
    }
}