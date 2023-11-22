import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GuessTheNumberGameTest {

    @Test
    public void testGuessHigherNumber() {
        GuessTheNumberGame.startGame();
        Player player = mock(HumanPlayer.class);
        when(player.makeGuess()).thenReturn(GuessTheNumberGame.targetNumber + 1);

        GuessTheNumberGame.checkGuess(player, 15);
    }

    @Test
    public void testGuessLowerNumber() {
        GuessTheNumberGame.startGame();
        Player player = mock(HumanPlayer.class);
        when(player.makeGuess()).thenReturn(GuessTheNumberGame.targetNumber - 1);

        GuessTheNumberGame.checkGuess(player, 15);
    }

    @Test
    public void testMatchWinner() {
        GuessTheNumberGame.startGame();
        Player player = mock(HumanPlayer.class);
        when(player.makeGuess()).thenReturn(GuessTheNumberGame.targetNumber);

        GuessTheNumberGame.checkGuess(player, 15);
    }
}
