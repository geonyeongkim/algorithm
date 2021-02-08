package main.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by geonyeong.kim on 2021-02-08
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        List<int[]> answerList = new ArrayList<>();

        Arrays.sort(intervals, Comparator.comparingInt((int[] o) -> o[0]));
        int min = intervals[0][0];
        int max = intervals[0][1];
        answerList.add(new int[]{min, max});
        int answerIdx = 0;

        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] <= max && intervals[i][1] > max) {
                max = intervals[i][1];
                answerList.set(answerIdx, new int[]{min, max});
            } else if(intervals[i][0] > max) {
                min = intervals[i][0];
                max = intervals[i][1];
                answerList.add(++answerIdx, new int[]{min, max});
            }
        }

        int[][] answer = new int[answerList.size()][];

        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] ans = mergeIntervals.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        for (int[] ints : ans) {
            for (int i : ints) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        ans = mergeIntervals.merge(new int[][]{{1, 4}, {4, 5}});
        for (int[] ints : ans) {
            for (int i : ints) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        ans = mergeIntervals.merge(new int[][]{{1, 4}, {2, 3}});
        for (int[] ints : ans) {
            for (int i : ints) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
