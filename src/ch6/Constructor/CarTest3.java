package ch6.Constructor;

public class CarTest3 {


    public static void main(String[] args) {
        Car c1 = new Car();
        Car c2 = new Car(c1); // 생성자를 사용해서 인스턴스 복사가 가능하다. .clone()으로도 복사가 가능하다


        System.out.println("c1의 값은? "+ c1.color + " "+ c1.gearType+ " "+ c1.door);
        System.out.println("c2의 값은? "+ c2.color + " "+ c2.gearType+ " "+ c2.door);
        c1.door = 100;

        System.out.println("c1의 값은? "+ c1.color + " "+ c1.gearType+ " "+ c1.door);
        System.out.println("c2의 값은? "+ c2.color + " "+ c2.gearType+ " "+ c2.door);

    }

}
