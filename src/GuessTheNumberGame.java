package src;
import java.util.Random; //classe da biblioteca Java

public class GuessTheNumberGame {
    private static Random random = new Random();
    private static int targetNumber;
    public static void main(String[] args) {
        //gera número aleatório de 1 a 100
        targetNumber = random.nextInt(100) + 1;
        // cria jogadores, humano(você) e computador
        Player humanPlayer = new HumanPlayer("Você");
        Player computerPlayer = new ComputerPlayer("Sr. Computador");

        Player currentPlayer = humanPlayer;
        //loop principal do jogo
        while (true) {
            checkGuess(currentPlayer);
            if (currentPlayer.hasGuessed()) {
                displayGameResult(currentPlayer);
                break;
            }
            //alterna entre os jogadores
            currentPlayer = (currentPlayer instanceof HumanPlayer) ? computerPlayer : humanPlayer;
        }
    }
    public static void checkGuess(Player player) {
        //obtém o palpite do jogador e verifica se está correto
        int guess = player.makeGuess();
        if (guess < targetNumber) {
            System.out.println(player.getName() + " seu palpite foi" + guess + " muito baixo!)");
        } else if (guess > targetNumber) {
            System.out.println(player.getName() + " fez a aposta" + guess + " muito alto!");
        } else {
            player.setGuessed(true);
        }
    }
    public static void displayGameResult(Player winner) {
        // printa em terminal o FINAL de jogo e mostra qual jogador acertou o número.
        System.out.println("FIM DO JOGO!");
        System.out.println(winner.getName() + " PARABÉNS VOCÊ ACERTOU! o número ERA: " + targetNumber + ". ");
        System.out.println("Tentativas" + winner.getName() + ": " + winner.getGuesses());
    }
}
