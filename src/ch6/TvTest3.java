package ch6;

public class TvTest3 {


    public static void main(String[] args) {
        Tv t1 = new Tv();
        Tv t2 = new Tv();

        System.out.println(" t1의 channel = " + t1.channel );
        System.out.println(" t2의 channel = " + t2.channel );
        t2=t1; // 이때 t2 참조변수에 저장된 메모리 주소가 변경된다.
        t1.channel = 7;
        System.out.println(" t1의 channel 값 변경 = " + t1.channel );
        System.out.println(" t1의 channel = " + t1.channel );
        System.out.println(" t2의 channel = " + t2.channel );
    }

}
