package src;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    private static Random random = new Random();
    private static int targetNumber;

    public static void main(String[] args) {
        startGame();
        Player player = getPlayer();
        int maxGuesses = 10;
        startGame(player, maxGuesses);
    }


    public static void startGame() {
        targetNumber = random.nextInt(100) + 1;
    }

    public static Player getPlayer() {
        Scanner scanner = new Scanner(System.in);
        Player player = null;

        System.out.println("BEM VINDO AO GUESS THE NUMBER!");
        System.out.println("O número foi sorteado. São dez rodadas. Tente acertá-lo.");
        System.out.println("Dígite 1 se entendeu.");

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.print("Digite o seu nome: ");
            String name = scanner.nextLine();
            player = new HumanPlayer(name); }
//        } else (choice == ) {
//            System.out.println("O computador é seu adversário.");
//            player = new ComputerPlayer("Computador The Boss");
//        }

        return player;
    }

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
    }



    public static void betResume(Player player) {
        System.out.println(player.getName() + " fez as seguintes suposições:");
        for (int bet : player.getGuesses()) {
            System.out.print(bet + " ");
        }
        System.out.println();
    }


}
