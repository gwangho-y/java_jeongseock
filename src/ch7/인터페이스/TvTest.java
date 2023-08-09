package ch7.인터페이스;

class Tv {
    protected boolean power;
    protected int channel;
    protected int volume;
    public void power() {power = !power;}
    public void channelUp() {channel++;}
    public void channelDown() {channel--;}
    public void volumeUp() {volume++;}
    public void volumeDown() {volume--;}
}

class VCR {
    protected int counter;
    public void play() {}
    public void stop() {}
    public void reset() {counter = 0;}
    public int getCounter() {return counter;}
    public void setCounter(int c){counter = c;}
}

interface IVCR {
    public void play();
    public void stop();
    public void reset();
    public int getCounter();
    public void setCounter(int c);
}

class TVCR extends Tv implements IVCR {
    VCR vcr = new VCR();
    @Override
    public void play() {
        vcr.play(); // 코드를 작성하는 대신 VCR의 메서드를 호출한다.
    }

    @Override
    public void stop() {
        vcr.stop();
    }

    @Override
    public void reset() {
        vcr.reset();
    }

    @Override
    public int getCounter() {
        return vcr.getCounter();
    }

    @Override
    public void setCounter(int c) {
        vcr.setCounter(c);
    }
}



public class TvTest {
}
