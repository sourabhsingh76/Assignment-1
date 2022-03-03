package games;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
	ArrayList<Card> spadeCards = new ArrayList<>(10);
	ArrayList<Card> faceCards = new ArrayList<>(12);
	ArrayList<Card> normalCards = new ArrayList<>(30);
	
	public Deck(){
        for(int i = 1; i <=10; i++){
            spadeCards.add(new Card("s",i));
        }
        String [] here = {"s", "h", "d", "c"};
        for(String v : here){
            for(int i = 11; i <= 13; i++){
                faceCards.add(new Card(v, i));
            }
        }
        String [] here2 = {"h", "d", "c"};
        for(String v : here2){
            for(int i = 1; i <= 10; i++){
                normalCards.add(new Card(v, i));
            }
        }
    }
	public ArrayList<Card> getSpadeCards() {
		return spadeCards;
	}
	
	public ArrayList<Card> getFaceCards() {
		return faceCards;
	}
	
	/*
	public ArrayList<Card> getNormalCards() {
		return normalCards;
	}
	*/
	
	public ArrayList<Card> concatenate(ArrayList<Card> one, ArrayList<Card> two, ArrayList<Card> three) {
        ArrayList<Card> result = new ArrayList<Card>();
        for(Card c : one){
            result.add(c);
        }
        
        for(Card c : two){
            result.add(c);
        }

        for(Card c : three){
            result.add(c);
        }
        return result;
    }
	
	public ArrayList<Card> randomShuffledCards(int n, String type){
		if(type == "SPADE") {
			ArrayList<Card> cards = getSpadeCards();
			// Shuffle Logic
			Random rand = new Random();     
	        for (int i = 0; i < 10; i++)
	        {
	            // Random for remaining positions.
	            int r = i + rand.nextInt(10 - i);
	              
	             //swapping the elements
	             Card temp = cards.get(r);
	             cards.set(r, cards.get(i));
	             cards.set(i, temp);  
	        }
	        
	        ArrayList<Card> firstFourCards =  new ArrayList<Card>(cards.subList(0, 4));

            // Delete first four cards from spadeCards
	        cards.removeAll(firstFourCards);
	        
			return firstFourCards;
		}else if(type == "FACECARD"){
			ArrayList<Card> cards = getFaceCards();
			// Shuffle Logic
			
			Random rand = new Random();     
	        for (int i = 0; i < 12; i++)
	        {
	            // Random for remaining positions.
	            int r = i + rand.nextInt(12 - i);
	              
	             //swapping the elements
	             Card temp = cards.get(r);
	             cards.set(r, cards.get(i));
	             cards.set(i, temp);
	               
	        }
	        
	        ArrayList<Card> firstFourCards =  new ArrayList<Card>(cards.subList(0, 4));

            // Delete first four cards from faceCards
	        cards.removeAll(firstFourCards);
	        
			return firstFourCards;
			
		}else{
			// NORMALCARDS
	        ArrayList<Card> cards = concatenate(spadeCards, faceCards, normalCards);
	        // Shuffle Logic
	        
	        Random rand = new Random();     
	        for (int i = 0; i < 30; i++)
	        {
	            // Random for remaining positions.
	            int r = i + rand.nextInt(30 - i);
	              
	             //swapping the elements
	             Card temp = cards.get(r);
	             cards.set(r, cards.get(i));
	             cards.set(i, temp);
	        }
	        
	        return cards;
		}
	}
	
	
}
