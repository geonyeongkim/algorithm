package main.programmers;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by geonyeong.kim on 2020-12-18
 */
public class StackQueue4 {

    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[]{i, priorities[i]});
        }

        int max = Collections.max(queue, Comparator.comparingInt(o -> o[1]))[1];

        while(!queue.isEmpty()) {
            int[] print = queue.poll();

            if(print[1] >= max) {
                answer++;
                if(location == print[0]) {
                    return answer;
                }
                max = Collections.max(queue, Comparator.comparingInt(o -> o[1]))[1];
            } else {
                queue.offer(print);
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        StackQueue4 stackQueue4 = new StackQueue4();
        int ans1 = stackQueue4.solution(new int[]{2, 1, 3, 2}, 2);
        System.out.println("ans1 -> " + ans1);

        int ans2 = stackQueue4.solution(new int[]{1, 1, 9, 1, 1, 1}, 0);
        System.out.println("ans2 -> " + ans2);

        int ans3 = stackQueue4.solution(new int[]{1, 1, 1}, 2);
        System.out.println("ans3 -> " + ans3);
    }
}
