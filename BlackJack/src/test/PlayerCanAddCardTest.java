package test;

import static org.junit.Assert.*;

import main.Deck;
import main.Player;

import org.junit.Test;

/**
 * 
 * @author Stephen Gentles
 *
 */

public class PlayerCanAddCardTest {

	@Test
	public void PlayerCanAddCard() {
		//Arrange
		Player player = new Player("TestPlayer",1);
		Deck theDeck = new Deck(1, true);
		
		//Act
		boolean result = player.addCard(theDeck.dealNextCard(),1);
		
		//Assert
		assertTrue(result);
	}

}
