package bakjoon;

import java.util.Scanner;

public class Joon_14890 {
    Joon_14890()
    {
        Scanner sc = new Scanner(System.in);

        int N, L;

        N = sc.nextInt();
        L = sc.nextInt();

        int map_row[][] = new int[N][N];
        int map_col[][] = new int[N][N];
        boolean usage_row[][] = new boolean[N][N];
        boolean usage_col[][] = new boolean[N][N];
        int val = 0;

        for (int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++)
            {
                val = sc.nextInt();
                map_row[i][j] = val;
                map_col[j][i] = val;

            }
        }

        int result = calculate(map_row,usage_row,N,L) +calculate(map_col,usage_col,N,L);
        System.out.println(result);

    }

    public int calculate(int map[][], boolean usage[][], int N, int L)
    {
        int rightVal;
        int result = 0;
        for(int row = 0; row < N; row++)
        {
            boolean r_check = true;
            for(int col = 0; col < N -1; col++)
            {

                rightVal = map[row][col+1];
                if(Math.abs(rightVal - map[row][col]) > 1) {
                    r_check = false;
                    break;  //높이 차이로 못감
                }
                else if(Math.abs(rightVal - map[row][col]) == 1) //경사로를 놓을 수 있다면 지나갈 수 있다.
                {
                    int direction = 0;
                    direction+=(map[row][col] > rightVal)?1:-1;

                    int s_idx = (direction==1?col+1:col);

                    boolean check = true;
                    int start = s_idx;
                    for(int i = 0; i < L; i++) {
                        if (s_idx == -1 || s_idx == N) {
                            check = false;
                            break;
                        }
                        if (!usage[row][s_idx] && map[row][start] == map[row][s_idx])
                        {
                            usage[row][s_idx]=true;
                        }
                        else
                        {
                            check = false;
                        }
                        s_idx += direction;
                    }

                    if(!check)r_check = false;

                }
            }
            if(r_check)
            {
//                System.out.println("row : " + row);
                result++;
            }

        }

        return result;
    }


    public static void main(String[] args) {
        new Joon_14890();
    }
}
