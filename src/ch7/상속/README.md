## 상속

기존의 클래스를 재사용하여 새로운 클래스를 작성하는 것. 
> 조상 클래스 : 부모(parent)클래스, 상위(super)클래스, 기반(base)클래스 <br>
> 자손 클래스 : 자식(child)클래스, 하위(sub)클래스, 파생된(derived)클래스

>생성자와 초기화 블럭은 상속되지 않는다. 멤버만 상속된다. <br>
>자손 클래스의 멤버 개수는 조상클래스보다 항상 같거나 많다.

### 상속의 장점
- 같은 내용의 코드를 한 곳에서 관리함으로써 코드의 중복이 줄어듬
- 클래스에 중복으로 코드를 추가할 경우, 상속을 사용해서 중복 최소화 가능하다.
- 자손 클래스들의 공통적인 부분은 조상 클래스에서 관리하기 때문에 관리가 쉬워진다.



```java
class Tv {
    boolean power;
    int channel;

    void power () {
        power = !power;
    }
    void channelUp() {
        ++channel;
    }

    void channelDown() {
        --channel;
    }
}

class CaptionTv extends Tv {
    boolean caption;

    void displayCaption(String text) {
        if (caption) {
            System.out.println(text);
        }
    }
}

public class CaptionTvTest {
    public static void main(String[] args) {
        CaptionTv ctv = new CaptionTv();
        ctv.channel = 10;
        ctv.channelUp();
        System.out.println(ctv.channel);
        ctv.displayCaption("Hello, World");
        ctv.caption = true;
        ctv.displayCaption("Hello, World");
    }
}
```

자손 클래스의 인스턴스를 생성하면 조상 클래스의 멤버와 자손 클래스의 멤버가 합쳐진 하나의 인스턴스로 생성된다.

## 포함 관계
상속 외에도 클래스를 재사용하는 방법.
한 클래스의 멤버 변수로 다른 클래스 타입의 참조변수를 선언하는 것.<br>
단위별로 여러개의 클래스를 작서앟고 포함 관계로 재사용하면 간결하고 손쉽게 클래스를 작성 가능.
```java
class Point {
    int x; // x 좌표
    int y; // y 좌표
}

class Circle {
    Point c = new Porint(); // 원점
    int r;
}
```

## 클래스 간의 관계설정
상속 관계를 맺을 지, 포함 관계를 맺을 지의 기준
> 원(Circle)은 점(Point)이다 <br>
> 원(Circle)은 점(Point)를 가지고 있다.

인 것인지, 가지고 있는 것인지.
예를들어 , 상속이라면 사자는 동물이다.가 될 수 있겠고, 포함이라면 사자는 몸, 심장, 발톱을 가지고 있다 가 되겠다.

아래 예제도 마찬가지다.<br>
원은 도형인가?? Yes! 원은 도형을 가지고 있는가? No!  == 상속<br>
원은 점인가??  No!  원은 점을 가지고 있는가? Yes!  ==  포함
```java
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
```


## 단일 상속
상속은 단일 상속과 다중상속이 있다.

### 다중 상속의 장단점
장점 : 여러 클래스를 상속받아 복합적인 기능을 가지 클래스를 작성할 수 있다 ex. c++ <br>
단점 : 상속받은 멤버간의 이름이 같은 경우 구별할 수 있는 방법이 없다.

### 단일 상속의 장단점
장점 : 하나의 조상만을 가지기 때문에 클래스 간의 관계가 명확해지고 코드를 더욱 신뢰할 수 있다.
단점 : 여러 클래스를 상속 받을 수 없기 때문에 다중상속처럼 기능이 다양하지는 않을 수 있다.

### 자바는 왜 단일 상속만 허용하는가?
예를 들어 TVCR에는 TV와 VCR의 기능이 있다고 해보자. 두가지를 클래스로 만들었다고 했을 때, 자동차와 와이퍼는 각각
power를 on of 하는 메서드가 있다고 했을 때 

