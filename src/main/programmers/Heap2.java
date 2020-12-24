package main.programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by geonyeong.kim on 2020-12-22
 */
public class Heap2 {

    class Job {
        int start;
        int terminateTime;

        public Job(int start, int terminateTime) {
            this.start = start;
            this.terminateTime = terminateTime;
        }

        public int getStart() {
            return start;
        }

        public int getTerminateTime() {
            return terminateTime;
        }
    }

    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (Comparator.comparingInt(o -> (o[0] + o[1]))));

        int answer = 0, time = 0, idx = 0;
        Queue<Job> queue = new LinkedList<>();

        while (idx < jobs.length || !queue.isEmpty()) {
            if(!queue.isEmpty() && queue.peek().getTerminateTime() <= time) {
                Job job = queue.poll();
                answer += (time - job.getStart());
                idx++;
            }

            if(idx < jobs.length && queue.isEmpty() && jobs[idx][0] <= time) {
                queue.add(new Job(jobs[idx][0], time + jobs[idx][1]));
            }

            time++;

            if(queue.isEmpty()) {
                break;
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
