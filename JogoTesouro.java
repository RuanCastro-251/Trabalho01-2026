import java.util.Scanner;

public class JogoTesouro {

    public JogoTesouro() {
        Scanner teste = new Scanner(System.in);
        String armadilhas[] = new String[3];
        String tesouros[] = new String[3];
        int opcao;

        do {
            System.out.println("===== ILHA DOS TESOUROS =====\r\n" + //
                    "1 - Mostrar instruções\r\n" + //
                    "2 - Mostrar mapa\r\n" + //
                    "3 - Jogar\r\n" + //
                    "4 - Mostrar status\r\n" + //
                    "5 - Sair\r\n" + //
                    "Escolha uma opção:");
            opcao = teste.nextInt();
            System.out.println("Sai");

        } while (opcao != 4);
    }

    private static String sortear() {
        String tipos[] = { "OURO", "DIAMANTE", "RUBI", "BURACO", "COBRA", "ESPINHOS", "VAZIO" };

        int posicao = (int) (Math.random() * 7);

        return tipos[posicao];
    }

    static void exibirBoasVindas() {
        System.out.println("Bem-vindo ao jogo Ilha dos Tesouros!\n");
        System.out.println("A ilha possui 15 posições, numeradas de 0 a 14.");
        System.out.println("Você possui 8 tentativas para encontrar os tesouros.");

    }

    public static void main(String[] args) {
        new JogoTesouro();
    }

}
