package main.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by geonyeong.kim on 2020-12-10
 */
public class MinimumInitialEnergyToFinishTasks {

    public int minimumEffort(int[][] tasks) {
        int maxSum = 0;

        Arrays.sort(tasks, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o2[1] - o2[0]) - (o1[1] - o1[0]);
            }
        });
        for(int i = 0; i< tasks.length; i++) {
            System.out.println("actual -> " + tasks[i][0] + " minimum -> " + tasks[i][1]);
        }

        for(int i = 0; i < tasks.length; i++) {
            maxSum += tasks[i][1];
//            maxList.add(tasks[i][1]);
        }

//        Collections.sort(maxList, Comparator.reverseOrder());

        int result = maxSum;

        while (true) {
            int sum = result;
            boolean flag = false;

            for (int i = 0; i < tasks.length; i++) {
                if (tasks[i][1] <= sum) {
                    sum -= tasks[i][0];
                } else {
                    flag = true;
                    sum = -1;
                    break;
                }
            }

            if (flag) break;
            result--;
        }

//        int cnt = 0;

//        while(true) {
//            int maxSum = 0;
//
//            for(int i = 0; i < cnt; i++) {
//                maxSum += maxList.get(i);
//            }
//
//            if(actualSum <= maxSum) {
//
//                while(true) {
//                    int sum = maxSum;
//                    boolean flag = false;
//
//                    for(int i = 0; i< tasks.length; i++) {
//                        if(tasks[i][1] <= sum) {
//                            sum -= tasks[i][0];
//                        } else {
//                            flag = true;
//                            sum = -1;
//                            break;
//                        }
//                    }
//
//                    if(flag) break;
//                    maxSum--;
//                }
//
//                result  = maxSum + 1;
//                break;
//            } else {
//                cnt++;
//            }
//        }

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
