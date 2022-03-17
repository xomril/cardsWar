import java.util.ArrayList;

public class Player {
    public final String name;
    public final ArrayList<Card> deck;

    public Player(String name){
        this.name = name;
        this.deck = new ArrayList<>();
    }

    public Card removeCard(){
        Card currentCard = this.deck.get(0);
        this.deck.remove(0);
        return currentCard;
    }

    public void addCard(Card card){
        this.deck.add(card);
    }
}
