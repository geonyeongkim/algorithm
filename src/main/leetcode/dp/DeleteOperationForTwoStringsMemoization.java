package main.leetcode.dp;

/*
* 2개의 문자열에 대해서 point를 다르게 하면서 lcs를 구하는 과정에서 메모이제이션 적용
*
* 2개의 문자열의 char를 비교하기 위한 m 인덱스, n 인덱스에 lcs값을 저장하고 있으면 재사용하도록 함.
* */
public class DeleteOperationForTwoStringsMemoization {

    public int minDistance(String s1, String s2) {
        int[][] memo = new int[s1.length() + 1][s2.length() + 1];
        return s1.length() + s2.length() - 2 * lcs(s1, s2, s1.length(), s2.length(), memo);
    }

    // longest common subsequence => 가장 긴 공통된 sub 문자열 구하기.
    public int lcs(String s1, String s2, int m, int n, int[][] memo) {
        if (m == 0 || n == 0)
            return 0;
        if (memo[m][n] > 0)
            return memo[m][n];
        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            memo[m][n] = 1 + lcs(s1, s2, m - 1, n - 1, memo);
        else
            memo[m][n] = Math.max(lcs(s1, s2, m, n - 1, memo), lcs(s1, s2, m - 1, n, memo));
        return memo[m][n];
    }

    public static void main(String[] args) {
        DeleteOperationForTwoStringsMemoization deleteOperationForTwoStrings = new DeleteOperationForTwoStringsMemoization();
        int ans = deleteOperationForTwoStrings.minDistance("sea", "eat");
        System.out.println(ans);

        ans = deleteOperationForTwoStrings.minDistance("leetcode", "etco");
        System.out.println(ans);
    }
}
