import java.util.ArrayList;
import java.util.Scanner;

public class JogoTesouro {

    public JogoTesouro() {
        Scanner teste = new Scanner(System.in);
        String armadilhas[] = new String[3];
        String tesouros[] = new String[3];

        int pontuacao = 0;

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
    }
}
