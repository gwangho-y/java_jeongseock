package ch7.인터페이스;

class D {
    void methodD() {
        J j = InstanceManager.getInstance();
        j.methodE();
        System.out.println(j.toString());
    }
}

class E implements J {
    @Override
    public void methodE() {
        System.out.println("메서드 E");
    }
    public String toString() { return "class E"; }
}

class InstanceManager {
    public static J getInstance() {
        return new E();
    }
}
interface J {
    public abstract void methodE();
}


public class InterfaceTest3 {
    public static void main(String[] args) {
        D d = new D();
        d.methodD();
    }
}
