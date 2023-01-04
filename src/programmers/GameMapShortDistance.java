package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class GameMapShortDistance {
    //https://school.programmers.co.kr/learn/courses/30/lessons/1844
    int maps[][];
    boolean visited[][];
    int answer = 10000;
    Queue<queue_list> queue;
    public int solution(int[][] maps)
    {
        this.maps = maps;
        visited = new boolean[maps.length][maps[0].length];
        queue = new LinkedList<>();

        queue.offer(new queue_list(0,0,1));
        bfs();
//        dfs(0,0,1);
        return answer==10000 ? -1 : answer;
    }
//처음에 캐릭터는 게임 맵의 좌측 상단인 (1, 1) 위치에 있으며, 상대방 진영은 게임 맵의 우측 하단인 (n, m) 위치에 있습니다.

        public void bfs()
        {
            int lists[][] = {{1,0},{-1,0},{0,1},{0,-1}};
            while(!queue.isEmpty())
            {
                queue_list tempQueue = queue.remove();
                if(tempQueue.x +1 == maps.length && tempQueue.y+1 == maps[0].length)
                {
                    answer = tempQueue.v;
                    return;
                }
                for(int i = 0; i < 4; i++)
                {
                    int xVal = lists[i][0] + tempQueue.x;
                    int yVal = lists[i][1] + tempQueue.y;
                    if(xVal < 0 || yVal < 0 || maps[0].length-1 < yVal || maps.length-1 < xVal) continue;
                        if(maps[xVal][yVal] == 1 && !visited[xVal][yVal])
                        {
                            visited[xVal][yVal]=true;
                            queue.offer(new queue_list(xVal,yVal, tempQueue.v+1));
                        }
                }
            }
            return;
        }
        class queue_list
        {
            int x;
            int y;
            int v;
            queue_list(int x, int y, int v)
            {
                this.x = x;
                this.y = y;
                this.v = v;
            }

        }


        public void dfs(int x,int y, int idx)
        {
            System.out.println("실행된 x : " + x + ", y : " + y +" , idx : " + idx);
          //  if(x<=-1 || y<=-1 || x==maps.length || y==maps[0].length)  return;
            if(maps[x][y]==0)   return;

            if(x+1==maps.length && y+1==maps[0].length)
            {
                answer = (answer >= idx ? idx : answer);
                return;
            }
            int lists[][] = {{x+1,y},{x-1,y},{x,y+1},{x,y-1}};
            maps[x][y] = 0;
            int cnt = 0;


            for(int i = 0; i < 4; i++)
            {
                if(lists[i][0]!=-1 && lists[i][1]!=-1 && lists[i][0] != maps.length && lists[i][1] != maps[0].length)
                {
                    if(maps[lists[i][0]][lists[i][1]] !=0)
                    {
                        dfs(lists[i][0],lists[i][1],idx+1);
                    }
                }
            }
            maps[x][y]=1;
    //애초에 dfs로 구현하면 효율이 떨어질 수 밖에 없다. (긴 정점을 방문을 무조건 하니까)
        }
    public static void main(String[] args) {
        int maps[][] = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        int maps2[][] = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
        System.out.println(new GameMapShortDistance().solution(maps));


    }

}
