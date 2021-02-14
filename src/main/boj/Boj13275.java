package main.boj;

import java.util.Scanner;

/*
 * manacher 알고리즘을 이용하는 특수 문제
 * */
public class Boj13275 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        StringBuilder sb = new StringBuilder('#');

        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i)).append('#');
        }

        // r = 팰린드롬중에 가장 오른쪽 끝 인덱스
        // p = r의 값을 정하는 중심 인덱스
        int r = 0, p = 0;

        int[] dp = new int[sb.length()];

        int answer = 0;

        for (int i = 0; i < sb.length(); i++) {
            // 탐색하려는 index가 이전에 발견한 팰린드롬안에 있다면, 현재 인덱스의 대칭점의 팰린드롬이었던 반지름을 얻어옴
            // Math.min을 하는 이유는 현재 index가 이전에 탐색했던 팰린드롬의 일부분으로 dp에 반지름 값이 있을수 있지만,
            // 지금 인덱스 기준으로는 팰린드롬이 없을수도 있기 때문!!!
            // 예 -> "babadada"
            dp[i] = r >= i ? Math.min(r - i, dp[p * 2 - i]): 1;

            while (i - dp[i] - 1 >= 0 && i + dp[i] + 1 < sb.length() && sb.charAt(i - dp[i] - 1) == sb.charAt(i + dp[i] + 1)) {
                dp[i]++;
            }

            answer = Math.max(answer, dp[i]);

            // 현재 index에서 찾은 팰린드롬이 이전에 찾은것보다 큰지 확인
            if (i + dp[i] > r) {
                r = i + dp[i];
                p = i;
            }
        }
        System.out.println(answer);
    }
}
