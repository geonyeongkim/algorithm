package main.leetcode.dp;

/*
* 이 DP는 LCS가 아닌 삭제할 갯수에 초점을 맞춘 문제로 DP 2차원 배열에 담아가면서 풀어가는 방심.
* */
public class DeleteOperationForTwoStringsWithoutLCSDP {

    public int minDistance(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                // 삭제에 초점을 맞추었기에, 각 첫번째 줄 dp값은 idx값을 가지도록 함.
                if (i == 0 || j == 0)
                    dp[i][j] = i + j;
                // 같으면 삭제하지 않아도 되니, dp[i - 1][j - 1] 와 같게 한다.
                else if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                // 다르면 삭제해야 하니, 이전 삭제할 갯수의 min값을 구한뒤 + 1 한다.
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        DeleteOperationForTwoStringsWithoutLCSDP deleteOperationForTwoStringsWithoutLCSDP = new DeleteOperationForTwoStringsWithoutLCSDP();
        int ans = deleteOperationForTwoStringsWithoutLCSDP.minDistance("sea", "eat");
        System.out.println(ans);

        ans = deleteOperationForTwoStringsWithoutLCSDP.minDistance("leetcode", "etco");
        System.out.println(ans);
    }
}
