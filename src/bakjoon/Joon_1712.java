package bakjoon;

import com.sun.tools.javac.Main;

import java.util.Scanner;

public class Joon_1712 {

    public Joon_1712()
    {
        Scanner sc = new Scanner(System.in);
        //a = 고정비용 b = 가변비용 c = 노트북가격
        //Q : 최초로 총 수입이 비용보다 많아지는 기점은?

        long input[] = new long[3];

        for(int i = 0; i < 3; i++)
            input[i] = sc.nextLong();

        /*
        고정비용 = 말그대로 고정
        가변비용 = 대수가 늘어나면 같이 늘어남
        그렇다면, (노트북가격 - 가변비용) * '답' 이 a를 넘어가는 순간이 답.
        a를 (노트북가격 - 가변비용)으로 나누면 된다.
        1000 18 1


        */

        long answer = (long)((double)input[0] / (double)(input[2] - input[1])) + 1;
        System.out.println(answer > 0 ? answer : -1);

    }

    public static void main(String[] args) {
        new Joon_1712();
    }


}
