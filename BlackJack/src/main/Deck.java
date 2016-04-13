package main;
import java.util.Random;

import common.NoCardsLeftException;


/**
 * Implementation of a deck of cards
 * @author Stephen Gentles
 *
 */
public class Deck implements IDeck {
	/**
	 * The array of cards in the deck, where the top card is in the first index.
	 */
	private Card[] myCards;
	
	/**
	 * The number of cards currently in the deck
	 */
	private int numCards;
	
	/**
	 * Declaration of Random number generator custom wrapper
	 */
	private IRandomWrapper randomWrapper;
	
	/**
	 * Track the top card in the current deck
	 */
	private int topPosition;
	
	/**
	 * Constructor with a default of one deck and no shuffling
	 */
	public Deck(IRandomWrapper randomWrapper) {
		
		//call the other constructor, defining one deck without shuffling
	this(1, false);
	
	}
	
	/**
	 * Constructor that defines the number of decks, that is, how many sets of 
	 * 52 cards are in the deck and if the deck should be shuffled.
	 * @param numDeck
	 * @param shuffle
	 */
	public Deck(int numDecks, boolean shuffle){

		
		this.numCards = numDecks * 52;
		this.myCards = new Card[this.numCards];
		
		//intial card index
		int c = 0;
		this.topPosition = 0;
		
		// for each deck
		for(int d = 0; d < numDecks; d++){
			
			//for each suit
			for(int s = 0; s < 4; s++)
			{
				
				//for each number
				for (int n = 1; n <= 13; n++){
					
					//Add new card t deck
					this.myCards[c] = new Card(Suit.values()[s], n);
					c++;
				}
			}
		}
		
		//shuffle if necessary
		if (shuffle) {
			this.shuffle();
			
		}
	}
	
	/**
	 * randomly shuffle deck by swapping pairs of cards
	 */
	public void shuffle(){
		Random rnd = new Random();
		
		//temporary card variable
		Card temp;
		
		int j;
		for(int i = 0; i < this.numCards; i++){
			//get a random card j to swap it's value with
			j = rnd.nextInt(this.numCards);
			
			//swap
			temp = this.myCards[i];
			this.myCards[i] = this.myCards[j];
			this.myCards[j] = temp;
			
			
		}
	}

	public Card dealNextCard() {
		/**
		 * deal the next card from the top of the deck
		 */
		
		//get the top card
		if(this.numCards == 0){
			try {
				throw new NoCardsLeftException("No more cards left on the deck");
			} catch (NoCardsLeftException e) {
				e.printStackTrace();
			}
		}
		Card top = this.myCards[0];
		
		//shift all the remaining card to the left by one index
		for(int c = 1; c < this.numCards; c++) {
			this.myCards[c-1] = this.myCards[c];
			
		}
		
		this.topPosition++;
		
		this.myCards[this.numCards-1] = null;
		
		//decrement the number of cards int he deck
		this.numCards--;
		
		return top;
				
	}
	
	/**
	 * print the top cards in the deck
	 * @param numToPrint  the number of cards from the top of the deck to print
	 */
	public void printDeck(int numToPrint){
		for(int c = 0; c < numToPrint; c++){
			System.out.printf("% 3d/%d %s\n", c+1, this.numCards, this.myCards[c].toString());
			
		}
		
		System.out.printf("\t[%d others]\n", this.numCards-numToPrint);
	}
}
