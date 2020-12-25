package main.programmers;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by geonyeong.kim on 2020-12-16
 */
public class StackQueue3 {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1, sum = 0, i = 0;

        List<Truck> q = new ArrayList<>();

        while (i < truck_weights.length || q.size()!=0 ) {
            if (i < truck_weights.length && sum + truck_weights[i] <= weight) {
                sum += truck_weights[i];
                q.add(new Truck(truck_weights[i++],answer + bridge_length));
            }

            answer++;

            if (q.size()!=0 && answer >= q.get(0).getTime()) {
                sum -= q.get(0).getWeight();
                q.remove(0);
            }
        }

        return answer;
    }

    class Truck {
        private int weight;
        private int time;

        public Truck(int weight, int time) {
            this.weight = weight;
            this.time = time;
        }

        public int getWeight() {
            return weight;
        }

        public int getTime() {
            return time;
        }
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