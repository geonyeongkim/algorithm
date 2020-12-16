package main.programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by geonyeong.kim on 2020-12-16
 */
public class StackQueue3 {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int[][] arr = new int[truck_weights.length][];

        int len = bridge_length;

        for (int i = 0; i < truck_weights.length; i++) {
            arr[i] = new int[]{truck_weights[i], 0};
        }
        Queue<Integer> queue = new LinkedList<>();

        while(true) {
            for(int i = 0; i < arr.length; i++) {
                if(arr[i][1] >= bridge_length) {
                    continue;
                }
                if(arr[i][1] > 0) {
                    arr[i][1] += 1;
                    continue;
                }
                if(len > 0 && weight >= arr[i][0]) {
                    weight -= arr[i][0];
                    queue.add(i);
                    len--;
                    arr[i][1] += 1;
                }
            }

            answer++;

            if(queue.isEmpty()) break;

            if(arr[queue.peek()][1] >= bridge_length) {
                weight += arr[queue.poll()][0];
                len++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        StackQueue3 stackQueue3 = new StackQueue3();
        int ans1 = stackQueue3.solution(2, 10, new int[]{7, 4, 5, 6});
        System.out.println("ans1 -> " + ans1);

        int ans2 = stackQueue3.solution(100, 100, new int[]{10});
        System.out.println("ans2 -> " + ans2);

        int ans3 = stackQueue3.solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10});
        System.out.println("ans3 -> " + ans3);
    }
}