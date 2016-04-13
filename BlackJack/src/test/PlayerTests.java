package test;

import static org.junit.Assert.*;

import main.Deck;
import main.JavaRandomWrapper;
import main.Player;

import org.junit.Test;

/**
 * 
 * @author Stephen Gentles
 *
 */

public class PlayerTests {

	@Test
	public void player_can_add_card() {
		//Arrange
		JavaRandomWrapper rnd = new JavaRandomWrapper();
		Player player = new Player("TestPlayer",1);
		Deck theDeck = new Deck(1, true);
		
		//Act
		boolean result = player.addCard(theDeck.dealNextCard(),1);
		
		//Assert
		assertTrue(result);
	}
	
	@Test
	public void player_has_valid_string_name() {
				//Arrange
				Player player = new Player("TestPlayer",1);
								
				//Act
				String result = player.getPlayerName();
				
				//Assert
				assertEquals("TestPlayer", result);
	}


}
