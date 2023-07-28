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
}

    public class carTest2 {
        public static void main(String[] args) {
            Car c1 = new Car();
            Car c2 = new Car("blue");
        }
}
