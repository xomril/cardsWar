
public class Card {
    public final String face;
    public final String suite;


    public Card(String face, String suite) {
        this.face = face;
        this.suite = suite;
    }

    public String toString() {
        return this.face + " of " + this.suite;
    }


}
