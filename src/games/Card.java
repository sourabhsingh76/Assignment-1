package games;

public class Card {
	
	int number;
	String deckName;
	
	
	public Card(String deckName, int number) {
		super();
		this.deckName = deckName;
		this.number = number;
	}

	/*
	@Override
	public String toString() {
		return "Card [number=" + number + ", deckName=" + deckName + "]";
	}
	*/
	
	public String toString() {
		return deckName+number;
	}
	
}
