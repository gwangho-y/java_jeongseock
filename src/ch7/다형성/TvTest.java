package ch7.다형성;

class Tv {
    boolean power;
    int channel;

    void power() {}
    void channelUp() {}
    void channelDown() {}
}

class CaptionTv extends Tv {
    String text;
    void caption() {}
}

class TvTest {
    public static void main(String[] args) {
        Tv t = new CaptionTv();
        CaptionTv c = new CaptionTv();

    }
}
