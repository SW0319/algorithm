package bakjoon;

import java.util.Scanner;

public class Joon_14503 {
//https://www.acmicpc.net/problem/14503

    int array[][];
    int isCleaned[][];
    int robot_X = 0, robot_Y = 0, robot_Direction = 0;
    int cleanCount = 0;
    Joon_14503()
    {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();   //새로
        int M = sc.nextInt();   //가로

        array = new int[N][M];
        isCleaned = new int[N][M];
        //Angle 0 : 북, 1 : 동, 2 : 남, 3 : 서
        //북 -> 서 -> 남 -> 동 ->
        //3 -> 2 -> 1 -> 0

        robot_X = sc.nextInt();
        robot_Y = sc.nextInt();
        robot_Direction = sc.nextInt();
        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < M; j++)
            {
                array[i][j] = sc.nextInt();
                isCleaned[i][j] = array[i][j];
            }

        }

        boolean status = true;

        do
        {
            doing_1(robot_X,robot_Y);

//            for(int i = 0; i < N; i ++)
//            {
//                for(int j = 0; j< M; j++)
//                    System.out.print(isCleaned[i][j] + " ");
//                System.out.println();
//            }

            boolean isChecked = false;
            for(int i = 0; i < 4; i++)
            {
                turn();
                if(checkIsCleaned())
                {
                    isChecked = true;
                    break;
                }
            }
            if(!isChecked)
            {
                int check_X = 0, check_Y = 0;
                switch (robot_Direction)
                {
                    case 0 : check_X = robot_X +1; check_Y = robot_Y; break;   //북
                    case 1 : check_X = robot_X; check_Y = robot_Y-1; break;     //동(오른쪽)
                    case 2 : check_X = robot_X -1; check_Y = robot_Y; break;   //남
                    case 3 : check_X = robot_X; check_Y = robot_Y+1; break;     //서
                }
                if(check_X != -1 && check_Y != -1)
                {
                    if(array[check_X][check_Y]== 1)
                        status = false;
                    else
                    {
                        robot_X = check_X;
                        robot_Y = check_Y;
                    }
                }
                else
                    status = false;
            }


        }while(status);

        System.out.println(cleanCount);
    }

    void turn() //방향 돌기
    {
        robot_Direction--;
        robot_Direction = (robot_Direction==-1?3:robot_Direction);
    }

    boolean checkIsCleaned() //true면 청소안된거임
    {
        int check_X = 0, check_Y = 0;
        switch (robot_Direction)
        {
            case 0 : check_X = robot_X -1; check_Y = robot_Y; break;   //북
            case 1 : check_X = robot_X; check_Y = robot_Y+1; break;     //동(오른쪽)
            case 2 : check_X = robot_X +1; check_Y = robot_Y; break;   //남
            case 3 : check_X = robot_X; check_Y = robot_Y-1; break;     //서
        }

        if(check_X == -1 || check_Y == -1)
            return false;

        if(isCleaned[check_X][check_Y] == 0 && array[check_X][check_Y]==0)    //청소되지 않았다면 이동하는 과정도 포함된다.
        {
      //      System.out.println("이동한 방향 : " + robot_Direction +"\n");
            robot_X = check_X;
            robot_Y = check_Y;
            return true;
        }

        else
            return false;
    }
    boolean doing_1(int x, int y)  //현재 위치를 청소 청소를 완료하면 true
    {
        boolean idle = false;
         if(isCleaned[x][y] == 0)
         {
             isCleaned[x][y] = 1;

             idle = true;
             cleanCount++;
         }
         return idle;
    }
    public static void main(String[] args) {
        new Joon_14503();
    }

}
