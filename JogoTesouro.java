import java.util.ArrayList;
import java.util.Scanner;

public class JogoTesouro {

    public JogoTesouro() {
        Scanner teste = new Scanner(System.in);
        String armadilhas[] = new String[3];
        String tesouros[] = new String[3];
        String mapa[] = new String[10];

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

            switch (opcao) {
                case 1:
                    System.out.println("Instruções do  Jogo:");
                    System.out.println(
                            "1- Cada posição do jogador é representada por um vetor, onde, em cada posição, pode conter um tesouro, uma armadilha ou estar vazia.\n");
                    System.out.println("2- Os tipos de tesouros existentes são: Ouro, Diamante e Rubi.\n");
                    System.out.println("3- O jogador pode cair nas seguintes armadilhas: Buraco, Cobra e Espinhos.\n");
                    System.out.println(
                            "4- O objetivo do jogador é explorar posições da ilha, encontrar tesouros, evitar armadilhas e fazer a maior pontuação possível antes que as tentativas acabem.\n");

                    break;

                case 2:
                    mapa(mapa);

                default:
                    break;
            }
        } while (opcao != 5);
    }

    private void mapa(String[] mapa) {
        for (int i = 0; i < mapa.length; i++) {
            mapa[i] = "?";
            System.out.println("[" + i + "]" + mapa[i]);
        }
        // if();
    }

    private static String sortear() {
        String tipos[] = { "OURO", "DIAMANTE", "RUBI", "BURACO", "COBRA", "ESPINHOS", "VAZIO" };

        int posicao = (int) (Math.random() * 7);

        return tipos[posicao];
    }

    static void exibirBoasVindas() {
        System.out.println("Seja Bem-vindo ao jogo Ilha dos Tesouros!\n");
        System.out.println("A ilha possui 15 posições, que são numeradas de 0 a 14.");
        System.out.println("Você possui 8 tentativas para encontrar os tesouros.");

    }

    public static void main(String[] args) {
        new JogoTesouro();
    }

}
