package ch6.Constructor;

public class ConstructorTest {

    public static void main(String[] args) {
        Car c1 = new Car();
        c1.color = "red";
        c1.gearType = "auto";
        c1.door = 4;

        // 위 처럼 인스턴스의 값을 하나씩 설정하는 것 보다, 생성자에서 값을 지정해 주는게 코드가 간결하고 직관적이다.
        Car c2 = new Car("white", "stick", 5);

    }




}
