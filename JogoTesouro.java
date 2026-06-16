import java.util.Scanner;

public class JogoTesouro {

    public JogoTesouro() {
        Scanner teste = new Scanner(System.in);
        String armadilhas[] = new String[3];
        String tesouros[] = new String[3];
<<<<<<< HEAD
        String mapa[] = new String[15];
        int tentativas = 8;
        int posicao = 0;
        int pontuação = 0;
=======

        int pontuacao = 0;

        String mapa[] = new String[10];

>>>>>>> 21e8d9c1e6103fd98c696d89fd53883507c21aa4
        int opcao;
        exibirBoasVindas();

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
                    System.out.println("\n=== INSTRUÇÕES DO JOGO ===");
                    System.out.println("- Escolha uma posição de 0 a 14 para explorar na ilha.");
                    System.out.println("- Tesouros disponíveis: OURO (+10), DIAMANTE (+20), RUBI (+15).");
                    System.out.println("- Armadilhas perigosas: BURACO (-5), COBRA (-10), ESPINHOS (-7).");
                    System.out.println("- Posições do tipo VAZIO não alteram sua pontuação.");
                    System.out.println("- Você tem um limite máximo de 8 jogadas.");
                    System.out.println(
                            "- O jogo acaba se as tentativas zerarem ou se todos os tesouros escondidos forem descobertos.");

                    break;

                case 2:
                    mapa(mapa);

                case 3:
                    jogo(posicao, teste, mapa, pontuação);
                    System.out.println(pontuação);
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
<<<<<<< HEAD
    }
=======
    }

    private int jogo(int posicao, Scanner teste, String mapa[], int pontuação) {
        mapa[0] = "OURO";
        mapa[1] = "DIAMANTE";
        mapa[2] = "RUBI";
        mapa[3] = "BURACO";
        mapa[4] = "COBRA";
        mapa[5] = "ESPINHOS";

        for (int i = 6; i < mapa.length; i++) {
            mapa[i] = "VAZIO";
        }
        System.out.println("Informe uma posição: ");
        posicao = teste.nextInt();
        if (posicao >= 0 && posicao <= 14) {
            if (mapa[posicao].equals("OURO")) {
                pontuação += 10;
            } else if (mapa[posicao].equals("DIAMANTE")) {
                pontuação += 20;
            } else if (mapa[posicao].equals("RUBI")) {
                pontuação += 15;
            } else if (mapa[posicao].equals("BURACO")) {
                pontuação -= 5;
            } else if (mapa[posicao].equals("COBRA")) {
                pontuação -= 10;
            } else if (mapa[posicao].equals("ESPINHOS")) {
                pontuação -= 7;
            } else {
                pontuação += 0;
            }

        }
        return pontuação;
    }

    private static String sortear() {
        String tipos[] = { "OURO", "DIAMANTE", "RUBI", "BURACO", "COBRA", "ESPINHOS", "VAZIO" };

        int posicao = (int) (Math.random() * 7);

        return tipos[posicao];
    }

    static void exibirBoasVindas() {
        System.out.println("Seja Bem-vindo ao jogo Ilha dos Tesouros!\n");
        System.out.println("A ilha possui 15 posições, que são numeradas de 0 a 14.");
        System.out.println("Você possui 8 tentativas apara encontrar os tesouros.");

    }

    public static void main(String[] args) {
        new JogoTesouro();
    }

>>>>>>> origin/main
}
