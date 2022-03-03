package games;

import java.util.ArrayList;

public class CardsGame {

	public static void main(String[] args) {
		ArrayList<Player> players = new ArrayList<>();  //declaring an ArrayList of type Player
		players.add(new Player("player1"));
		players.add(new Player("player2"));
		players.add(new Player("player3"));
		players.add(new Player("player4"));
		
		
		Deck deck = new Deck();       //declaring an instance of Deck class
		
		
		ArrayList<Card> shuffledSpadeCards = deck.randomShuffledCards(4,"SPADE");   //Get randomly shuffled 4 spade cards
		
		for(int i=0;i<4;i++) {         //assigning each player 1 spade card
			players.get(i).addCard(shuffledSpadeCards.get(i));
		}
		
		
		ArrayList<Card> shuffledFaceCards = deck.randomShuffledCards(4, "FACECARD");  //Get randomly shuffled 4 face cards
		
        for (int i =0;i<4;i++){        //assigning each player 1 face card
        	players.get(i).addCard(shuffledFaceCards.get(i));
        }
        
        
    	ArrayList<Card> shuffledNormalCards = deck.randomShuffledCards(44,"NORMALCARD");  //Get all randomly shuffled normal cards 
    	
    	int a=0;                         //assigning each player 11 normal cards
    	for (int i = 0; i < 4; i++){
    		a++;
            for(int j = 11*i; j<11*a; j++){
            	players.get(i).addCard(shuffledNormalCards.get(j));   
            }
        }
        
    	
        for(Player p : players) {              //printing cards contained by each player
        	System.out.println(p + " = " + p.getCards());
        }

	}

}
