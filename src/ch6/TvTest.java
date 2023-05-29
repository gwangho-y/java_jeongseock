package ch6;

public class TvTest {
    public static void main(String[] args) {
        Tv tv;                      // Tv 인스턴스를 참조하기 위한 변수 tv를 선언
        tv = new Tv();              // Tv 인스턴스를 생성.
        tv.channel = 7;
        tv.channelDown();
        System.out.println("tv.channel = " + tv.channel); // tv.channel = 6
    }
}