package games;

public class Card {
	
	int number;
	String deckName;
	
	public Card(String deckName, int number) {   //constructor
		super();
		this.deckName = deckName;
		this.number = number;
	}
	
	@Override
	public String toString() {
		return deckName+number;
	}
	
}
