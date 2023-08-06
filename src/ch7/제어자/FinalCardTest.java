package ch7.제어자;

class Card {
    final int NUMBER;
    final String KIND;
    static int width = 100;
    static int height = 250;

    Card(String kind, int num) {
        this.KIND = kind;
        this.NUMBER = num;
    }
    Card() {
        this("HEART", 1);
    }
}

public class FinalCardTest {
    public static void main(String[] args) {
        Card c = new Card("HEART", 10);
        // c.NUMBER = 5;  //final 이기 때문에 변경 불가능
    }
}
