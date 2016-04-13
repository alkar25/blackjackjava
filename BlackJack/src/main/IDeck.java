package main;


/**
 * 
 * @author Stephen Gentles
 *
 */

public interface IDeck {
	public void shuffle();
	public Card dealNextCard();
	public void printDeck(int numToPrint);
}
