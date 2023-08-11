package ch7.인터페이스.StarTest;

class Unit {
    int hp;

    Unit(int hp) {
        this.hp = hp;
    }
}
class GroundUnit extends Unit {

    GroundUnit(int hp) {
        super(hp);
    }
}
class AirUnit extends Unit {
    AirUnit(int hp) {
        super(hp);
    }
}

class Marine extends GroundUnit {
    Marine() {
        super(200);
    }
}
class Tank extends GroundUnit implements Repairable{
    Tank() {
        super(150);
    }
}
class SCV extends GroundUnit implements Repairable{
    SCV() {
        super(100);
    }
    void repair(Repairable r) {
        if (r instanceof Readable) {
            Unit u = (Unit) r;
            u.hp += 100;
        }
    }
}
class DropShip extends AirUnit implements Repairable{
    DropShip() {
        super(120);
    }
}

interface Repairable {}

// 만약에 인터페이스로 해결하지 않고, 상속으로만 해결한다고 하면 기계유닛이란걸 상속

public class UnitTest {
    public static void main(String[] args) {
        DropShip d = new DropShip();
        Marine m = new Marine();
        SCV s = new SCV();

        s.repair(d);
//        s.repair(m); // 에러
    }
}
