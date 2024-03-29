## 생성자
- 인스턴스 초기화 메서드
- 메서드와 유사하지만 리턴 값이 없다.
- 생성자의 이름은 클래스와 같아야 한다.
- 연산자 new가 인스턴스를 생성하는 것이지, 생성자가 인스턴스를 생성하는 것은 아니다.

```java
    class Card {
        int a;
        Card(int a) {
            this.a = a;
        }
    }
    
    Card c = new Card(10);
```

위 코드의 동작 단계
> 1. 연산자 new에 의해 메모리에 Card 클래스의 인스턴스가 생성된다.
> 2. 생성자 Card()가 수행
> 3. 연산자 new의 결과로 생성된 Card 인스턴스의 주소가 반환되어 참조변수 c에 저장된다.

### 기본 생성자
생성자 정의 없이 인스턴스 생성 가능하게 해주는 보이지 않는 생성자를 의미한다.

### 생성자에서 다른 생성자 호출하기 this(), this
생성자 간에도 서로 호출이 가능하다
- 생성자의 이름으로 클래스 이름 대신 this를 사용한다
- 다른 생성자를 호출할 때는 반드시 첫 줄에서만 호출이 가능하다.

```java
class Car {
    String color;
    String gearType; 
    int door;

    Car(String color, String gearType, int door) {
        this.color = color;
        this.gearType = gearType;
        this.door = door;
    }

    Car(String color) {
        this(color, "auto", 4);
    }
    
    Car() {
        this("white", "auto", 4);
    }
}
```
같은 클래스 내의 생성자들은 일반적으로 서로 관계가 깊은 경우가 많아서 서로 호출하도록 하여 
유기적으로 연결해주면 더 좋은 코드를 얻을 수 있다.

> **this** <br>
>인스턴스 자신을 가리키는 참조변수, 인스턴스의 주소가 저장되어 있다. 
>모든 인스턴스 메서드에 지역변수로 숨겨진 채로 존재한다.
> 
> **this(), this(매개변수)** <br>
> 생성자, 같은 클래스의 다른 생성자를 호출할 때 사용한다.


### 생성자를 이용한 인스턴스의 복사
생성자를 통해 기존의 인스턴스의 값을 활용하여 값 복사가 가능하다.
이 경우에는 단순히 값을 통한 복사이기 때문에 기존에 사용한 인스턴스의 값을 변경하여도 값 복사된 인스턴스는
영향을 받지 않는다.
그리고 아래의 코드는 `clone`을 사용하여서도 값 복사가 가능하다.

```java
    // 생성자    
    Car(Car c) {
        this(c.color, c.gearType, c.door);
    }

    Car c1 = new Car();
    Car c2 = new Car(c1); // 단순히 객체의 값만 복사 했으므로 영향을 받지 않는다.

    System.out.println("c1은 = " + c1.color + c1.gearType + c1.door); // whiteauto4
    System.out.println("c2는 = " + c2.color + c2.gearType + c2.door); // whiteauto4

    c1.door = 100;

    System.out.println("c1은 = " + c1.color + c1.gearType + c1.door); // whiteauto100
    System.out.println("c2는 = " + c2.color + c2.gearType + c2.door); // whiteauto4
```

> 인스턴스 생성시 고려해야할 사항
> 1. 클래스 - 어떤 클래스의 인스턴스를 생성할 것인가?
> 2. 생성자 - 선택한 클래스의 어떤 생성자로 인스턴스를 생성할 것인가?