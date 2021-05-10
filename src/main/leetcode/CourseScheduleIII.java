package main.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
* 강의 코스들이 있는데, 강의 시간과 종료시간을 주어짐. => [[duration time, finish time], [duration time, finish time]]
*
* 우선순위 큐를 두는 이유 => 강의시간이 가장 오래 걸리는 코스를 peek 하기 위해!!!
*
* 논리적으로 종료시간 기준으로 오름차순 정렬 후, iterate 돌면서 현재 코스가 큐에 있는 코스 중 가장 오래걸리는 코스보다 짦은 강의 시간이라면? 당연히 time 이 절약되므로 교체!!!
* 때문에, 먼저 정렬 후 -> 가장 오래걸리는 코스는 변경하는것!!!
* 단, 변경했기에 기존 오래걸린 코스는 poll 로 큐에서 제거하고, 교체한 코스는 큐으 offer로 넣음.
* */
public class CourseScheduleIII {

    // courses => [[duration, deadline]]
    public int scheduleCourse(int[][] courses) {
        // 1. deadline 기준으로 오름차순 정렬
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));

        // 우선순위 큐 => 기준은 duration 큰게 우선
        PriorityQueue < Integer > queue = new PriorityQueue< >((a, b) -> b - a);
        int time = 0;
        for (int[] c: courses) {

            if (time + c[0] <= c[1]) {
                queue.offer(c[0]);
                time += c[0];
            } else if (!queue.isEmpty() && queue.peek() > c[0]) {
                time += c[0] - queue.poll();
                queue.offer(c[0]);
            }
        }

        return queue.size();
    }

    public static void main(String[] args) {
        CourseScheduleIII courseScheduleIII = new CourseScheduleIII();
        int ans = courseScheduleIII.scheduleCourse(new int[][]{{100,200},{200,1300},{1000,1250},{2000,3200}});
        System.out.println(ans);

        ans = courseScheduleIII.scheduleCourse(new int[][]{{1, 2}});
        System.out.println(ans);

        ans = courseScheduleIII.scheduleCourse(new int[][]{{3,2},{4,3}});
        System.out.println(ans);

        // expect = 2
        ans = courseScheduleIII.scheduleCourse(new int[][]{{5,5},{4,6},{2,6}});
        System.out.println(ans);

        ans = courseScheduleIII.scheduleCourse(new int[][]{{8, 10}, {7, 8}, {4, 6}});
        System.out.println(ans);

        // expect = 5
        ans = courseScheduleIII.scheduleCourse(new int[][]{{5,15},{3,19},{6,7},{2,10},{5,16},{8,14},{10,11},{2,19}});
        System.out.println(ans);
    }
}
