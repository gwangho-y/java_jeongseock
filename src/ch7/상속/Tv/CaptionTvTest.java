package ch7.상속.Tv;

public class CaptionTvTest {

    public static void main(String[] args) {
        CaptionTv ctv = new CaptionTv();
        ctv.channel = 10;
        ctv.channelUp();
        System.out.println(ctv.channel);
        ctv.displayCaption("Hello, world");
        ctv.caption = true; // 자막 기능 on
        ctv.displayCaption("Hello, World");
    }


}
