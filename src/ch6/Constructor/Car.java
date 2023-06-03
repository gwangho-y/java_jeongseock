package ch6.Constructor;

public class Car {
    String color;
    String gearType;
    int door;

    Car() {}

    Car(String c, String g, int d) {
        color = c;
        gearType = g;
        door = d;
    }

    Car(String color) {
        door = 5;

    }
}
