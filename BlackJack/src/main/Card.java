package main;


/**
 * 
 * @author Stephen Gentles
 *
 */
public class Card implements ICard {
	/**
	 * One of the four suits for a card. ace, queen, etc
	 */
	private Suit mySuit;
	/**
	 * The value or number of the card for eg if the suit is a Ace, Jack-King: values 11-13.
	 */
	private int myNumber;
	
	/**
	 * Card constructor
	 * @param aSuit
	 * @param aNumber
	 */
	public Card(Suit aSuit, int aNumber){
		this.mySuit = aSuit;
		
		if (aNumber >= 1 && aNumber <= 13)
		{
			this.myNumber = aNumber;
		} else {
			System.err.println(aNumber + " is not a valid card number");
			System.exit(1);
		}
	}
	
	/**
	 * returns the number of the card
	 * @return
	 */
	public int getNumber() {
		return myNumber;
	}
	
	public String toString() {
		
		String numStr = "";
		
		switch(this.myNumber){
		case 2:
			numStr = "Two";
			break;
			
		case 3:
			numStr = "Three";
			break;
			
		case 4:
			numStr = "Four";
			break;
			
		case 5:
			numStr = "Five";
			break;
			
		case 6:
			numStr = "Six";
			break;
			
		case 7:
			numStr = "Seven";
			break;
			
		case 8:
			numStr = "Eight";
			break;
			
		case 9:
			numStr = "Nine";
			break;
			
		case 10:
			numStr = "Ten";
			break;
			
		case 11:
			numStr = "Jack";
			break;
			
		case 12:
			numStr = "Queen";
			break;
			
		case 13:
			numStr = "King";
			break;
			
		case 1:
			numStr = "Ace";
			break;
			
			
		}
		return numStr + " of " + mySuit.toString();
		
	}

}
