package common;

import main.Card;

public interface IDeck {
	public void shuffle();
	public Card dealNextCard();
	public void printDeck(int numToPrint);
}
