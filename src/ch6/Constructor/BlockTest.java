package ch6.Constructor;

public class BlockTest {
    /*
        클래스 초기화 블럭
        클래스가 로딩될 때 한번만 실행된다.
    */
    static {
        System.out.println("static { }");
    }
    /*
        인스턴스 초기화 블럭
        생성자와 같이 인스턴스를 생성할 때마다 실행
        생성자보다 먼저 실행된다.
    */
    {
        System.out.println("{ }"); // 인스턴스 초기화 블럭
    }


    public BlockTest () {
        System.out.println("생성자");
    }

    public static void main(String[] args) {
        System.out.println("BlockTest bt = new BlockTest();");
        BlockTest bt = new BlockTest();

        System.out.println("BlockTest bt2 = new BlockTest();");
        BlockTest bt2 = new BlockTest();
    }
}
