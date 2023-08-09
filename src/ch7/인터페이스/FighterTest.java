package ch7.인터페이스;



interface Movable { void move(int x, int y);}
interface Attackable { void attack(Unit u);}
interface Fightable extends Movable, Attackable{ }

class Unit { int currentHP, x, y; }

class Fighter extends Unit implements Fightable {
    public void attack(Unit u) {}

    public void move(int x, int y) {}
}


public class FighterTest {
    public static void main(String[] args) {
        Fighter f = new Fighter();
        if (f instanceof Fighter) {
            System.out.println("f는 Unit의 자손");
        }
        if (f instanceof Fightable) {
            System.out.println("f는 Fightable 인터페이스를 구현");
        }
        if (f instanceof Attackable) {
            System.out.println("f는 Attackable 인터페이스를 구현");
        }
        if (f instanceof Movable) {
            System.out.println("f는 Movable 인터페이스를 구현");
        }
    }
}
