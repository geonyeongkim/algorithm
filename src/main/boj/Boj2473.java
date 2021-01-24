package main.boj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by geonyeong.kim on 2021-01-24
 */
public class Boj2473 {

    public static void main(String[] args) {
        long MAX = Long.MAX_VALUE;

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[] values = new long[n];

        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }

        Arrays.sort(values);

        long[] answer = new long[3];

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                long sum = values[i] + values[left] + values[right];

                if (Math.abs(sum) < MAX) {
                    answer[0] = values[i];
                    answer[1] = values[left];
                    answer[2] = values[right];
                    MAX = Math.abs(sum);
                }

                if (sum < 0)
                    left++;
                else
                    right--;
            }
        }

        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }
}
