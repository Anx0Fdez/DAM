public class RunTime {

    public void totalMemory() {
        float MiB = Runtime.getRuntime().totalMemory() / 1024 / 1024;
        System.out.println("Total memory: " + MiB + " MiB");
    }

    public void freeMemory() {
        float MiB = Runtime.getRuntime().freeMemory() / 1024 / 1024;
        System.out.println("Free memory: " + MiB + " MiB");
    }

    public void maxMemory() {
        float MiB = Runtime.getRuntime().maxMemory() / 1024 / 1024;
        System.out.println("Max memory: " + MiB + " MiB");
    }

    public void availableProcessors() {
        System.out.println("Available processors: " + Runtime.getRuntime().availableProcessors());
    }

    public void listSystemProperties() {
        System.out.println("--------------------");
        System.out.println("System properties:");
        System.getProperties().list(System.out);
    }
}