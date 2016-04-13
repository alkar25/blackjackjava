package main;


/**
 * an implementation of a blackjack player.
 * @author Stephen Gentles
 *
 */
public class Player implements IPlayer{
	
	/**
	 * The player's name
	 */
	private String name;
	
	/**
	 * Set Players Ace Value Preference
	 */
	private int playerAceValuePref;
	
	/**
	 * The cards in the player's current hand
	 * 
	 */
	private Card[] hand = new Card[10];
	
	/**
	 * The number of cards in the player's current hand
	 */
	private int numCards;
	
	
	/**
	 * Player constructor
	 * @param aName
	 */
	public Player(String aName, int aceValuePref){
		this.name = aName;
		this.playerAceValuePref = aceValuePref;
		
		//set a player's hand to empty
		this.emptyHand();
	}
	
	/**
	 * Empties the player's hand
	 */
	public void emptyHand(){
		for(int c = 0; c < 10; c++)
		{
			this.hand[c] = null;
		}
		this.numCards = 0;
	} 

	/**
	 *  Add a card to player's hand
	 * @param aCard the card to add
	 * @return whether the sum of the new hand is below or equal to 21
	 */
	public boolean addCard(Card aCard, int aceValPref){
		// print error if we already have maxed out the number of cards
		if(this.numCards == 10) {
			System.err.printf("%s's hand already has 10 cards; " + 
					"cannot add another\n",  this.name);
			System.exit(1);
		}
		
		this.hand[this.numCards] = aCard;
		this.numCards++;
		
		return (this.getHandSum(aceValPref) <= 21);
		
	}
	
	/**
	 * Get the sum of the cards in the player's hand
	 * @return the sum
	 */
	public int getHandSum(int aceValue){
		int handSum = 0;
		int cardNum;
		int numAces = 0;
		
		//calculate each card's contribution to the hand sum
		for(int c = 0; c < this.numCards; c++){
			
			//get the number for the current hand
			cardNum = this.hand[c].getNumber();
			
			if (cardNum == 1) { //ace
				numAces++;
				handSum += aceValue;
			} else if (cardNum > 10 ){ //face card
				handSum += 10;
			} else {
				handSum += cardNum;
			}
		}
		return handSum;
	}
		
		public int getFinalHandSum(int aceValue){
			int handSum = 0;
			int cardNum;
			int numAces = 0;
			
			//calculate each card's contribution to the hand sum
			for(int c = 0; c < this.numCards; c++){
				
				//get the number for the current hand
				cardNum = this.hand[c].getNumber();
				
				if (cardNum == 1) { //ace
					numAces++;
					handSum += aceValue;
				} else if (cardNum > 10 ){ //face card
					handSum += 10;
				} else {
					handSum += cardNum;
				}
			}
		
		// While we have aces and while the handsum is above 21 we subtract 10
		while(handSum > 21 && numAces > 0){
			handSum -= 10;
			numAces--;
		}
			
		
		return handSum;
	}
	
	/**
	 * prints the cards in the player's hand
	 * @param showFirstCard whether the first card is hidden or not
	 */
	public void printHand(boolean showFirstCard){
		System.out.printf("%s's cards:\n", this.name);
		for(int c = 0; c < this.numCards; c++)
		{
			if (c == 0 && !showFirstCard){
				System.out.println(" [hidden]");
			} else {
				System.out.printf(" %s\n", this.hand[c].toString());
			}
		}
	}
	
	public String getPlayerName(){
		return this.name;
	}
}
