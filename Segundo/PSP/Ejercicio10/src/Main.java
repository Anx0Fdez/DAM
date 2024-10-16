public class Main {
    public static void main(String[] args) {

        Prioridades pri = new Prioridades(1);
        Prioridades prio = new Prioridades(2);

        prio.setPriority(1);
        pri.setPriority(10);

        pri.start();
        prio.start();

        try {
            pri.join();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}