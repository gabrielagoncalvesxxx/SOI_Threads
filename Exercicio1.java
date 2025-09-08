public class Exercicio1 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(() -> {
                long id = Thread.currentThread().threadId(); // Para JDK 19+
                System.out.println("Thread ID: " + id);
            });
            t.start();
        }
    }
}