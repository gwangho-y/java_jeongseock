package ch7.다형성;

public class CatTest2 {
    public static void main(String[] args) {
        Car car = new Car();
        FireEngine fe = null;

        car.drive();
        fe = (FireEngine) car;
        fe.drive();

    }
}
