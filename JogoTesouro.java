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
        int opcao;
        
        popularIlhaRandomico();
        exibirBoasVindas();

        do {
            System.out.println("\n===== ILHA DOS TESOUROS =====");
            System.out.println("1 - Mostrar instruções");
            System.out.println("2 - Mostrar mapa");
            System.out.println("3 - Jogar");
            System.out.println("4 - Mostrar status");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = teste.nextInt();

            switch (opcao) {
                case 1:
                    exibirInstrucoes();
                    break;

                case 2:
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

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
            
            if (tentativasRestantes <= 0) {
                System.out.println("\n=== FIM DE JOGO! Suas tentativas acabaram. ===");
                mostrarStatus();
                break;
            }

        } while (opcao != 5);
        
        teste.close();
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