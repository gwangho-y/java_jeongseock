package ch7.상속.DrawShape;

// 원은 도형인가? yes. Shape 상속
// 원은 점인가? no, 점을 가지고 있다 yes. Point 포함
public class Circle extends Shape {
    Point center; // 원의 원점좌표
    int r; // 반지름

    Circle () {
        this(new Point(0,0), 100);
    }

    Circle(Point center, int r){
        this.center = center;
        this.r = r;
    }

    void draw() {
        System.out.printf("[center=(%d, %d), r=%d, color=%s]%n", center.x, center.y, r, color);

    }

}
