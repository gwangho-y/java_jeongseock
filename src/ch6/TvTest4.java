package ch6;

public class TvTest4 {


    public static void main(String[] args) {
        Tv[] tvArr = new Tv[3]; // 길이 3인 Tv객체 배열

        // Tv 객체 생성 후 Tv 객체 배열의 각 요소에 저장
        for (int i = 0; i < tvArr.length; i++) {
            tvArr[i] = new Tv();
            tvArr[i].channel = i + 10;
        }
        for (int i = 0; i < tvArr.length; i++) {
            tvArr[i].channelUp();
            System.out.printf("tvArr[%d].channel=%d%n", i, tvArr[i].channel);
            /* 아래 출력`
                tvArr[0].channel=11
                tvArr[1].channel=12
                tvArr[2].channel=13
            */
        }


    }

}
