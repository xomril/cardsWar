import javax.swing.*;

public class Game {
    private static DeckOfCards deck = new DeckOfCards();
    public static Player player1;
    public static Player player2;
    public static int playerCount = 2; // count all the players manually

    public static void main(String[] args) {
        initGame();
        courseOfGame();
        declareWinner();
    }


    private static void initGame(){
        deck.shuffle();
        player1 = new Player("Tomer");
        player2 = new Player("Yael");

        // Deal the cards.
        for (int i = 0; i < 52 / playerCount; i++) {
            player1.addCard(deck.dealCard());
            player2.addCard(deck.dealCard());
        }
    }

    public static void declareWinner() {
        String msg;
        msg = "player1 have " + player1.deck.size() + " cards\nplayer2 have " + player2.deck.size();
        if(player1.deck.size() > player2.deck.size()) {
            msg += "\n" + player1.name + " won the game";
        } else {
            msg += "\n" + player2.name + " won the game";
        }

        JOptionPane.showMessageDialog(null, msg);
    }

    public static void courseOfGame() {
        while ((!player1.deck.isEmpty() && !player2.deck.isEmpty())){
            Card cp1 = player1.deck.get(0);
            Card cp2 = player2.deck.get(0);
            String msg;
            if(cp1.face > cp2.face) { // Player1 win
                player1.addCard(player2.removeCard());

                msg = "Player1 put: " + cp1.toString() + "\nPlayer2 put: " + cp2.toString() + "\n" +  player1.name +" win";
                JOptionPane.showMessageDialog(null, msg);
            }

            if(cp1.face < cp2.face) { // Player2 win
                player2.addCard(player1.removeCard());
                msg = "Player1 put: " + cp1.toString() + "\nPlayer2 put: " + cp2.toString() + "\n" +  player2.name +" win";
                JOptionPane.showMessageDialog(null, msg);
            }

            if(cp1.face == cp2.face) { // war
                doWar(player1, player2, 0);
            }
            msg =   player1.name + " have " + player1.deck.size() + " cards\n" +  player2.name +" have " + player2.deck.size();
            JOptionPane.showMessageDialog(null, msg);
        }

    }

    public static void doWar(Player player1, Player player2, int round){
        int index;
        String msg;
        index = (round * 3) + 2;
        JOptionPane.showMessageDialog(null, "**** WAR ****");
        if(player1.deck.size() <= index || player2.deck.size() <= index) {
            System.out.println();
            msg = "Game over: " +  player1.name +" have " + player1.deck.size() + " cards\n" +  player2.name +" have " + player2.deck.size();
            JOptionPane.showMessageDialog(null, msg);
            return;
        }
        Card cp1 = player1.deck.get(index);
        Card cp2 = player2.deck.get(index);
        if(cp1.face > cp2.face) { // Player1 win
            msg =   player1.name + " put: " + cp1.toString() + "\n" +  player2.name +" put: " + cp2.toString() + "\n" +  player1.name +" won " + index + " cards in this war";
            JOptionPane.showMessageDialog(null, msg);
            for(int i=0; i< index; i++){
                player1.addCard(player2.removeCard());
            }
        }

        if(cp1.face < cp2.face) { // Player2 win
            msg = player1.name + " put: " + cp1.toString() + "\n"+  player2.name +" put: " + cp2.toString() + "\n" +  player2.name + " won " + index + " cards in this war";
            JOptionPane.showMessageDialog(null, msg);
            for(int i=0; i< index; i++){
                player2.addCard(player1.removeCard());
            }
        }

        doWar(player1, player2, round + 1);
    }
}
