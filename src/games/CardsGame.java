package games;

import java.util.ArrayList;

public class CardsGame {

	public static void main(String[] args) {
		ArrayList<Player> players = new ArrayList<>();
		players.add(new Player("player1"));
		players.add(new Player("player2"));
		players.add(new Player("player3"));
		players.add(new Player("player4"));
		
		
		Deck deck = new Deck();
		
		// Get 4 spadeCards
		ArrayList<Card> shuffledSpadeCards = deck.randomShuffledCards(4,"SPADE");
		
		for(int i=0;i<4;i++) {
			players.get(i).addCard(shuffledSpadeCards.get(i));
		}
		
		// Get 4 faceCards
		ArrayList<Card> shuffledFaceCards = deck.randomShuffledCards(4, "FACECARD");
		
        for (int i =0;i<4;i++){
        	players.get(i).addCard(shuffledFaceCards.get(i));
        }
        
        // Get all NormalCards
    	ArrayList<Card> shuffledNormalCards = deck.randomShuffledCards(44,"NORMALCARD");
    	
    	/*
        for (int i = 0; i < 4; i++){
            for(int j = 0; j < 44; j++){
            	players.get(i%4).addCard(shuffledNormalCards.get(j%4));    
            }
        }
        */
    	int a=0;
    	for (int i = 0; i < 4; i++){
    		a++;
            for(int j = 11*i; j<11*a; j++){
            	players.get(i).addCard(shuffledNormalCards.get(j));   
            }
        }
        
        for(Player p : players) {
        	System.out.println(p + "=" + p.getCards());
        }
     

	}

}
