import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.;
import org.junit.Test;
public class MorpionTest {

	@Test
	public void remainingGames() {
		Morpion game = new Morpion(3x3, player1X, player2O);
		game.play(player1, 0x0);
		game.play(player2, 0x1);
		assertThat(game.report(), equalTo(4 games for player1, 3 games for player2) );
	}

	@Test(expected = BoxAlreadySelectedException.class)
	public void boxAlreadySelected() {
		Morpion game = new Morpion(3x3, player1X, player2O);
		game.play(player1, 0x0);
		game.play(player2, 0x1);
		game.play(player1, 0x1);
	}

	@Test
	public void winner() {
		Morpion game = new Morpion(3x3, player1X, player2O);
		game.play(player1, 0x0);
		game.play(player2, 0x1);
		game.play(player1, 1x1);
		game.play(player2, 0x2);
		game.play(player1, 2x2);
		assertThat(game.report(),equalTo(Game Over, player1 is a winner));
	}

	@Test
	public void displayEqualityGame() {
		Morpion game = new Morpion(3x3, player1X, player2O);
		game.play(player1, 0x0);
		game.play(player2, 1x1);
		game.play(player1, 0x1);
		game.play(player2, 0x2);
		game.play(player1, 2x0);
		game.play(player2, 1x0);
		game.play(player1, 1x2);
		game.play(player2, 2x1);
		game.play(player1, 2x2);
		assertThat(game.report(),equalTo(Game Over, equality));
		String expectedDisplay = new StringBuilder().append(XXO)
				.append(Morpion.LINE_SEPARATOR).append(OOX)
				.append(Morpion.LINE_SEPARATOR).append(XOX)
				.append(Morpion.LINE_SEPARATOR).toString();
		assertThat(game.display(),equalTo(expectedDisplay.toString()));
	}
}