## 인터페이스
일종의 추상클래스. 
### 추상 클래스와의 차이
- 추상화보다는 추상화 정도가 높다.
- 몸통을 갖춘 일반 메서드 또는 멤버변수를 가질 수 없다.

    ```java
    // 추상화 클래스
    abstract class AbClass {
        int a;
        void method(int c) {}
        abstract void abMethod(int c);
    }
  
    // 인터페이스
    interface Interface {
        public static final int b;    // 상수
        public abstract void method(int c);
    }
    
    ```
### 인터페이스 작성
- 접근제어자로 public, default 만 사용가능하다.
- 모든 멤버변수는 public static final 이어야한다. (생략 시 컴파일러가 추가)
- JDK 1.8 이전 : 모든 메서드는 추상메서드여야 한다
- JDK 1.8 이후 : static 메서드와 디폴트 메서드의 추가를 허용한다.

```java
interface PlayingCard {
    public static final int SPADE = 4;
    final int DIAMOND = 3;        // public static final이 자동 추가된다.         
    static int HEART = 2;         // public static final이 자동 추가된다.        
    int CLOVER = 1;               // public static final이 자동 추가된다.  
    public abstract String getCardNumber();
    String getCardKind();         // public abstract 자동 추가
    
    // JDK 1.8 이후
    public static staticMethod(); // static 메서드
    
}
```
### 인터페이스의 상속
인터페이스는 인터페이스만 상속할 수 있다.그리고 다중 상속을 허용한다.
```java
interface Movable {
    /**지정된 위치 이동**/
    void move(int x, int y);
}
interface Attackable {
    /**지정 유닛 타격**/
    void attack(Unit u);
}

interface Fightable extends Movable, Attackable {} // 다중상속으로 move와 attack을 가진다.
```

### 인터페이스의 구현
- 추상 클래스처럼 인스턴스 생성 불가능
- 클래스에서 implements로 상속 받을 수 있다.
    ```java
    class Fighter implements Fightable {
        public void move(int x, int y) {}
        public void attack(Unit u) {}
    }
    ```
- 클래스에서 인터페이스의 메서드 일부만 구현했다면 추상 클래스로 선언해야한다.
    ````java
    abstract class Fighter implements Fighteable { // move만 구현했으므로 추상 클래스가 되야한다.
        public void move(int x, int y) {} 
    }
    ````

아래 코드로 상속 관계를 볼 수 있다.
```java
interface Movable {
  void move(int x, int y); // 추상 메서드 - public abstract 생략
}
interface Attackable {
  void attack(Unit u);    //  추상 메서드 - public abstract 생략
}
interface Fightable extends Movable, Attackable{ }

class Unit { int currentHP, x, y; }

class Fighter extends Unit implements Fightable {
    public void attack(Unit u) {}
    
    public void move(int x, int y) {}  // Movable의 move를 상속 받았기 때문에 조상의 접근제어자에 맞춰준다.
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
```

### 인터페이스를 이용한 다중 상속
두 조상으로부터 상속 받은 멤버(변수, 메서드선언부)가 일치하다면 어느 조상의 것인지 알 수 없다.
상속을 포기하던가, 조상클래스 내용을 변경하는 수 밖에 없다.

#### 자바에서 인터페이스로만 다중 상속을 허용하는 이유
C++ 에서 다중상속을 허용하기 때문에 자바는 다중 상속을 허용하지 않는다는 것이 단점으로 부각되는 것에 대한 대응으로
인터페이스를 이용한 다중 상속을 허용하는 것일 뿐 실제로는 인터페이스로 다중 상속을 구현하는 경우는 거의 없다.

#### 인터페이스와 클래스를 상속 받는 경우 멤버의 충돌 가능성
- 멤버변수<br>
  인터페이스는 멤버변수를 static final만 정의 가능하기 때문에 조상클래스의 멤버변수끼리 충돌날 일은 없다.
  충돌 되더라도 클래스 이름 붙여서 구별할 수 있다. 
- 메서드<br>
  인터페이스의 추상메서드는 구현 내용이 없으므로, 조상메서드의 메서드와 선언부가 일치하는 경우 
  조상클래스의 메서드를 상속 받으면 된다.

하지만 충돌날 이름을 중복해서 만드는게 과연 좋은 설계일까 싶다

