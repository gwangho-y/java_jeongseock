package ch6.MemberCall;

public class MemberCall {
    int iv = 10;
    static int cv = 20;

    int iv2 = cv;
//    static int cv2 = iv; // 클래스 변수는 인스턴스 변수 사용이 불가능
    static int cv2 = new MemberCall().iv;

    void instanceMethod1() {
        System.out.println(cv); // 인스턴스 메서드에서 클래스 변수 사용 가능
        System.out.println(iv); // 인스턴스 메서드에서 인스턴스 변수 사용 가능
    }
    static void staticMethod2(){
        System.out.println(cv);
//        System.out.println(iv); 클래스 메서드에서 인스턴스 변수 사용 불가능
        MemberCall c = new MemberCall();
        c.instanceMethod1(); // 인스턴스 생성 후에 인스턴스 메서드에 접근 가능하다.
    }
    void instanceMethod2 () { // 인스턴스 메서드에서는 인스턴스, 클래스 메서드 전부 호출 가능
        staticMethod2();
        instanceMethod1();
    }

}
