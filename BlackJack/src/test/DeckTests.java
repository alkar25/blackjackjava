package test;

import static org.junit.Assert.*;

import main.Card;
import main.Deck;
import main.IRandomWrapper;
import main.Player;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import common.NoCardsLeftException;

/**
 * 
 * @author Stephen Gentles
 *
 */
public class DeckTests {

	private static final IRandomWrapper IRandomWrapper = null;

	@Test
	 public void dealNextCard_returns_correct_card_on_one_deck_after_shuffle(){
	   	/*
		// Arrange sut - system under test
	    Deck sut = new Deck(new StubbedRandomWrapper());
	    
	    // Act
	    sut.shuffle();
	    Card card1  = sut.dealNextCard();
	    Card card2 = sut.dealNextCard();
	    
	    // Assert
	    // We know based on StubbedRandomWrapper that the random wrapper will try to move swap cards infront with card behind while moving up the stack
	    assertEquals(card1.getNumber(), 2);
	    assertEquals(card2.getNumber(), 3); */
	  }
	  
	@Rule
	  public final ExpectedException exception = ExpectedException.none();
	
	@Test
	  public void dealNextCard_throws_exception_when_out_of_cards(){
	    // Arrange sut - system under test
		//int nextInt = randomWrapper.nextInt(0);
		Player dealer = new Player("Dealer", 11);
		Deck sut = new Deck(1,true);
			        
	    exception.expect(NoCardsLeftException.class);
	    // Act
	    dealer.addCard(sut.dealNextCard(), 11);
	    // Assert automatically done 
	
	  }

}
