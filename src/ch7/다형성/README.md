## 다형성
여러가지 형태를 가질 수 있는 능력을 의미한다. 자바에서는 한 타입의 참조 변수로 여러 타입의 객체를 참조할 수 있도록 했다.
**조상클래스 타입의 참조변수로 자손 클래스의 인스턴스를 참조할 수 있도록 하였다**는 것.

아래는 Tv -> CaptionTv 형태로 상속이 됐다.
```java
class Tv {
    boolean power;
    int channel;

    void power() {}
    void channelUp() {}
    void channelDown() {}
}

class CaptionTv extends Tv {
    String text;
    void caption() {}
}
```

인스턴스를 생성할 때, 아래와 같이 생성한다면 어떤 차이가 있을까?
```java
Tv t = new CaptionTv();
CaptionTv c = new CaptionTv();
```
변수 t로는 CaptionTv에만 선언된 멤버들을 사용할 수 없다.
같은 타입의 인스턴스라고 해도 참조변수의 타입에 따라 사용할 수 잇는 멤버의 개수가 달라진다.
```java
c.text = "텍스트";
c.caption();

t.text = "텍스트";    // 선언 불가능 
t.caption();         // 선언 불가능 
```

반대의 경우는? 선언이 불가능하다. Tv의 멤버 개수보다 참조변수의 멤버 개수가 많으므로 존재하지 않는 멤버를 참조를 
시도하려할 수도 있기 때문이다. 조상은 초기화가 되었지만 자손의 멤버는 초기화도 되지 않았는데 접근할 수는 없기 때문 아닐까?
```java
CaptionTv v = new Tv();
```

> 조상 타입의 참조 변수로 자손 타입의 인스턴스를 참조할 수 있다. <br/>
> 반대로 자손 타입의 참조 변수로 조상 타입의 인스턴스를 참조할 수는 없다.

### 참조변수의 형변환
> 자손타입 -> 조상타입(Up-casting) : 형변환 생략 가능
> 조상타입 -> 자손타입(Down-casting) : 형변환 생략 불가

조상타입의 참조변수를 자손타입의 참조변수에 저장하는 경우에는 명시적으로 형변환을 해줘야한다.
조상의 인스턴스를 자손 타입의 참조변수로 사용할 경우 멤버의 갯수를 늘리는 것이기 때문에 문제가 발생할 수 있으므로
명시적으로 형변환을 한 후에 사용할 수 있다.
```java
class Car {
    String color;
    int door;
    void drive () {}
    void stop() {}
}

class FireEngine extends Car {
    void water() {}
}
public class CarTest {
  public static void main(String[] args) {
    Car car = null;
    FireEngine fe = new FireEngine();
    FireEngine fe2 = null;
    car = fe;               // 형변환 업캐스팅
    fe2 = (FireEngine) car; // 형변환 다운캐스팅
  }
}
```

참고로, 형변환은 참조변수의 타입을 변환하는 것이지 인스턴스에 아무런 영향을 미치지 않는다.
단지 형변환을 통해서, 참조하고 있는 인스턴스에서 사용할 수 있는 멤버의 범위(개수)를 조절하는 것뿐이다.


아래의 코드는 어떻게 실행이 될까??
```java
public class CatTest2 {
  public static void main(String[] args) {
    Car car = new Car();
    FireEngine fe = null;

    car.drive();
    fe = (FireEngine) car; // 컴파일은 ok, 실행 시 에러 발생.
    fe.drive();
  }
}
```
컴파일은 문제 없이 되지만 실행시 오류가 발생한다.
**다운 캐스팅을 거쳤기 때문에 문제가 없을 줄 알았지만, 이미 Car 인스턴스가 생성된 상태에서 자손 클래스 변수가 참조하면
조상인 Car에는 선언되지 않은 멤버에 접근 할 수 있기 때문에 에러가 발생한다.**

### instanceof 연산자
- 참조변수가 참조하고 있는 인스턴스의 실제 타입을 알 수 있다. 
- 연산 결과로 true, false 중 하나를 반환한다.
- 결과로 true를 얻었다면 검사한 타입으로 형변환이 가능하다.

### 참조변수와 인스턴스의 연결
조상타입 참조변수에 자손의 인스턴스를 연결할 시, 알아두어야 할 점이 있다.
```java
class Parent {
    int x = 100;
}
class Child {
    int x = 200;
}
Parent p = new Child();
p.x; // 100
```
위 코드 처럼 조상타입으로 선언 되었고 p.x를 출력하면 어떤게 출력이 될까? 정답은 100이 출력된다.
조상의 멤버변수명과 자손의 멤버변수 명이 같을 때, 조상타입 참조변수에 자손의 인스턴스를 연결하면 참조타입인 조상의 것을 따른다.


메서드는 어떻게 될까?? 메서드는 오버라이딩한 자손의 메서드를 따른다.
```java
class Parent {
    void haha {
        System.out.println("조상");
    }
}
class Child {
    void haha {
        System.out.println("자손");
    }
}
Parent p = new Child();
p.haha; // "자손"
```

> 조상타입의 참조변수에 자손의 인스턴스를 연결하면
> - 같은 이름의 멤버 변수는 참조타입인 조상의 것을 따른다.
> - 메서드는 오버라이딩한 자손의 것을 따른다.


### 매개변수의 다형성
참조변수의 다형적인 특징을 메서드 매개변수에도 사용할 수 있다.
아래 코드를 보자 상품에 대한 구매자가 있고, 구매자가 제품을 구매하는 메서드를 만든다고 가정했을 때, 메서드는 아래와 같이 될 것이다.

```java
class Product {
    int price;
}

class Tv extends  Product{}
class Computer extends Product {}
class Audio extends Product {}

class Buyer {
    int money = 1000;
    
    void buy(Tv tv) {
        this.money -= tv.price;
    }
    void buy(Computer cp) {
        this.money -= cp.price;
    }
    void buy(Audio ad) {
        this.money -= ad.price;
    }
}
```
매개변수 역시 다형성을 사용하면 변경 할 수 있다. 이런게 만들면 product를 상속 받은 클래스들을
한번에 받을 수 있기 때문에 메서드의 양도 줄일 수 있다.
```java
class Buyer {
    int money = 1000;

    void buy(Product pd) {
        this.money -= pd.price;
    }
}
``