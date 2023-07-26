package ch6.Constructor;

public class StaticBlockTest {
    static int[] arr = new int[10];
    /*
        배열이나 예외처리 같은 복잡한 초기화는
        클래스 초기화 블럭을 사용하기도 한다.
    */
    static {
        System.out.println("배열 초기화");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10) + 1;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr ["+i+"] = "+ arr[i]);
        }
    }
}
