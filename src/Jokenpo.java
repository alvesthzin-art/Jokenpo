import java.util.Scanner;
import java.util.Random;

public class Jokenpo {

    private Scanner input;
    private Random random;

    public Jokenpo() {
        input = new Scanner(System.in);
        random = new Random();
    }


    public void jogarRodada() {
        boolean continuar = true;

        System.out.println("=== JOKENPÔ ===");

        while (continuar) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Pedra");
            System.out.println("2 - Papel");
            System.out.println("3 - Tesoura");
            System.out.print("Sua escolha: ");

            int escolhaJogador = input.nextInt();

            if (escolhaJogador < 1 || escolhaJogador > 3) {
                System.out.println("Escolha inválida! Use apenas 1, 2 ou 3.");
                continue;
            }

            int escolhaComputador = random.nextInt(3) + 1;

            String opcaoJogador = opcaoParaTexto(escolhaJogador);
            String opcaoComputador = opcaoParaTexto(escolhaComputador);

            System.out.println("\n--- RESULTADO DA RODADA ---");
            System.out.println("Você escolheu: " + opcaoJogador);
            System.out.println("Computador escolheu: " + opcaoComputador);

            String resultado = verificarResultado(escolhaJogador, escolhaComputador);
            System.out.println("Resultado: Você " + resultado + "!");

            System.out.print("\nDeseja jogar novamente? (s/n): ");
            char resposta = input.next().toLowerCase().charAt(0);

            if (resposta != 's') {
                continuar = false;
                System.out.println("\nObrigado por jogar!");
            }
        }
    }

    public static String opcaoParaTexto(int opcao) {
        switch (opcao) {
            case 1: return "Pedra";
            case 2: return "Papel";
            case 3: return "Tesoura";
            default: return "Desconhecido";
        }
    }

    public static String verificarResultado(int jogador, int computador) {
        if (jogador == computador) {
            return "Empatou";
        } else if ((jogador == 1 && computador == 3) ||
                (jogador == 2 && computador == 1) ||
                (jogador == 3 && computador == 2)) {
            return "Venceu";
        } else {
            return "Perdeu";
        }
    }
}
