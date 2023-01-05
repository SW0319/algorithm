package programmers;

import java.util.*;

public class Network {
    //https://school.programmers.co.kr/learn/courses/30/lessons/43162
    public int solution(int n, int[][] computers) {
        int answer = 0;
        if(n==1)return 1;
        boolean visited[] = new boolean[n];
        for(int i = 0; i < n; i++)
            if(!visited[i])
            {
                dfs(i,computers,visited);
                answer++;
            }
        return answer;
    }

    boolean[] dfs(int i,int[][] computers, boolean[] visited)
    {
        visited[i] = true;

        for(int j = 0; j < computers.length; j++)
        {
            if(i != j && computers[i][j]== 1 && !visited[j])
            {
                visited = dfs(j,computers,visited);
            }
        }
        return visited;
    }
    public static void main(String[] args) {
        int n = 3;
        int computers[][] = {{1,1,0},{1,1,0},{0,0,1}};
        int computers2[][] = {{1,1,0},{1,1,1},{0,1,1}};
        System.out.println(new Network().solution(n,computers2));
    }
}
