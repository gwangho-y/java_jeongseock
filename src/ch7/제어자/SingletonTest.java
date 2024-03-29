package ch7.제어자;

final class Singleton {
    private static Singleton s = new Singleton();

    private Singleton() {
        System.out.println("생성");
    }

    public static Singleton getInstance() {
        if(s==null) {
            s = new Singleton();
        }
        return s;
    }
}

public class SingletonTest {
    public static void main(String[] args) {
        Singleton s = Singleton.getInstance();
    }
}
