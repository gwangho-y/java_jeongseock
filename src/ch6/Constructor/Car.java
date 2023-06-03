package ch6.Constructor;

public class Car {
    String color;
    String gearType;
    int door;

    Car() {
        this("white", "auto", 4);
    }

    Car(String c, String g, int d) {
        color = c;
        gearType = g;
        door = d;
    }

    Car(String color) {
//        door = 5; // 다른 생성자 호출 전에 변수 값은 설정 못 한다. 다른 생성자에서 변수값을 수정해버리면 무의미해지는 경우가 생겨서 막아 놓은듯
        this(color, "auto", 4); // 다른 생성자를 호출할 때는 this를 사용한다. 여기서 this는 Car(String c, String g, int d) 생성자를 호출한다.
    }
}
