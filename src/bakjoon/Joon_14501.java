package bakjoon;

import java.util.Scanner;

public class Joon_14501 {

    int array[][];
    int N;
    int max_account;

    public Joon_14501()
    {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        array = new int[N][2];

        for(int i = 0; i< N; i++)
            for(int j = 0; j < 2; j++)
                array[i][j] = sc.nextInt();

        calculate(0,0,0,-1,0);
        System.out.println(max_account);


    }

    void calculate(int day, int max, int account, int doingIdx, int restWork)
    {
        if(doingIdx != -1)
        {
            if(restWork + day > N+1) return;
        }

        day++;  //일수를 더한다.

        if(day != N + 1)    //퇴사날이 되었는지 확인한다.
        {
            if (doingIdx == -1) //아니라면 그날 상담이 있는지 확인한다.
            {
                //상담이 없다면
                //상담을 안하는 재귀 생성
          //      System.out.println("상담 안하는 재귀 생성 day : " + day +" , max : " + max + " , account : " + account + ", doingIdx : " + doingIdx + " , restwork : " + restWork);
                calculate(day,max,account,doingIdx,restWork);
                //상담하는 재귀 생성    생성한 날도 상담을 하기 때문에 restWork는 1 뺀다.
                doingIdx = day-1;
                restWork = array[doingIdx][0] -1;

                //생성한 날에 상담이 끝났다면


         //       System.out.println("상담 하는 재귀 생성 day : " + day +" , max : " + max + " , account : " + account + ", doingIdx : " + doingIdx + " , restwork : " + restWork);

                    if(restWork==0)
                    {
                        account += array[doingIdx][1];
                        doingIdx = -1;
                    }
                    calculate(day,max,account,doingIdx,restWork);

            }
            else
            {
                //상담이 있다면
                restWork--;

                if(restWork == 0)
                {
                    account += array[doingIdx][1];
                    doingIdx = -1;
                    restWork = 0;
                }
              //  System.out.println("상담이 있을때 실행 day : " + day +" , max : " + max + " , account : " + account + ", doingIdx : " + doingIdx + " , restwork : " + restWork);
                calculate(day,max,account,doingIdx,restWork);

            }
        }
      //  System.out.println("재귀 탈출 day : " + day +" , max : " + max + " , account : " + account + ", doingIdx : " + doingIdx + " , restwork : " + restWork);
        max_account = (max_account >= account ? max_account : account);
    }
    public static void main(String[] args) {
        new Joon_14501();
    }

}
