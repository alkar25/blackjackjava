package test;

import static org.junit.Assert.*;

import main.Deck;
import main.Player;

import org.junit.Test;

public class PlayerHasNameTest {

	@Test
	public void PlayerHasName() {
				//Arrange
				Player player = new Player("TestPlayer",1);
								
				//Act
				String result = player.getPlayerName();
				
				//Assert
				assertEquals("TestPlayer", result);
	}

}
