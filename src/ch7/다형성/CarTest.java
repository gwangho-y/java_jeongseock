package ch7.다형성;

class Car {
    String color;
    int door;
    void drive () {}
    void stop() {}
}

class FireEngine extends Car {
    void water() {}
}

class Ambulance extends Car {
    void siren() {}
}

public class CarTest {
    public static void main(String[] args) {
        Car car = null;
        FireEngine fe = new FireEngine();
        FireEngine fe2 = null;
        car = fe;               // 형변환 업캐스팅
        fe2 = (FireEngine) car; // 형변환 다운캐스팅
    }
}
