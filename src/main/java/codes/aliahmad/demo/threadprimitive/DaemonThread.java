package codes.aliahmad.demo.threadprimitive;


public class DaemonThread {
    public static void main(String[] args) throws InterruptedException {
        Thread daemon = new Thread(() -> {
            while (true) {
                System.out.println("Daemon still working...");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ignored) {
                }
            }
        });
//        daemon.setDaemon(true); // Set as daemon
        daemon.start();

        System.out.println("Main thread done.");
        // JVM exits immediately after this
    }
}
