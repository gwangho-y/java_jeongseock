package ch7.인터페이스;
class Tv2 {
    protected boolean power;
    protected int channel;
    protected int volume;
    public void power() {power = !power;}
    public void channelUp() {channel++;}
    public void channelDown() {channel--;}
    public void volumeUp() {volume++;}
    public void volumeDown() {volume--;}
}


interface IVCR2 {
    public void play();
    public void stop();
    public void reset();
    public int getCounter();
    public void setCounter(int c);
}

class TVCR2 extends Tv2 implements IVCR2 {
    @Override
    public void play() {}

    @Override
    public void stop() {}

    @Override
    public void reset() {}

    @Override
    public int getCounter() {return 0;}

    @Override
    public void setCounter(int c) {}
}

public class TvTest2 {
}
