package main.boj;

import java.util.Scanner;

public class Boj2631 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        int[] memo = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, lis(i, arr, memo));
        }

        System.out.println(n - answer);
    }

    private static int lis(int idx, int[] arr, int[] memo) {
        if(idx == arr.length -1) return 1;

        if(memo[idx] != 0) return memo[idx];

        memo[idx] = 1;

        for (int i = idx +1; i < arr.length; i++) {
            if(arr[idx] < arr[i]) {
                memo[idx] = Math.max(memo[idx], lis(i, arr, memo) + 1);
            }
        }
        return memo[idx];
    }
}
