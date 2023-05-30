package ch6.Card;

public class CardTest {
    public static void main(String[] args) {
        System.out.println("Card.width = " + Card.width);
        System.out.println("Card.height = " + Card.height);

        Card c1 = new Card();
        c1.kind = "Heart";
        c1.number = 7;

        Card c2 = new Card();
        c2.kind = "Spade";
        c2.number = 4;

        System.out.println("c1은 "+ c1.kind + ", "+ c1.number + "이며, 크기는 " + c1.width + " , " + c1.height );
        System.out.println("c2는 "+ c2.kind + ", "+ c2.number + "이며, 크기는 " + c2.width + " , " + c2.height);
        System.out.println("c1의 width와 height를 변경합니다");
        // c1, c2의 width 값을 변경해도 결과는 동일하게 변경된다.
//        c1.width = 50;
//        c1.height = 80;
        Card.width = 50;
        Card.height = 80;

        System.out.println("c1은 "+ c1.kind + ", "+ c1.number + "이며, 크기는 " + c1.width + " , " + c1.height );
        System.out.println("c2는 "+ c2.kind + ", "+ c2.number + "이며, 크기는 " + c2.width + " , " + c2.height);

    }
}