#### 두 개의 클래스로부터 상속을 받아야 할 상황이라면
두 클래스 중 비중이 높은 쪽을 상속으로 선택하고 한 쪽의 클래스는 포함 관계로 처리하거나 
어느 한 쪽의 필요한 부분을 뽑아와서 인터페이스로 만든 다음 구현한다.
```java
class Tv { // 조상 클래스로 사용
    protected boolean power;
    protected int channel;
    protected int volume;
    public void power() {power = !power;}
    public void channelUp() {channel++;}
    public void channelDown() {channel--;}
    public void volumeUp() {volume++;}
    public void volumeDown() {volume--;}
}

class VCR { // 포함관계로 사용
    protected int counter;
    public void play() {}
    public void stop() {}
    public void reset() {counter = 0;}
    public int getCounter() {return counter;}
    public void setCounter(int c){counter = c;}
}

interface IVCR { // 필요한 기능
    public void play();
    public void stop();
    public void reset();
    public int getCounter();
    public void setCounter(int c);
}

class TVCR extends Tv implements IVCR {
    VCR vcr = new VCR();
    @Override
    public void play() {
        vcr.play(); // 코드를 작성하는 대신 VCR의 메서드를 호출한다.
    }

    @Override
    public void stop() {
        vcr.stop();
    }

    @Override
    public void reset() {
        vcr.reset();
    }

    @Override
    public int getCounter() {
        return vcr.getCounter();
    }

    @Override
    public void setCounter(int c) {
        vcr.setCounter(c);
    }
}
```
이렇게 만드는 것의 장점
- VCR 클래스의 인스턴스를 사용하면 손쉽게 다중 상속을 구현할 수 있다.
- 또한 VCR 클래스의 내용이 변경되어도 변경된 내용이 TVCR 클래스에도 자동적으로 반영이 된다.

단점
- IVCR 인터페이스를 구현하기 위해 새로 메서드를 작성해야하는 부담이 있다.

인터페이스를 새로 작성하지 않고도 VCR 클래스를 TVCR 클래스에 포함 시키는 것만으로도 충분하지만, 
인터페이스를 이용하면 다형적 특성을 얻을 수 있다는 장점도 있다고 한다.

나라면 어떻게 했을까?? 다중상속이 필요한게 아니라면 VCR을 꼭 상속 받아서 복잡하게 만들지는 않고 TVCR에서 바로 구현 했을 것이다.
```java
class Tv2 {
    protected boolean power;
    protected int channel;
    protected int volume;
    public void power() {power = !power;}
    public void channelUp() {channel++;}
    public void channelDown() {channel--;}
    public void volumeUp() {volume++;}
    public void volumeDown() {volume--;}
}


interface IVCR2 {
    public void play();
    public void stop();
    public void reset();
    public int getCounter();
    public void setCounter(int c);
}

class TVCR2 extends Tv2 implements IVCR2 {
    @Override
    public void play() {}

    @Override
    public void stop() {}

    @Override
    public void reset() {}

    @Override
    public int getCounter() {return 0;}

    @Override
    public void setCounter(int c) {}
}
```


### 인터페이스를 이용한 다형성
- 클래스처럼 인터페이스 타입의 참조변수가 클래스의 인스턴스를 참조 할 수 있다.
  ```java
  Fightable f = (Fightable) new Fighter();
  or
  Fightable f = new Fighter();
  ```

- 메서드의 매개변수로 인터페이스를 지정할 수도 있다.<br>
  메서드 호출 시 해당 인터페이스를 구현한 클래스의 인스턴스를 매개변수로 제공해야한다.
    ```java
    class Fighter extends Unit implements Fighterble {
        public void attack(Fightable f) {}
    }
    ```
- 메서드의 리턴 타입으로 인터페이스 지정 가능하다.<br>
  메서드가 해당 인터페이스(Fighterble)를 구현한 클래스(Fighter)의 인스턴스를 반환한다는 것을 의미한다.
  ```java
  class Fighter extends Unit implements Fighterble {
    Fighterble method() {
        return Fighter;
    }
  }
  ```

아래 예제는 메서드의 리턴 타입을 인터페이스로, return 문에서는 인터페이스를 상속 받은 클래스를 던져준다.
```java
interface Parseable {
    // 구문 작업 수행
    public abstract void parse(String fileName);
}

class ParserManager {
    protected static Parseable getParser(String type) {
        if (type.equals("XML")) {
            return new XMLParser();
        }else {
            return new HTMLParser();
        }
    }
}

class XMLParser implements Parseable {
    @Override
    public void parse(String fileName) {}
}

class HTMLParser implements Parseable {

    @Override
    public void parse(String fileName) {}
}

class NewXMLParser implements Parseable {

    @Override
    public void parse(String fileName) {

    }
}
public class ParserTest {
    public static void main(String[] args) {
        Parseable parser = ParserManager.getParser("XML");
        parser.parse("XML File");
    }
}

```

