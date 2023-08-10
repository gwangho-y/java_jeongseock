package ch7.인터페이스.StarTest;

class Building {}

class Bunker extends Building  {


}
class Barrak extends Building implements Liftable {
    ImpLiftable impLiftable = new ImpLiftable();
    @Override
    public void liftOff(Liftable liftable) {
        impLiftable.liftOff(liftable);
    }

    @Override
    public void move(int x, int y) {
        impLiftable.move(x, y);

    }
}
class Factory extends Building implements Liftable {
    ImpLiftable impLiftable = new ImpLiftable();
    @Override
    public void liftOff(Liftable liftable) {
        impLiftable.liftOff(liftable);
    }

    @Override
    public void move(int x, int y) {
        impLiftable.move(x,y);
    }
}

interface Liftable {
    /**건물 들어올린다**/
    void liftOff(Liftable liftable);
    /**움직인다**/
    void move(int x,int y);
}

class ImpLiftable implements Liftable {

    @Override
    public void liftOff(Liftable liftable) {
        /**내용 구현해주세요**/
        Building b = (Building) liftable;
        System.out.println(b + "가 공중에 뜬다!");
    }

    @Override
    public void move(int x, int y) {
        System.out.println(x + " , "+ y +" 위치로 움직인다");
    }


}

public class BuildingTest {

}
