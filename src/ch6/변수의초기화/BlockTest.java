package ch6.변수의초기화;

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
