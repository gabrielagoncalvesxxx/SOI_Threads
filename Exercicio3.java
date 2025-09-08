import java.util.Random;

class ThreadVetor extends Thread {
    private int num;
    private int[] vetor;

    public ThreadVetor(int num, int[] vetor) {
        this.num = num;
        this.vetor = vetor;
    }

    @Override
    public void run() {
        long inicio = System.currentTimeMillis();
        if (num % 2 == 0) {
            for (int i = 0; i < vetor.length; i++) {
                int x = vetor[i];
            }
        } else {
            for (int valor : vetor) {
                int x = valor;
            }
        }
        long fim = System.currentTimeMillis();
        System.out.println("Thread " + num + " levou " + (fim - inicio) + " ms");
    }
}

public class Exercicio3 {
    public static void main(String[] args) {
        int[] vetor = new int[1000];
        Random random = new Random();
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = random.nextInt(100) + 1;
        }

        ThreadVetor t1 = new ThreadVetor(1, vetor);
        ThreadVetor t2 = new ThreadVetor(2, vetor);
        t1.start();
        t2.start();
    }
}