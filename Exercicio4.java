import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

class CorridaSapo extends Thread {
    private static final int DISTANCIA = 50;
    private static final int SALTO_MAX = 5;
    private static AtomicInteger colocacao = new AtomicInteger(1);

    private String nome;

    public CorridaSapo(String nome) {
        this.nome = nome;
    }

    @Override
    public void run() {
        Random random = new Random();
        int percorrido = 0;
        while (percorrido < DISTANCIA) {
            int salto = random.nextInt(SALTO_MAX) + 1;
            percorrido += salto;
            System.out.println(nome + " saltou " + salto + "m (total: " + percorrido + ")");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int posicao = colocacao.getAndIncrement();
        System.out.println(nome + " chegou! Colocação: " + posicao);
    }
}

public class Exercicio4 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            new CorridaSapo("Sapo " + i).start();
        }
    }
}