package main.programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by geonyeong.kim on 2020-12-22
 */
public class Heap3 {

    public int[] solution(String[] operations) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        PriorityQueue<Integer> reverQueue = new PriorityQueue<>(Comparator.reverseOrder());

        for(String operation : operations) {
            String[] arr = operation.split(" ");

            if(arr[0].equals("I")) {
                queue.add(Integer.valueOf(arr[1]));
                reverQueue.add(Integer.valueOf(arr[1]));
            } else {
                if(queue.isEmpty()) continue;

                if(arr[1].equals("1")) {
                    int max = reverQueue.poll();
                    queue.remove(max);
                } else {
                    int min = queue.poll();
                    reverQueue.remove(min);
                }
            }
        }

        if(queue.isEmpty() && reverQueue.isEmpty()) return new int[]{0, 0};

        return new int[]{reverQueue.poll(), queue.poll()};
    }

    public static void main(String[] args) {
        Heap3 heap3 = new Heap3();
        int[] ans1 = heap3.solution(new String[]{"I 16","D 1"});
        System.out.println("ans1 1 -> " + ans1[0]);
        System.out.println("ans1 2 -> " + ans1[1]);

        int[] ans2 = heap3.solution(new String[]{"I 7","I 5", "I -5", "D -1"});
        System.out.println("ans2 1 -> " + ans2[0]);
        System.out.println("ans2 2 -> " + ans2[1]);
    }
}