이 코드의 장점은 만약에 XMLPaser가 NewXMLParser로 변경되도, getParser에서 클래스를 갈아끼우기만 하면 되기 때문에
코드가 꼬일 문제 같은 것들이 없다.
분산처리 환경이라면 사용자 단의 코드를 수정하지 않고 서버단의 코드를 수정하는 것만으로 바뀐 프로그램을 사용하는 것이 가능하다.


### 인터페이스의 장점
> - 개발 시간을 단축시킬 수 있다.
> - 표준화가 가능하다
> - 서로 관계없는 클래스들에게 관계를 맺어줄 수 있다.
> - 독립적인 프로그래밍이 가능하다

1. 개발 시간을 단축 시킬 수 있다.<br/>
   인터페이스는 양쪽의 클래스를 연결하고 있다. 인터페이스에 있는 메서드를 사용하려는 쪽에서는 메서드의 내용에 관계없이
   선언부만 알고 사용하면 되고, 메서드의 실제 내용 구현하는 쪽과 분리해서 작업을 할 수 있기 때문에 동시에 개발 진행가능.
2. 표준화가 가능하다.<br/>
    프로그램에 사용하는 기본 틀을 인터페이스로 작성한 다음, 개발자들에게 인터페이스를 구현하여 프로그램을
   작성하도록 함으로써 일관되고 정형화된 프로그램 개발이 가능하다.
3. 서로 관계없는 클래스들에게 관계를 맺어줄 수 있다.<br/>
   서로 상속 관계에 있지 않고, 같은 조상 클래스를 가지고 있지 않은 서로 아무런 관련 없는 클래스들에게 하나의 인터페이스를
   공통적으로 구현하도록 함으로써 관계를 맺을 수 있다.
4. 독립적인 프로그래밍이 가능하다.<br/>
   클래스의 선언과 구현을 분리 시키는게 가능해서 실제 구현에 독립적인 프로그램을 작성하는게 가능하다.
   클래스와 클래스 간의 직접적인 관계를 인터페이스를 이용해서 간접적인 관계로 변경 -> 한 클래스와 연결된 다른 클래스에 영향 X
   -> 독립적인 프로그래밍 가능
  

아래와 같은 코드가 있다고 해보자.

```java
class Unit {}
class GroundUnit extends Unit {}
class AirUnit extends Unit {}

class Marine extends GroundUnit {}
class Tank extends GroundUnit {}
class SCV extends GroundUnit {}
class DropShip extends AirUnit {}
```

Tank, SCV, DropShip 같은 기계 로봇만 수리 가능하고 SCV가 수리하는 기능을 가지고 있다면 어떻게 짤 것인가?? <br/>
SCV의 `type`이라는 속성을 지정하고, 기계형일 경우에만 수리를 한다.
`if (type이 기계형일 때만 수리)` 로 분기를 나눠서 짤 수 있겠다.
```java
class Unit {
    int hp;
    String type;

    Unit(int hp, String type) {
        this.hp = hp;
        this.type = type;
    }
}
class GroundUnit extends Unit {
    GroundUnit(int hp, String type) {
        super(hp, type);
    }
}
class AirUnit extends Unit {
    AirUnit(int hp, String type) {
        super(hp, type);
    }
}

class Marine extends GroundUnit {
    Marine(int hp, String type) {
        super(hp, type);
    }
}
class Tank extends GroundUnit {
    Tank(int hp, String type) {
        super(hp, type);
    }
}
class SCV extends GroundUnit {
    SCV(int hp, String type) {
        super(hp, type);
    }

    void repair(Unit u) {
        if (u.type.equals("기계형")) {
            u.hp += 100;
            System.out.println("수리 완료...!!");
        }else {
            System.out.println("기계형이 아닌 유닛은 수리 불가능..");
        }
    }
}
class DropShip extends AirUnit {
    DropShip(int hp, String type) {
        super(hp, type);
    }
}


// 만약에 인터페이스로 해결하지 않고, 상속으로만 해결한다고 하면 기계유닛이란걸 상속

public class UnitTest {
    public static void main(String[] args) {
        SCV scv = new SCV(100, "기계형");
        Tank tank = new Tank(200,"기계형");
        Marine marine = new Marine(150, "인간형");
        scv.repair(tank);
        scv.repair(marine);
    }
}

```

인터페이스를 사용해서 짜면은 어떻게 짤 수 있을까??

```java
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
        s.repair(m); // 에러
    }
}
```
1. 수리가 가능한 유닛들을 인터페이스로 묶어준다.
2. SCV의 repair 메서드에서 Repairable을 상속한 유닛만 수리 가능한 인스턴스만 매개변수로 받는다.
3. 인스턴스를 Unit으로 형변환해서 수리를 한다.

