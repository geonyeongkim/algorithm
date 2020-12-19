package main.programmers;

import java.util.Arrays;

/**
 * Created by geonyeong.kim on 2020-12-19
 */
public class Sort1 {

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int answerIdx = 0;

        for (int[] command : commands) {
            int[] subArray = new int[command[1] - command[0] + 1];
            int idx = 0;
            for (int i = command[0] - 1; i < command[1]; i++) {
                subArray[idx++] = array[i];
            }
            Arrays.sort(subArray);
            answer[answerIdx++] = subArray[command[2] - 1];
        }
        return answer;
    }

    public static void main(String[] args) {
        Sort1 sort1 = new Sort1();
        int[] ans1 = sort1.solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
        for (int i : ans1) {
            System.out.println("i -> " + i);
        }
    }
}
