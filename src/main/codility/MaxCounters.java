package main.codility;

import java.util.Arrays;

public class MaxCounters {

    public int[] solution(int N, int[] A) {
        int[] answer = new int[N];

        int max = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == N + 1) {
                Arrays.fill(answer, max);
            } else {
                answer[A[i] - 1]++;
                max = Math.max(max, answer[A[i] - 1]);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        MaxCounters maxCounters = new MaxCounters();
        int[] ans = maxCounters.solution(5, new int[]{3, 4, 4, 6, 1, 4, 4});
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