이렇게 인터페이스로 구현하면 서로 관계가 없는 클래스들을 묶어서 만들어 줄 수 있다.


다음 예제를 보자

```java
class Building {}

class Bunker extends Building  { }
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
```
건물 클래스의  `Barrak`과 `Factory`는 공중에 뜰 수 있다. 
그렇기 때문에 공중에 띄우는 `Liftable` 인터페이스를 만들고, 구현 내용은 `ImpLiftable`에 작성해서
포함 관계를 만든다. `ImpLiftable` 에서 상세 내용을 구현했기 때문에 언제든지 재사용이 가능해지고
좀 더 확장성 있는 코드를 만들 수 있다.


### 결국 인터페이스란?
인터페이스는 결국에 접속기라고 생각하면 되겠다.
먼저 책에서는 인터페이스를 이해하기 위해서는 아래 두 가지를 반드시 염두에 두고 있어야 한다고 한다.
> - 클래스를 사용하는 쪽(User)과 클래스를 제공(Provider)하는 쪽이 있다.
> - 메서드를 사용(호출)하는 쪽(User)에서는 사용하려는 메서드의 선언부만 알고 구현부는 몰라도 된다.

```java
class A {
    public void methodA(B b) {
        b.methodB();
    }
}

class B {
    public void methodB() {
        System.out.println("methodB");
    }
}

public class InterfaceTest {
    public static void main(String[] args) {
        A a = new A();
        a.methodA(new B());
    }
}
```
위 코드처럼 사용하는 쪽을 A 제공하는 쪽을 B라고 했을 때, 
A와 B는 직접적인 관계에 있다.
난 이상함을 못 느꼈지만, 이 코드의 문제점은 B가 수정 됐을 때, A의 메서드도 변형이 일어날 수 있다는 것이었다.
만약에 B의 `methodB`의 선언부가 변경되면 A에 있는 `methodA`도 수정을 해주거나, 클래스가 변경되어도 수정을
해줘야하는 것이다.

하지만 인터페이스를 사용하면 A의 내용을 변경하지 하지 않고도 구현이 가능하다.

```java
class A2 {
    void autoPlay(I i) {
        i.play();
    }
}

class B2 implements I {
    @Override
    public void play() {
        System.out.println("play B class");
    }
}

class C2 implements I {

    @Override
    public void play() {
        System.out.println("play C class");
    }
}

interface I {
    public abstract void play();
}

public class InterfaceTest2 {
    public static void main(String[] args) {
        A2 a = new A2();
        a.autoPlay(new B2());
        a.autoPlay(new C2());
    }
}

```

인터페이스를 추가 함으로써 B2가 변경되거나 교체 되더라도 A2는 변경할 코드가 없어졌다.
그리고 C2 클래스도 자유롭게 추가가 가능해졌다.
이렇게 직접적인 관계가 아니라 간접적인 관계로 만들어줌으로써 코드의 변경을 유현하게 할 수 있다.
`a.autoPlay(new B2())` 처럼 매개변수를 통해 동적으로 제공 받을 수도 있고
아래의 코드처럼 매개변수를 주입하지 않고 제 3의 클래스를 통해서도 제공받을 수 있다.

```java
class D {
    void methodD() {
        J j = InstanceManager.getInstance();
        j.methodE();
        System.out.println(j.toString());
    }
}

class E implements J {
    @Override
    public void methodE() {
        System.out.println("메서드 E");
    }
    public String toString() { return "class E"; }
}

class InstanceManager {
    public static J getInstance() {
        return new E();
    }
}
interface J {
    public abstract void methodE();
}


public class InterfaceTest3 {
    public static void main(String[] args) {
        D d = new D();
        d.methodD();
    }
}
```

`a.autoPlay(new B2())` 와 `d.methodD()`의 차이점을 알겠는가??
D 클래스에는 인스턴스를 대신 생성해주는 `InstanceManager`라는 클래스를 사용해 인스턴스를 대신 생성해서 돌려 받았다는 점이다.
이렇게 만듦으로써 제공자인 E 클래스를 수정하거나 교체해도 D 클래스는 매개변수를 수정할 필요조차 없어진다.

두 예제의 클래스 간 연관 관계는 다음과 같다.

>1.  A -> I -> B 
>2.  D -> InstanceManager -> J -> E


