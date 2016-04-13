package main;
import java.util.Scanner;

/**
 * 
 * @author Stephen Gentles
 *
 */

public class GameRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//init
		Scanner sc = new Scanner(System.in);
		Deck theDeck = new Deck(1, true);
		
		//Init players ace value preference 1 or 11
		int playerAcePrefValue = 11; //Init to 11 by default
		int dealerAcePrefValue = 11; //Ace always values 11 for the dealer
		
		//Store player's name
		String playerName = "Default Player";
		
		//Init dealer 
		Player dealer = new Player("Dealer", dealerAcePrefValue);
		
				
		//prompt user to enter the Ace card value preference of either 1 or 11
		System.out.println("Please enter your name");
		playerName = sc.next();
		System.out.println("Would you like value of your Ace card to be 1 or 11?\n");
		while (!sc.hasNextInt()) sc.next();
		int input = sc.nextInt();
	    
		if(input == 1){
			playerAcePrefValue = 1;
		} else if (input == 11){
			playerAcePrefValue = 11;
		}
		
		//Init Player object
		Player me = new Player(playerName, playerAcePrefValue);
				
				
		me.addCard(theDeck.dealNextCard(),playerAcePrefValue);
		dealer.addCard(theDeck.dealNextCard(),dealerAcePrefValue);
		me.addCard(theDeck.dealNextCard(),playerAcePrefValue);
		dealer.addCard(theDeck.dealNextCard(),dealerAcePrefValue);
		
		//print initial hands
		System.out.println("Cards are dealt\n");
		me.printHand(true);
		dealer.printHand(false);
		System.out.println("\n");
		
		// flags for when each player is finished hitting
		boolean meDone = false;
		boolean dealerDone = false;
		String ans;
		
		while(!meDone || !dealerDone){
			if (!meDone)
			{
				System.out.print("Hit or Stand? (Enter H or S): ");
				ans = sc.next();
				System.out.println();
				
				//if the player hits
				if(ans.compareToIgnoreCase("H") == 0){
					// Add next card in the deck and store whether player is busted
					meDone = !me.addCard(theDeck.dealNextCard(),playerAcePrefValue);
					me.printHand(true);
				} else {
					System.out.println(me.getPlayerName() + " decided to stands\n");
					meDone = true;
				}
			}
			
			//dealer's turn
			if(!dealerDone) {
				if (dealer.getHandSum(dealerAcePrefValue) < 17 ){
					System.out.println("The dealer hits\n");
					dealerDone = !dealer.addCard(theDeck.dealNextCard(),dealerAcePrefValue);
					dealer.printHand(false);
				} else  {
					System.out.println("The Dealer stands\n");
					dealerDone = true;
				}
			}
			
			System.out.println();
		}
		
		//Close scanner
		sc.close();
		
		//print final hands
		me.printHand(true);
		dealer.printHand(true);
		
		int mySum = me.getHandSum(playerAcePrefValue);
		int dealerSum = dealer.getHandSum(dealerAcePrefValue);
		
		if(mySum > dealerSum && mySum <= 21 || dealerSum > 21){
			System.out.println("your Win!");
		}else
		{
			System.out.println("Dealer wins");
		}
		
		
		
		
		
	}

}
