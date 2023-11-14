package src;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    private static Random random = new Random();
    private static int targetNumber;
    public static void main(String[] args) {
        startGame();
        Player player = getPlayer();
        int maxGuesses = 15;
        startGame(player, maxGuesses);
    }


    public static void startGame() {
        targetNumber = random.nextInt(100) + 1;
    }
<<<<<<< HEAD
    public static Player getPlayer() {
        Scanner scanner = new Scanner(System.in);
        Player player = null;

        System.out.println("BEM VINDO AO GUESS THE NUMBER!");
        System.out.println("O número foi sorteado. São quinze rodadas. Tente acertá-lo.");
        System.out.println("Pressione Enter para começar ou digite qualquer outra coisa para sair.");

        String input = scanner.nextLine();

        if (input.isEmpty()) {
            System.out.println("O computador é o seu adversário. Dê enter para começar!");
            String Player = scanner.nextLine();
            player = new HumanPlayer("Player");
=======
    public static void checkGuess(Player player) {
        //obtém o palpite do jogador e verifica se está correto
        int guess = player.makeGuess();
        if (guess < targetNumber) {
            System.out.println(player.getName() + " seu palpite foi" + guess + " muito baixo!)");
        } else if (guess > targetNumber) {
            System.out.println(player.getName() + " fez a aposta" + guess + " muito alto!");
>>>>>>> main
        } else {
            System.out.println("Reiniciando o jogo...");
            startGame(); // Reinicia o jogo chamando o método startGame
            player = getPlayer(); // Chama recursivamente getPlayer para obter um novo jogador
        }

        return player;
    }
<<<<<<< HEAD

    public static int startGame(Player player, int maxAttempts) {
        Player computerPlayer = new ComputerPlayer("Computador The Boss");
        int attempts = 0;

        while (attempts < maxAttempts) {
            int bet = player.makeGuess();
            System.out.println(player.getName() + " supõe: " + bet);
            attempts++;

            if (bet == targetNumber) {
                System.out.println(player.getName() + " acertou o número correto! É " + bet + ". Fim de jogo!");
                betResume(player);
                return 0;
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
        }

        return 1;
=======
    public static void displayGameResult(Player winner) {
        // printa em terminal o FINAL de jogo e mostra qual jogador acertou o número.
        System.out.println("FIM DO JOGO!");
        System.out.println(winner.getName() + " PARABÉNS VOCÊ ACERTOU! o número ERA: " + targetNumber + ". ");
        System.out.println("Tentativas" + winner.getName() + ": " + winner.getGuesses());
>>>>>>> main
    }



    public static void betResume(Player player) {
        System.out.println(player.getName() + " fez as seguintes suposições:");
        for (int bet : player.getGuesses()) {
            System.out.print(bet + " ");
        }
        System.out.println();
    }


}
