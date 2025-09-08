import java.io.BufferedReader;
import java.io.InputStreamReader;

class PingThread extends Thread {
    private String servidor;
    private String nome;

    public PingThread(String nome, String servidor) {
        this.nome = nome;
        this.servidor = servidor;
    }

    @Override
    public void run() {
        try {
            Process p = Runtime.getRuntime().exec("ping -4 -c 10 " + servidor);
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            double soma = 0;
            int count = 0;

            while ((line = reader.readLine()) != null) {
                if (line.contains("time=")) {
                    String tempo = line.substring(line.indexOf("time=") + 5, line.indexOf(" ms"));
                    double t = Double.parseDouble(tempo);
                    soma += t;
                    count++;
                    System.out.println(nome + " - tempo: " + t + " ms");
                }
            }
            System.out.println(nome + " - Média: " + (soma / count) + " ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class Exercicio5 {
    public static void main(String[] args) {
        new PingThread("UOL", "www.uol.com.br").start();
        new PingThread("Terra", "www.terra.com.br").start();
        new PingThread("Google", "www.google.com.br").start();
    }
}