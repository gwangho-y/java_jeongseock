package ch7.상속.TVCR;

public class TVCR extends Tv{
    VCR vcr = new VCR();
    void play() {
        vcr.play();
    }
}
