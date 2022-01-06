import java.util.ArrayList;

// The Deck class represents a shuffled deck of cards.
// It provides several operations including
// initialize, shuffle, deal, and check if empty.
public class Deck {
	// cards is an ArrayList of all the Card objects in our deck
	private ArrayList<Card> cardsList;

	// size is the number of not-yet-dealt cards.
	// Cards are dealt from the top (highest index) down.
	// The next card to be dealt is at size - 1.
	private int size;

	// Creates a new Deck instance given arrays of ranks, suits, and values
	// You will need to initialize both the cardsList and size instance variables
	// You should go through and make all possible pairs of suits and ranks
	public Deck(String[] ranks, String[] suits, int[] values) {
		cardsList = new ArrayList<Card>();
		size = ranks.length * suits.length;
		/*
		for (int i = 0; i<size-1; i++){ // go through 3 array and make every single card
			Card c = new Card(ranks[i], suits[i], values[i]);
			cardsList.add(c);
		}
		*/ // this doesn't work b/c need to loop through the suits and then the ranks as well. need a nested loop.
		 for (int i =0; i<suits.length; i++){
			 for (int j = 0; j< ranks.length; j++){
				 Card c = new Card(ranks[j], suits[i], values[j]); //use j for values because the values tag along with the ranks
				 cardsList.add(c);
			 }
		 }
		// // Remember, in a constructor you need to first create the ArrayList for the instance variable!
	}
	// Deals a card from this deck.
	// return the card just dealt, or null if all the cards have been dealt already
	// Recall that the cards are dealt from top (highest-index) down
	// Updates the size as well
	public Card deal() {
		int count = size;
		if (count>0){
			size--;
			return cardsList.get(count-1);
		}
		return null;
	}

	// Determines if this deck is empty (there are no undealt cards).
	// returns true if this deck is empty, false otherwise.
	public boolean isEmpty() {
		if (size<=0){
			return true;
		}
		return false;
	}

	// Returns the size (number of undealt cards) in this deck.
	public int getSize() {
		return size;
	}

	// Shuffles the deck by repeatedly randomly swapping pairs of cards
	// This method should change the order of the cards in cardsList
	// Shuffling should also reset the size variable to its original value
	public void shuffle() {
		int ogSize = cardsList.size();
		for (int i = 0; i<size-1; i++){
			Card temp = cardsList.get(i);
			int random = (int)(Math.random()*ogSize);
			Card swap = cardsList.get(random);
			cardsList.set(i, swap);
			cardsList.set(random, temp);

		}
	}

	// OPTIONAL: Write code that carries out a "perfect" shuffle
	// that perfectly interweaves the two halves of the deck
	public void perfectShuffle() {
		// YOUR CODE HERE
	}








	// CODE BELOW HERE IS ALREADY WRITTEN:

	/**
	 * Generates and returns a string representation of this deck.
	 * @return a string representation of this deck.
	 */
	@Override
	public String toString() {
		if (cardsList == null) {
			return "";
		}

		String rtn = "size = " + size + "\nUndealt cards: \n";

		for (int k = size - 1; k >= 0; k--) {
			rtn = rtn + cardsList.get(k);
			if (k != 0) {
				rtn = rtn + ", ";
			}
			if ((size - k) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\nDealt cards: \n";
		for (int k = cardsList.size() - 1; k >= size; k--) {
			rtn = rtn + cardsList.get(k);
			if (k != size) {
				rtn = rtn + ", ";
			}
			if ((k - cardsList.size()) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\n";
		return rtn;
	}

	// Returns the card at the given index of the deck
	// This method should only be used in testing code
	public Card getCardAtIndex(int idx) {
		return cardsList.get(idx);
	}

	// This version of equals() is used in the testing code
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		else if (o == null || getClass() != o.getClass()) {
			return false;
		}
		else {
			return cardsList.equals(((Deck) o).cardsList);
		}
	}
}
