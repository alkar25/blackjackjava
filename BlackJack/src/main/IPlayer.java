package main;


/**
 * 
 * @author Stephen Gentles
 *
 */

public interface IPlayer {
	public void emptyHand();
	public int getHandSum(int aceValue);
	public String getPlayerName();
	public void printHand(boolean showFirstCard);
	public boolean addCard(Card aCard, int aceValPref);
}
