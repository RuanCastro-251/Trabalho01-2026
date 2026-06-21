import java.util.Scanner;

public class JogoTesouro {

    private int pontuacao = 0;
    private int tentativasRestantes = 8;
    private int tesourosEncontrados = 0;
    private int armadilhasEncontradas = 0;
    private int vaziosExplorados = 0;
    private int totalTesouros = 0;

    public JogoTesouro() {
        Scanner teste = new Scanner(System.in);

        String mapa[] = new String[15];
        String[] opcoes = { "OURO", "DIAMANTE", "RUBI", "BURACO", "COBRA", "ESPINHOS", "VAZIO" };
        String[] mapaInterrogacao = new String[15];
        for (int i = 0; i < mapa.length; i++) {
            mapaInterrogacao[i] = "?";
        }

        int opcao;

        popularIlhaRandomico(opcoes, mapa);
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

                    mostrarMapa(mapaInterrogacao);
                    break;

                case 3:
                    jogarRodada(teste, mapa, mapaInterrogacao);

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

            if (tentativasRestantes <= 0 || todosTesourosEncontrados(totalTesouros)) {
                if (tentativasRestantes <= 0) {
                    System.out.println("\n=== FIM DE JOGO! Suas tentativas acabaram! ===");
                }
                if (todosTesourosEncontrados(totalTesouros)) {
                    System.out.println("\n=== FIM DE JOGO! Todos os tesouros foram encontrados! ===");

                }
                mostrarStatus();

                System.out.print("Deseja jogar novamente? (S/N): ");
                String resposta = teste.next();

                if (resposta.equalsIgnoreCase("S")) {

                    reiniciarPartida(opcoes, mapa, mapaInterrogacao);

                } else {

                    System.out.println("Jogo encerrado.");
                    break;
                }
            }

        } while (opcao != 5);

        iniciar();
    }

    public void iniciar() {
        System.out.println("Iniciou o Jogo!");
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

    private String[] popularIlhaRandomico(String[] opcoes, String[] mapa) {

        totalTesouros = 0;

        for (int i = 0; i < mapa.length; i++) {

            int indiceSorteado = (int) (Math.random() * opcoes.length);

            mapa[i] = opcoes[indiceSorteado];

            if (mapa[i].equals("OURO") ||
                    mapa[i].equals("DIAMANTE") ||
                    mapa[i].equals("RUBI")) {

                totalTesouros++;
            }
        }

        return mapa;
    }

    private boolean todosTesourosEncontrados(int totalTesouros) {
        return tesourosEncontrados == totalTesouros;
    }

    private void mostrarMapa(String[] mapaInterrogacao) {

        System.out.println("\n=== MAPA DA ILHA ===");

        for (int i = 0; i < mapaInterrogacao.length; i++) {
            System.out.println("[" + i + "] " + mapaInterrogacao[i]);
        }
    }

    private void jogarRodada(Scanner teste, String[] mapa, String[] mapaInterrogacao) {

        System.out.print("\nInforme uma posição para explorar (0 a 14): ");
        int posicao = teste.nextInt();

        if (posicao < 0 || posicao >= mapa.length) {
            System.out.println("Posição inválida!");
            return;
        }

        if (!mapaInterrogacao[posicao].equals("?")) {
            System.out.println("Essa posição já foi explorada!");
            return;
        }

        String itemEncontrado = mapa[posicao];

        calcularEAtualizarPontuacao(itemEncontrado);

        mapaInterrogacao[posicao] = itemEncontrado;

        tentativasRestantes--;

        System.out.println("Tentativas restantes: " + tentativasRestantes);
    }

    private String calcularEAtualizarPontuacao(String item) {
        switch (item) {
            case "OURO":
                System.out.println("Você encontrou OURO! +10 pontos.");
                pontuacao += 10;
                tesourosEncontrados++;
                return "OURO";
            case "DIAMANTE":
                System.out.println("Você encontrou DIAMANTE! +20 pontos.");
                pontuacao += 20;
                tesourosEncontrados++;
                return "DIAMANTE";
            case "RUBI":
                System.out.println("Você encontrou RUBI! +15 pontos.");
                pontuacao += 15;
                tesourosEncontrados++;
                return "RUBI";
            case "BURACO":
                System.out.println("Você caiu em uma armadilha: BURACO! -5 pontos.");
                pontuacao -= 5;
                armadilhasEncontradas++;
                return "BURACO";
            case "COBRA":
                System.out.println("Você caiu em uma armadilha: COBRA! -10 pontos.");
                pontuacao -= 10;
                armadilhasEncontradas++;
                return "COBRA";
            case "ESPINHOS":
                System.out.println("Você caiu em uma armadilha: ESPINHOS! -7 pontos.");
                pontuacao -= 7;
                armadilhasEncontradas++;
                return "ESPINHOS";
            case "VAZIO":
                System.out.println("Você explorou uma posição VAZIA. 0 pontos.");
                vaziosExplorados++;
                return "VAZIO";
            default:
                return "?";
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

    private void reiniciarPartida(String[] opcoes, String[] mapa, String[] mapaInterrogacao) {
        pontuacao = 0;
        tentativasRestantes = 8;
        tesourosEncontrados = 0;
        armadilhasEncontradas = 0;
        vaziosExplorados = 0;

        popularIlhaRandomico(opcoes, mapa);

        for (int i = 0; i < mapa.length; i++) {
            mapaInterrogacao[i] = "?";
        }
        System.out.println("\n=== NOVA PARTIDA INICIADA ===");

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