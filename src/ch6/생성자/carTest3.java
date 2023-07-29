package ch6.생성자;

public class carTest3 {
    public static void main(String[] args) {
        Car c1 = new Car();
        Car c2 = new Car(c1); // 단순히 객체의 값만 복사 했으므로 영향을 받지 않는다.

        System.out.println("c1은 = " + c1.color + c1.gearType + c1.door); // whiteauto4
        System.out.println("c2는 = " + c2.color + c2.gearType + c2.door); // whiteauto4

        c1.door = 100;

        System.out.println("c1은 = " + c1.color + c1.gearType + c1.door); // whiteauto100
        System.out.println("c2는 = " + c2.color + c2.gearType + c2.door); // whiteauto4
    }
}
