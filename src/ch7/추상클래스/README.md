## 추상클래스
### 추상 클래스
- 미완성 설계도. 클래스들의 공통적인 부분들만 묶어 놓은 클래스.
- 미완성 설계도이기 때문에 인스턴스는 생성할 수 없다.
- 추상 클래스에도 생성자가 있으며 멤버변수, 메서드도 가질 수 있다.
- 추상메서드가 하나라도 있다면 추상 클래스가 된다.

> 추상 클래스는 어디까지나 미완성의 설계도일 뿐이며, 내 생각에는 공통적인 기능을 묶기 위한 상속용 클래스라고 나름 정의를 내렸다.


### 추상 메서드
- 선언부만 작성하고 구현부는 작성하지 않은 채로 남겨둔 미완성 메서드.
- 구현부는 상속 받은 클래스에서 구현한다.
  - 메서드의 내용이 상속받는 클래스에 따라 달라질 수 있기 때문이다.
- 주석을 덧붙여 어떤 기능을 수행할 목적으로 작성됐는지 알려줘야한다.
- 자손 클래스는 오버라이딩을 통해 추상 메서드를 모두 구현해야한다.
- 하나라도 구현하지 않는다면 자손 클래스 역시 추상 클래스로 지정해주어야한다.

````java
abstract class Player {
    abstract void play(int pos);
    abstract void stop();
}

class AudioPlayer extends Player {
    void play(int pos) {}
    void stop() {}
}

abstract class AbstractPlayer extends Player {
    void play(int pos) {}
    // stop() 메서드를 구현하지 않았기 때문에 아직 미완성이므로 추상 클래스가 되야한다.
}
````



#### 구현부가 없는 메서드만 주구장창 만들어서 무슨 의미가 있나??
구현부보다 중요한게 선언부이기 때문이라고 하는데, 
메서드 작업 시 아래의 두가지를 결정하는게 쉽지 않아서 이기 때문이라고 한다.
- 메서드의 이름과 메서드의 작업에 필요한 매개변수
- 결과로 어떤 타입을 반환할 것인가를 결정


### 추상 클래스의 작성
> 추상 - 낱낱의 구체적 표상이나 개념에서 공통된 성질을 뽑아 이를 일반적인 개념으로 파악하는 정신 작용.

#### 상속과 추상은 반대라고 생각하면 쉽다
구체화(상속) <> 추상화
> 구체화 : 상속을 통해 클래스를 구현, 확장하는 작업. <br/>
> 추상화 : 자손의 공통된 부분을 뽑아서 조상 클래스를 만드는 것.

상속 계층도를 따라 내려갈수록 클래스의 기능은 점점 구체화된다. <br/>
반대로 올라갈수록 추상화의 정도가 심해진다고 볼 수 있다.

아래는 추상화를 사용한 상속 예제

```java
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
```

