package main.leetcode;

import java.util.Arrays;

/**
 * Created by geonyeong.kim on 2020-12-10
 */
public class MinimumInitialEnergyToFinishTasks {

    /*
    * 문제 풀이 참고.
    * actual과 minimum간의 차이로 정렬한 접근까지는 동일
    *
    * 답의 경우 actualSum <= answer <= minimumSum 범위를 가지고 있기 때문에 (actualSum + 어떤 순서든 만족하는 최소한의 additional value) 가 된다.
    * 때문에, 정렬한 값들을 하나씩 비교하면서 최소한의 additional value 를 찾아간다.
    * 마지막에 minimum 보다 낮다면 tuple의 actual과 minimum의 차이를 더하면 원하는 최소한의 additional value 가 나오게 된다.
    * */
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));
        int total = 0;
        for (int[] task: tasks)
            total += task[0];
        int res = total;
        for (int[] task: tasks) {
            if (task[1] > total)
                total = task[1];
            total -= task[0];
        }
        return res + total;
    }

    /*
    * 이게 내가 푼 풀이...
    * actual과 minimum간의 차이로 정렬한 접근까지는 맞았으나,
    * 답의 최소값을 구하는 과정에서 틀림
    *
    * 나의 경우는 minimum의 sumation에서 하나씩 빼가면서 답을 구함.
    * time limit 에 걸려버림.
    * */
    public int myMinimumEffort(int[][] tasks) {
        int maxSum = 0;

        Arrays.sort(tasks, (o1, o2) -> (o2[1] - o2[0]) - (o1[1] - o1[0]));

        for(int i = 0; i < tasks.length; i++) {
            maxSum += tasks[i][1];
        }

        int result = maxSum;

        while (true) {
            int sum = result;
            boolean flag = false;

            for (int i = 0; i < tasks.length; i++) {
                if (tasks[i][1] <= sum) {
                    sum -= tasks[i][0];
                } else {
                    flag = true;
                    break;
                }
            }

            if (flag) break;
            result--;
        }

        return result + 1;
    }

    public static void main(String[] args) {
        MinimumInitialEnergyToFinishTasks minimumInitialEnergyToFinishTasks = new MinimumInitialEnergyToFinishTasks();
        int res1 = minimumInitialEnergyToFinishTasks.minimumEffort(new int[][]{{1,2}, {2, 4}, {4,8}});
        System.out.println("res1 -> " + res1);

        int res2 = minimumInitialEnergyToFinishTasks.minimumEffort(new int[][]{{1,3},{2,4},{10,11},{10,12},{8,9}});
        System.out.println("res2 -> " + res2);

        int res3 = minimumInitialEnergyToFinishTasks.minimumEffort(new int[][]{{1,7},{2,8},{3,9},{4,10},{5,11},{6,12}});
        System.out.println("res3 -> " + res3);
    }
}
