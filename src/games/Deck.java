package games;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
	ArrayList<Card> spadeCards = new ArrayList<>(10);   //creating an ArrayList of type Card of size 10
	ArrayList<Card> faceCards = new ArrayList<>(12);    //creating an ArrayList of type Card of size 12
	ArrayList<Card> normalCards = new ArrayList<>(30);  //creating an ArrayList of type Card of size 30
	
	public Deck(){                            //constructor
        for(int i = 1; i <=10; i++){          //all spade cards except face cards(11,12,13)
            spadeCards.add(new Card("s",i));
        }
        String [] here = {"s", "h", "d", "c"};    //s denotes spade, h denotes heart, d denotes diamond, c denotes club
        for(String v : here){
            for(int i = 11; i <= 13; i++){     //all face cards
                faceCards.add(new Card(v, i));
            }
        }
        String [] here2 = {"h", "d", "c"};     //remaining normal cards except face cards(11,12,13)
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
	
	
	public ArrayList<Card> concatenate(ArrayList<Card> one, ArrayList<Card> two, ArrayList<Card> three) {   //concatenate all the remaining cards
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
	        for (int i = 0; i < 10; i++)     //shuffling 10 spade cards  
	        {
	            int r = i + rand.nextInt(10 - i);  //getting value of r in the range from 0 to 10-i
	              
	             //swapping the elements
	             Card temp = cards.get(r);
	             cards.set(r, cards.get(i));
	             cards.set(i, temp);  
	        }
	        
	        ArrayList<Card> firstFourCards =  new ArrayList<Card>(cards.subList(0, n));   //n represents first n cards selected from 10 shuffled spade cards

	        cards.removeAll(firstFourCards);   // Delete first four cards from spadeCards
	        
			return firstFourCards;
		}else if(type == "FACECARD"){
			ArrayList<Card> cards = getFaceCards();
			
			// Shuffle Logic
			Random rand = new Random();     
	        for (int i = 0; i < 12; i++)     //shuffling 12 face cards 
	        {
	            int r = i + rand.nextInt(12 - i);   //getting value of r in the range from 0 to 12-i
	              
	             //swapping the elements
	             Card temp = cards.get(r);
	             cards.set(r, cards.get(i));
	             cards.set(i, temp);
	               
	        }
	        
	        ArrayList<Card> firstFourCards =  new ArrayList<Card>(cards.subList(0, n));  //n represents first n cards selected from 12 shuffled face cards

	        cards.removeAll(firstFourCards);      // Delete first four cards from faceCards
	        
			return firstFourCards;
			
		}else{ 
	        ArrayList<Card> cards = concatenate(spadeCards, faceCards, normalCards);  //remaining cards
	       
	        // Shuffle Logic
	        Random rand = new Random();     
	        for (int i = 0; i < 44; i++)    //shuffling remaining cards 
	        {
	            int r = i + rand.nextInt(44 - i);   //getting value of r in the range from 0 to 44-i
	              
	             //swapping the elements
	             Card temp = cards.get(r);
	             cards.set(r, cards.get(i));
	             cards.set(i, temp);
	        }
	        
	        return cards;
		}
	}
	
	
}
