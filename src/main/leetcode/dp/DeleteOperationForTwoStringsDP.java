package main.leetcode.dp;

/*
* DP 문제로 문자열의 각 char 들을 2차원 배열로 정의하여 LCS를 구할 수 있음.
*
* DP 2 차원 배열의 마지막이 구하고자하는 LCS 값이 된다.
*
* */
public class DeleteOperationForTwoStringsDP {

    public int minDistance(String s1, String s2) {
        /*
        * 한 사이즈 크게 2차월 배열을 만듬.
        * 초기값을 0으로 사용하기 위함.
        */
       int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                // 첫 번째 줄이기 때문에 연산하지 않고 skip
                if (i == 0 || j == 0)
                    continue;

                // 두 char이 같으면, 각자 두 문자열의 이전 char 값의 dp 값 + 1을 하면 됨.
                // 이전 dp 값에는 이미 top-down 으로 값이 들어가졌기 때문.
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                // 같이 않은 경우에는, 기존 lcs 구하던것처럼 s1 문자열의 전 idx 에서의 값과, s2 문자열의 전 idx 값의 max 값 사용.
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return s1.length() + s2.length() - 2 * dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        DeleteOperationForTwoStringsDP deleteOperationForTwoStrings = new DeleteOperationForTwoStringsDP();
        int ans = deleteOperationForTwoStrings.minDistance("sea", "eat");
        System.out.println(ans);

        ans = deleteOperationForTwoStrings.minDistance("leetcode", "etco");
        System.out.println(ans);
    }
}
