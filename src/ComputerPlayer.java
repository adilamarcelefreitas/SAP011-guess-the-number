package src;

import java.util.Random;

public class ComputerPlayer extends Player {
    public ComputerPlayer(String name) {
        super(name);
    }

    @Override
    public int makeGuess() {
        Random random = new Random();
        int bet = random.nextInt(100) + 1;
        getGuesses().add(bet);
        return bet;
    }
}