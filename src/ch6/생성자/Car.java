package ch6.생성자;

class Car {
    String color;
    String gearType;
    int door;

    Car(String color, String gearType, int door) {
        this.color = color;
        this.gearType = gearType;
        this.door = door;
    }

    Car(String color) {
        this(color, "auto", 4);
    }

    Car() {
        this("white", "auto", 4);
    }

    Car(Car c) {
        this(c.color, c.gearType, c.door);
    }
}
