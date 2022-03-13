import java.util.HashMap;

public class Game {
    public static HashMap<String, Integer> cardValue;

    public static void main(String[] args) {
        //helper method just to calculate scores in each round;
        createMap();

        //create new deck of cards
        DeckOfCards myDeckOfCards = new DeckOfCards();
        // place Cards in random order
        myDeckOfCards.shuffle();

        Player player1 = new Player("Omri");
        Player player2 = new Player("Tomer");

        //deal the cards
        for (int i = 0; i < 26; i++) {
            player1.addCard(myDeckOfCards.dealCard().toString());
            player2.addCard(myDeckOfCards.dealCard().toString());
        }

        //game step
        for (int i = 0; i < 26; i++) {
            gameStep(player1, player2);
        }

        //show scores
        System.out.println(player1.name + " score: " + player1.score);
        System.out.println(player2.name + " score: " + player2.score);

    }

    public static void gameStep(Player player1, Player player2) {
        String card1 = player1.getNextCard();
        String card2 = player2.getNextCard();

        System.out.println(player1.name + ": " + card1);
        System.out.println(player2.name + ": " + card2);

        String stepWinner = "Nobody ";
        if(cardValue.get(card1.split(" ")[0]) >  cardValue.get(card2.split(" ")[0]) ) {
            player1.addScore();
            stepWinner = player1.name;
        }
        if(cardValue.get(card1.split(" ")[0]) <  cardValue.get(card2.split(" ")[0]) ) {
            player2.addScore();
            stepWinner = player2.name;
        }

        System.out.println(stepWinner + " Won!!!");

        System.out.println(" ----------- ----------- ");
    }

    private static void createMap() {
        cardValue = new HashMap<String, Integer>();
        cardValue.put("Ace", 14);
        cardValue.put("King", 13);
        cardValue.put("Queen", 12);
        cardValue.put("Jack", 11);
        cardValue.put("Ten", 10);
        cardValue.put("Nine", 9);
        cardValue.put("Eight", 8);
        cardValue.put("Seven", 7);
        cardValue.put("Six", 6);
        cardValue.put("Five", 5);
        cardValue.put("Four", 4);
        cardValue.put("Three", 3);
        cardValue.put("Deuce", 2);
    }

}
