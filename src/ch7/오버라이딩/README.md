## 오버라이딩
조상 클래스로부터 상속 받은 메서드의 내용을 변경하는 것.

### 오버라이딩 조건 
메서드의 선언부가 조상과 완전 일치해야한다.

> 자손과 조상 메서드는 서로 <br>
> - **이름**이 같아야 한다.
> - **매개변수**가 같아야 한다.
> - **반환타입**이 같아야 한다.


메서드 앞에 붙는 접근제어자와 예외는 제한된 조건 하에서 다르게 변경 할 수 있다.
1. 접근제어자는 조상 클래스의 메서드보다 좁은 범위로 변경 할 수 없다.<br>
    조상클래스 메서드 접근제어자가 protected라면 자손 클래스는 protected나 public이어야 한다.
    왜 일까? 접근을 더 넓게만 허용 할 수 있다는건데, 좁아지면 안 되는 이유는 뭐지?
    public, protected, (default), private
2. 조상 클래스의 메서드보다 많은 수의 예외를 선언할 수 없다. <br>
   예외는 반대로 적은 갯수만 허용할 수 있다. 주의점은 선언된 예외의 갯수가 아닐 수도 있다.
   예를들어 하위 클래스에서 Exception을 예외로 받으면 어떻게 될까?? 에러가 뜬다 왜냐하면 Exception은
    모든 예외의 최고 조상이기 때문에 가장 많은 양의 예외를 받을 수 있기 때문이다.
    
```java
class parent {
    void parentMethod() throws IOException {

    }
}

class child extends parent {
    void parentMethod() throws Exception { // 에러
        
    }
}
```

조상 클래스의 메서드를 자손 클래스에서 오버라이딩 할 때 불가능한 것들
> 1. 접근 제어자를 조상 클래스의 메서드보다 좁은 범위로 변경할 수 없다.
> 2. 예외는 조상 클래스의 메서드보다 많이 선언할 수 없다.
> 3. 인스턴스 메서드를 static 메서드로 또는 그 반대로 변경할 수 없다.

조상클래스의 static 메서드를 자손 클래스에서 다시 static 메서드로 정의 가능한가??

가능은 한데, 오버라이딩은 아니다. 오버라이딩으로 취급되지 않고, 별개의 static 메서드를 정의한 것일 뿐이다.
각 메서드는 클래스 이름으로 구별되고 호출할 때는 클래스이름.메서드이름()으로 하는 것이 바람직하다.
static 메서드는 어디까지나 자신들이 정의된 클래스에 묶여있는 것이다.



### 오버로딩과 오버라이딩의 차이
> 오버로딩(overloading) : 기존에 없는 새로운 메서드를 정의 하는 것 (new)
> 오버라이딩(overriding) : 상복받은 메서드의 내용을 변결하는 것 (modify, change)

```java

class Parent {
    void parentMethod() {}
}

class Child extends Parent {
    void parentMethod() {}  // 오버라이딩
    void parentMethod(int i) {} // 오버로딩
    
    void childMethod() {}
    void childMethod(int i) {} // 오버로딩
    void childMethod() {} // 이건 메서드 중복 선언이라서 에러
}
```



### super
> 조상 클래스로부터 상속 받은 멤버를 참조하는 참조변수


### super와 this의 차이

- 자손의 입장에서는 조상의 멤버도 자신의 멤버이기 때문에 super와 this를 사용하여 참조가능하다
- 조상멤버 : super, 자신의멤버 : this 를 사용하여 구별한다.
- 인스턴스 메서드에는 인스턴스의 주소가 지역변수로 저장된다. 이것이 super와 this의 값이 된다.


```java
public class SuperTest {
    public static void main(String[] args) {
        Child c = new Child();
        c.method();
    }
}

class Parent {
    int x=10;
}

class Child extends Parent {
    void method() {
        System.out.println("x = " + x);    // x = 10
        System.out.println("this.x =" + this.x); // this.x = 10
        System.out.println("super.x = " + super.x); // super.x = 10
    }
}

```
위 코드의 경우 x, this.x, super.x 모두 같은 변수를 의미하기 때문에 같은 값이 출력된다.

자손 클래스에서 x의 값을 변경하면 어떻게 될까?

```java
class Child extends Parent {
    int x = 20;
    void method() {
        System.out.println("x = " + x);    // x = 20
        System.out.println("this.x =" + this.x); // this.x = 20
        System.out.println("super.x = " + super.x); // super.x = 10
    }
}
```
같은 이름의 멤버 변수가 조상과 자손에 둘 다 있다면, super.x : 조상의 x, this.x : 자손의 x 를 참조하게 된다.
즉, super를 사용하면 조상과 자손의 멤버를 구별할 수 있다.

#### 메서드도 super로 호출 가능하다.
```java
class Point {
    int x;
    int y;
    
    String getLocation() {
        return "x :" + x + ", y : " + y; 
    }
}

class Point3D extends Point {
    int z;
    String getLocation() { // 오버라이딩
        return super.getLocation() + ", z :" + z;
    }
}
```
getLocation을 오버라이딩한 상태로 조상의 getLocation를 호출하여 추가로 필요한 코드를 덧댔다.
이처럼 코드를 재활용도 가능하다.


### super()
`super()`는 `this()`와 마찬가지로 생성자인데, 조상클래스의 생성자다.
`super()`를 사용하면 조상클래스의 생성자를 호출할 수 있다.

#### 자손의 인스턴스 생성 시 
- 자손의 멤버와 조상의 멤버가 합쳐진 하나의 인스턴스가 생성된다.
- 자손의 생성자에서 조상의 생성자가 호출되야한다.
  - 자손의 멤버가 조상의 멤버를 사용할 수  있으므로 조상멤버가 먼저 초기화가 되야 하기 때문
- 조상 클래스 생성자의 호출은 최고 조상인 Object 클래스까지 가서 끝난다.
- 조상의 생성자를 호출하지 않을 시 컴파일러는 자동으로 `super()`를 호출한다.

> Object 클래스를 제외한 모든 클래스의 생성자 첫 줄에 생성자인 `this()`, `super()`를 호출해야 한다.<br>
> 그렇지 않으면 컴파일러가 자동적으로 `super()`를 생성자의 첫 줄에 삽입한다.

인스턴스를 생성 시 클래스를 선택하는 것 만큼 생성자를 선택하는게 중요하다.
왜?? 
> 1. 클래스 - 어떤 클래스의 인스턴스를 생성할 것인가?
> 2. 생성자 - 선택한 클래스의 어떤 생성자를 이용하여 인스턴스를 생성할 것인가?

```java
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
```

Point3D의 생성자에서 `super()` 가 자동으로 추가 되야하지만, 조상에 생성자 `Point()`가 없으므로
지정을 해줘야한다. `Point()` 생성자를 추가하거나 `super(x ,y)` 를 추가한다.



