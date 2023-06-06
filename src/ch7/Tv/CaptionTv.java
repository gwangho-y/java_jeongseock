package ch7.Tv;

public class CaptionTv extends Tv {
    boolean caption; // 자막 상태

    void displayCaption(String text) {
        if (caption) {
            System.out.println(text);
        }
    }

    // tv의 메서드 역시 상속 된다.

}
