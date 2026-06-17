import java.util.Scanner;

public class JogoTesouro {
    private String[] mapa = new String[3];
    private int pontuacao = 0;
    private int tentativasRestantes = 8;
    private int tesourosEncontrados = 0;
    private int armadilhasEncontradas = 0;
    private int vaziosExplorados = 0;

    public JogoTesouro() {
        Scanner teste = new Scanner(System.in);
<<<<<<< HEAD
        String armadilhas[] = new String[3];
        String tesouros[] = new String[3];
        String mapa[] = new String[15];
        int tentativas = 8;
        int posicao = 0;
        int pontuacao = 0;
=======
>>>>>>> 9c28cb8d59cf53cadf24a31d448bf0eccee52ad4
        int opcao;
        
        popularIlhaRandomico();
        exibirBoasVindas();
        mapa[0] = "OURO";
        mapa[1] = "DIAMANTE";
        mapa[2] = "RUBI";
        mapa[3] = "BURACO";
        mapa[4] = "COBRA";
        mapa[5] = "ESPINHOS";

        for (int i = 6; i < mapa.length; i++) {
            mapa[i] = "VAZIO";
        }
        do {
<<<<<<< HEAD

            System.out.println("===== ILHA DOS TESOUROS =====\r\n" + //
                    "1 - Mostrar instruções\r\n" + //
                    "2 - Mostrar mapa\r\n" + //
                    "3 - Jogar\r\n" + //
                    "4 - Mostrar status\r\n" + //
                    "5 - Sair\r\n" + //
                    "Escolha uma opção:");
=======
            System.out.println("\n===== ILHA DOS TESOUROS =====");
            System.out.println("1 - Mostrar instruções");
            System.out.println("2 - Mostrar mapa");
            System.out.println("3 - Jogar");
            System.out.println("4 - Mostrar status");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
>>>>>>> 9c28cb8d59cf53cadf24a31d448bf0eccee52ad4
            opcao = teste.nextInt();

            switch (opcao) {
                case 1:
                    exibirInstrucoes();
                    break;

                case 2:
<<<<<<< HEAD
                    mapa(mapa);
                    break;

                case 3:
                    for (int i = 0; i < tentativas; i++) {
                        pontuacao = jogo(posicao, teste, mapa, pontuacao);
                        System.out.println(pontuacao);
                    }
                    break;
=======
                    mostrarMapa();
                    break;

                case 3:
                    jogarRodada(teste);
                    break;

                case 4:
                    mostrarStatus();
                    break;

                case 5:
                    System.out.println("Saindo do jogo... Até logo!");
                    break;

>>>>>>> 9c28cb8d59cf53cadf24a31d448bf0eccee52ad4
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
<<<<<<< HEAD
        } while (opcao != 5);
    }

    private void mapa(String[] mapa) {

        for (int i = 0; i < mapa.length; i++) {
            mapa[i] = "?";
            System.out.println("[" + i + "]" + mapa[i]);
        }
    }

    private int jogo(int posicao, Scanner teste, String mapa[], int pontuacao) {

        System.out.println("Informe uma posição: ");
        posicao = teste.nextInt();
        System.out.println("Você encontrou: " + mapa[posicao]);

        if (posicao >= 0 && posicao <= 14) {
            if (mapa[posicao].equals("OURO")) {
                pontuacao += 10;
            } else if (mapa[posicao].equals("DIAMANTE")) {
                pontuacao += 20;
            } else if (mapa[posicao].equals("RUBI")) {
                pontuacao += 15;
            } else if (mapa[posicao].equals("BURACO")) {
                pontuacao -= 5;
            } else if (mapa[posicao].equals("COBRA")) {
                pontuacao -= 10;
            } else if (mapa[posicao].equals("ESPINHOS")) {
                pontuacao -= 7;
            } else {
                pontuacao += 0;
            }

        }
        return pontuacao;
=======
            
            if (tentativasRestantes <= 0) {
                System.out.println("\n=== FIM DE JOGO! Suas tentativas acabaram. ===");
                mostrarStatus();
                break;
            }

        } while (opcao != 5);
        
        teste.close();
>>>>>>> 9c28cb8d59cf53cadf24a31d448bf0eccee52ad4
    }

