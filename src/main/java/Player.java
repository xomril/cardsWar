import java.util.ArrayList;

public class Player {
    public final String name;
    public final ArrayList<String> deck;
    public int score;

    public Player(String name){
        this.name = name;
        this.deck = new ArrayList<>();
        this.score = 0;
    }

    public void addCard(String card){
        this.deck.add(card);
    }

    public String getNextCard(){
        String currentCard = this.deck.get(0);
        this.deck.remove(0);
        return currentCard;
    }

    public void addScore(){
        this.score++;
    }
}
