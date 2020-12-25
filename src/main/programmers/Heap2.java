package main.programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by geonyeong.kim on 2020-12-22
 */
public class Heap2 {

    /*
    * 요청 들어온 시간으로 정렬 후
    * heap에 넣는 순서는 처리시간이 금방끝나는 순으로 넣어야함.
    * */
    public int solution(int[][] jobs) {
        int answer = 0, count = 0, idx = 0, time = 0;

        // 요청 순서대로 정렬
        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));

        // 처리시간이 짧은 순으로 들어가는 heap 생성
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        while(count < jobs.length) {

            // 요청시간이 현재 시간보다 이하인 작업들을 모두 heap 에 넣음.
            while(idx < jobs.length && jobs[idx][0] <= time) {
                queue.add(jobs[idx++]);
            }

            // heap에 비어있다는것은 작업은 없지만, 아직 처리할 task는 남았다는 의미.
            // 때문에, 처리할 task의 요청시간으로 time 변경
            if(queue.isEmpty()) {
                time = jobs[idx][0];
            } else {
                // heap에서 꺼내와 실제 요청부터 처리한 시간을 계산하여 answer에 반영
                // 그리고 처리시간을 현재 time에 더함. -> 후 task의 실제 요청-완료 시간을 구하기 위함.
                int[] task = queue.poll();
                answer += (task[1] + time - task[0]);
                time += task[1];
                // task 처리 건수 증가.
                count++;
            }
        }

        return answer / jobs.length;
    }

    public static void main(String[] args) {
        Heap2 heap2 = new Heap2();
        int ans1 = heap2.solution(new int[][]{{0, 3}, {1, 9}, {2, 6}});
        System.out.println("ans1 -> " + ans1);
    }
}
