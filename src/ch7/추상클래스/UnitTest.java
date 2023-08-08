package ch7.추상클래스;

abstract class Unit {
    int x, y;
    abstract void move(int x, int y);
    void stop() {} // stop의 기능을 전부 공통으로 사용하고 동일한 기능을 한다면 추상 메서드로 만들 필요는 X
}

class Marine extends Unit{
    @Override
    void move(int x, int y) {

    }
    void stimpack() {}
}
class Tank extends Unit{
    @Override
    void move(int x, int y) {

    }
    void formChange() {}
}

class Dropship extends Unit{
    @Override
    void move(int x, int y) {

    }
    void drop() {}
}



public class UnitTest {
    public static void main(String[] args) {
        Unit[] units = new Unit[4];
        units[0] = new Marine();
        units[1] = new Tank();
        units[2] = new Dropship();

        // units[0].stim() 이건 왜 작동이 안 된다고 했지?? Unit에는 stim이 없기 때문에!! 만약에 units[1] 이 stim이 가능할리는 없잖아.
        // 명시되 있지 않은 메서드인 상태로 다른 곳에서도 쓰면 위험하기도하고 애초애 Unit이 가지지 않은 메서드니깐 사용 못 한다.

        for (int i = 0; i < units.length; i++) {
            units[i].move(2, 4);
        }

        Object[] unit = new Object[4];
        unit[0] = new Marine();
        unit[1] = new Tank();
        unit[2] = new Dropship();

        for (int i = 0; i < unit.length; i++) {
            // unit[i].move(2, 4); // Object도 move를 가지고 있지 않으니깐 기능을 끌어다 쓰지는 못 한다.
        }

    }
}