1. 연관 관계를 점차 간접적으로 둠으로써 A 에서는 B의 변경, 교체가 생겨도 코드를 수정할 필요는 없어졌다.<br/>
    I라는 인터페이스를 상속 받은 클래스를 매개변수로 교체 해주기만하면 User 쪽에서는 편하게 제공자를 사용할 수 있다. 
2. 1번 예제에서 매번 인스턴스를 교체해서 사용하는 것을 `InstanceManager` 라는 클래스로 별도 관리함으로써 
   D는 변경에 대해서 어떠한 것도 신경쓰지 않아도 된다. 하지만 제공자인 J가 교체가 된다면 `InstanceManager`의 코드를 수정해야할 수도 있다.

내가 생각한 이 코드들의 장점은 다음과 같다.
1. 제공자 클래스의 교체가 빈번하거나 같은 기능을 하는 여러 제공자 클래스를 실행해야 할 경우에는 인터페이스만 상속 받으면 되기 때문에
    굉장히 편리할거 같다.
2. 하나의 제공자 클래스만 사용해야한다면 User 단에서는 어떠한 클래스로 교체가 되는지 아예 몰라도 되기 때문에 편리할거 같다.

### 디폴트 메서드와 static 메서드
JDK 1.8부터 디폴트 메서드와 static 메서드를 추가할 수 있게 됨.

#### 1.8 이전에는 없었던 이유
static 메서드는 인스턴스와 관계가 없는 독립적인 메서드이기 때문에 예전부터 인터페이스에 추가 못 할 이유가 없었다.
하지만 자바를 쉽게 배울 수 있도록 규칙을 단순화 할 필요가 있어서 인터페이스는 추상 메서드만을 고집햇다고 한다.
인터페이스과 관련된 static 메서드들은 별고의 클래스에 따로 두어 관리했다고 한다.
Collection 인터페이스와 Collections 클래스의 예가 있는데 이건 11장에서 나온다고 한다.

#### 디폴트 메서드
인터페이스의 단점은 추상 메서드 하나를 추가하면 관련된 모든 클래스에서 메서드 상세기능을 만들어줘야한다.
그렇기 때문에 **디폴트 메서드**라는 것이 고안 되었다.
> 디폴트 메서드 : 추상메서드의 기본적인 구현을 제공하는 메서드로 추상메서드는 아니기 때문에 연관된 클래스를 변경하지 않아도 된다.

```java
interface Interface {
    void method(); // 추상메서드
    default void newMethod() {} // 디폴트 메서드
}
```

이렇게 디폴트 메서드를 추가함으로써 인터페이스와 관련된 클래스에는 메서드를 추가한 효과를 얻고, 
추상메서드처럼 구현을 하지않아도 된다.

대신, 디폴트 메서드가 기존의 메서드 이름과 중복되어 충돌한다면 다음과 같은 해결책들이 있다.
> 1. 여러 인터페이스의 디폴트 메서드 간의 충돌 <br/>
    - 인터페이스를 구현한 클래스에서 디폴트 메서드를 오버라이딩 해야한다.
>2. 디폴트 메서드와 조상 클래스의 메서드 간의 충돌 <br/>
    - 조상 클래스의 메서드가 상속되고, 디폴트 메서드는 무시된다.
>3. 위 두개 규칙을 외우기 귀찮으면, 필요한 쪽의 메서드와 같은 내용으로 오버라이딩 해버린다.


```java
class Parent {
    public void method2() {
        System.out.println("method2 in Parent");
    }
}

interface MyInterface {
    default void method1() {
        System.out.println("method1 in MyInterface");
    }
    default void method2() {
        System.out.println("method2 in MyInterface");
    }
    static void staticMethod() {
        System.out.println("staticMethod in MyInterface");
    }
}

interface MyInterface2 {
    default void method1() {
        System.out.println("method1 in MyInterface2");
    }
    static void staticMethod() {
        System.out.println("staticMethod in MyInterface2");
    }
}

class Child extends Parent implements MyInterface, MyInterface2 {


    @Override
    public void method1() {
        System.out.println("method1 in Child");
    }
}
public class DefaultMethodTest {
    public static void main(String[] args) {
        Child c = new Child();
        c.method1(); // 1
        c.method2(); // 2
        MyInterface.staticMethod(); 
        MyInterface2.staticMethod(); 
    }
}
```
결과를 보고 풀이를 해보자.
1. 두개의 인터페이스에 method1이 중복으로 선언되 있어서 충돌이 발생하고 있기 때문에 Child에서 오버라이딩해서 작성한
    내용이 출력된다.  method1 in Child
2. 조상 클래스와 인터페이스 간의 중복이 발생하기 때문에 조상 클래스의 메서드가 적용된다. method2 in Parent

