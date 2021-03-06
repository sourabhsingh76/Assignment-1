package games;

import java.util.ArrayList;

public class Player {
	String name;
	
	ArrayList<Card> cards = new ArrayList<Card>();   //creating an ArrayList of type Card

	public Player(String name) {       //constructor
		super();
		this.name = name;
	}
	
	public void addCard(Card v) {
		cards.add(v);
	}
	
	@Override
	public String toString() {
		return name;
	}

	public ArrayList<Card> getCards() {
		return cards;
	}
	
}
