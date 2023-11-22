import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    private final boolean guessed;
    protected String name;
    protected List<Integer> guesses;

    public Player(String name) {
        this.name = name;
        this.guesses = new ArrayList<>();
        this.guessed = false;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getGuesses() {
        return guesses;
    }

    public abstract int makeGuess();

    public void setGuesses(int targetNumber) {
    }
}
