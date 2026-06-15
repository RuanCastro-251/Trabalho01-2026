
/* Trabalho Final - Jogo da Ilha dos Tesouros 
 * Enunciado:
 * Desenvolver um jogo em Java, executado via Console, utilizando os conteúdos estudados na disciplina de Introdução à Programação.
 *
 *
*/

public class TrabalhoFinal {
    public static void main(String[] args) {

        

        System.out.println("Bem-vindo ao Jogo da Ilha dos Tesouros!");
        System.out.println("Você está em uma ilha misteriosa e precisa encontrar o tesouro escondido.");

        // OP3
        System.out.println("");

        switch (opcao) {
            case 1:
                System.out.println("1 - Mostrar instruções");

                // OP1
                System.out.println("Instruções do  Jogo:");
                System.out.println(
                        "1. Cada posição do jogador é representada por um vetor, onde, em cada posição, pode conter um tesouro, uma armadilha ou estar vazia.");
                System.out.println("2. Os tipos de tesouros existentes são: Ouro, Diamante e Rubi.");
                System.out.println("3. O jogador pode cair nas seguintes armadilhas: Buraco, Cobra e Espinhos.");
                System.out.println(
                        "4. O objetivo do jogador é explorar posições da ilha, encontrar tesouros, evitar armadilhas e fazer a maior pontuação possível antes que as tentativas acabem.");

                break;
            case 2:
                System.out.println("2 - Mostrar mapa");

                break;
            case 3:
                System.out.println("Vamos começar a aventura! Boa sorte!");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }

    }
}
public static String palavra;