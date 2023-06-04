package ch6.Constructor;

class Product{
    static int count = 0;
    int serialNo;

    /*
        Product 인스턴스를 생성할 때마다 count+1 해준 후
        인스턴스 변수인 serialNo에 저장한다.
    */

    {
        ++count;
        serialNo = count;
    }

    public Product() {}
}


public class ProductTest {
    public static void main(String[] args) {
        Product p1 = new Product();
        Product p2 = new Product();
        Product p3 = new Product();
        Product p4 = new Product();

        System.out.println("p1의 제품번호(serial no)는 "+ p1.serialNo);
        System.out.println("p2의 제품번호(serial no)는 "+ p2.serialNo);
        System.out.println("p3의 제품번호(serial no)는 "+ p3.serialNo);
        System.out.println("p4의 제품번호(serial no)는 "+ p4.serialNo);


    }

}
