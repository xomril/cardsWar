import java.util.HashMap;

public class Game {
    public static HashMap<String, Integer> cardValue;

    public static void main(String[] args) {
        // Helper method just to calculate scores in each round.
        createMap();

        // Create new deck of cards.
        DeckOfCards myDeckOfCards = new DeckOfCards();

        // Place Cards in random order.
        myDeckOfCards.shuffle();

        // Create Players.
        Player player1 = new Player("Omri");
        Player player2 = new Player("Tomer");
        int playerCount = 2; // count all the players manually

        // Deal the cards.
        for (int i = 0; i < 52 /playerCount; i++) {
            player1.addCard(myDeckOfCards.dealCard().toString());
            player2.addCard(myDeckOfCards.dealCard().toString());
        }

        // Fight till the end.
        for (int i = 0; i < 52 /playerCount; i++) {
            gameStep(player1, player2);
        }

        // Show scores.
        System.out.println(player1.name + " score: " + player1.score);
        System.out.println(player2.name + " score: " + player2.score);

    }

    public static void gameStep(Player player1, Player player2) {

        String stepWinner = gameLogic(player1, player2);
        System.out.println(stepWinner);
        System.out.println(" ----------- ----------- ");
    }

    private static String gameLogic(Player player1, Player player2){
        String card1 = player1.getNextCard();
        String card2 = player2.getNextCard();

        System.out.println(player1.name + ": " + card1);
        System.out.println(player2.name + ": " + card2);
        String stepWinner = "Nobody ";

        // Only the face (=card value) is being calculated, incase of a tie - nobody won the round.
        if(cardValue.get(card1.split(" ")[0]) >  cardValue.get(card2.split(" ")[0]) ) {
            player1.addScore();
            stepWinner = player1.name;
        }

        if(cardValue.get(card1.split(" ")[0]) <  cardValue.get(card2.split(" ")[0]) ) {
            player2.addScore();
            stepWinner = player2.name;
        }
        return stepWinner + " Won!!!";
    }

    private static void createMap() {
        cardValue = new HashMap<>();
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
