package main.boj;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by geonyeong.kim on 2021-02-01
 */
public class Boj2014 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        int targetIdx = sc.nextInt();

        long[] nums = new long[K];
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < K; i++) {
            nums[i] = sc.nextInt();
            priorityQueue.add(nums[i]);
        }

        long answer = 0;

        while(targetIdx > 0 && !priorityQueue.isEmpty()) {
            answer = priorityQueue.poll();
            targetIdx--;
            for (int i = 0; i < nums.length; i++) {
                priorityQueue.add(nums[i] * answer);
                if(answer % nums[i] == 0) break;
            }
        }

        System.out.println(answer);
    }
}