    private void exibirInstrucoes() {
        System.out.println("\n=== INSTRUÇÕES DO JOGO ===");
        System.out.println("- Escolha uma posição de 0 a 14 para explorar na ilha.");
        System.out.println("- Tesouros disponíveis: OURO (+10), DIAMANTE (+20), RUBI (+15).");
        System.out.println("- Armadilhas perigosas: BURACO (-5), COBRA (-10), ESPINHOS (-7).");
        System.out.println("- Posições do tipo VAZIO não alteram sua pontuação.");
        System.out.println("- Você tem um limite máximo de 8 jogadas.");
        System.out.println("- O jogo acaba se as tentativas zerarem ou se você escolher sair.");
    }

    private void popularIlhaRandomico() {
        String[] opcoes = { "OURO", "DIAMANTE", "RUBI", "BURACO", "COBRA", "ESPINHOS", "VAZIO" };
        for (int i = 0; i < mapa.length; i++) {
            int indiceSorteado = (int) (Math.random() * opcoes.length);
            mapa[i] = opcoes[indiceSorteado];
        }
    }

    private void mostrarMapa() {
        System.out.println("\n=== MAPA DA ILHA ===");
        for (int i = 0; i < mapa.length; i++) {

            System.out.println("[" + i + "] ?");
        }
    }

    private void jogarRodada(Scanner teste) {
        System.out.print("\nInforme uma posição para explorar (0 a 14): ");
        int posicao = teste.nextInt();

        if (posicao >= 0 && posicao < mapa.length) {
            String itemEncontrado = mapa[posicao];
            
            calcularEAtualizarPontuacao(itemEncontrado);
            
            tentativasRestantes--;
            System.out.println("Tentativas restantes: " + tentativasRestantes);
        } else {
            System.out.println("Posição inválida! Escolha um número entre 0 e 14.");
        }
    }

    private void calcularEAtualizarPontuacao(String item) {
        if (item.equals("OURO")) {
            System.out.println("Você encontrou OURO! +10 pontos.");
            pontuacao += 10;
            tesourosEncontrados++;
        } else if (item.equals("DIAMANTE")) {
            System.out.println("Você encontrou DIAMANTE! +20 pontos.");
            pontuacao += 20;
            tesourosEncontrados++;
        } else if (item.equals("RUBI")) {
            System.out.println("Você encontrou RUBI! +15 pontos.");
            pontuacao += 15;
            tesourosEncontrados++;
        } else if (item.equals("BURACO")) {
            System.out.println("Você caiu em uma armadilha: BURACO! -5 pontos.");
            pontuacao -= 5;
            armadilhasEncontradas++;
        } else if (item.equals("COBRA")) {
            System.out.println("Você caiu em uma armadilha: COBRA! -10 pontos.");
            pontuacao -= 10;
            armadilhasEncontradas++;
        } else if (item.equals("ESPINHOS")) {
            System.out.println("Você caiu em uma armadilha: ESPINHOS! -7 pontos.");
            pontuacao -= 7;
            armadilhasEncontradas++;
        } else if (item.equals("VAZIO")) {
            System.out.println("Você explorou uma posição VAZIA. 0 pontos.");
            vaziosExplorados++;
        }
    }

    private void mostrarStatus() {
        System.out.println("\n=== STATUS ATUAL ===");
        System.out.println("Pontuação Total: " + pontuacao);
        System.out.println("Tentativas Restantes: " + tentativasRestantes);
        System.out.println("Tesouros Encontrados: " + tesourosEncontrados);
        System.out.println("Armadilhas Encontradas: " + armadilhasEncontradas);
        System.out.println("Posições Vazias Exploradas: " + vaziosExplorados);
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