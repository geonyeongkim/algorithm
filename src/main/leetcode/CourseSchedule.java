package main.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by geonyeong.kim on 2021-03-12
 */
public class CourseSchedule {

    boolean answer;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0) return true;
        answer = true;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            map.put(prerequisites[i][0], prerequisites[i][1]);
        }

        // check
        boolean[] visit = new boolean[numCourses];
        dfs(map, prerequisites[0][0], map.get(prerequisites[0][0]), visit);
        return answer;
    }

    private void dfs(Map<Integer, Integer> map, int start, int curr, boolean[] visit) {
        if (curr == start) {
            answer = false;
            return;
        }

        visit[curr] = true;

        if (map.get(curr) != null && !visit[map.get(curr)]) {
            dfs(map, start, map.get(curr), visit);
        }
    }

    public static void main(String[] args) {
        CourseSchedule courseSchedule = new CourseSchedule();
        boolean ans = courseSchedule.canFinish(2, new int[][]{{1, 0}});
        System.out.println(ans);

        ans = courseSchedule.canFinish(2, new int[][]{{1, 0}, {0, 1}});
        System.out.println(ans);
    }
}
