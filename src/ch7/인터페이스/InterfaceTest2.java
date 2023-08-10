package ch7.인터페이스;


class A2 {
    void autoPlay(I i) {
        i.play();
    }
}

class B2 implements I {
    @Override
    public void play() {
        System.out.println("play B class");
    }
}

class C2 implements I {

    @Override
    public void play() {
        System.out.println("play C class");
    }
}

interface I {
    public abstract void play();
}

public class InterfaceTest2 {
    public static void main(String[] args) {
        A2 a = new A2();
        a.autoPlay(new B2());
        a.autoPlay(new C2());
    }
}
