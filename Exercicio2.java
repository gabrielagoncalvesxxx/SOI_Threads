import java.util.Random;

public class Exercicio2 {
    public static void main(String[] args) {
        int[][] matriz = new int[3][5];
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                matriz[i][j] = random.nextInt(100);
            }
        }

        for (int i = 0; i < 3; i++) {
            final int linha = i;
            Thread t = new Thread(() -> {
                int soma = 0;
                for (int num : matriz[linha]) {
                    soma += num;
                }
                System.out.println("Linha " + linha + " soma: " + soma);
            });
            t.start();
        }
    }
}