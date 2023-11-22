import java.util.Random;

public class ComputerPlayer extends Player {
    private static Random random = new Random();

    public ComputerPlayer(String name) {
        super(name);
    }

    @Override
    public int makeGuess() {
        int bet = random.nextInt(100) + 1;
        getGuesses().add(bet);
        return bet;
    }
}
