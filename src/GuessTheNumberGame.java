import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    private static Random random = new Random();
    private static int targetNumber;

    public static void main(String[] args) {
        Player player = getPlayer();
        int maxGuesses = 15;
        checkGuess(player, maxGuesses);
    }

    public static void startGame() {
        targetNumber = random.nextInt(100) + 1;
    }

    public static Player getPlayer() {
        Scanner scanner = new Scanner(System.in);
        Player player = null;

        System.out.println("BEM VINDO AO GUESS THE NUMBER!");
        System.out.println("O número foi sorteado. São quinze rodadas. Tente acertá-lo.");
        System.out.println("O Computador é o seu adversário.");
        System.out.println("Pressione Enter para começar ou digite qualquer outra coisa para sair.");

        String input = scanner.nextLine();

        if (input.isEmpty()) {
            player = new HumanPlayer("Jogador");
        } else {
            System.out.println("Reiniciando o jogo...");
            startGame(); // Reinicia o jogo chamando o método startGame
            player = getPlayer(); // Chama recursivamente getPlayer para obter um novo jogador
        }
        return player;
    }

    public static void checkGuess(Player player, int maxAttempts) {
        Player computerPlayer = new ComputerPlayer("Computador The Boss");
        int attempts = 0;

        while (attempts < maxAttempts) {
            int bet = player.makeGuess();
            System.out.println(player.getName() + " seu palpite foi: " + bet);
            attempts++;

            if (bet == targetNumber) {
                System.out.println("UHUU VOCÊ CONSEGUIU " + player.getName() + "! " + "O número correto é: " + bet);
                displayGameResult(player);
                return;
            } else if (bet < targetNumber) {
                System.out.println("Muito baixo!");
            } else {
                System.out.println("Muito alto!");
            }

            // Alternar entre o player e o computador
            Player temp = player;
            player = computerPlayer;
            computerPlayer = temp;
        }

        if (attempts >= maxAttempts) {
            System.out.println("Fim de jogo! O número de tentativas máximo foi alcançado.");
            displayGameResult(computerPlayer);
        }
    }

    public static void displayGameResult(Player winner) {
        System.out.println("RESUMO DA PARTIDA!");
        System.out.println(winner.getName() + " Aqui vai o resumo da partida.");
        System.out.println("Tentativas de " + winner.getName() + ": " + winner.getGuesses().size());
        betResume(winner);
    }

    public static void betResume(Player player) {
        System.out.println(player.getName() + " seus palpites foram:");
        for (int bet : player.getGuesses()) {
            System.out.print(bet + "!");
        }
    }
}
