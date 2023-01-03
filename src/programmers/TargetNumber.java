package programmers;

import java.util.Arrays;

public class TargetNumber {
//https://school.programmers.co.kr/learn/courses/30/lessons/43165?language=java
    int answer = 0;
    public int solution(int[] numbers, int target) {

        logic(numbers,target,0);
        numbers[0]*=-1;
        logic(numbers,target,0);

        return answer;
    }

    public void logic(int[] numbers, int target, int idx)
    {
        idx++;
        if(idx == numbers.length)
        {
            if(Arrays.stream(numbers).sum()==target)
                answer++;
            return;
        }

        logic(numbers,target,idx);
        numbers[idx]*=-1;
        logic(numbers,target,idx);
    }

    public static void main(String[] args) {
        int numbers[] = {4,1,2,1};
        int target = 4;

        System.out.println(new TargetNumber().solution(numbers,target));
    }

}
