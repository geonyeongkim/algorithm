package main.boj;

import java.util.Scanner;

public class Boj7490 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < testCase; i++) {
            int N = sc.nextInt();

            dfs("1", 1, 0, 1, N, 1);
            System.out.println();
        }
    }

    private static void dfs(String s, int sign, int sum, int num, int end, int cur) {
        if (cur == end) {
            if (sum + (sign * num) == 0) {
                System.out.println(s);
            }
            return;
        }

        // 순서 중요. 이어붙이는 연산부터 먼저 dfs로 돌려야 함.
        dfs(s + " " + (cur + 1), sign, sum, num * 10 + (cur + 1), end, cur + 1);
        dfs(s + "+" + (cur + 1), 1, sum + (sign * num), cur + 1, end, cur + 1);
        dfs(s + "-" + (cur + 1), -1, sum + (sign * num), cur + 1, end, cur + 1);
    }
}
