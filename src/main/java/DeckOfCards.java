import java.security.SecureRandom;
import java.util.ArrayList;

public class DeckOfCards extends ArrayList<Card>{
    private static final SecureRandom randomNumbers = new SecureRandom();
    private static final int NUMBER_OF_CARDS = 52;
    private String _name;
    private ArrayList<Card> deck = new ArrayList<>(NUMBER_OF_CARDS);
    private int currentCard = 0;


    public DeckOfCards() {
        // Ace should be higher (=14) than King (=13)
        int[] faces = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        // populate deck with Card objects
        for (int count = 0; count < NUMBER_OF_CARDS; count++) {
            deck.add(count, new Card(faces[count % 13], suits[count/13]));
        }
    }

    //Contractor for players' deck. Empty deck, with name of the player
    public DeckOfCards(String playerName){
        _name = playerName;
    }

    public void setPlayerName (String playerName){
        _name = playerName;
    }

    public String getPlayerName(){
        return _name;
    }

    // shuffle deck of Cards with one-pass algorithm
    public void shuffle() {
        // next call to method dealCard should start at deck[0] again
        currentCard = 0;

        // for each Card, pick another random Card (0-51) and swap them
        for (int first = 0; first < deck.size(); first++) {
            // select a random number between 0 and 51
            int second = randomNumbers.nextInt(NUMBER_OF_CARDS);

            // swap current Card with randomly selected Card
            Card temp = deck.get(first);
            deck.set(first, deck.get(second));
            deck.set(second, temp);
        }
    }

    // deal one Card
    public Card dealCard() {
        // determine whether Cards remain to be dealt
        if (currentCard < deck.size()) {
            return deck.get(currentCard++); // return current Card in array
        }
        else {
            return null; // return null to indicate that all Cards were dealt
        }
    }

    public void addCardToDeck(DeckOfCards this, DeckOfCards other, int range){
        for (int i = 0; i <= range; i++) {
            this.add(this.get(i));
            this.add(other.get(i));
        }
    }

    public void removeCardFromDeck(DeckOfCards this, int range) {
        for (int i = 0; i <= range; i++) {
            this.remove(this.get(0));
        }
    }
}
