## package와 import
- 클래스의 묶음
- 클래스를 효율적으로 관리할 수 있다.
- 같은 이름의 클래스도 서로 다른 패키지에 존재 가능하다.
- 클래스의 실제 이름은 패키지명을 포함한 것이다.
  - String 클래스는 java.lang.String이다.
- 패키지도 패키지를 포함할 수 있다.
  - java.lang의 lang패키지는 java 패키지의 하위 패키지다.

> 하나의 소스파일에는 첫 번재 문장으로 단 한번의 패키지 선언만을 허용한다.
> 모든 클래스는 반드시 하나의 패키지에 속해야한다.
> 패키지는 점(.)을 구분자로 하여 계층 구조로 구성할 수 있다.
> 패키지는 물리적으로 클래스 파일(.class)을 포함하는 하나의 디렉토리다.


### 패키지의 선언
클래스나 인터페이스의 소스파일 맨 위에 한줄만 적어준다.
```java
package 패키지명;
```
- 패키지 선언문은 소스파일에서 첫 번째 문장이어야한다.
- 하나의 소스파일에 단 한번만 선언될 수 있다.
- 해당 소스 파일에 포함된 모든 클래스나 인터페이스는 선언된 패키지에 속하게 된다.
  - 예를 들어 아래와 같이 선언했다면 SuperTest는 ch7.오버라이딩 패키지에 속하게 된다.
    ```java
      package ch7.오버라이딩;
    
      public class SuperTest {}
      ```
- 패키지명은 클래스명과 구분하기 위해 소문자로 하는 것을 원칙으로 한다.
- 패키지를 지정하지 않으면 이름없는 패키지에 속하게 된다. 
패키지를 선언하지 않은 모든 클래스는 이름없는 패키지에 속하게 된다.


## import문
import 문을 사용하면 클래스를 호출 시 package 명을 생략할 수 있다. 

### import 문의 역할
컴파일러에게 클래스의 패키지에 대한 정보를 제공하는 것이다.
컴파일러는 import 문을 통해 소스파일에 사용된 클래스의 패키지를 알아낸 다음, 클래스 이름 앞에 패키지명을 붙여준다.
import 문은 프로그램의 성능에 영향을 미치지 않는다. 컴파일하는데 시간이 좀 더 걸릴 뿐이다.

### import 문의 선언
소스 파일에서 모든 선언은 순서가 있다.
> 1. package
> 2. import
> 3. class

import 문의 선언 방법은 아래와 같다.
> import 패키지명.클래스명; <br>
> import 패키지명.*;

````java
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;

import java.util.*;
````
`패키지명.*` 이란? 
- 패키지의 모든 클래스를 불러올 수 있다. 실행시 성능상의 차이는 없다.
- `*`은 하위패키지의 클래스가지 불러올 순 없다. `java.util.*` 대신 `java.*`으로 util 패키지는 불러올 수 없다.

### static import 문
static 멤버를 호출할 때 클래스 이름을 생략할 수 있다.
static 멤버를 자주 사용할 때 편리하다.
```java
import static java.lang.Integer.*;
import static java.lang.Math.random;
import static java.lang.System.out;

class 클래스 {
    public static void main(String[]args){
        out.println(random());
    }
}
```




  
