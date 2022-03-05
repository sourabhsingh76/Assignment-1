package games;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
	ArrayList<Card> spadeCards = new ArrayList<>(10);   //declaring an ArrayList of type Card of size 10
	ArrayList<Card> faceCards = new ArrayList<>(12);    //declaring an ArrayList of type Card of size 12
	ArrayList<Card> normalCards = new ArrayList<>(30);  //declaring an ArrayList of type Card of size 30
	
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
	
	public void shuffleLogic(ArrayList<Card> cards) {
		Random rand = new Random();     
        for (int i = 0; i < cards.size() ; i++)     //shuffling cards  
        {
            int r = i + rand.nextInt(cards.size() - i);  //getting value of r in the range from 0 to cards.size()-i
              
             //swapping the elements
             Card temp = cards.get(r);
             cards.set(r, cards.get(i));
             cards.set(i, temp);  
        }
	}
	
	public ArrayList<Card> randomShuffledCards(int n, String type){
		if(type == "SPADE") {              
			shuffleLogic(spadeCards);
				        
	        ArrayList<Card> firstFourCards =  new ArrayList<Card>(spadeCards.subList(0, n));   //n represents first n cards selected from 10 shuffled spade cards

	        spadeCards.removeAll(firstFourCards);   // Delete first four cards from spadeCards
	        
			return firstFourCards;
		}else if(type == "FACECARD"){
			shuffleLogic(faceCards);
	        
	        ArrayList<Card> firstFourCards =  new ArrayList<Card>(faceCards.subList(0, n));  //n represents first n cards selected from 12 shuffled face cards

	        faceCards.removeAll(firstFourCards);      // Delete first four cards from faceCards
	        
			return firstFourCards;
		}else{ 
	        ArrayList<Card> cards = concatenate(spadeCards, faceCards, normalCards);  //remaining cards
	        shuffleLogic(cards);
	        
	        return cards;
		}
	}
	
}
