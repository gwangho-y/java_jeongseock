package ch7.오버라이딩;

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Point3D extends Point {
    int z;

    Point3D(int x, int y, int z) {
        // 컴파일러가 자동으로 super()를 삽입한다. 여기서 super는 조상인 Point의 생성자를 의미한다.
        // super();  // 에러. 조상의 Point() 생성자가 없기 때문ㅇ이다.
        super(x,y);
        this.z = z;
    }
}

public class PointTest {
    public static void main(String[] args) {
        Point3D p3 = new Point3D(1,2,3);
    }
}
