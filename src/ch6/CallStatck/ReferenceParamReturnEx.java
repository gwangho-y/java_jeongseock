package ch6.CallStatck;

public class ReferenceParamReturnEx {

    public static void main(String[] args) {
        Data d = new Data();
        d.x = 10;

        Data d2 = copy(d);
        System.out.println("d.x = "+ d.x);
        System.out.println("d2.x = "+ d2.x);
    }
    static Data copy(Data d) {
        Data tmp = new Data(); // 새로운 인스턴스 생성
        tmp.x = d.x;
        return tmp;
    }
}
