## 변수의 초기화
변수를 선언하고 값을 저장하는 것.

- 멤버변수 - 변수를 초기화 하지 않아도 기본 값으로 초기화가 된다.
- 지역변수 - 사용하기 전에 반드시 초기화 해야한다.

```java
class InitTest {
    int x;  // 인스턴스 변수  기본값 0으로 초기화 된다.
    int y;  // 인스턴스 변수
    
    void method1 {
        int i;
        int j = i; // 에러. 지역 변수를 초기화 하지 않고 사용
    }
}
```
> 멤버변수와 배열의 초기화는 선택적이지만 지역변수는 필수로 초기화 해야한다.

| 자료형            | 기본값       |
|------------------|-------------|
| boolean          | false       |
| char             | '\u000'     |
| byte, short, int | 0           |
| long             | 0L          |
| float            | 0.0f        |
| double           | 0.0d of 0.0 |
| 참조형 변수        | null        |

> 멤버변수 초기화 방법
> 1. 명시적 초기화
> 2. 생성자
> 3. 초기화 블럭
>   - 인스턴스 초기화 블럭 : 인스턴스 변수를 초기화 하는데 사용
>   - 클래스 초기화 블럭 : 클래스 변수를 초기화 하는데 사용.


### 1. 명시적 초기화
선언과 동시에 초기화 하는 것을 명시적 초기화라고 한다. 가장 간단하고 우선적으로 고려되야한다.
```java
class Car{
    int door = 4; // 기본형 변수의 초기화
    Engine e = new Engine(); // 참조형 변수의 초기화
}
```

### 2. 생성자
복잡한 초기화를 사용할 경우에는 명시적 초기화보다 생성자를 통한 초기화를 사용한다.


### 3. 초기화 블럭
> 클래스 초기화 블럭 : 클래스 변수의 복잡한 초기화에 사용된다. <br>
> 인스턴스 초기화 블럭 : 인스턴스 변수의 복잡한 초기화에 사용된다.

생성자보다 인스턴스 초기화 블럭이 먼저 수행된다.
```java
class InitBlock {
    static {
//        클래스 초기화 블럭 
    }
    {
//        인스턴스 초기화 블럭
    }
    
}
```
**사용처**
인스턴스 초기화 블럭은 모든 생성자에서 공통으로 수행돼야 하는 코드를 넣는다.

초기화 블럭 내에서는 조건문, 반복문, 예외처리 구문 등을 자유롭게 사용할 수 있다.

```java
Car() {
    count++; // 중복되는 초기화 작업
    serialNo = count; // 중복되는 초기화 작업
    color = "white";
    gearType = "Auto";
}

Car(String color, String gearType) {
    count++; // 중복되는 초기화 작업
    searialNo = count; // 중복되는 초기화 작업
    this.color = color;
    this.gearType;
}
```

위에 중복되는 코드들을 인스턴스 블럭에 넣어주면 코드가 보다 간결해진다.
```java
{
    count++;
    serialNo = count;
}

Car() {
    color = "white";
    gearType = "Auto";
}

Car(String color, String gearType) {
    this.color = color;
    this.gearType;
}
```


또다른 예제
```java
public class BlockTest {
    static  {
        System.out.println("static {}");
    }
    {
        System.out.println("{}");
    }

    public BlockTest(){
        System.out.println("생성자");
    }

    public static void main(String[] args) {
        BlockTest bt = new BlockTest();
        BlockTest bt2 = new BlockTest();
//        static {}   // 클래스 초기화 구문은 최초 한번만 실행된다.
//        {}
//        생성자
//        {}
//        생성자
    }
}
```

### 멤버변수의 초기화 시기와 순서
> 클래스 변수의 초기화 시점 : 클래스가 처음 로딩될 때 단 한번만 초기화 된다.
> 인스턴스 변수의 초기화 시점: 인스턴스가 생성될 때마다 초기화된다.
> 클래스 변수의 초기화 순서 : 기본값 -> 명시적 초기화 -> 클래스 초기화 블럭
> 인스턴스변수의 초기화 순서 : 기본값 -> 명시적초기화 -> 인스턴스 초기화블럭 -> 생성자

```java
class InitTest {
    static int cv = 1;    // 명시적 초기화
    int iv = 1;           // 명시적 초기화
    static {
        cv2 = 2;         // 클래스 초기화  블럭
    }
    {iv = 2;}            // 인스턴스 초기화 블럭
    InitTest () {
        iv = 3;          // 생성자
    }
}
```

클래스의 초기화  <br>
1. 기본값 cv = 0; 
2. 명시적초기화 cv = 1;
3. 클래스 초기화블럭 cv = 2;

인스턴스 초기화  <br>
4. 기본값 cv = 2; iv = 0;
5. 명시적초기화  cv2 = 2; , iv = 1;
6. 인스턴스 초기화블럭 cv = 2; iv = 2;
7. 생성자 cv = 2; iv = 3;





