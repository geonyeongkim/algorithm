package main.programmers;

import java.util.PriorityQueue;

/**
 * Created by geonyeong.kim on 2020-12-22
 */
public class Heap1 {

    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue();
        for (int i : scoville) priorityQueue.add(i);

        while (true) {

            // check
            if(priorityQueue.isEmpty()) {
               return -1;
            } else if (priorityQueue.peek() >= K) {
                break;
            } else {
                if (priorityQueue.size() > 1) {
                    int a = priorityQueue.poll();
                    int b = priorityQueue.poll();
                    priorityQueue.add(a + (b * 2));
                } else {
                    return -1;
                }
            }
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Heap1 heap1 = new Heap1();
        int ans1 = heap1.solution(new int[]{1, 2, 3, 9, 10, 12}, 7);
        System.out.println("ans1 -> " + ans1);
    }
}
