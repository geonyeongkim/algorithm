package main.programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by geonyeong.kim on 2021-01-06
 */
public class BinarySearchTree1 {

    public long solution(int n, int[] times) {
        long answer = 0, t = 0;

        int[] endTimes = new int[times.length];

        while (true) {
            for (int i = 0; i < endTimes.length; i++) {
                if (t == endTimes[i]) {
                    // 어디가 최선일지 idx 를 찾음.
                    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
                    for (int j = 0; j < endTimes.length; j++) {
                        priorityQueue.add(new int[]{endTimes[j] + times[j], j});
                    }
                    int[] ints = priorityQueue.poll();
                    endTimes[ints[1]] = ints[0];
                    n--;
                }
            }

            if (n == 0) {
                int max = 0;
                for (int endTime : endTimes) {
                    max = Math.max(max, endTime);
                }
                answer = max;
                break;
            }
            t++;
        }

        return answer;
    }

    public static void main(String[] args) {
        BinarySearchTree1 binarySearchTree1 = new BinarySearchTree1();
        long ans1 = binarySearchTree1.solution(6, new int[]{7, 10});
        System.out.println("ans1 => " + ans1);

//        for (int[] ints : priorityQueue) {
//            System.out.println("int => " + ints[0] + " , " + ints[1]);
//        }

//        for (int endTime : endTimes) {
//            System.out.print(endTime + ", ");
//        }
//        System.out.println();
    }
}
